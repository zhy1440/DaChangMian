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
		// ��ȡ��ǰ��Ŀ�����·��
		String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println(t);// debug
		int num = t.indexOf(".metadata");
		System.out.println(num);// debug
		if (-1 != num) {
			t = t.substring(1, num);
		} else {
			int n = t.indexOf("DcmWorkspace");
			t = t.substring(1, n);
		}
		System.out.println(t);
		savePath = t.replace('/', '\\') + "DcmWorkspace\\kefu\\downloadpic\\";
		System.out.println(savePath);// debug
		// ��web.xml�����õ�һ����ʼ������
		picPath = config.getInitParameter("picPath");

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
					System.out.println("��������:" + item.getFieldName() + "��������ֵ:" + item.getString("UTF-8"));
				} else {
					if (item.getName() != null && !item.getName().equals("")) {
						System.out.println("�ϴ��ļ��Ĵ�С:" + item.getSize());
						System.out.println("�ϴ��ļ�������:" + item.getContentType());
						// item.getName()�����ϴ��ļ��ڿͻ��˵�����·������
						System.out.println("�ϴ��ļ�������:" + item.getName());

						File tempFile = new File(item.getName());
						String fileName = tempFile.getName();
						String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
						SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
						// �������ڸ�ʽ
						String strNow = df.format(new Date());
						// �ϴ��ļ��ı���·��
						File file = new File(savePath, strNow + "." + prefix);
						rb.setFileName(picPath.substring(4) + strNow + "." + prefix);
						item.write(file);
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			rb.setErrorMsg("ͼƬ�ϴ�ʧ��");
			rb.setSuccess(false);
			String result = StringUtils.listToJson(rb, false);
			out.print(result);
		}
		rb.setSuccessMsg("ͼƬ�ϴ��ɹ���");
		rb.setSuccess(true);
		String result = StringUtils.listToJson(rb, false);
		out.print(result);

	}

}
