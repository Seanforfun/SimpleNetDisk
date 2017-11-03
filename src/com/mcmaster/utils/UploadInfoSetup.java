package com.mcmaster.utils;

import com.mcmaster.vo.Uploads;

public class UploadInfoSetup {
	public static Uploads uploadSetup(Uploads u, String fileName)
	{
		u.setRealname(fileName);
		u.setUuidname(UuidUtils.getFileName(fileName));
		u.setSavepath(SavePathUtils.getSavePath(fileName) + "/" + fileName);
		return u;
	}
}
