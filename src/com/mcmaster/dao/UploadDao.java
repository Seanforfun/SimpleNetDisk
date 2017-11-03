package com.mcmaster.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.mcmaster.exception.MyExceptions;
import com.mcmaster.utils.DataSourceUtils;
import com.mcmaster.vo.Uploads;

public class UploadDao {

	public List<Uploads> upload(List<Uploads> uploadFiles, int rowNum) throws MyExceptions {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		Object[][] params = new Object[rowNum][];
		String sql = "insert into resources values(null, ?, ?, ?, null, ?)";
		List<Uploads> retList = new ArrayList<Uploads>();
		
		for(int i = 0; i < rowNum; i++)
		{
			Uploads up = uploadFiles.get(i);
			if(null != up)
				params[i] = new Object[]{up.getUuidname(), up.getRealname(), up.getSavepath(), up.getDescription()};
		}
		
		try {
			int[] batch = runner.batch(sql, params);
			
			for(int i = 0; i < batch.length; i++)
			{
				if(batch[i] != 0)
				{
					retList.add(uploadFiles.get(i));
				}
			}
		} catch (SQLException e) {
			throw new MyExceptions(e.getMessage());
		}
		
		return retList;
	}
}
