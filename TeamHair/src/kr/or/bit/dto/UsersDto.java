package kr.or.bit.dto;

import java.util.Date;

public class UsersDto {
	private String userId;
	private String passwords;
	private String email;
	private String phone;
	private String gender;
	private Date createDate;
	private Date updateDate;
	private String isHairDesigner;
	private String isActive;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
//		String input = "";
//		if (gender == "M" || gender.toUpperCase() == "MALE" || gender == "1") {
//			input = "M";
//		} else if (gender == "F" || gender.toUpperCase() == "FEMAIL" || gender == "0") {
//			input = "F";
//		}
//		this.gender = input;
		this.gender = gender;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getIsHairDesigner() {
		return isHairDesigner;
	}

	public void setIsHairDesigner(String isHairDesigner) {
//		String input = "";
//		if (isHairDesigner.toUpperCase() == "Y" || isHairDesigner.toUpperCase() == "YES" || isHairDesigner == "1") {
//			input = "M";
//		} else if (isHairDesigner.toUpperCase() == "N" || isHairDesigner.toUpperCase() == "NO"
//				|| isHairDesigner == "0") {
//			input = "F";
//		}

		this.isHairDesigner = isHairDesigner;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "UsersDto [userId=" + userId + ", passwords=" + passwords + ", email=" + email + ", phone=" + phone
				+ ", gender=" + gender + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", isHairDesigner=" + isHairDesigner + ", isActive=" + isActive + "]";
	}

}
