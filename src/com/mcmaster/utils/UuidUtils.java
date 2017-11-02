package com.mcmaster.utils;

import java.util.UUID;

public class UuidUtils {
	public static String getUuid()
	{
		UUID randomUUID = UUID.randomUUID();
		String uuid = randomUUID + "";
		return uuid;
	}
	
	public static String getFileName(String fileName)
	{
		String uuid = UuidUtils.getUuid() + fileName;
		return uuid;
	}
}
