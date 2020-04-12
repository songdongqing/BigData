package com.sdq.bigdata.util;

import com.google.gson.Gson;
import com.sdq.bigdata.other.IPBean;
import com.sdq.bigdata.other.IPList;
import com.sdq.bigdata.other.IPSpider;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class IPUtils {

    private static final String MY_IP_API = "https://www.ipip.net/ip.html";

    // 获取当前ip地址，判断是否代理成功
    public static String getMyIp() {
        try {
            String html = HttpUtils.getResponseContent(MY_IP_API);

            Document doc = Jsoup.parse(html);
            Element element = doc.selectFirst("div.tableNormal");

            Element ele = element.selectFirst("table").select("td").get(1);

            String ip = element.selectFirst("a").text();

            // System.out.println(ip);
            return ip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 检测代理ip是否有效
     *
     * @param ipBean
     * @return
     */
    public static boolean isValid(IPBean ipBean) {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ipBean.getIp(), ipBean.getPort()));
        try {
            URLConnection httpCon = new URL("https://www.baidu.com").openConnection(proxy);
            httpCon.setConnectTimeout(5000);
            httpCon.setReadTimeout(5000);
            int code = ((HttpURLConnection) httpCon).getResponseCode();
            System.out.println(code);
            return code == 200;
        } catch (IOException e) {

        }
        return false;
    }

    public static void getIpAddress(){
        System.out.println("Start: ");

        IPSpider spider = new IPSpider();
        List<IPBean> list = spider.crawlHttp(3);

        System.out.println("爬取数量：" + list.size());



        Gson gson = new Gson();
        for (IPBean ipBean : list) {
            System.out.println(gson.toJson(ipBean));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        boolean valid = IPUtils.isValid(ipBean);
                        if (valid){
                            IPList.add(ipBean);
                        }
                    }catch (Exception e){

                    }finally {
                        IPList.increase();
                    }
                }
            }).start();
        }

        while (true){
            // 判断所有副线程是否完成
            if (IPList.getCount() == list.size()){
                List<IPBean> ipBeanListNew = new ArrayList<>();
                List<IPBean> ipBeanList = IPList.ipBeanList;
                for (IPBean ipBean : ipBeanList){
                    boolean falg = true;
                    for(IPBean ip : ipBeanListNew){
                        if(ip.getIp().equals(ipBean.getIp())){
                            falg = false;
                        }
                    }
                    if(falg){
                        ipBeanListNew.add(ipBean);
                    }
                    IPList.ipBeanList = ipBeanListNew;
                }
                System.out.println("有效数量：" + IPList.getSize());
                break;
            }
        }
    }
}
