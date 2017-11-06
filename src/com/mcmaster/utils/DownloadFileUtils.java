package com.mcmaster.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class DownloadFileUtils {
	public static void downloadSingleFile(File f, HttpServletResponse response)
			throws IOException {
		FileInputStream inputStream = new FileInputStream(f);
		OutputStream outputStream = response.getOutputStream();
		IOUtils.copy(inputStream, outputStream);
		inputStream.close();
		outputStream.close();
	}
}
