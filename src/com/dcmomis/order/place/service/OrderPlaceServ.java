package com.dcmomis.order.place.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcmomis.order.OrderRecordBean;

public class OrderPlaceServ extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2149932017980837259L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// doPost(request, response);
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

		String output = OrderPlaceDao.placeOrderRecord(orb);

		out.print(output);
		System.out.println("=== Place Order Output ===========>>> " + output);

	}

}
