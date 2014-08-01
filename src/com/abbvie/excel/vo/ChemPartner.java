package com.abbvie.excel.vo;
/**
 * ChemPartner
 * 
 * @author Sinbad Bai
 * @created 2014-7-30
 */
public class ChemPartner {

	private String cPNumber;
	
	private String VialCode;
	
	private String volume;
	
	private String LocationX;
	
	private String LocationY;
	
	private String ANumber;
	
	private String Lot;

	public String getcPNumber() {
		return cPNumber;
	}

	public void setcPNumber(String cPNumber) {
		this.cPNumber = cPNumber;
	}

	public String getVialCode() {
		return VialCode;
	}

	public void setVialCode(String vialCode) {
		VialCode = vialCode;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getLocationX() {
		return LocationX;
	}

	public void setLocationX(String locationX) {
		LocationX = locationX;
	}

	public String getLocationY() {
		return LocationY;
	}

	public void setLocationY(String locationY) {
		LocationY = locationY;
	}

	public String getANumber() {
		return ANumber;
	}

	public void setANumber(String aNumber) {
		ANumber = aNumber;
	}

	public String getLot() {
		return Lot;
	}

	public void setLot(String lot) {
		Lot = lot;
	}
}
