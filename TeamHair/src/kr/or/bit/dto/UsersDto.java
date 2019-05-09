package kr.or.bit.dto;

import java.util.Date;

public class UsersDto {
	
	private String userId;
	private String passwords;
	private String userName;
	private String email;
	private String phone;
	private String gender;
	private String userType;
	private String termsOfUseYn;
	private String loginYn;
	private String reserveYn;
	private String useSnsYn;
	private Date createDate;
	private Date updateDate;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
		this.gender = gender;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getTermsOfUseYn() {
		return termsOfUseYn;
	}
	public void setTermsOfUseYn(String termsOfUseYn) {
		this.termsOfUseYn = termsOfUseYn;
	}
	public String getLoginYn() {
		return loginYn;
	}
	public void setLoginYn(String loginYn) {
		this.loginYn = loginYn;
	}
	public String getReserveYn() {
		return reserveYn;
	}
	public void setReserveYn(String reserveYn) {
		this.reserveYn = reserveYn;
	}
	public String getUseSnsYn() {
		return useSnsYn;
	}
	public void setUseSnsYn(String useSnsYn) {
		this.useSnsYn = useSnsYn;
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
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "UsersDto [userId=" + userId + ", passwords=" + passwords + ", userName=" + userName + ", email=" + email
				+ ", phone=" + phone + ", gender=" + gender + ", userType=" + userType + ", termsOfUseYn="
				+ termsOfUseYn + ", loginYn=" + loginYn + ", reserveYn=" + reserveYn + ", useSnsYn=" + useSnsYn
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", isActive=" + isActive + "]";
	}

	

}
