package com.dcmomis.common.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dcmomis.common.ResponseBean;
import com.dcmomis.utils.StringUtils;

public class ImageUploadServ extends HttpServlet {
	private static final long serialVersionUID = -7744625344830285257L;
	private String savePath;

	public void init(ServletConfig config) {
		//get the path web application working on
		String ws_path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println("worspace_path_before:" + ws_path);// debug
		int num = ws_path.indexOf(".metadata");
		if (-1 != num) {
			ws_path = ws_path.substring(1, num);
		} else {
			int n = ws_path.indexOf("DcmWorkspace");
			ws_path = ws_path.substring(1, n);
		}
		System.out.println("worspace_path_after:" + ws_path);
		
		// get common picture save path from web.xml
		String picPath = config.getInitParameter("picPath");
		savePath = ws_path.replace('/', '\\') + picPath;
		System.out.println("pic_save_path:" + savePath);
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
					System.out.println("=== FORM INFORMATION ===============>>>");
					System.out.println("fieldName: " + item.getFieldName() + " value: " + item.getString("UTF-8"));
					System.out.println("=== FORM INFORMATION END ===========>>>");
				} else {
					if (item.getName() != null && !item.getName().equals("")) {
						// Debug file information
						System.out.println("=== PIC_FILE INFORMATION ===============>>>");
						System.out.println("fileSize: " + item.getSize());
						System.out.println("fileType: " + item.getContentType());
						System.out.println("uploadedFileName: " + item.getName());
						System.out.println("=== PIC_FILE INFORMATION END ===========>>>");

						String tempFileName = item.getName();
						String prefix = tempFileName.substring(tempFileName.lastIndexOf(".") + 1);
						SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
						// Define file name use time string
						String strNow = df.format(new Date());
						File file = new File(savePath, strNow + "." + prefix);
						rb.setFileName("downloadpic/" + strNow + "." + prefix);

						System.out.println("=== Uploaded FileName: ========> " + "downloadpic/" + strNow + "." + prefix);
						item.write(file);
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("图片上传失败！");
			rb.setErrorMsg("图片上传失败！");
			rb.setSuccess(false);
			String result = StringUtils.listToJson(rb, false);
			out.print(result);
		}
		System.out.println("图片上传成功！");
		rb.setSuccessMsg("图片上传成功！");
		rb.setSuccess(true);
		String result = StringUtils.listToJson(rb, false);
		out.print(result);
	}
}
