package com.dcmomis.kefu.feedbacks.service;

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
import com.dcmomis.order.service.OrderOperationDao;
import com.dcmomis.utils.DBUtils;
import com.dcmomis.utils.StringUtils;

public class FeedBacksServ extends HttpServlet {
	// execute GET request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String output = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		
		String action = (String) request.getParameter("action");
		// String userName = (String)request.getParameter("userName");
		// deal with different Action
		if (action.equals("getOrderList")) {
			try {
				String node = (String) request.getParameter("node");
				output = FeedBacksDao.getOrderList(node); 
			} catch (Exception e) {
			} finally {
			}
		} else if (action.equals("queryOrderRecordbyUid")) {
			//根据用户id查询该用户所有订单记录
			try {
				String id = (String) request.getParameter("uid");
				output = OrderOperationDao.queryOrderRecordbyUid(id);
			} catch (Exception e) {
			} finally {
			}
		} else if (action.equals("updateOrderType")) {
			//移动订单记录
			try {
				String orderId = (String) request.getParameter("orderId");
				String orderType = (String) request.getParameter("orderType");
				output = FeedBacksDao.updateOrderType(orderId,orderType);
			} catch (Exception e) {
			} finally {
			}
		} else if (action.equals("updateFinalPrice")) {
			//移动订单记录
			try {
				String orderId = (String) request.getParameter("orderId");
				String finalPrice = (String) request.getParameter("finalPrice");
				output = FeedBacksDao.updateFinalPrice(orderId,finalPrice);
			} catch (Exception e) {
			} finally {
			}
		}
		
		// jsonp设置
		boolean jsonP = false;
		String cb = request.getParameter("callback");
		if (cb != null) {
			jsonP = true;
			response.setContentType("text/javascript");
		} else {
			response.setContentType("application/x-json");
		}
		if (jsonP) {
			output = cb + "("+output;
		}
		
		if (jsonP) {
			output =output+ ");";
		}
		System.out.println(output);
		out.print(output);
		
		out.flush();
		out.close();

	}

	public String data() {
		String a = "{\"success\": true,\"children\": [{ \"id\": 5, \"name\": \"Evan\", \"leaf\": true }]}";
		return a;
	}

}
