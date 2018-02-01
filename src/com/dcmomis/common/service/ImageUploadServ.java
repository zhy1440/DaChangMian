package com.dcmomis.common.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

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
import com.dcmomis.utils.initUtils;

public class ImageUploadServ extends HttpServlet {
	private static final long serialVersionUID = -7744625344830285257L;
	public String savePath;

	public void init(ServletConfig config) {
//		//get the path web application working on
//		String ws_path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//		System.out.println("worspace_path_before:" + ws_path);// debug
//		int num = ws_path.indexOf(".metadata");
//		if (-1 != num) {
//			//UNDER DEBUG WORKSPACE
//			ws_path = ws_path.substring(1, num);
//		} else {
//			//UNDER DEPLOY ENVIRONMENT
//			int n = ws_path.indexOf("DcmWorkspace");
//			ws_path = ws_path.substring(1, n);
//		}
//		//Real directory
//		System.out.println("worspace_path_after:" + ws_path);
//		
//		// get common picture save path from web.xml
//		String picPath = config.getInitParameter("picPath");
//		savePath = ws_path.replace('/', '\\') + picPath;
//		System.out.println("pic_save_path:" + savePath);
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

//			Properties p =initUtils.loadProperties().get("PIC_PATH");
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
						String picPath = initUtils.loadProperties().get("PIC_PATH").toString().replace('/', '\\');
						System.out.println("===> Upload Image store path:" + picPath);
						File file = new File(picPath, strNow + "." + prefix);
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
	
	/**
	 * 存网络图片
	 * @param strUrl
	 * @return
	 * @throws Exception
	 */
	public String storeImage(String strUrl) throws Exception {
		URL url = new URL(strUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5 * 1000);
		InputStream inStream = conn.getInputStream();
		byte[] data = readInputStream(inStream);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String picPath = initUtils.loadProperties().get("PIC_PATH").toString().replace('/', '\\');
		System.out.println("===> Internet pic store path:" + picPath);
		String fileName = df.format(new Date()) + ".jpg";
		File imageFile = new File(picPath + fileName);
		
		FileOutputStream outStream = new FileOutputStream(imageFile);
		outStream.write(data);
		outStream.close();
		
		return "downloadpic\\" + fileName;
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}
}
