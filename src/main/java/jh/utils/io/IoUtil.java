package jh.utils.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

}
