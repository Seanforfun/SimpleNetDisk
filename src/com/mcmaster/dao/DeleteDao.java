package com.mcmaster.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mcmaster.exception.MyDeleteException;
import com.mcmaster.utils.DataSourceUtils;

public class DeleteDao {

	public void deleteSelected(String[] ids) throws MyDeleteException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from resources where id = ?";
		Object[][] params = new Object[ids.length][];
		
		for (int i = 0; i < ids.length; i++) {
			params[i] = new Object[]{ids[i]};
		}
		
		try {
			runner.batch(sql, params);
		} catch (SQLException e) {
			throw new MyDeleteException(e.getMessage());
		}
	}

}
