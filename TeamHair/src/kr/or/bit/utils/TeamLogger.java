package kr.or.bit.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TeamLogger {
	static String path="C:\\Temp\\log\\";
	
	public static void getLogger(String path) {
		File files = new File(path);
		if(!files.exists()) {
			try {
				files.mkdir();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}
	
	public static void info(String contents) {
		String fileName = path + "log." + TeamFormat.dateFormat(new Date());
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(fileName, true);
			bw = new BufferedWriter(fw);
			bw.write(TeamFormat.dateTimeFormat(new Date()) + "  " + contents);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
