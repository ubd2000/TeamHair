package kr.or.bit.dto;

public class SpaceDto {
	private int spaceId;
	private String spaceType;
	private int branchId;
	private String spaceName;
	public int getSpaceId() {
		return spaceId;
	}
	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}
	public String getSpaceType() {
		return spaceType;
	}
	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	
	@Override
	public String toString() {
		return "SpaceDto [spaceId=" + spaceId + ", spaceType=" + spaceType + ", branchId=" + branchId + ", spaceName="
				+ spaceName + "]";
	}
	
	
}



