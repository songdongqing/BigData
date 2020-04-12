package com.sdq.bigdata.util;

import com.alibaba.fastjson.JSON;
import com.sdq.bigdata.entity.Content;
import com.sdq.bigdata.entity.Datas;
import com.sdq.bigdata.entity.PositionResult;
import com.sdq.bigdata.entity.Result;
import com.sdq.bigdata.other.IPBean;
import com.sdq.bigdata.other.IPList;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:爬取数据
 */
@Slf4j
public class JsoupUtils {



    public static void main(String[] args) throws IOException {
          IPUtils.getIpAddress();

          List<Result> results = new ArrayList<>();
          int pageNumber = 1;
          PositionResult positionResult = transation("深圳","数据分析",pageNumber);
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
                  pageNumber++;
                  positionResult = transation("深圳","数据分析",pageNumber);
                  if(positionResult!=null){
                      results.addAll(positionResult.getResult());
                  }else {
                      log.info("positionResult is null,pageNumber=[{}]",pageNumber);
                      break;
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
                .header("Cookie","JSESSIONID=ABAAABAABGGAAFDDBB7A179A16F93F537EC228C8E3A990A; SEARCH_ID=9eb8df8996c64552885779a46157ad64; user_trace_token=20200412181223-8a349dc0-b982-45c5-acca-63a2557b190a; X_HTTP_TOKEN=42daf4b72327b2813436866851bf5e71415983ed09; WEBTJ-ID=20200412181221-1716de02ff578e-047c05c91f2931-87f133f-1327104-1716de02ff6673")
                .header("Host","www.lagou.com")
                .header("Referer","https://www.lagou.com/jobs/list_")//去掉发生403错误HTTP error fetching URL
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                .timeout(5000).ignoreContentType(true)
                .ignoreHttpErrors(true)  ;

        List<IPBean> ipBeanList = IPList.ipBeanList;
        for (IPBean ipBean : ipBeanList) {
            try {
//                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ipBean.getIp(), ipBean.getPort()));
                connection .proxy(ipBean.getIp(),ipBean.getPort());
                doc = connection.get();
                String stringData = doc.text().toString();
                Datas datas = JSON.parseObject(stringData, Datas.class);
                if(datas.isSuccess()){
                    Content content = datas.getContent();
                    PositionResult positionResult = content.getPositionResult();
                    return positionResult;
                }else {
                    log.info("data error = {},ipBean = {}",stringData,JSON.toJSONString(ipBean));
                }
            }catch (Exception e){
                log.info("ipBean = {}", JSON.toJSONString(ipBean));

            }
//            break;

        }

       return null;
    }
}