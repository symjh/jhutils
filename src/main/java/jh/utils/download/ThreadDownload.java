package jh.utils.download;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadDownload {

    private static ExecutorService p = Executors.newFixedThreadPool(10);

    //一次读文件大小 1M
    final static int tempSize = 1024 * 1024;



    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        System.out.println("载入文件："+(System.currentTimeMillis()-start));

        final FileInputStream in = new FileInputStream(new File("C:\\Users\\jhjia\\Downloads\\3.zip"));


//        final DataInputStream in = new DataInputStream(file);

//        final RandomAccessFile in = new RandomAccessFile("C:\\Users\\jhjia\\Downloads\\3.zip","rwd");

        final long all = 41812108;
        final long count = 41812108/ (8 * 1024 * 1024);

        System.out.println(all);
        System.out.println(count);

        final ArrayList<Long> longs = new ArrayList<Long>();

        for (int i =0;i<count;i++){
            longs.add((long) Math.ceil((double) all / count) * i);
            if( i == (int)(count - 1)) {
                longs.add(all);
            }
        }

        for (int i =0;i<count;i++) {
            final Integer index = i;
            p.execute(new Runnable() {
                public void run() {
                    try {
                        byte[] bytes = new byte[tempSize];
                        long start =  longs.get(index);
//                        RandomAccessFile rin = new RandomAccessFile("C:\\Users\\jhjia\\Downloads\\3.zip","rwd");
//                        rin.seek(start);
                        RandomAccessFile rout = new RandomAccessFile("C:\\Users\\jhjia\\Downloads\\3copy.zip","rwd");
                        rout.seek(start);
                        while(in.read(bytes)!=-1) {
                            System.out.println("--第"+index+"个--start:"+start);
                            long temp = longs.get(index+1);
                            long outSize = temp - start;
                            start += tempSize;
                            if(start > temp){
                                System.out.println("--第"+index+"个--上限"+temp+"--outSize:"+outSize);
                                rout.write(bytes,0,Integer.parseInt(Long.toString(outSize)));
                                break;
                            }else{
                                rout.write(bytes);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("结束："+(System.currentTimeMillis()-start));
        p.shutdown();
    }

}
