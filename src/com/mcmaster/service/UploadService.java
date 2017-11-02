package com.mcmaster.service;

import java.util.List;

import com.mcmaster.dao.UploadDao;
import com.mcmaster.exception.MyExceptions;
import com.mcmaster.vo.Uploads;

public class UploadService {

	public List<String> upload(List<Uploads> uploadFiles) throws MyExceptions {
		UploadDao dao = new UploadDao();
		List<String> ret = dao.upload(uploadFiles, uploadFiles.size());
		return ret;
	}

}
