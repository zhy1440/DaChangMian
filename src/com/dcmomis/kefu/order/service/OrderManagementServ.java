package com.dcmomis.kefu.order.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcmomis.order.OrderRecordBean;
import com.dcmomis.order.service.OrderOperationDao;

import net.sf.json.JSONObject;

public class OrderManagementServ extends HttpServlet {
	// execute GET request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String myParam = request.getParameter("myParam");
		JSONObject jsonObject = JSONObject.fromObject(myParam);
		OrderRecordBean orb = new OrderRecordBean();
		orb.setCstId((String)jsonObject.get("cstId"));
		orb.setDcmId((String)jsonObject.get("dcmId"));
		orb.setLink((String)jsonObject.get("link"));
		orb.setCommodityName((String)jsonObject.get("commodityName"));
		orb.setUnitPrice((String)jsonObject.get("unitPrice"));
		orb.setAmount((String)jsonObject.get("amount"));
		orb.setGoodsColor((String)jsonObject.get("goodsColor"));
		orb.setGoodsSize((String)jsonObject.get("goodsSize"));
		orb.setDiscountDesc((String)jsonObject.get("discountDesc"));
		orb.setComments((String)jsonObject.get("comments"));
		orb.setPicture((String)jsonObject.get("picUrl"));

		// String output = "{success: true,errors: {clientCode: 'Client not
		// found',portOfLoading: 'This field must not be null'}}";
		String output = OrderOperationDao.placeOrderRecord(orb);
		
		// jsonp‘O÷√
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
