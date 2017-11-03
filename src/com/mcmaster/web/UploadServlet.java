package com.mcmaster.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mcmaster.exception.MyExceptions;
import com.mcmaster.service.UploadService;
import com.mcmaster.utils.SavePathUtils;
import com.mcmaster.utils.UploadFileUtils;
import com.mcmaster.utils.UploadInfoSetup;
import com.mcmaster.vo.Uploads;


public class UploadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024 * 100);
		String temporaryPath = ResourceBundle.getBundle("SaveDirectory").getString("temporary");
		File f = new File(temporaryPath);
		factory.setRepository(f);
		ServletFileUpload upload = new ServletFileUpload(factory);
		int counter = 0;
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			int fileNum = list.size() >> 1;
			List<Uploads> uploadFiles = new ArrayList<Uploads>();			
			
			if(fileNum != 0)
			{
				for(FileItem fileItem : list)
				{
					counter++;
					Uploads uploadFile = null;
					if(counter % 2 != 0)
					{
						uploadFile= new Uploads();
						uploadFiles.add(uploadFile);
					}
					else
					{
						uploadFile = uploadFiles.get((counter / 2) - 1);
					}
					
					if(fileItem.isFormField())
					{
						uploadFile.setDescription(fileItem.getString());
					}
					else
					{
						uploadFile = UploadInfoSetup.uploadSetup(uploadFile, fileItem.getName());
					}
				}
				
				UploadService service = new UploadService();
				List<Uploads> ret = service.upload(uploadFiles);
				
				if(null != ret)
				{
					UploadFileUtils.saveFiletoPath(list, ret);
				}
			}
			
		} catch (FileUploadException | MyExceptions e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
