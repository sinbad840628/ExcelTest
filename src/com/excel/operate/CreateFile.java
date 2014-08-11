package com.excel.operate;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

/**
 * @author wd
 * 
 */
public class CreateFile extends Frame {
	private static final long serialVersionUID = 7863555841628851148L;
	private static final String currentDirectory = ".";
	private static final String txtFile = ".txt";
	private static final String txtFileName = "文本文件(*.txt)";
	private static final String csvFile = ".csv";
	private static final String csvFileName = "csv文件(*.csv)";
	private static final String zero = "0";
	private static final String Charset = "UTF-8";
	private static final String colon = ":";
	private static final String space = " ";
	private static final String nan = "NaN";
	private static final String[] key = {"借出者", "全", "秒标", "净标", "普通", "快标", "阳光"};
	private static final String empty = "";
	private static final String lineBreak = "\r\n";
	
	private ArrayList<String> names;
	private ArrayList<String> values;
	
	public CreateFile() {
		this.names = new ArrayList<String>();
		this.values = new ArrayList<String>();
	}
	
	private int findIndex(String name) {
		for (int i = 0; i < names.size(); i++) {
			if (name.equalsIgnoreCase(names.get(i))) {
				return i;
			}
		}
		
		return -1;
	}
	
	private String getValue(int index) {
		return this.values.get(index);
	}
	
	private String getString(ArrayList<String> values) {
		String value = empty;
		for (int i = 0; i < values.size(); i ++) {
			value += "," + values.get(i);
		}
		
		return value;
	}
	
	private String diagram1(String name) {
		int index;
		String rate = zero;
		ArrayList<String> valueList = new ArrayList<String>();
		
		index = findIndex(name + key[1]);
		if (index == -1) {
			valueList.add(zero);
		} else {
			valueList.add(getValue(index));
			rate = getValue(index + 1);
		}
		
		index = findIndex(name + key[0]);
		if (index == -1) {
			valueList.add(zero);
		} else {
			valueList.add(getValue(index));
		}
		
		valueList.add(rate);
		
		return getString(valueList);
	}
	
	private String diagram2(String name) {
		int index;
		ArrayList<String> valueList = new ArrayList<String>();
		
		for (int i = 1; i < 5; i++) {
			index = findIndex(name + key[i]);
			if (index == -1) {
				valueList.add(zero);
			} else {
				valueList.add(getValue(index));
			}
		}
		
		return getString(valueList);
	}
	
	private String diagram3(String name) {
		int index;
		ArrayList<String> valueList = new ArrayList<String>();
		
		for (int i = 2; i < 5; i++) {
			index = findIndex(name + key[i]);
			if (index == -1) {
				valueList.add(zero);
			} else {
				valueList.add(getValue(index + 1));
			}
		}
		
		return getString(valueList);
	}
	
	private String diagram4(String name) {
		int index;
		ArrayList<String> valueList = new ArrayList<String>();
		
		index = findIndex(name + key[0]);
		if (index == -1) {
			valueList.add(zero);
			valueList.add(zero);
		} else {
			valueList.add(getValue(index));
			valueList.add(getValue(index + 1));
		}
		
		return getString(valueList);
	}
	
	private void writeFile() {
		BufferedWriter bw;
		String[] customer = {"人人贷", "红岭创投", "E速贷", "808信贷", "中 宝", "易贷365", "微贷网", "搜搜贷"};
		String[] acronym = {  "RRD",     "HL",     "ESD",   "808",    "ZB",    "ED365",  "WDW",    "SSD"};
		String[] titles = {"平台名,贷款万,借出者,利率", 
						   ",贷款,秒标	,净标,普通标",
						   "利率,秒标利率%,净标利率%,普标利率%",
						   "人数,借出人数,借入人数"};
		String charSet = "GB2312";
		String fileName;
		try {
			fileName = fileDialog(0);
			if (fileName == null) {
				return;
			}
			File f = new File(fileName);
			if (!f.exists()) {
				f.createNewFile();
			}
			
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), charSet));
			
			bw.write(titles[0] + lineBreak);
			for (int i = 0; i < customer.length; i++) {
				bw.write(customer[i] + diagram1(acronym[i]) + lineBreak);
			}
			bw.write(lineBreak + lineBreak);
			
			bw.write(titles[1] + lineBreak);
			for (int i = 0; i < customer.length; i++) {
				bw.write(customer[i] + diagram2(acronym[i]) + lineBreak);
			}
			bw.write(lineBreak + lineBreak);
			
			bw.write(titles[2] + lineBreak);
			for (int i = 0; i < customer.length; i++) {
				bw.write(customer[i] + diagram3(acronym[i]) + lineBreak);
			}
			bw.write(lineBreak + lineBreak);
			
			bw.write(titles[3] + lineBreak);
			for (int i = 0; i < customer.length; i++) {
				bw.write(customer[i] + diagram4(acronym[i]) + lineBreak);
			}
			bw.write(lineBreak + lineBreak);
			
			bw.close();				
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String fileDialog(int dialogType) {
		JFileChooser filechooser = new JFileChooser();
		filechooser.setCurrentDirectory(new File(currentDirectory));
		filechooser.setAcceptAllFileFilterUsed(false);
		String fileName;
		
		if (dialogType == 1) {
			filechooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
				public boolean accept(File f) {
					if (f.getName().endsWith(txtFile) || f.isDirectory()) {
						return true;
					}
					return false;
				}
	
				public String getDescription() {
					return txtFileName;
				}
			});
		} else {
			filechooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
				public boolean accept(File f) {
					if (f.getName().endsWith(csvFile) || f.isDirectory()) {
						return true;
					}
					return false;
				}
	
				public String getDescription() {
					return csvFileName;
				}
			});
		}

		int ret;
		if (dialogType == 1) {
			ret = filechooser.showOpenDialog(null);
			if (ret == JFileChooser.APPROVE_OPTION) {
				return filechooser.getSelectedFile().getAbsolutePath();
			}
		} else {
			ret = filechooser.showSaveDialog(null);
			if (ret == JFileChooser.APPROVE_OPTION) {
				fileName = filechooser.getSelectedFile().getAbsolutePath();
				if (!csvFile.equalsIgnoreCase(fileName.substring(fileName.length() - 4, fileName.length()))) {
					fileName += csvFile;
				}
				return fileName;
			}
		}
		
		return null;
	}
	
	public void read() {
		String lineContent;
		int index;
		String value = zero;
		String fileName = fileDialog(1);
		
		if (fileName != null) {
			File file = new File(fileName);
			try {
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), Charset);
				BufferedReader in = new BufferedReader(read);
				while ((lineContent = in.readLine()) != null) {
					while (!"".equals(lineContent)) {
						index = lineContent.indexOf(colon);
						if (index > 0) {
							this.names.add(lineContent.substring(0, index).trim());
							lineContent = lineContent.substring(index + 1,
									lineContent.length());
							index = lineContent.indexOf(space);
							if (index > 0) {
								value = lineContent.substring(0, index).trim();
								if (nan.equalsIgnoreCase(value)) {
									value = zero;
								}

								lineContent = lineContent.substring(index + 1,
										lineContent.length());
							}
							this.values.add(value);
						} else {
							lineContent = empty;
						}
					}
				}
				in.close();
				
				if (this.values.size() > 0) {
					writeFile();
				}
			} catch (FileNotFoundException e1) {
				System.out.println("文件没有找到！");
			} catch (IOException e) {
				System.out.println("读取文件错误！");
			}
		}
	}
	
	public static void main(String[] args) {
		CreateFile r = new CreateFile();
		r.read();
		
		System.exit(0);
	}
}
