package com.excel.operate;
/**
 * 说明：
 *	 1，将source目录下jacob.dll复制一份到使用的jdk/bin下
 *   2 ，复制一份到c:/windows/system32 下
 * @author Administrator
 *
 */
public class SheetWorkBookUtils {
	/**
	 * 绝对地址另存
	 * @param xlsfile
	 * @param saveAsFile
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public static void saveCopyAs(String xlsfile, String saveAsFile){
		SheetCopy sc = new SheetCopy();
		sc.setXlsfile(xlsfile);
		sc.setSaveAsFile(saveAsFile);
		Thread t = new Thread(sc,"sc"+System.currentTimeMillis());
		Thread tmain = Thread.currentThread();
		try{
			t.start();
			while(sc.getIsContinue() != 1){
				tmain.sleep(100);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			t.stop();
		}		
	}
	public static void main(String[] args) {
		SheetWorkBookUtils.saveCopyAs("C:\\Dev\\WorkSpace\\ExcelTest\\lib\\2.csv", "C:\\Dev\\WorkSpace\\ExcelTest\\lib\\22.csv");		
	}	  
}

