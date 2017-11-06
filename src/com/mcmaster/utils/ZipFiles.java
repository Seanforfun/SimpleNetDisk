package com.mcmaster.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

public class ZipFiles {
	public static void downloadZipFiles(List<File> files, HttpServletResponse response) throws IOException
	{
		ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
		
		for(File f : files)
		{
			zos.putNextEntry(new ZipEntry(f.getName()));
			FileInputStream inputStream = new FileInputStream(f);
			
			byte b[] = new byte[1024];  
            int n = -1;  
            while((n = inputStream.read(b)) != -1){  
                zos.write(b, 0, n);
            }
            zos.flush();
            inputStream.close();
		}
		
		zos.close();
	}
}
