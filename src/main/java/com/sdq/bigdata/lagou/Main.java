package com.sdq.bigdata.lagou;

/**
 * GITHUBLoginApater.java
 *
 * Function：Jsoup model apater class.
 *
 *   ver     date           author
 * ──────────────────────────────────
 *   1.0     2017/06/22     bluetata
 *
 * Copyright (c) 2017, [https://github.com/] All Rights Reserved.
 */

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Map;

/**
 * @since      crawler(datasnatch) version(1.0)</br>
 * @author     bluetata / sekito.lv@gmail.com</br>
 * @reference  http://bluetata.blog.csdn.net/</br>
 * @version    1.0</br>
 * @update     03/14/2019 16:00
 */
public class Main {

    public static String LOGIN_URL = "https://github.com/login";
    public static String USER_AGENT = "User-Agent";
    public static String USER_AGENT_VALUE = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0";
    private static ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");;

    public static void main(String[] args) throws Exception {

//        h1("深圳", "数据分析","1"); // 模拟登陆github的用户名和密码
//          h2("深圳", "数据分析","1");
        h3("深圳", "数据分析","1");
    }


    public static void h1(String city, String position,String pageNumber) throws Exception {
        String url = "https://www.lagou.com/jobs/positionAjax.json?city="+city+"&needAddtionalResult=false";

        Document doc = null;

        Connection connection = Jsoup.connect(String.valueOf(url))
                .data("first","true")
                .data("kd",String.valueOf(position))
                .data("pn",String.valueOf(pageNumber))
                .header("Accept","application/json, text/javascript, */*; q=0.01")//去掉中文乱码
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .header("Connection","keep-alive")
                .header("Cookie", "" +
                        "user_trace_token=20200413002257-db2d2bbc-9932-477d-b74d-7633577e9f0f;" +
                        " X_HTTP_TOKEN=bd0499de4c18ba998958076851c36839947919f29d;")
                .header("Referer","https://www.lagou.com/jobs/list_")//去掉发生403错误HTTP error fetching URL
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(5000).ignoreContentType(true)
                .ignoreHttpErrors(true)  ;
         doc = connection.get();
         System.out.println(doc.body().toString());
    }

    public static void h2(String city, String position,String pageNumber) throws Exception {
        String url = "https://www.lagou.com/";

        Connection connection = Jsoup.connect(url)
//                .header("Accept","application/json, text/javascript, */*; q=0.01")//去掉中文乱码
//                .header("Accept-Encoding","gzip, deflate, br")
//                .header("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
//                .header("Connection","keep-alive")
//                .header("Referer","https://www.lagou.com/jobs/list_")//去掉发生403错误HTTP error fetching URL
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
//                .data("positionIds","7000600,7009998,7002631,6805412,7006350,7009993,6960038,6839749,5956240,6616569,6659356,6659357,6626446,6626479,6693438,6616976,6685660,2901045")
                .timeout(10000).ignoreContentType(true)
                .ignoreHttpErrors(true)  ;
        Response rs = connection.execute();
        System.out.println(rs.body());
        System.out.println(rs.cookies());

        String url2 = "https://www.lagou.com/upload/ltm/oss.html?u=/&q=341&n=467&d=1775&l=1450&dns=0&p=3681&pi=64&qn=1424&t=1586712578884";

        Connection connection2 = Jsoup.connect(url2)
//                .header("Accept","application/json, text/javascript, */*; q=0.01")//去掉中文乱码
//                .header("Accept-Encoding","gzip, deflate, br")
//                .header("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
//                .header("Connection","keep-alive")
//                .header("Referer","https://www.lagou.com/jobs/list_")//去掉发生403错误HTTP error fetching URL
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
//                .data("positionIds","7000600,7009998,7002631,6805412,7006350,7009993,6960038,6839749,5956240,6616569,6659356,6659357,6626446,6626479,6693438,6616976,6685660,2901045")
                .timeout(5000).ignoreContentType(true)
                .cookies(rs.cookies())
                .ignoreHttpErrors(true)  ;
        Response rs2 = connection2.execute();
        System.out.println(rs2.body());
        System.out.println(rs2.cookies());
        System.out.println(rs2.cookie("user_trace_token"));

        String url3 = "https://www.lagou.com/jobs/positionAjax.json?city="+city+"&needAddtionalResult=false";

        Document doc3 = null;

        Connection connection3 = Jsoup.connect(url3)
                .data("first","true")
                .data("kd",String.valueOf(position))
                .data("pn",String.valueOf(pageNumber))
                .header("Accept","application/json, text/javascript, */*; q=0.01")//去掉中文乱码
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .header("Connection","keep-alive")
                .header("Cookie", "" +
                        "user_trace_token="+rs2.cookie("user_trace_token")+";" +
                        " X_HTTP_TOKEN=bd0499de4c18ba998958076851c36839947919f29d;")
                .header("Referer","https://www.lagou.com/jobs/list_")//去掉发生403错误HTTP error fetching URL
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(5000).ignoreContentType(true)
                .ignoreHttpErrors(true)  ;
        doc3 = connection3.get();
        System.out.println(doc3.body().toString());
    }

