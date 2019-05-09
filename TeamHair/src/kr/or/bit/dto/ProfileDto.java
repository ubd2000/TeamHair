package kr.or.bit.dto;

public class ProfileDto {
	private String userId;
	private String introduction;
	private String website;
	private String photoName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
	@Override
	public String toString() {
		return "ProfileDto [userId=" + userId + ", introduction=" + introduction + ", website=" + website
				+ ", photoName=" + photoName + "]";
	}
	
	
}
