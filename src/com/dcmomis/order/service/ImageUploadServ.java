package com.dcmomis.order.service;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dcmomis.common.ResponseBean;
import com.dcmomis.order.OrderRecordBean;
import com.dcmomis.utils.*;

public class ImageUploadServ extends HttpServlet {
	private static final long serialVersionUID = -7744625344830285257L;
	private String savePath;
	private String picPath;

	// execute GET request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Todo
	}

	public void init(ServletConfig config) {
		//get the path web application working on
		String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println(t);// debug
		int num = t.indexOf(".metadata");
		if (-1 != num) {
			t = t.substring(1, num);
		} else {
			int n = t.indexOf("DcmWorkspace");
			t = t.substring(1, n);
		}
		System.out.println(t);
		// get common pic save path from web.xml
		picPath = config.getInitParameter("picPath");
		savePath = t.replace('/', '\\') + picPath;
		System.out.println(savePath);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// doPost(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ResponseBean rb = new ResponseBean();

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			Iterator itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				if (item.isFormField()) {
					System.out.println("fieldName:" + item.getFieldName() + "value:" + item.getString("UTF-8"));
				} else {
					if (item.getName() != null && !item.getName().equals("")) {
						// Debug file information
						System.out.println("fileSize:" + item.getSize());
						System.out.println("fileType:" + item.getContentType());
						System.out.println("uploadedFileName:" + item.getName());

						String tempFileName = item.getName();
						String prefix = tempFileName.substring(tempFileName.lastIndexOf(".") + 1);
						SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
						// Define file name use time string
						String strNow = df.format(new Date());
						File file = new File(savePath, strNow + "." + prefix);
						rb.setFileName("downloadpic/" + strNow + "." + prefix);

						System.out.println("uploaded FileName:" + "downloadpic/" + strNow + "." + prefix);
						item.write(file);
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			rb.setErrorMsg("图片上传失败！");
			rb.setSuccess(false);
			String result = StringUtils.listToJson(rb, false);
			out.print(result);
		}
		rb.setSuccessMsg("图片上传成功！");
		rb.setSuccess(true);
		String result = StringUtils.listToJson(rb, false);
		out.print(result);

	}

}
