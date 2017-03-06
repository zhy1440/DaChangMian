package com.dcmomis.kefu.order.service;

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

public class OrderManagementServ extends HttpServlet {
	// execute GET request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		OrderRecordBean orb = new OrderRecordBean();
		orb.setCstId(request.getParameter("cstId"));
		orb.setDcmId(request.getParameter("dcmId"));
		orb.setLink(request.getParameter("link"));
		orb.setCommodityName(request.getParameter("commodityName"));
		orb.setUnitPrice(request.getParameter("unitPrice"));
		orb.setAmount(request.getParameter("amount"));
		orb.setGoodsColor(request.getParameter("goodsColor"));
		orb.setGoodsSize(request.getParameter("goodsSize"));
		orb.setDiscountDesc(request.getParameter("discountDesc"));
		orb.setComments(request.getParameter("comments"));
		orb.setPicture(request.getParameter("picUrl"));

		// String output = "{success: true,errors: {clientCode: 'Client not
		// found',portOfLoading: 'This field must not be null'}}";
		String output = OrderOperationDao.placeOrderRecord(orb);
		
		// jsonp…Ë÷√
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
