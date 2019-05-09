package kr.or.bit.utils;

public class TeamConvert {
	
	public static String checkToYn(String str) {
		String yn="";
		if(str==null) {
			yn="N";
		} else if(str.trim().equals("on")) {
			yn="Y";
		}
		return yn;
	}
}
