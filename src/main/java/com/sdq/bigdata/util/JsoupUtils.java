package com.sdq.bigdata.util;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.sdq.bigdata.entity.Content;
import com.sdq.bigdata.entity.Datas;
import com.sdq.bigdata.entity.PositionResult;
import com.sdq.bigdata.entity.Result;
import com.sdq.bigdata.lagou.MyMain;
import com.sdq.bigdata.other.IPBean;
import com.sdq.bigdata.other.IPList;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.*;

/**
 * Author:   chenfeiliang
 * Description:爬取数据
 */
@Slf4j
public class JsoupUtils {

    public static Set<String> uselessIp = new HashSet<>();

    public  static Map<String,String> cookies;

    public static void main(String[] args) throws Exception {
          //IPUtils.getIpAddress();

          List<Result> results = new ArrayList<>();
          int pageNumber = 1;
          PositionResult positionResult = transation("广州","数据分析",pageNumber);
          if(positionResult == null){
              return;
          }
          results.addAll(positionResult.getResult());

          int pageCount = positionResult.getTotalCount()/positionResult.getResultSize();

          if(positionResult.getTotalCount()%positionResult.getResultSize()!=0){
              pageCount = pageCount + 1;
          }
          log.info("pageCount=[{}]",pageCount);

          while (pageNumber<=pageCount){
              try {
                  int k = 0;
                  pageNumber++;
                  positionResult = transation("广州","数据分析",pageNumber);
                  if(positionResult!=null){
                      results.addAll(positionResult.getResult());
                  }else {
                      log.info("positionResult is null,pageNumber=[{}]",pageNumber);
                      k++;
                      if(k<=IPList.getSize()){
                          pageNumber--;
                      }
                  }
              }catch (Exception e){
                 log.error("pageNumber=[{}],error={}",pageNumber,e);
              }
          }
        System.out.println("总数："+results.size());


    }

    public static PositionResult transation(String city, String position, int pageNumber) throws IOException {
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
//                .header("Cookie","JSESSIONID=ABAAABAABGGAAFDDBB7A179A16F93F537EC228C8E3A990A; SEARCH_ID=9eb8df8996c64552885779a46157ad64; user_trace_token=20200412181223-8a349dc0-b982-45c5-acca-63a2557b190a; X_HTTP_TOKEN=42daf4b72327b2813436866851bf5e71415983ed09; WEBTJ-ID=20200412181221-1716de02ff578e-047c05c91f2931-87f133f-1327104-1716de02ff6673")
                .header("Host","www.lagou.com")
                .header("Referer","https://www.lagou.com/jobs/list_")//去掉发生403错误HTTP error fetching URL
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(5000).ignoreContentType(true)
                .ignoreHttpErrors(true)  ;

        List<IPBean> ipBeanList = IPList.ipBeanList;
        for (int i = 0 ;i<ipBeanList.size();i++) {
            IPBean ipBean = ipBeanList.get(i);
//            if(uselessIp.contains(ipBean.getIp())){
//                continue;
//            }
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ipBean.getIp(), ipBean.getPort()));
            try {
                if(cookies==null){
                    cookies = getCookie(proxy);
                }
                connection.proxy(proxy);
                connection.cookies(cookies);
                doc = connection.get();
                String stringData = doc.text().toString();
                Datas datas = JSON.parseObject(stringData, Datas.class);
                if(datas.isSuccess()){
                    Content content = datas.getContent();
                    PositionResult positionResult = content.getPositionResult();
                    return positionResult;
                }else {
                    log.info("data error = {},ipBean = {}",stringData,JSON.toJSONString(ipBean));
                   // uselessIp.add(ipBean.getIp());
                    cookies = getCookie(proxy);
                }
            }catch (Exception e){
                log.info("ipBean = {}", JSON.toJSONString(ipBean));

            }
//            break;

        }

       return null;
    }

    public static Map<String,String> getCookie(Proxy proxy) throws IOException {
        String url1 = "https://a.lagou.com/collect";

        Connection connection1 = Jsoup.connect(url1)
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(10000).ignoreContentType(true)
                .proxy(proxy)
                .ignoreHttpErrors(true)  ;
        Connection.Response rs1 = connection1.execute();
        System.out.println(rs1.body());
        System.out.println(rs1.cookies());

        String url2 = "https://www.lagou.com/utrack/track.js?version=1.0.1.0";

        Connection connection2 = Jsoup.connect(url2)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(20000).ignoreContentType(true)
                .proxy(proxy)
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

        page.executeJavaScript(rs2.body());

        java.util.Set<com.gargoylesoftware.htmlunit.util.Cookie> cookiesTemmp =
                webClient.getCookieManager().getCookies();
        //观察一下cookie
        cookiesTemmp.stream().forEach(item -> {
            System.out.println(item.getName() + " ---------- " + item.getValue());
            cookies.put(item.getName(),item.getValue());
        });

        System.out.println(cookies);
        return cookies;
    }



}