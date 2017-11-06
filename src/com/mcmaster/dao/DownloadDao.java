package com.mcmaster.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mcmaster.exception.MyDownloadException;
import com.mcmaster.exception.MyFindFileByIdException;
import com.mcmaster.utils.DataSourceUtils;
import com.mcmaster.vo.Downloads;

public class DownloadDao {

	public List<Downloads> downloadShow() throws MyDownloadException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from resources";
		List<Downloads> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Downloads>(Downloads.class));
		} catch (SQLException e) {
			throw new MyDownloadException(e.getMessage());
		}
		return list;
	}

	public Downloads getFileById(String id) throws MyFindFileByIdException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from resources where id = ?";
		Downloads download = null;
		try {
			download = runner.query(sql, new BeanHandler<Downloads>(Downloads.class), id);
		} catch (SQLException e) {
			throw new MyFindFileByIdException(e.getMessage());
		}
		
		return download;
	}
}
