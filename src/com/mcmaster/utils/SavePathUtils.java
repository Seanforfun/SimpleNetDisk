package com.mcmaster.utils;

import java.util.ResourceBundle;

public class SavePathUtils {
	public static String getSavePath(String fileName)
	{
		int code = UuidUtils.getFileName(fileName).hashCode();
		String parentPath = ResourceBundle.getBundle("SaveDirectory").getString("directory");
		String hexString = Integer.toHexString(code);
		char directory1 = hexString.charAt(0);
		char directory2 = hexString.charAt(1);
		String path = parentPath + "/" + directory1 + "/" + directory2;
		return path;
	}
}
