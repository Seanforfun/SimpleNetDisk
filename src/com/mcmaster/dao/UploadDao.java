package com.mcmaster.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.mcmaster.exception.MyExceptions;
import com.mcmaster.utils.DataSourceUtils;
import com.mcmaster.vo.Uploads;

public class UploadDao {

	public List<String> upload(List<Uploads> uploadFiles, int rowNum) throws MyExceptions {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		Object[][] params = new Object[rowNum][];
		String sql = "insert into resources values(null, ?, ?, ?, null, ?)";
		List<String> retList = null;
		
		for(int i = 0; i < rowNum; i++)
		{
			Uploads up = uploadFiles.get(i);
			if(null != up)
				params[i] = new Object[]{up.getUuidname(), up.getRealname(), up.getSavepath(), up.getDescription()};
		}
		
		try {
			int[] batch = runner.batch(sql, params);
			
			for(int i : batch)
			{
				if(i != 0)
				{
					String name = uploadFiles.get(i).getRealname();
					retList.add(name);
				}
			}
		} catch (SQLException e) {
			throw new MyExceptions(e.getMessage());
		}
		
		return retList;
	}

}
