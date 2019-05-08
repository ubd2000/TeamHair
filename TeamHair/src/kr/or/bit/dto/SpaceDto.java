package kr.or.bit.dto;

public class SpaceDto {
	private int spaceID;
	private String spaceType;
	private int branchID;
	private String spaceName;
	
	public int getSpaceID() {
		return spaceID;
	}
	public void setSpaceID(int spaceID) {
		this.spaceID = spaceID;
	}
	public String getSpaceType() {
		return spaceType;
	}
	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}
	public int getBranchID() {
		return branchID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	@Override
	public String toString() {
		return "SpaceDto [spaceID=" + spaceID + ", spaceType=" + spaceType + ", branchID=" + branchID + ", spaceName="
				+ spaceName + ", getSpaceID()=" + getSpaceID() + ", getSpaceType()=" + getSpaceType()
				+ ", getBranchID()=" + getBranchID() + ", getSpaceName()=" + getSpaceName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}



