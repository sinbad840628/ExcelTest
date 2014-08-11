package com.csv.operate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReadCSV {
	public static void main(String[] args) { 
		try { 
			File csv = new File("C:\\Dev\\WorkSpace\\ExcelTest\\lib\\2.csv"); // CSV文件
	
			BufferedReader br = new BufferedReader(new FileReader(csv));
	
			// 读取直到最后一行 
			String line = ""; 
			while ((line = br.readLine()) != null) { 
			// 把一行数据分割成多个字段 
			StringTokenizer st = new StringTokenizer(line, ",");
	
			while (st.hasMoreTokens()) { 
			// 每一行的多个字段用TAB隔开表示 
			System.out.print(st.nextToken() + "\t"); 
			} 
			System.out.println(); 
			} 
			br.close();
		} catch (FileNotFoundException e) { 
		// 捕获File对象生成时的异常 
		e.printStackTrace(); 
		} catch (IOException e) { 
		// 捕获BufferedReader对象关闭时的异常 
		e.printStackTrace(); 
		} 
	}//end of main function 
	
	/**
     * 读取CSV文件
     *//*
     public void  readeCsv(){
         try {    
              
             ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据
             String csvFilePath = "c:/test.csv";
              CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("SJIS"));    //一般用这编码读就可以了    
              
              reader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。
              
              while(reader.readRecord()){ //逐行读入除表头的数据    
                  csvList.add(reader.getValues());
              }            
              reader.close();
              
              for(int row=0;row<csvList.size();row++){
                  
                  String  cell = csvList.get(row)[0]; //取得第row行第0列的数据
                  System.out.println(cell);
                  
              }
              
              
         }catch(Exception ex){
             System.out.println(ex);
         }
     }
     
     *//**
      * 写入CSV文件
      *//*
     public void writeCsv(){
         try {
             
             String csvFilePath = "c:/test.csv";
              CsvWriter wr =new CsvWriter(csvFilePath,',',Charset.forName("SJIS"));
              String[] contents = {"aaaaa","bbbbb","cccccc","ddddddddd"};                    
              wr.writeRecord(contents);
              wr.close();
          } catch (IOException e) {
             e.printStackTrace();
          }
     }*/
}
