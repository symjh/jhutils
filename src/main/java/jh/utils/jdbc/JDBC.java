package jh.utils.jdbc;

import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC {

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
//    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String CONNECT_URL = "jdbc:mysql://localhost:3306/xf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";

    static Connection connection;

    public static Connection createConnection() throws Exception{
        if(connection == null){
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(CONNECT_URL,"root","root");
        }
        return connection;
    }

    public static String findDBVersion() throws Exception{
        String dbRs = "";
        String sql = "select version() from dual;";
        Statement statement = createConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            dbRs = rs.getString("version()");
        }
        return dbRs;
    }

    public static List<Map<String,Object>> findList(String sql) throws Exception{
        List<Map<String,Object>> dbRs = new ArrayList<Map<String,Object>>();

        Statement statement = createConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData md = rs.getMetaData();
        int columnCount = md.getColumnCount();
        while (rs.next()) {
            Map<String,Object> map = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                map.put(md.getColumnName(i), rs.getObject(i));
            }
            dbRs.add(map);
        }
        return dbRs;
    }


    public static Map<String,Object> findOne(String sql) throws Exception{
        Map<String,Object> dbRs = new HashMap<>();
        Statement statement = createConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData md = rs.getMetaData();
        int columnCount = md.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                dbRs.put(md.getColumnName(i), rs.getObject(i));
            }
        }
        return dbRs;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(findList("select * from test1;"));
    }

}
