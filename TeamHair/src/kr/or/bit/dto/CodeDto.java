package kr.or.bit.dto;

import java.io.Serializable;

public class CodeDto implements Serializable {
	private String classCode;
	private String className;
	private String code;
	private String codeName;
	
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeName() {
		return codeName;
	}
	
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	@Override
	public String toString() {
		return "CodeDto [classCode=" + classCode + ", className=" + className + ", code=" + code + ", codeName="
				+ codeName + "]";
	}
	
	
}
