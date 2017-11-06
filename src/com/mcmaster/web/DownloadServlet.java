package com.mcmaster.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mcmaster.exception.DownloadException;
import com.mcmaster.exception.MyFindFileByIdException;
import com.mcmaster.service.DownloadService;
import com.mcmaster.utils.DownloadFileUtils;
import com.mcmaster.utils.ZipFiles;
import com.mcmaster.vo.Downloads;

public class DownloadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("ckb");
		List<File> fileList = new LinkedList<>();
		
		for(String id : ids)
		{
			DownloadService service = new DownloadService();
			Downloads download;
			try {
				download = service.findFileById(id);
				 response.setContentType("application/x-msdownload");  
			     response.setHeader("Content-Disposition", "attachment;filename=test.zip");
				if(null != download)
				{
					String savePath = download.getSavepath();
					File f = new File(savePath);
					
					if(f.exists())
					{
						fileList.add(f);
					}
					else
					{
						throw new DownloadException("Current file doesn't exist!");
					}
				}
			} catch (MyFindFileByIdException | DownloadException e) {
				e.printStackTrace();
			}
		}
		ZipFiles.downloadZipFiles(fileList, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
