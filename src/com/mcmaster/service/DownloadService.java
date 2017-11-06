package com.mcmaster.service;

import java.util.List;

import com.mcmaster.dao.DownloadDao;
import com.mcmaster.exception.MyDownloadException;
import com.mcmaster.exception.MyFindFileByIdException;
import com.mcmaster.vo.Downloads;

public class DownloadService {

	public List<Downloads> downloadShow() throws MyDownloadException {
		DownloadDao dao = new DownloadDao();
		List<Downloads> list = dao.downloadShow();
		return list;
	}

	public Downloads findFileById(String id) throws MyFindFileByIdException {
		DownloadDao dao = new DownloadDao();
		Downloads down = dao.getFileById(id);  
		return down;
	}

}
