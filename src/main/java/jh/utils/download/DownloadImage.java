package jh.utils.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 下载文件
 */
public class DownloadImage {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String format = "%s";
//        download(format, "C:\\temp");
        for(int i = 1;i<9999;i++) {
            String bit4 = bit3(i);
            System.out.println(String.format(format,bit4));
            download(String.format(format,bit4), "C:\\temp\\3");
        }
    }

    public static String bit2(Integer i){
        String temp = String.valueOf(i);
        if(temp.length() == 1){
            temp = "0"+temp;
        }else if(temp.length() == 2){
            temp = temp;
        }
        return temp;
    }

    public static String bit3(Integer i){
        String temp = String.valueOf(i);
        if(temp.length() == 1){
            temp = "00"+temp;
        }else if(temp.length() == 2){
            temp = "0"+temp;
        }else if(temp.length() == 3){
            temp = ""+temp;
        }
        return temp;
    }

    public static String bit4(Integer i){
        String temp = String.valueOf(i);
        if(temp.length() == 1){
            temp = "000"+temp;
        }else if(temp.length() == 2){
            temp = "00"+temp;
        }else if(temp.length() == 3){
            temp = "0"+temp;
        }
        return temp;
    }

    public static String download(String urlPath,String savePath) throws Exception {
        // 构造URL
        URL url = new URL(urlPath);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5*60000*1000);
        con.setRequestProperty("User-agent","Mozilla/5.0");
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024*1024*10];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf=new File(savePath);
        if(!sf.exists()){
            sf.mkdirs();
        }
        int randomNo=(int)(Math.random()*1000000);
        String filename=urlPath.substring(urlPath.lastIndexOf("/")+1,urlPath.length());//获取服务器上图片的名称
//        filename=new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date())+randomNo+filename;//时间+随机数防止重复
        OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);
        String virtualPath="/upload/SDSPage/"+filename;//存入数据库的虚拟路径
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
        return virtualPath;
    }

}
