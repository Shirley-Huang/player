package com.dandan.common.utils;

/**
 * @Description
 * @Author dandan
 * @Date 2020-01-07
 */
public class StringUtils {

    public static boolean isEmpty(String str){
        if(str == null || str.equals("")){
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }


}
