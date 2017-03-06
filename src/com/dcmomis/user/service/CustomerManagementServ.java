package com.dcmomis.user.service;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dcmomis.user.CustomerInfoBean;
import com.dcmomis.utils.*;

public class CustomerManagementServ extends HttpServlet {
	// execute GET request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String output = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String action = (String) request.getParameter("action");
		// String userName = (String)request.getParameter("userName");

		// deal with different Action
		if (action.equals("queryCustomerInfo")) {
			try {
				output = queryCustomerInfo();
			} catch (Exception e) {
			} finally {
			}
		} else if (true) {
		}

		System.out.println(output);
		out.print(output);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// doGet(request, response);
		PrintWriter out = response.getWriter();
		out.print("Hello");
		System.out.println("Hello");
	}

	public String queryCustomerInfo() {
		String result = null;
		List<CustomerInfoBean> customerInfoList = getCustomerInfoList();
		result = StringUtils.listToJson("customers", customerInfoList);
		return result;
	}

	public List<CustomerInfoBean> getCustomerInfoList() {
		Connection conn = null;
		Statement stm = null;
		ResultSet result = null;
		String queryString = "SELECT" + " c.user_id, r.member_desc, r.EXCHANGE_RATE, c.COMMEN_ADDR" + " FROM"
				+ " bd_dw_dcm_usr_customer_info c"
				+ " LEFT JOIN bd_prm_dcm_usr_exchange_rate r ON c.member_level = r.member_level";
		try {
			conn = DBUtils.getDBConnection();
			stm = conn.createStatement();
			result = stm.executeQuery(queryString);
			List<CustomerInfoBean> customerInfoList = new ArrayList<CustomerInfoBean>();
			while (result.next()) {
				CustomerInfoBean customerInfo = new CustomerInfoBean();
				customerInfo.setUserId(result.getString("user_id"));
				customerInfo.setMemberLevel(result.getString("member_desc"));
				customerInfo.setExchangRate(result.getString("EXCHANGE_RATE"));
				customerInfo.setCommonAddr(result.getString("COMMEN_ADDR"));
				customerInfoList.add(customerInfo);
			}
			return customerInfoList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(stm, result, conn);
		}
		return null;
	}
}
