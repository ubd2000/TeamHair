package kr.or.bit.dto;

public class BranchDto {
	private int branchID;
	private String branchName;
	private String address1;
	private String address2;
	private String postalCode;
	private String phone;
	private int map_X;
	private int map_Y;
	
	
	public int getBranchID() {
		return branchID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMap_X() {
		return map_X;
	}
	public void setMap_X(int map_X) {
		this.map_X = map_X;
	}
	public int getMap_Y() {
		return map_Y;
	}
	public void setMap_Y(int map_Y) {
		this.map_Y = map_Y;
	}

	@Override
	public String toString() {
		return "BranchDto [branchID=" + branchID + ", branchName=" + branchName + ", address1=" + address1
				+ ", address2=" + address2 + ", postalCode=" + postalCode + ", phone=" + phone + ", map_X=" + map_X
				+ ", map_Y=" + map_Y + "]";
	}
	
	
}

