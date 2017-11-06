package com.mcmaster.service;

import com.mcmaster.dao.DeleteDao;
import com.mcmaster.exception.MyDeleteException;

public class DeleteService {

	public void deleteSelected(String[] ids) throws MyDeleteException {
		DeleteDao dao = new DeleteDao();
		dao.deleteSelected(ids);
	}
	
}
