package com.sdq.bigdata.test;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.sdq.bigdata.entity.Content;
import com.sdq.bigdata.entity.Datas;
import com.sdq.bigdata.entity.PositionResult;
import com.sdq.bigdata.other.IPBean;
import com.sdq.bigdata.other.IPList;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;

/**
 * Author:   chenfeiliang
 * Description:小可爱是大傻瓜
 */

public class Test {

    public  static Map<String,String> cookies = null;

    public static void main(String[] args) throws IOException, InterruptedException {



        for (int i=1;i<=30;i++) {
//            getJob("深圳", "数据分析", i);
//            Thread.sleep(5000);
            System.out.println(JSON.toJSONString(getCookie()));
        }

    }

    public static PositionResult getJob(String city, String position, int pageNumber) throws IOException {
        String url = "https://www.lagou.com/jobs/positionAjax.json?city="+city+"&needAddtionalResult=false";

        Document doc = null;

        if(Objects.isNull(cookies)){
            cookies = getCookie();
        }

        Connection connection = Jsoup.connect(String.valueOf(url))
                .data("first","true")
                .data("kd",String.valueOf(position))
                .data("pn",String.valueOf(pageNumber))
                .header("Accept","application/json, text/javascript, */*; q=0.01")//去掉中文乱码
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .header("Connection","keep-alive")
                .cookies(cookies)
                .header("Host","www.lagou.com")
                .header("Referer","https://www.lagou.com/jobs/list_")//去掉发生403错误HTTP error fetching URL
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(5000).ignoreContentType(true)
                .ignoreHttpErrors(true)  ;

        doc = connection.get();
        String stringData = doc.text().toString();
        System.out.println(stringData);
        Datas datas = JSON.parseObject(stringData, Datas.class);
        if(datas.isSuccess()){
            Content content = datas.getContent();
            PositionResult positionResult = content.getPositionResult();
            return positionResult;
        }else {
            cookies = null;
            return getJobAgain(city,position,pageNumber);
        }
    }

    public static PositionResult getJobAgain(String city, String position, int pageNumber) throws IOException{
        String url = "https://www.lagou.com/jobs/positionAjax.json?city="+city+"&needAddtionalResult=false";

        Document doc = null;

        if(Objects.isNull(cookies)){
            cookies = getCookie();
        }

        Connection connection = Jsoup.connect(String.valueOf(url))
                .data("first","true")
                .data("kd",String.valueOf(position))
                .data("pn",String.valueOf(pageNumber))
                .header("Accept","application/json, text/javascript, */*; q=0.01")//去掉中文乱码
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .header("Connection","keep-alive")
                .header("Cookie", ""+
                        "user_trace_token=20200414230729-d4be2376-99c8-47b7-bc48-0c6a6f8a0f82;" +
                        //20200412184515-3fa6e72d-5f00-4d0e-a669-5c5b248afb02
                        "X_HTTP_TOKEN=42daf4b72327b2819486786851bf5e71415983ed09;" )
                //77a12b351ef581248665786851fc8c2688b48ea3c2
                .header("Host","www.lagou.com")
                .header("Referer","https://www.lagou.com/jobs/list_")//去掉发生403错误HTTP error fetching URL
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(5000).ignoreContentType(true)
                .ignoreHttpErrors(true)  ;

        doc = connection.get();
        String stringData = doc.text().toString();
        System.out.println(stringData);
        Datas datas = JSON.parseObject(stringData, Datas.class);
        if(datas.isSuccess()){
            Content content = datas.getContent();
            PositionResult positionResult = content.getPositionResult();
            return positionResult;
        }
        return null;
    }

    public static Map<String,String> getCookie() throws IOException {
        String url1 = "https://a.lagou.com/collect";

        Connection connection1 = Jsoup.connect(url1)
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(10000).ignoreContentType(true)
                .ignoreHttpErrors(true)  ;
        Connection.Response rs1 = connection1.execute();
        System.out.println(rs1.body());
        System.out.println(rs1.cookies());

        String url2 = "https://www.lagou.com/utrack/track.js?version=1.0.1.0";

        Connection connection2 = Jsoup.connect(url2)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(20000).ignoreContentType(true)
                .ignoreHttpErrors(true);
        Connection.Response rs2 = connection2.execute();
        System.out.println(rs2.body());
        System.out.println(rs2.cookies());

        Map<String, String> cookies = rs2.cookies();

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
        page.executeJavaScript("document.cookie=''");
        page.executeJavaScript(rs2.body());

        java.util.Set<com.gargoylesoftware.htmlunit.util.Cookie> cookiesTemmp =
                webClient.getCookieManager().getCookies();
        //观察一下cookie
        cookiesTemmp.stream().forEach(item -> {
            System.out.println(item.getName() + " ---------- " + item.getValue());
            cookies.put(item.getName(),item.getValue());
        });
        return cookies;
    }

}