package com.mcmaster.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mcmaster.exception.MyDownloadException;
import com.mcmaster.service.DownloadService;
import com.mcmaster.vo.Downloads;

public class DownloadShowServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DownloadService service = new DownloadService();
		try {
			List<Downloads> list = service.downloadShow();
			request.setAttribute("files", list);
			request.getRequestDispatcher("/download/download.jsp").forward(
					request, response);
		} catch (MyDownloadException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
