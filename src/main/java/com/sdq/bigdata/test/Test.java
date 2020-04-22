package com.sdq.bigdata.test;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.Lists;
import com.sdq.bigdata.constant.CityEnum;
import com.sdq.bigdata.constant.PositionEnum;
import com.sdq.bigdata.entity.*;
import com.sdq.bigdata.other.IPBean;
import com.sdq.bigdata.other.IPList;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Slf4j
public class Test {

     public  static  Map<String, String> cookies = null;

     public static List<Result> getDatas(){

//         String[] cities = {"深圳", "广州"};//
//         String[] potisions = {"数据分析", "数据运营", "数据挖掘", "算法工程师"}; //

         List<Result> results = Collections.synchronizedList(new ArrayList<>());

         ExecutorService service = Executors.newFixedThreadPool(8);
         List<Future> futures = new ArrayList<>();

         for (CityEnum city : CityEnum.values()) {
             for (PositionEnum position : PositionEnum.values()) {
                 Future future = service.submit(new Runnable() {
                     @Override
                     public void run() {
                         try {
                             addJob(city.getName(), position.getName(), results);
                         } catch (IOException e) {
                             e.printStackTrace();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                 });
                 futures.add(future);
             }
         }
         futures.stream().forEach(future -> {
             try {
                 future.get();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             } catch (ExecutionException e) {
                 e.printStackTrace();
             }
         });

         System.out.println("总数：" + results.size());
         return results;
     }

    public static void main(String[] args) throws IOException, InterruptedException {


    }

    public static void addJob(String city, String position, List<Result> resultAll) throws IOException, InterruptedException {
        int pageNumber = 1;
        List<Result> results = new ArrayList<>();
        //第一页调用返回的结果
        Content content = getJob(city, position, pageNumber);
        if (content == null) {
            return;
        }
        if (content.getPositionResult() != null &&
                content.getPositionResult().getResult() != null &&
                (!content.getPositionResult().getResult().isEmpty())) {
            results.addAll(content.getPositionResult().getResult());
        }

        int pageCount = content.getPositionResult().getTotalCount() / content.getPageSize();

        if (content.getPositionResult().getTotalCount() % content.getPageSize() != 0) {
            pageCount = pageCount + 1;
        }

        if (pageCount > 30) {
            pageCount = 30;
        }

        System.out.printf("city=%s,position=%s,pageCount=%d", city, position, pageCount);

        while (pageNumber < pageCount) {
            try {
                pageNumber++;
                content = getJob(city, position, pageNumber);
                if (content!=null&&content.getPositionResult() != null &&
                        content.getPositionResult().getResult() != null &&
                        (!content.getPositionResult().getResult().isEmpty())) {
                    results.addAll(content.getPositionResult().getResult());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        results.forEach(result -> {
            result.setAggregatePositionIds(Lists.newArrayList(position));
        });

//        System.out.println(city + position + "***************" + results.size());
        resultAll.addAll(results);
    }

    public static Content getJob(String city, String position, int pageNumber) throws IOException, InterruptedException {
        String url = "https://www.lagou.com/jobs/positionAjax.json?city=" + city + "&needAddtionalResult=false";

        Document doc = null;

        if (Objects.isNull(cookies)) {
            cookies = getCookie();
        }

        Connection connection = Jsoup.connect(String.valueOf(url))
                .data("first", "true")
                .data("kd", String.valueOf(position))
                .data("pn", String.valueOf(pageNumber))
                .header("Accept", "application/json, text/javascript, */*; q=0.01")//去掉中文乱码
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .header("Connection", "keep-alive")
                .cookies(cookies)
                .header("Host", "www.lagou.com")
                .header("Referer", "https://www.lagou.com/jobs/list_")//去掉发生403错误HTTP error fetching URL
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(5000).ignoreContentType(true)
                .ignoreHttpErrors(true);

        doc = connection.get();
        String stringData = doc.text().toString();
        System.out.println(stringData);
        Datas datas = JSON.parseObject(stringData, Datas.class);
        if (datas.isSuccess()) {
            Content content = datas.getContent();
            return content;
        } else {
            cookies = getCookie();
//            Thread.sleep(1000);
            return getJobAgain(city, position, pageNumber);
        }
    }

    public static Content getJobAgain(String city, String position, int pageNumber) throws IOException {
        String url = "https://www.lagou.com/jobs/positionAjax.json?city=" + city + "&needAddtionalResult=false";

        Document doc = null;
        synchronized (Test.class) {
            if (Objects.isNull(cookies)) {
                cookies = getCookie();
            }
        }

        Connection connection = Jsoup.connect(String.valueOf(url))
                .data("first", "true")
                .data("kd", String.valueOf(position))
                .data("pn", String.valueOf(pageNumber))
                .header("Accept", "application/json, text/javascript, */*; q=0.01")//去掉中文乱码
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .header("Connection", "keep-alive")
                .cookies(cookies)
                .header("Host", "www.lagou.com")
                .header("Referer", "https://www.lagou.com/jobs/list_")//去掉发生403错误HTTP error fetching URL
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(5000).ignoreContentType(true)
                .ignoreHttpErrors(true);

        doc = connection.get();
        String stringData = doc.text().toString();
        System.out.println(stringData);
        Datas datas = JSON.parseObject(stringData, Datas.class);
        if (datas.isSuccess()) {
            Content content = datas.getContent();
            return content;
        }
        return null;
    }

    public static Map<String, String> getCookie() throws IOException {
        String url1 = "https://a.lagou.com/collect";

        Connection connection1 = Jsoup.connect(url1)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(10000).ignoreContentType(true)
                .ignoreHttpErrors(true);
        Connection.Response rs1 = connection1.execute();

        String url2 = "https://www.lagou.com/utrack/track.js?version=1.0.1.0";

        Connection connection2 = Jsoup.connect(url2)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(20000).ignoreContentType(true)
                .ignoreHttpErrors(true);
        Connection.Response rs2 = connection2.execute();

        Map<String, String> cookies = new HashMap<>();
        cookies.put("user_trace_token", rs1.cookie("user_trace_token"));

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
            if (item.getName().equals("X_HTTP_TOKEN")) {
                cookies.put(item.getName(), item.getValue());
            }
        });

        System.out.println("all cookies: " + cookies);
        return cookies;
    }

    //将爬虫的数据存到文件中
    public static void save() {
        try {

            File f1 = new File("E:/file/LOL/666.txt");
            if (f1.exists() == false) {
                f1.getParentFile().mkdirs();
            }
            // 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
            byte data[] = {88, 89};
            // 创建基于文件的输出流
            FileOutputStream fos = new FileOutputStream(f1);
            // 把数据写入到输出流
            fos.write(data);
            // 关闭输出流
            fos.close();
            System.out.println("输入完成");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}