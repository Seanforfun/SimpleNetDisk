package com.mcmaster.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.mcmaster.vo.Uploads;

public class UploadFileUtils {
	public static void saveFiletoPath(List<FileItem> list, List<Uploads> ret)
			throws FileUploadException, IOException {

		int count = 0;
		for (FileItem fileItem : list) {
			if (!fileItem.isFormField()) {
				Uploads upload = ret.get(count);
				count++;
				String savePath = UploadFileUtils.makePath(upload);
				InputStream input = fileItem.getInputStream();
				FileOutputStream output = new FileOutputStream(new File(
						upload.getSavepath()));
				IOUtils.copy(input, output);
				input.close();
				output.close();
			}
		}
	}

	public static void createdirectory(String[] token, int level) {
		String root = ResourceBundle.getBundle("SaveDirectory").getString(
				"directory");
		File f = new File(root, token[level - 3]);

		if (!f.exists()) {
			f.mkdir();
		}

		File f1 = new File(f, token[level - 2]);

		if (!f1.exists()) {
			f1.mkdir();
		}
	}

	public static String makePath(Uploads upload) throws IOException {
		String fileName = upload.getRealname();
		String savePath = upload.getSavepath();
		String[] token = savePath.split("/");
		int level = token.length;
		createdirectory(token, level);
		File f = new File(upload.getSavepath());
		if (!f.exists()) {
			f.createNewFile();
		}
		return upload.getSavepath();
	}

}
