package kr.or.ddit.file.util;

public class FileUtil {

	public static String getFileExt(String fileName) {
		//확장가가 있을경우 .을 포함한 확장자 값을 리턴
		//확장자가 없을경우 "" 리턴(white space)
		
			
		int dotIndex = fileName.lastIndexOf(".");
		
		if(dotIndex == -1) {
			return "";
		} else {
			return fileName.substring(dotIndex);
		}
	}
	
	
}
