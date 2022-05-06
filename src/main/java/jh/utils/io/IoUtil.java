package jh.utils.io;

import java.awt.*;
import java.io.*;

public class IoUtil {

//    public static String out2String(OutputStream out){
//        ByteArrayOutputStream b = (ByteArrayOutputStream)out.;
//        return new String(out.)
//    }

    public static String in2String(InputStream in){

        byte[] bytes = new byte[1024];
        int temp = 0;
        StringBuffer sb = new StringBuffer();
        try {
            while ((temp = in.read(bytes))!=-1 ){
                sb.append(new String(bytes));
            }
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        File file = new File("C:\\Users\\jhjia\\Desktop\\1.xlsx");

        if(file.renameTo(file)){
            System.out.println("11");
        }else{
            System.out.println("22");
        }

    }


}
