package com.mcmaster.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.mcmaster.exception.DownloadException;

public class FileDownlaodServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("filename");
		String savePath = request.getParameter("savepath");
		response.setHeader("content-disposition", "attachment;filename=" +  fileName);
		File f = new File(savePath);
		
		if(f.exists())
		{
			FileInputStream inputStream = new FileInputStream(f);
			OutputStream outputStream = response.getOutputStream();
			IOUtils.copy(inputStream, outputStream);
		}
		else
		{
			try {
				throw new DownloadException("This file doesn't exist!");
			} catch (DownloadException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
