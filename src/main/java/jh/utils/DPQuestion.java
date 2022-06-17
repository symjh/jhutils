package jh.utils;

import jh.utils.array.ArrayView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 动态规划问题
 */
public class DPQuestion {

    /**
     * 最少张数问题
     * 给定一个数字、一个数组（纸币面值）
     * 给出组成该数字所需最少纸币数量
     * @param amout
     * @return
     */
    public static Integer minCount(int amout){
        int[] all = new int[]{1,2,5};
        // 存放结果
        Map<Integer,Integer> rs = new HashMap<Integer,Integer>();
        rs.put(0,0);
        rs.put(1,1);
        rs.put(2,1);
        rs.put(5,1);
        for(int i = 1 ;i < amout; i++){
            Integer count1 = rs.get(i-1);
            Integer count2 = rs.get(i-2);
            Integer min = 1;
            if(i>=5) {
                Integer count5 = rs.get(i - 5);
                min = Math.min(Math.min(count1, count2), count5);
            }else if(i>=2){
                min = Math.min(count1,count2);
            }else{
                min = count1;
            }

            rs.put(i,min+1);

        }
        System.out.println(rs);
        return rs.get(amout);
    }

    // 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public static Integer frog(Integer count){
        //1 2 3 5
        // fn = f(n-1) + f(n-2)
        Map<Integer,Integer> rs = new HashMap<>();
        rs.put(1,1);
        rs.put(2,2);

        for(int i = 3;i <= count;i++){
            rs.put(i,rs.get(i-1)+rs.get(i-2));
        }
        System.out.println(rs);
        return rs.get(count);
    }

    // 问题：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    //　　机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    //　　问总共有多少条不同的路径？
    public static Integer bot(Integer m,Integer n){

        Integer[][] rs = new Integer[m][n];
        // (m,n) => (m-1,n) 右移一步
        // 或者  => (m,n-1) 下移一步
        // 以此类推

        // 数据初始化
        rs[0][0] = 0;
        rs[0][1] = 1;
        rs[1][0] = 1;
        for(int x = 1;x < m; x++){
            rs[x][0] = 1;
        }
        for(int y = 1;y < n;y++){
            rs[0][y] = 1;
        }

        for(int x=1;x<m;x++){
            for(int y=1;y<n;y++){
                rs[x][y] = rs[x-1][y] + rs[x][y-1];
           }
        }
        ArrayView.view2D(rs);
        return rs[m-1][n-1];
    }



    public static void main(String[] args) {
        minCount(200);
        frog(20);
        bot(8,8);


    }





}
