package com.sdq.bigdata.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class HbaseClient {

    public static Configuration conf;
    HBaseAdmin admin = new HBaseAdmin(conf);

    static {
        //使用HBaseConfiguration的单例方法实例化
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "192.168.19.11");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
    }

    public HbaseClient() throws IOException {
    }

    //判断表是否存在
    public static boolean isTableExist(String tableName) throws MasterNotRunningException,
            ZooKeeperConnectionException, IOException {
        //在HBase中管理、访问表需要先创建HBaseAdmin对象
//Connection connection = ConnectionFactory.createConnection(conf);
//HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
        HBaseAdmin admin = new HBaseAdmin(conf);
        return admin.tableExists(tableName);
    }

    //插入数据成功
    public static void addRowData(String tableName, String rowKey, String columnFamily, String
            column, String value) throws IOException {
        //创建HTable对象
        HTable hTable = new HTable(conf, tableName);
        //向表中插入数据
        Put put = new Put(Bytes.toBytes(rowKey));
        //向Put对象中组装数据
        put.add(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(value));
        hTable.put(put);
        hTable.close();
        System.out.println("插入数据成功");
    }

    //获取所有数据
    public static void getAllRows(String tableName) throws IOException {
        Map<String, List<String>> map = new HashMap();
        HTable hTable = new HTable(conf, tableName);
        //得到用于扫描region的对象
        Scan scan = new Scan();
        //使用HTable得到resultcanner实现类的对象
        ResultScanner resultScanner = hTable.getScanner(scan);
        for (Result result : resultScanner) {
            Cell[] cells = result.rawCells();
            String family = "";
            for (Cell cell : cells) {

//                String key = Bytes.toString(CellUtil.cloneRow(cell))+"_"+Bytes.toString(CellUtil.cloneFamily(cell));
//                if(map.containsKey(key))
//                {
//
//                }else {
//
//                }
                System.out.print("列族：" + Bytes.toString(CellUtil.cloneFamily(cell)) + " ");
                System.out.print("行键：" + Bytes.toString(CellUtil.cloneRow(cell)) + " ");
                System.out.print("列:" + Bytes.toString(CellUtil.cloneQualifier(cell)) + " ");
                System.out.print("值:" + Bytes.toString(CellUtil.cloneValue(cell)) + " ");
                System.out.println();
            }

        }
    }

    //创建表
    public static void createTable(String tableName, String... columnFamily) throws
            MasterNotRunningException, ZooKeeperConnectionException, IOException {
        HBaseAdmin admin = new HBaseAdmin(conf);
        //判断表是否存在
        if (isTableExist(tableName)) {
            System.out.println("表" + tableName + "已存在");
            //System.exit(0);
        } else {
            //创建表属性对象,表名需要转字节
            HTableDescriptor descriptor = new HTableDescriptor(TableName.valueOf(tableName));
            //创建多个列族
            for (String cf : columnFamily) {
                descriptor.addFamily(new HColumnDescriptor(cf));
            }
            //根据对表的配置，创建表
            admin.createTable(descriptor);
            System.out.println("表" + tableName + "创建成功！");
        }
    }

    //添加列族
    public void addAFamily(String tableName, String familyName) throws IOException {

        TableName tablename = TableName.valueOf(tableName);
        admin.disableTable(tablename);
        HTableDescriptor hDescriptor = admin.getTableDescriptor(tablename);
        HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(familyName);
        hDescriptor.addFamily(hColumnDescriptor);
        admin.modifyTable(tablename, hDescriptor);
        admin.enableTable(tablename);


    }


    public static void main(String[] args) throws IOException {

        System.out.println("***************** 样本情况 ******************************");
        getAllRows("position");
        System.out.println();

        System.out.println("***************** 工资情况 ******************************");
        getAllRows("salary");
        System.out.println();

        System.out.println("*************** 公司规模分布 ********************************");
        getAllRows("companySize");
        System.out.println();

        System.out.println("*************** 工作年限要求 ********************************");
        getAllRows("workYear");
        System.out.println();

        System.out.println("*************** 公司融资情况 ********************************");
        getAllRows("companySalary");
        System.out.println();

        System.out.println("*************** 行业分布 ********************************");
        getAllRows("industryField");
        System.out.println();

        System.out.println("*************** 职位要求 ********************************");
        getAllRows("skill");



    }

}