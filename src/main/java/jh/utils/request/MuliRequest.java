package jh.utils.request;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import jh.utils.StringUtil;
import jh.utils.io.IoUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/**
 * 用java发送各种请求
 */
public class MuliRequest {




    //请求完整路径
    private String url;
    private Integer threadCount = 1;
    private static Integer TIMEOUT = 6000;

    //请求协议
    private String protocol;

    //请求体
    private String params;


    public static MuliRequest builder(){
        return new MuliRequest();
    }

    private MuliRequest addUrl(String url){
        this.url = url;
        return this;
    }

    private MuliRequest addThreadCount(Integer threadCount){
        this.threadCount = threadCount;
        return this;
    }

    private void start()throws Exception{

        if(StringUtil.isNull(url)){
            throw new Exception("url is null");
        }
        for (int i = 0;i<this.threadCount;i++) {
            String threadName = "thread-"+i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(threadName+" result is:"+simpleRequestStr(url));
                }
            },threadName).start();

        }
    }



    public static void main(String[] args) throws Exception {

        MuliRequest.builder().addUrl("http://localhost:8888/getVT").addThreadCount(10).start();
        MuliRequest.builder().addUrl("http://www.baidu.com/").addThreadCount(10).start();
//        System.out.println(simpleRequestStr("http://localhost:8888/getVT"));

    }

    public static InputStream simpleRequest(String url){

        try {
            HashMap<String,String> map = new HashMap<>();
//            map.computeIfAbsent(
//            map.computeIfPresent()
            HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
            connection.setConnectTimeout(TIMEOUT);
            InputStream in = connection.getInputStream();

            return in;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String simpleRequestStr(String url) {
        return IoUtil.in2String(simpleRequest(url));
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
    }
}
