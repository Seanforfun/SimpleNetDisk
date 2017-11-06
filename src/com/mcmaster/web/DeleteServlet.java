package com.mcmaster.web;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mcmaster.exception.MyDeleteException;
import com.mcmaster.exception.MyFindFileByIdException;
import com.mcmaster.service.DeleteService;
import com.mcmaster.service.DownloadService;
import com.mcmaster.vo.Downloads;

public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("ckb");
		DeleteService service = new DeleteService();
		DownloadService dService = new DownloadService();
		Downloads download = null;
		
		for(String id : ids)
		{
			try {
				download = dService.findFileById(id);
				String savePath = download.getSavepath();
				File f = new File(savePath);
				System.out.println(savePath);
				if(!f.exists())
					throw new RuntimeException("File doesn't exist!");
				else
				{
					f.delete();
				}
			} catch (MyFindFileByIdException e) {
				e.printStackTrace();
			}
		}
		
			try {
				service.deleteSelected(ids);
			} catch (MyDeleteException e) {
				e.printStackTrace();
			}
		request.getRequestDispatcher("/show").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
