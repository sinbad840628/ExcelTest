package com.abbvie.common;
/**
 * @author Sinbad Bai
 * @created 2014-7-30
 */
public class Common {
	
	// connect the database
		public static final String DRIVER = "com.mysql.jdbc.Driver";
		public static final String DB_NAME = "test";
		public static final String USERNAME = "root";
		public static final String PASSWORD = "344189";
		public static final String IP = "127.0.0.1";
		public static final String PORT = "3306";
		public static final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DB_NAME;
		
		// common
		public static final String EXCEL_PATH = "lib/Compound_list.xls";
		
		//STUDENT_SQL
		//public static final String INSERT_STUDENT_SQL = "insert into student_info(no, name, age, score) values(?, ?, ?, ?)";
		//public static final String UPDATE_STUDENT_SQL = "update student_info set no = ?, name = ?, age= ?, score = ? where id = ? ";
		//public static final String SELECT_STUDENT_ALL_SQL = "select id,no,name,age,score from student_info";
		//public static final String SELECT_STUDENT_SQL = "select * from student_info where name like ";
		
		//AROOM_SQL
		public static final String INSERT_AROOM_SQL = "insert into AROOM_Info(itemNo, aNumber, Lot, dispersalBarCode,PositionX,PositionY) values(?, ?, ?, ?, ?,?)";
		public static final String UPDATE_AROOM_SQL = "update AROOM_Info set itemNo = ?,  Lot= ?, dispersalBarCode = ? ,PositionX = ?, PositionY = ? where aNumber = ? ";
		public static final String SELECT_ALL_AROOM_SQL = "select itemNo, aNumber, Lot, dispersalBarCode,PositionX,PositionY from AROOM_Info";
		public static final String SELECT_AROOM_SQL = "select * from student_info where aNumber like ";
		
		//ChemPartner_SQL
		public static final String INSERT_ChemPartner_SQL = "insert into ChemPartner(cPNumber, VialCode, volume, PositionX,PositionY,ANumber,Lot) values(?, ?, ?, ?, ?, ?, ?)";
		public static final String UPDATE_ChemPartner_SQL = "update ChemPartner set cPNumber = ?, volume = ?, PositionX= ?, PositionY = ?, ANumber = ?,Lot = ?  where aNumber = ? AND  VialCode = ?";
		public static final String SELECT_ALL_ChemPartner_SQL = "select cPNumber, VialCode, volume, PositionX,PositionY,ANumber,Lot from ChemPartner";
		public static final String SELECT_ChemPartner_SQL = "select * from ChemPartner where where aNumber like ? AND  VialCode like ? ";
		
}
