package com.excel.operate;
/**
 * ˵����
 *	 1����sourceĿ¼��jacob.dll����һ�ݵ�ʹ�õ�jdk/bin��
 *   2 ������һ�ݵ�c:/windows/system32 ��
 * @author Administrator
 *
 */
public class SheetWorkBookUtils {
	/**
	 * ���Ե�ַ���
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
		SheetWorkBookUtils.saveCopyAs("D:/tt.xls", "D:/tt2.xls");		
	}	  
}

