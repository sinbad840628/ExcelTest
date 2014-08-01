package com.abbvie.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abbvie.common.Common;
import com.abbvie.excel.vo.AROOM;
import com.abbvie.excel.vo.ChemPartner;
import com.b510.excel.vo.Student;


public class DBUtil {

	/**
	 * @param sql
	 */
	public static void insertAROOM(String aRoomSQL, AROOM aroom) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(aRoomSQL);
			
			ps.setString(1, aroom.getItemNo());
			ps.setString(2, aroom.getANumber());
			ps.setString(3, aroom.getLot());
			ps.setDouble(4, aroom.getAmountMg());
			ps.setDouble(5, aroom.getWeightNeedMg());
			ps.setString(6, aroom.getDispersalBarCode());
			ps.setString(7, aroom.getPositionX());
			ps.setString(8, aroom.getPositionY());
			ps.setDouble(9, aroom.getAllDissolve());
			
			boolean flag = ps.execute();
			
			if(!flag){
				System.out.println("Save ARoom data : itemNo. = " + aroom.getItemNo() + " , ANumber = " + aroom.getANumber() + ", Lot = " + aroom.getLot() +
						" AmountMg "+aroom.getAmountMg() + " WeightNeedMg " + aroom.getWeightNeedMg() + " DispersalBarCode " + aroom.getDispersalBarCode() + 
						" PositionX" + aroom.getPositionX() + " PositionY " + aroom.getPositionY() + " AllDissolve " + aroom.getAllDissolve()
						+ " succeed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}//end of function insertAROOM
	
	public static void insertChemPartner(String chemSQL, ChemPartner chemPartner) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(chemSQL);
			
			ps.setString(1, chemPartner.getcPNumber());
			ps.setString(2, chemPartner.getVialCode());
			ps.setString(3, chemPartner.getVolume());
			ps.setString(4, chemPartner.getLocationX());
			ps.setString(5, chemPartner.getLocationY());
			ps.setString(6, chemPartner.getANumber());
			ps.setString(7, chemPartner.getLot());
			
			boolean flag = ps.execute();
			if(!flag){
				
				System.out.println("Save ChemPartner data : CPNumber. = " + chemPartner.getcPNumber() + " , VialCode = " + chemPartner.getVialCode() + ", Volume = " + chemPartner.getVolume() 
						+ " LocationX " + chemPartner.getLocationX() + " LocationY " + chemPartner.getLocationY() + " ANumber " + chemPartner.getANumber() + " Lot " + chemPartner.getLot()						
						+ " succeed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}//end of function insertChemPartner
	
	public static ResultSet selectAllAROOM(String AroomSQL) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			
			ps = conn.prepareStatement(AroomSQL);
			
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return rs;
	}// end of function 
	
	public static ResultSet selectAllChemPartner(String ChemSQL) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(ChemSQL);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return rs;
	}//end of function SelectAllChemPartner
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List selectARoom(String sql, AROOM aroom) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString("no").equals(aroom.getNo()) || rs.getString("name").equals(aroom.getName())|| rs.getString("age").equals(aroom.getAge())){
					list.add(1);
				}else{
					list.add(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List selectChemPartner(String sql, ChemPartner chemPartner) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString("no").equals(student.getNo()) || rs.getString("name").equals(student.getName())|| rs.getString("age").equals(student.getAge())){
					list.add(1);
				}else{
					list.add(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}
}
