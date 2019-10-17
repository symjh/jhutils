package jh.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;

public class ImgUtil {


    /**
     * <p>Title: thumbnailImage</p>
     * <p>Description: 依据图片路径生成缩略图 </p>
     * @param imagePath    原图片路径
     * @param w            缩略图宽
     * @param h            缩略图高
     */
    public static void thumbnailImage(String imagePath, int w, int h, OutputStream out){
        File imgFile = new File(imagePath);
        if(imgFile.exists()){
            try {
                Image img = ImageIO.read(imgFile);
                // 依据原图与要求的缩略图比例，找到最合适的缩略图比例
                int width = img.getWidth(null);
                int height = img.getHeight(null);
                if((width*1.0)/w < (height*1.0)/h){
                    if(width > w){
                        h = Integer.parseInt(new java.text.DecimalFormat("0").format(height * w/(width*1.0)));
                    }
                } else {
                    if(height > h){
                        w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h/(height*1.0)));
                    }
                }
                BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics g = bi.getGraphics();
                g.drawImage(img, 0, 0, w, h, Color.WHITE, null);
                g.dispose();
                String suffix = imagePath.substring(imagePath.lastIndexOf(".")+1,imagePath.length());
                ImageIO.write(bi,suffix,out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

        }
    }


    public static void main(String[] args) {
        String imagePath = "C:\\Users\\jhjia\\Desktop\\test\\bigImg.jpeg";
        String suffix = imagePath.substring(imagePath.lastIndexOf(".")+1,imagePath.length());
        System.out.println(suffix);
    }

}
