package com.sdq.bigdata.util;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws IOException {
//        String url = "https://a.lagou.com/collect";
//        Connection connection = Jsoup.connect(String.valueOf(url))
//                .timeout(5000).ignoreContentType(true)
//                .ignoreHttpErrors(true)  ;
//        Document doc = connection.get();
//        String stringData = doc.body().toString();
//        log.info("stringData:{}",stringData);
        get51("深圳","数据分析");
    }

    public static void get51(String city,String position) throws IOException {
        String url = "https://search.51job.com/list/040000,000000,0000,01,9,99,"+position+",2,1.html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
        Connection connection = Jsoup.connect(String.valueOf(url))
                .timeout(5000).ignoreContentType(true)
                .ignoreHttpErrors(true)  ;
        Document doc = connection.get();
        String stringData = doc.body().toString();
        log.info("stringData:{}",stringData);
    }

}