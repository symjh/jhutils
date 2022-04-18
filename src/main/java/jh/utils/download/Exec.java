package jh.utils.download;

import java.io.FileInputStream;

public class Exec {
    public Exec(FileInputStream fis, Integer index){
        this.fis = fis;
        this.index = index;
    }

    private FileInputStream fis;

    private Integer index;

    @Override
    public String toString() {
        return "Exec{" +
                "fis=" + fis +
                ", index=" + index +
                '}';
    }

    public void run() {
        System.out.println(this.fis);
        System.out.println(this.index);


    }
}
