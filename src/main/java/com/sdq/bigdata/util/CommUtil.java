package com.sdq.bigdata.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class CommUtil {

    /**
     * 功能：驼峰命名转下划线命名
     * 小写和大写紧挨一起的地方,加上分隔符,然后全部转小写
     */
    public static String camel2under(String c)
    {
        String separator = "_";
        c = c.replaceAll("([a-z])([A-Z])", "$1"+separator+"$2").toLowerCase();
        return c;
    }

    /**
     * 功能：驼峰命名转下划线命名
     * 小写和大写紧挨一起的地方,加上分隔符,然后全部转小写
     */
    public static void main(String[] args)
    {
//        String separator = camel2under("userCode");
//        System.out.println(separator);
        List<String> list = new ArrayList<>();
        list.add("sdq");
        list.add("cfl");
        System.out.println(listToStr(list));

    }

    public static String listToStr(List<String> list){
        if(list == null || list.size()==0){
            return "";
        }
        String result = "";

        for (String s:list){
            result = result + s;
            result = result + ",";
        }

        return result.substring(0,result.length()-1);
    }


}