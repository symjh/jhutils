package jh.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class ExcelTools {

    /**
     * 读取excel表格信息
     * 转换为map
     * 其中 key 是第一行表头
     * value 是每一格的值
     * @param filePath
     * @return
     * @throws Exception
     */
    public static List<LinkedHashMap<String,String>> loadExcel(String filePath) throws Exception{
        List<LinkedHashMap<String,String>> rs = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(filePath));
        HSSFWorkbook wb = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = wb.getSheetAt(0);
        Integer rowTotal = sheet.getLastRowNum();
        List<String> fields = fieldName(sheet.getRow(0));
        for(int i = 1; i< rowTotal;i++){
            LinkedHashMap<String,String> map = new LinkedHashMap<>();
            HSSFRow row = sheet.getRow(i);
            Integer cellTotal = fields.size();
            map.put("rowIndex",String.valueOf(i));
            for (int c = 0 ;  c < cellTotal ; c++){
                HSSFCell cell = row.getCell(c);
                map.put(fields.get(c),getHValue(cell));
            }
            rs.add(map);
        }
        return rs;
    }

    public static List<String> fieldName(HSSFRow firstRow){
        Short cellTotal = firstRow.getLastCellNum();
        List<String> rs = new ArrayList<>();
        for (short c = 0 ; c < cellTotal ; c++){
            HSSFCell cell = firstRow.getCell(c);
            rs.add(getHValue(cell));
        }
        return rs;
    }

    public static String getHValue(HSSFCell cell){
        String rs = "";
        if(cell == null){
            return rs;
        }
        if(cell.getCellType().equals(CellType.FORMULA)){
            rs = String.valueOf(cell.getNumericCellValue());
        }else if(cell.getCellType().equals(CellType.NUMERIC)){
            rs = String.valueOf(cell.getNumericCellValue());
        }else{
            rs = String.valueOf(cell.getStringCellValue());
        }
        return rs;
    }

    /**
     * excel写入操作需要独占文件，提前判断文件是否可写
     * @param flieFullName
     * @param run
     * @throws InterruptedException
     */
    private static void runByLock(String flieFullName,Function<Object,?> run) throws InterruptedException {
        int i = 0;
        while (i<10){
            i++;
            if(!isFileLock(flieFullName)){
                System.out.println(run.apply(new Object()));
                break;
            }else{
                System.out.println("文件被锁，等待重试");
                Thread.sleep(1000);
            }
        }
    }

    /**
     * 通过此方法判断文件是否可写
     * @param filePath
     * @return
     */
    private static Boolean isFileLock(String filePath){
        Boolean rs = false;
        try {
            RandomAccessFile file = new RandomAccessFile(filePath,"rw");
        }catch (Exception e){
            e.printStackTrace();
            rs = true;
        }
        return rs;
    }

    private static String changeOne(Object o){
//        List<String> fields = fieldName()
        return "111";
    }

    public static void main(String[] args) throws InterruptedException {
        String fileName = "C:\\Users\\jhjia\\Desktop\\11.txt";
        runByLock(fileName,ExcelTools::changeOne);
    }

}
