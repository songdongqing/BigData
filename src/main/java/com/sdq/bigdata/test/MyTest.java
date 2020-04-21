package com.sdq.bigdata.test;

import com.sdq.bigdata.util.CommUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MyTest {


    public static void main(String[] args) {
        //实体类所在的package在磁盘上的绝对路径 E:\git\Repository\BigData2\BigData\src\main\java\com\sdq\bigdata\entity
        String packageName = "E:\\git\\Repository\\BigData2\\BigData\\src\\main\\java\\com\\sdq\\bigdata\\entity";
        //生成sql的文件夹
        String filePath = "E:\\create\\";
        //项目中实体类的路径
        String prefix = "com.sdq.bigdata.entity.";
        String className = "";

        StringBuffer sqls = new StringBuffer();
        //获取包下的所有类名称
        List<String> list = getAllClasses(packageName);
        for (String str : list) {
            className = prefix + str.substring(0, str.lastIndexOf("."));
            String sql = generateSql(className, filePath);
            sqls.append(sql);
        }
        System.out.println(sqls.toString());
        StringToSql(sqls.toString(), filePath + "report.sql");

    }
    /**
     * 根据实体类生成建表语句
     * @author
     * @date	2019年1月14日
     * @param className 全类名
     * @param filePath 磁盘路径  如 : d:/workspace/
     */
    public static String generateSql(String className,String filePath){
        try {
            Class<?> clz = Class.forName(className);
            className = clz.getSimpleName();
            Field[] fields = clz.getDeclaredFields();
            StringBuffer column = new StringBuffer();
            String varchar = " varchar(255) DEFAULT NULL,";
            for (Field f : fields) {
                column.append(" \n `"+CommUtil.camel2under(f.getName())+"`").append(varchar);
            }
            StringBuffer sql = new StringBuffer();
            sql.append("\n DROP TABLE IF EXISTS `"+className+"`; ")
                    .append(" \n CREATE TABLE `"+className+"`  (")
                    .append(" \n `id` varchar(50) NOT NULL,")
                    .append(" \n "+column)
                    .append(" \n PRIMARY KEY (`id`) ,")
                    .append("\n INDEX `id`(`id`) ")
                    .append(" \n ) ENGINE = InnoDB;");
            return sql.toString();
        } catch (ClassNotFoundException e) {

            return null;
        }

    }

    /**
     * 获取包下的所有类名称,获取的结果类似于 XXX.java
     * @author
     * @date	2019年1月14日
     * @param packageName
     * @return
     */
    public static List<String> getAllClasses(String packageName){
        List<String> classList = new ArrayList<String>();
        String className="";
        File f = new File(packageName);
        if(f.exists() && f.isDirectory()){
            File[] files = f.listFiles();
            for (File file : files) {
                className = file.getName();
                classList.add(className);
            }
            return classList;
        }else{

            return null;
        }
    }
    /**
     * 将string 写入sql文件
     * @author
     * @date	2019年1月14日
     * @param str
     * @param path
     */
    public static void StringToSql(String str,String path){
        byte[] sourceByte = str.getBytes();
        if(null != sourceByte){
            try {
                File file = new File(path);     //文件路径（路径+文件名）
                if (!file.exists()) {   //文件不存在则创建文件，先创建目录
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                FileOutputStream outStream = new FileOutputStream(file);    //文件输出流用于将数据写入文件
                outStream.write(sourceByte);
                outStream.flush();
                outStream.close();  //关闭文件输出流
                System.out.println("生成成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}