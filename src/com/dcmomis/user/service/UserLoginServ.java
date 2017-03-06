package com.dcmomis.user.service;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dcmomis.user.CustomerInfoBean;
import com.dcmomis.utils.*;

public class UserLoginServ extends HttpServlet {
	// execute GET request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userName = "ÇëÖØÐÂµÇÂ¼";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String uid = (String) request.getParameter("uid");
		if (!uid.equals("undefined")) {
			userName = getUserName(uid);
		}

		System.out.println(userName);
		out.print(userName);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// doGet(request, response);
		PrintWriter out = response.getWriter();
		out.print("Hello");
		System.out.println("Hello");
	}

	public String getUserName(String uid) {
		List<CustomerInfoBean> customerInfoList = new ArrayList<CustomerInfoBean>();
		CustomerInfoBean customerInfo = new CustomerInfoBean();
		// customerInfo.setUserId(result.getString("user_id"));
		customerInfo.setUserName("admin");
		customerInfo.setEmail("email");
		customerInfo.setMobile("mobile");
		customerInfoList.add(customerInfo);
		return StringUtils.listToJson(customerInfoList, false);
	}
}
