package com.dcmomis.kefu.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcmomis.order.OrderRecordBean;
import com.dcmomis.utils.DBUtils;
import com.dcmomis.utils.StringUtils;

public class NaviTreeServ extends HttpServlet {
	// execute GET request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String output = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String node = request.getParameter("node");
		PrintWriter pw = response.getWriter();
		boolean jsonP = false;
		
		output = NaviTreeDao.getChildren(node);
		System.out.println(node);
		String cb = request.getParameter("callback");
		if (cb != null) {
			jsonP = true;
			response.setContentType("text/javascript");
		} else {
			response.setContentType("application/x-json");
		}
		if (jsonP) {
			pw.write(cb + "(");
		}
		pw.print(output);
		if (jsonP) {
			pw.write(");");
		}

		System.out.println(output);
		// pw.write(this.data());
		pw.flush();
		pw.close();

	}

	public String data() {
		String a = "{\"success\": true,\"children\": [{ \"id\": 5, \"name\": \"Evan\", \"leaf\": true }]}";
		return a;
	}

}
