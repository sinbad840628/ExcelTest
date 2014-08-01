package com.abbvie.excel.vo;

/**
 * AROOM
 * 
 * @author Sinbad Bai
 * @created 2014-7-30
 */
public class AROOM {
	
	private String itemNo;
	
	private String aNumber;
	
	private String Lot;	
	
	private double amountMg;
	
	private double weightNeedMg;
	
	private String dispersalBarCode;
		
	private String PositionX;
	
	private String PositionY;
	
	private double allDissolve;

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getANumber() {
		return aNumber;
	}

	public void setANumber(String aNumber) {
		this.aNumber = aNumber;
	}

	public double getAmountMg() {
		return amountMg;
	}

	public void setAmountMg(double amountMg) {
		this.amountMg = amountMg;
	}

	public double getWeightNeedMg() {
		return weightNeedMg;
	}

	public void setWeightNeedMg(double weightNeedMg) {
		this.weightNeedMg = weightNeedMg;
	}

	public String getLot() {
		return Lot;
	}

	public void setLot(String lot) {
		Lot = lot;
	}

	public String getDispersalBarCode() {
		return dispersalBarCode;
	}

	public void setDispersalBarCode(String dispersalBarCode) {
		this.dispersalBarCode = dispersalBarCode;
	}

	public String getPositionX() {
		return PositionX;
	}

	public void setPositionX(String positionX) {
		PositionX = positionX;
	}

	public String getPositionY() {
		return PositionY;
	}

	public void setPositionY(String positionY) {
		PositionY = positionY;
	}

	public double getAllDissolve() {
		if(this.weightNeedMg != 0 ){
			allDissolve =amountMg / weightNeedMg * 100;
		}
		return allDissolve;
	}

	public void setAllDissolve(double allDissolve) {
		this.allDissolve = allDissolve;
	}
	
}
