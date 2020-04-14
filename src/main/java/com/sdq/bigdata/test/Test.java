package com.sdq.bigdata.test;

import com.alibaba.fastjson.JSON;
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

/**
 * Author:   chenfeiliang
 * Description:小可爱是大傻瓜
 */
@Slf4j
public class Test {



    public static void main(String[] args) throws IOException {

        transation("深圳","数据分析",1);

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
                .header("Cookie", ""+
                        "user_trace_token=20200412184515-3fa6e72d-5f00-4d0e-a669-5c5b248afb02;" +
                        " X_HTTP_TOKEN=e32add487ad7873f50247868511197646a02c954d2;" )
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


        }
        return null;
    }

}