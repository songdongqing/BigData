//package com.sdq.bigdata.hbase;
//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.*;
//import org.apache.hadoop.hbase.client.*;
//import org.apache.hadoop.hbase.util.Bytes;
//
//import java.io.IOException;
//
///**
// * Author:   chenfeiliang
// * Description:
// */
//public class HbaseClient {
//
//    public static Configuration conf;
//    static{
//        //使用HBaseConfiguration的单例方法实例化
//        conf = HBaseConfiguration.create();
//        conf.set("hbase.zookeeper.quorum", "192.168.19.11");
//        conf.set("hbase.zookeeper.property.clientPort", "2181");
//    }
//
//    //判断表是否存在
//    public static boolean isTableExist(String tableName) throws MasterNotRunningException,
//            ZooKeeperConnectionException, IOException {
//        //在HBase中管理、访问表需要先创建HBaseAdmin对象
////Connection connection = ConnectionFactory.createConnection(conf);
////HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
//        HBaseAdmin admin = new HBaseAdmin(conf);
//        return admin.tableExists(tableName);
//    }
//
//    //插入数据成功
//    public static void addRowData(String tableName, String rowKey, String columnFamily, String
//            column, String value) throws IOException{
//        //创建HTable对象
//        HTable hTable = new HTable(conf, tableName);
//        //向表中插入数据
//        Put put = new Put(Bytes.toBytes(rowKey));
//        //向Put对象中组装数据
//        put.add(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(value));
//        hTable.put(put);
//        hTable.close();
//        System.out.println("插入数据成功");
//    }
//
//    //获取所有数据
//    public static void getAllRows(String tableName) throws IOException{
//        HTable hTable = new HTable(conf, tableName);
//        //得到用于扫描region的对象
//        Scan scan = new Scan();
//        //使用HTable得到resultcanner实现类的对象
//        ResultScanner resultScanner = hTable.getScanner(scan);
//        for(Result result : resultScanner){
//            Cell[] cells = result.rawCells();
//            for(Cell cell : cells){
//                //得到rowkey
//                System.out.println("行键:" + Bytes.toString(CellUtil.cloneRow(cell)));
//                //得到列族
//                System.out.println("列族" + Bytes.toString(CellUtil.cloneFamily(cell)));
//                System.out.println("列:" + Bytes.toString(CellUtil.cloneQualifier(cell)));
//                System.out.println("值:" + Bytes.toString(CellUtil.cloneValue(cell)));
//            }
//        }
//    }
//
//    //创建表
//    public static void createTable(String tableName, String... columnFamily) throws
//            MasterNotRunningException, ZooKeeperConnectionException, IOException{
//        HBaseAdmin admin = new HBaseAdmin(conf);
//        //判断表是否存在
//        if(isTableExist(tableName)){
//            System.out.println("表" + tableName + "已存在");
//            //System.exit(0);
//        }else{
//            //创建表属性对象,表名需要转字节
//            HTableDescriptor descriptor = new HTableDescriptor(TableName.valueOf(tableName));
//            //创建多个列族
//            for(String cf : columnFamily){
//                descriptor.addFamily(new HColumnDescriptor(cf));
//            }
//            //根据对表的配置，创建表
//            admin.createTable(descriptor);
//            System.out.println("表" + tableName + "创建成功！");
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.out.println(isTableExist("student"));
////        addRowData("student","1002","info","age","18");
////        getAllRows("student");
////        createTable("position","info");
//        com.sdq.bigdata.entity.Result result = new com.sdq.bigdata.entity.Result();
//        result.setSalary("1111");
//        result.setCity("广州");
//        result.setPositionName("数据分析");
//        String rowKey = result.getCity()+"_"+result.getPositionName()+"_"+result.getSalary();
//        addRowData("position",rowKey,"info","city",result.getCity());
//        addRowData("position",rowKey,"info","position",result.getPositionName());
//        addRowData("position",rowKey,"info","salary",result.getSalary());
//        getAllRows("position");
///*
//                01_11 (0,01_11)
//                01_11 (0,01_11)
//                02_11  统计样本数量
//         sdq   广州 数据分析
//        cfl   深圳 数据分析
//                8
//        xm
//        xl
//                map(key,value) {
//                key = value (01_11,1) 01_11
//                 value =
//                 }
//                 reduce(key,Itertor)  (01_11,{1,1})
//
//
//        深圳  数据分析  salary:10K-20K  company:上市公司  hdfs(hadoop)
//        深圳  数据分析  10K-21K  上市公司  hdfs(hadoop)
//        map(key,value){  (0,深圳  数据分析  10K-20K  上市公司)
//                         (19,深圳  数据分析  10K-20K  上市公司)
//
//        }
//        reduce(key,Itertor){
//        }
//                */
//
//
//            //
//
//
//
//    }
//
//}