    public static void h3(String city, String position,String pageNumber) throws Exception {

        String url1 = "https://a.lagou.com/collect";

        Connection connection1 = Jsoup.connect(url1)
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(10000).ignoreContentType(true)
                .ignoreHttpErrors(true)  ;
        Response rs1 = connection1.execute();
        System.out.println(rs1.body());
        System.out.println(rs1.cookies());

        String url2 = "https://www.lagou.com/utrack/track.js?version=1.0.1.0";

        Connection connection2 = Jsoup.connect(url2)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(20000).ignoreContentType(true)
                .ignoreHttpErrors(true);
        Response rs2 = connection2.execute();
        System.out.println(rs2.body());
        System.out.println(rs2.cookies());

        Map<String, String>  cookies = rs2.cookies();



        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //启动cookie
        webClient.getCookieManager().setCookiesEnabled(true);
        // 启动 js 解释器
        webClient.getOptions().setJavaScriptEnabled(true);
        // 禁用 css 支持 提高速度
        webClient.getOptions().setCssEnabled(false);
        // ajax
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());

        //执行请求 需要等待几秒，目的是加载js并执行js代码
        HtmlPage page = webClient.getPage(url2);
        webClient.getOptions().setTimeout(10000);
        webClient.waitForBackgroundJavaScript(4000);
        page.executeJavaScript(rs2.body());

        java.util.Set<com.gargoylesoftware.htmlunit.util.Cookie> cookiesTemmp =
                webClient.getCookieManager().getCookies();
        //观察一下cookie
        cookiesTemmp.stream().forEach(item -> {
            System.out.println(item.getName() + " ---------- " + item.getValue());
            cookies.put(item.getName(),item.getValue());
        });

        System.out.println(cookies);

        String url3 = "https://www.lagou.com/jobs/positionAjax.json?city="+city+"&needAddtionalResult=false";

        Document doc3 = null;

        Connection connection3 = Jsoup.connect(url3)
                .data("first","true")
                .data("kd",String.valueOf(position))
                .data("pn",String.valueOf(pageNumber))
                .header("Accept","application/json, text/javascript, */*; q=0.01")//去掉中文乱码
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .header("Connection","keep-alive")
//                .header("Cookie", "" +
//                        "user_trace_token="+rs2.cookie("user_trace_token")+";" +
//                        " X_HTTP_TOKEN=bd0499de4c18ba998958076851c36839947919f29d;")
                .cookies(cookies)
                .header("Referer","https://www.lagou.com/jobs/list_")//去掉发生403错误HTTP error fetching URL
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(5000).ignoreContentType(true)
                .ignoreHttpErrors(true)  ;
        doc3 = connection3.get();
        System.out.println(doc3.body().toString());
    }

}
