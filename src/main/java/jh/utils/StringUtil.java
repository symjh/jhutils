package jh.utils;

/**
 * 对字符串操作的工具类
 */
public class StringUtil {

    /**
     * 判断传入的字符串是否为null或空值
     * true 不为空
     * false 为空
     * @param str
     * @return
     */
    public static Boolean isNotNull(String str){
        return !(isNull(str));
    }

    /**
     * 判断传入的字符串是否为null或空值
     * true 为空
     * false 不为空
     * @param str
     * @return
     */
    public static Boolean isNull(String str){
        return str == null || "".equals(str.trim());
    }

}
