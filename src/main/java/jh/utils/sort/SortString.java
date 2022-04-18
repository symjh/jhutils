package jh.utils.sort;

/**
 * 收录各种排序的实现
 */
public class SortString {

    public static void main(String[] args) {
        String param = "612984";
        System.out.println(bubbleSort(param));
        System.out.println(selectSort(param));
        System.out.println(insertionSort(param));
    }

    /**
     * 冒泡排序
     * @param str
     * @return
     */
    public static String bubbleSort(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i< chars.length;i++) {
            for (int j = 0; j< chars.length -1;j++){
                if(chars[j] > chars[j+1]){
                    char temp = chars[j];
                    chars[j] = chars[j+1];
                    chars[j+1] = temp;
                }
            }
        }
        return new String(chars);
    }

    /**
     * 选择排序
     * @param str
     * @return
     */
    public static String selectSort(String str){

        char[] chars = str.toCharArray();
        for (int i = 0 ; i<chars.length -1;i++){
            int min = i;
            //遍历中找到最小的数的下标然后赋值给min
            for(int j = i+1 ; j<chars.length;j++){
                if(chars[min] > chars[j]){
                    min = j;
                }
            }
            if(i!=min) {
                char temp = chars[min];
                chars[min] = chars[i];
                chars[i] = temp;
            }
        }
        return new String(chars);
    }

    /**
     * 插入排序
     * @param str
     * @return
     */
    public static String insertionSort(String str){

        char[] chars = str.toCharArray();
        for (int i = 0 ;i< chars.length ;i++){

            for(int j = i ; j > 0 ;j--){
                if(chars[i]<chars[j]){
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return new String(chars);
    }

}
