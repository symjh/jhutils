package jh.utils.array;

/**
 * 用于遍历展示数组
 */
public class ArrayView {

    public static void view2D(Integer[][] rs){

        for(int x=0;x<rs.length;x++){
            for(int y=0;y<rs[x].length;y++){
                if(y == 0){
                    System.out.print("\n");
                }
                System.out.print(fill(rs[x][y],5," "));

            }
        }
    }

    public static void view(int[] rs){
        for(int x=0;x<rs.length;x++){
            System.out.print(rs[x]+" ");
        }
    }

    // 补位
    public static String fill(Object o,Integer bit,String fix){
        String str = o.toString();
        Integer len = str.length();
        if(len < bit) {
            for (; len < bit; len++) {
                str = fix+str;
            }
        }
        return str;
    }

}
