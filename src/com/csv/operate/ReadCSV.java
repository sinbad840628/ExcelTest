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
			File csv = new File("C:\\Dev\\WorkSpace\\ExcelTest\\lib\\2.csv"); // CSV�ļ�
	
			BufferedReader br = new BufferedReader(new FileReader(csv));
	
			// ��ȡֱ�����һ�� 
			String line = ""; 
			while ((line = br.readLine()) != null) { 
			// ��һ�����ݷָ�ɶ���ֶ� 
			StringTokenizer st = new StringTokenizer(line, ",");
	
			while (st.hasMoreTokens()) { 
			// ÿһ�еĶ���ֶ���TAB������ʾ 
			System.out.print(st.nextToken() + "\t"); 
			} 
			System.out.println(); 
			} 
			br.close();
		} catch (FileNotFoundException e) { 
		// ����File��������ʱ���쳣 
		e.printStackTrace(); 
		} catch (IOException e) { 
		// ����BufferedReader����ر�ʱ���쳣 
		e.printStackTrace(); 
		} 
	}//end of main function 
	
	/**
     * ��ȡCSV�ļ�
     *//*
     public void  readeCsv(){
         try {    
              
             ArrayList<String[]> csvList = new ArrayList<String[]>(); //������������
             String csvFilePath = "c:/test.csv";
              CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("SJIS"));    //һ�����������Ϳ�����    
              
              reader.readHeaders(); // ������ͷ   �����Ҫ��ͷ�Ļ�����Ҫд��䡣
              
              while(reader.readRecord()){ //���ж������ͷ������    
                  csvList.add(reader.getValues());
              }            
              reader.close();
              
              for(int row=0;row<csvList.size();row++){
                  
                  String  cell = csvList.get(row)[0]; //ȡ�õ�row�е�0�е�����
                  System.out.println(cell);
                  
              }
              
              
         }catch(Exception ex){
             System.out.println(ex);
         }
     }
     
     *//**
      * д��CSV�ļ�
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
