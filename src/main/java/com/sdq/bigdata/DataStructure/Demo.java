package com.sdq.bigdata.DataStructure;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class Demo {

    public  static List<Integer> list = new ArrayList<>();
    public  static int b[][] = {{0,0,0},{0,0,0},{0,0,0}};
    public static void main(String[] args) {

        int a[][] = {{1,2,5},{10,11,6},{12,12,7}};

        output(a);
        getDatas(a,0,0);


    }
    public static void prin(){
        System.out.println(JSON.toJSONString(list));
    }

    public static void getDatas(int a[][],int i,int j){
        b[i][j]=1;
        list.add(a[i][j]);
         if(i==0){
             if(j==0){            //左上角
                 boolean b1 =xia(a,i,j);//
                 boolean b2 =you(a,i,j);
                 if((!b1)&&(!b2)){
                     prin();
                 }
                 list.remove(list.size()-1);

             }else if(j==a[0].length-1){ //右上角
                 boolean b1 =xia(a,i,j);
                 boolean b2 =zuo(a,i,j);
                 if((!b1)&&(!b2)){
                     prin();
                 }
                 list.remove(list.size()-1);


             }else {
                 boolean b1 =xia(a,i,j);
                 boolean b2 =you(a,i,j);
                 boolean b3 =zuo(a,i,j);
                 if((!b1)&&(!b2)&&(!b3)){
                     prin();
                 }
                 list.remove(list.size()-1);
             }
         }
        else if(j==0){           //第一列
            if(i==a[0].length-1){ //左下角
                boolean b2 =you(a,i,j);
                boolean b3 =shang(a,i,j);
                if((!b2)&&(!b3)){
                    prin();
                }
                list.remove(list.size()-1);

            } else {
                boolean b1 =xia(a,i,j);
                boolean b2 =you(a,i,j);
                boolean b3 =shang(a,i,j);
                if((!b1)&&(!b2)&&(!b3)){
                    prin();
                }
                list.remove(list.size()-1);

            }

        }
        else if(j==a.length-1){   //最后一列
            if(i==a[0].length-1){ //右下角的那一个
                boolean b1 =shang(a,i,j);
                boolean b2 =zuo(a,i,j);
                if((!b1)&&(!b2)){
                    prin();
                }
                list.remove(list.size()-1);
            }else {
                boolean b1 =xia(a,i,j);
                boolean b2 =shang(a,i,j);
                boolean b3 =zuo(a,i,j);
                if((!b1)&&(!b2)&&(!b3)){
                    prin();
                }
                list.remove(list.size()-1);
            }


        }
        else if(i==a.length-1){ //最后一行
             boolean b1 =you(a,i,j);
             boolean b2 =shang(a,i,j);
             boolean b3 =zuo(a,i,j);
             if((!b1)&&(!b2)&&(!b3)){
                 prin();
             }
             list.remove(list.size()-1);

         }else {
             boolean b1 = xia(a, i, j);
             boolean b2 = you(a, i, j);
             boolean b3 = shang(a, i, j);
             boolean b4 = zuo(a, i, j);
             if((!b1)&&(!b2)&&(!b3)&&(!b4)){
                 prin();
             }
             list.remove(list.size()-1);

         }
    }
    public static boolean shang(int a[][],int i ,int j){
        if(a[i][j]<a[i-1][j]){
            getDatas(a,i-1,j);//shang
            return true;
        }
        return false;
    }

    public static boolean xia(int a[][],int i ,int j){
        if(a[i][j]<a[i+1][j]){
            getDatas(a,i+1,j);//xia
            return true;
        }
        return false;
    }

    public static boolean zuo(int a[][],int i ,int j){
        if(a[i][j]<a[i][j-1]){
            getDatas(a,i,j-1);//zuo
            return true;
        }
        return false;
    }

    public static boolean you(int a[][],int i ,int j){
        if(a[i][j]<a[i][j+1]){
            getDatas(a,i,j+1);//you
            return true;
        }
        return false;
    }

    public static void output(int a[][]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }

}