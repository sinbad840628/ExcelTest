package com.excel.operate;
/***
 * SheetCopy.java
 * 
 * Create Version: $version:1.1
 * Author: tangjw
 * Create Date: 2011-4-1
 * 
 * Copyright (c) 2009 �Ϻ�������Ϣ�������޹�˾ Corporation. All Right Reserved.
 */
import org.jawin.COMException;
import org.jawin.DispatchPtr;
import org.jawin.win32.Ole32;


/**
 * MonitorAndReport--en.fang.report.util.SheetCopy.java
 * ------------------------------------
 * @author Administrator
 * @create 2011-4-1����10:33:39
 * @�޸� Administrator
 * @version $version:1.1  $date:2011-4-1����10:33:39
 * -------------------------------------
 * TODO
 */
public class SheetCopy implements Runnable{
	
	private  String xlsfile;
	private  String saveAsFile;
	private  int  isContinue=0;
	
	/**
	 * @return String xlsfile
	 */
	public String getXlsfile() {
		return xlsfile;
	}

	/**
	 * @param String xlsfile
	 */
	public void setXlsfile(String xlsfile) {
		this.xlsfile = xlsfile;
	}
	
	public int getIsContinue() {
		return isContinue;
	}

	public void setIsContinue(int isContinue) {
		this.isContinue = isContinue;
	}

	/**
	 * @return String saveAsFile
	 */
	public String getSaveAsFile() {
		return saveAsFile;
	}
	/**
	 * @param String saveAsFile
	 */
	public void setSaveAsFile(String saveAsFile) {
		this.saveAsFile = saveAsFile;
	}
	
	public  void saveCopyAs(String xlsfile, String saveAsFile){
		try  
	      {   
	    	  Ole32.CoInitialize();
		      DispatchPtr app = new DispatchPtr("Excel.Application");//�½�һ������

		      app.put("Visible", false);   
		      DispatchPtr preses = (DispatchPtr)app.get("Workbooks");//ȡ�ĵ�ǰ�Ľ���
			  DispatchPtr pres = (DispatchPtr) preses.invoke("open", xlsfile);//��ppt//,"MsoTriState.msoFalse, MsoTriState.msoFalse, MsoTriState.msoFalse");
			  pres.invoke("SaveCopyAs",saveAsFile);
			  pres.invoke("Close", false);
			  app.invoke("Quit");
	      }   
	      catch (Exception e)   
	      {   
	          e.printStackTrace();   
	      }   
	      finally  
	      {   
	    	  try {
				Ole32.CoUninitialize();
			} catch (COMException e) {
				e.printStackTrace();
			}finally{
				isContinue = 1;
			}
	      }   
	}
	@Override
	public void run() {
		saveCopyAs(xlsfile, saveAsFile);
	}

}
