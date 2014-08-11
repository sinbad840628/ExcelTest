package com.excel.operate;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.NumberFormat;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileExcel {
	public static void main(String[] args) throws Exception {
		FileExcel rf = new FileExcel();
		String s = "";
		s = rf.readEXCEL("C:\\Dev\\WorkSpace\\ExcelTest\\lib\\22.csv");
		//s = rf.readEXCEL2007("C:\\Dev\\WorkSpace\\ExcelTest\\lib\\2.csv");
		System.out.println(s);
	}

	// 读取xls文件
	@SuppressWarnings("deprecation")
	public String readEXCEL(String file) throws IOException {
		StringBuilder content = new StringBuilder();
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));// 创建对Excel工作簿文件的引用
		for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
			if (null != workbook.getSheetAt(numSheets)) {
				HSSFSheet aSheet = workbook.getSheetAt(numSheets);// 获得一个sheet
				for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet
						.getLastRowNum(); rowNumOfSheet++) {
					if (null != aSheet.getRow(rowNumOfSheet)) {
						HSSFRow aRow = aSheet.getRow(rowNumOfSheet); // 获得一个行
						for (short cellNumOfRow = 0; cellNumOfRow <= aRow
								.getLastCellNum(); cellNumOfRow++) {
							if (null != aRow.getCell(cellNumOfRow)) {
								HSSFCell aCell = aRow.getCell(cellNumOfRow);// 获得列值
								if (this.convertCell(aCell).length() > 0) {
									content.append(this.convertCell(aCell));
								}
							}
							content.append("\n");
						}
					}
				}
			}
		}
		return content.toString();
	}

	// 读取xlsx文件
	public String readEXCEL2007(String file) throws IOException {
		StringBuilder content = new StringBuilder();
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
			if (null != workbook.getSheetAt(numSheets)) {
				XSSFSheet aSheet = workbook.getSheetAt(numSheets);// 获得一个sheet
				for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet
						.getLastRowNum(); rowNumOfSheet++) {
					if (null != aSheet.getRow(rowNumOfSheet)) {
						XSSFRow aRow = aSheet.getRow(rowNumOfSheet); // 获得一个行
						for (short cellNumOfRow = 0; cellNumOfRow <= aRow
								.getLastCellNum(); cellNumOfRow++) {
							if (null != aRow.getCell(cellNumOfRow)) {
								XSSFCell aCell = aRow.getCell(cellNumOfRow);// 获得列值
								if (this.convertCell(aCell).length() > 0) {
									content.append(this.convertCell(aCell));
								}
							}
							content.append("\n");
						}
					}
				}
			}
		}
		return content.toString();
	}

	private String convertCell(Cell cell) {
		NumberFormat formater = NumberFormat.getInstance();
		formater.setGroupingUsed(false);
		String cellValue = "";
		if (cell == null) {
			return cellValue;
		}

		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			cellValue = formater.format(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_STRING:
			cellValue = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			cellValue = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			cellValue = Boolean.valueOf(cell.getBooleanCellValue()).toString();
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			cellValue = String.valueOf(cell.getErrorCellValue());
			break;
		default:
			cellValue = "";
		}
		return cellValue.trim();
	}
}