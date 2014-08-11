package com.excel.operate;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelOperate {
	///static String[][]  result = null;
	public static void main(String[] args) throws Exception{
		File file = new File("C:\\Dev\\WorkSpace\\ExcelTest\\lib\\22.xls");
		String[][] result = getData(file, 1);
		String[][] gwldata = result;
		int rowLength = result.length;
		System.out.println("从C:\\Dev\\WorkSpace\\ExcelTest\\lib\\22.xls 中读出的数据：");
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + "\t\t");
			}
			System.out.println();
		}//end of for loop
		System.out.println("##################转化后的格式###################################");
		for (int i = 0; i < rowLength; i++) {
			//for (int j = 0; j < gwldata[i].length; j++) {
				System.out.println("A;"+gwldata[i][0]+";;Systemliquid;"+gwldata[i][1]+";;"+gwldata[i][4]+";;;");
				System.out.println("D;"+gwldata[i][2]+";;Abbvie 96Well Microplate;"+gwldata[i][3]+";;"+gwldata[i][4]+";;;");
				System.out.println("W;");
			//}
			
		}
	}
	
	
	
	 /**
     * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
     * @param file 读取数据的源Excel
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return 读出的Excel中数据的内容
     * @throws FileNotFoundException
     * @throws IOException
     */
	public static String[][] getData(File file, int ignoreRows) throws FileNotFoundException,IOException{
		
		List<String[]> result = new ArrayList<String[]>();
		int rowSize = 0;
		
		BufferedInputStream in = new BufferedInputStream( new FileInputStream(file));
		
		//打开HSSFworkbook
		POIFSFileSystem fs = new POIFSFileSystem(in);
		
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		
		HSSFCell cell = null;
		
		for( int sheetIndex = 0 ; sheetIndex < wb.getNumberOfSheets(); sheetIndex++ ){
			HSSFSheet st = wb.getSheetAt(sheetIndex);
			
			//第一行因为是标题，所以不取
			
			for ( int rowIndex = ignoreRows ; rowIndex <= st.getLastRowNum(); rowIndex++) {
				HSSFRow row = st.getRow(rowIndex);
				
				if (row == null) {
					continue;
				}
				
				int tempRowSize = row.getLastCellNum() +1;
				if( tempRowSize > rowSize ){
					rowSize = tempRowSize;
				}
				String[] values = new String[rowSize];
				Arrays.fill(values, "");
				boolean hasValue = false;
				for (short  columnIndex = 0; columnIndex <= row.getLastCellNum();columnIndex++) {
					String value= "";
					cell = row.getCell(columnIndex);
					if (cell != null) {
						//注意！ 一定要设置成为这个状态，否则会是乱码
						//cell.set
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;

						case HSSFCell.CELL_TYPE_NUMERIC:
							if(HSSFDateUtil.isCellDateFormatted(cell)){
								Date date = cell.getDateCellValue();
								if (date != null) {
									value = new SimpleDateFormat("yyyy-MM-dd").format(date);
								}
							}else{
								//value = "";
								//value = cell.getCellType() + "";
								value = (int)cell.getNumericCellValue() + "";
							}break;
							
						case HSSFCell.CELL_TYPE_FORMULA:
							if(!cell.getStringCellValue().equals("")){
								value = cell.getStringCellValue();
							}else{
								value = cell.getNumericCellValue() + "";
							}
							break;
						case HSSFCell.CELL_TYPE_BLANK:break;
						case HSSFCell.CELL_TYPE_ERROR:value = "";break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = (cell.getBooleanCellValue() == true? "Y" : "N");
							break;
						default:
							value="";
						}//end of switch
						
					}//end of if loop
					
					if(columnIndex == 0 && value.trim().equals("")){
						break;
					}
					values[columnIndex] = rightTrim(value);
					hasValue = true;
					
				}//end of for loop
				if(hasValue){
					result.add(values);
				}
			}
		}
		in.close();
		String[][] returnArray = new String[result.size()][rowSize];
		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = (String[])result.get(i);
		}
		
		return returnArray;
		
	}//end of function getData
	
	public static String rightTrim(String str){
		if (str == null){
			return "";
		}
		int length = str.length();
		for (int i = length -1; i>=0;i--) {
			if (str.charAt(i) != 0x20) {
				break;
			}
			length--;
		}
		return str.substring(0,length);
	}
}
