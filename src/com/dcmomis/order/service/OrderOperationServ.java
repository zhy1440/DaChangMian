package com.dcmomis.order.service;

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

public class OrderOperationServ extends HttpServlet {
	// execute GET request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String output = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String action = (String) request.getParameter("action");
		// String userName = (String)request.getParameter("userName");
		// deal with different Action
		if (action.equals("queryOrderRecord")) {
			try {
				output = queryOrderRecord();
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
		} else if (true) {
		}

		System.out.println(output);
		out.print(output);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// doGet(request, response);
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

		out.print(output);
		System.out.println(output);

	}

	public String queryOrderRecord() {
		String result = null;
		List<OrderRecordBean> orderRecordList = getOrderRecordList();
		result = StringUtils.listToJson("orders", orderRecordList);
		return result;
	}

	public List<OrderRecordBean> getOrderRecordList() {
		Connection conn = null;
		Statement stm = null;
		ResultSet result = null;
		String queryString = "SELECT " + "ORDER_ID, ORDER_DATE, GROUP_ID, CST_ID, LINK, COMMODITY_NAME, COMMODITY_DESC,"
				+ "UNIT_PRICE, AMOUNT, GOODS_COLOR, GOODS_SIZE, DISCOUNT_FINAL, DISCOUNT_2, TOTAL_PRICE,"
				+ "COMMENTS, PICTURE, OVERSEAS_FREIGH, INLAND_FREIGH " + "FROM BD_DW_DCM_ORDER_RECORD";
		try {
			conn = DBUtils.getDBConnection();
			stm = conn.createStatement();
			result = stm.executeQuery(queryString);
			List<OrderRecordBean> orderRecordList = new ArrayList<OrderRecordBean>();
			while (result.next()) {
				OrderRecordBean orderRecord = new OrderRecordBean();
				orderRecord.setOrderId(result.getString("ORDER_ID"));
				orderRecord.setOrderTime(result.getString("ORDER_DATE"));
				orderRecord.setGroupId(result.getString("GROUP_ID"));
				orderRecord.setCstId(result.getString("CST_ID"));
				orderRecord.setLink(result.getString("LINK"));
				orderRecord.setCommodityName(result.getString("COMMODITY_NAME"));
				orderRecord.setCommodityDesc(result.getString("COMMODITY_DESC"));
				orderRecord.setAmount(result.getString("AMOUNT"));
				orderRecord.setGoodsColor(result.getString("GOODS_COLOR"));
				orderRecord.setUnitPrice(result.getString("UNIT_PRICE"));
				orderRecord.setGoodsSize(result.getString("GOODS_SIZE"));
				orderRecord.setComments(result.getString("COMMENTS"));
				orderRecordList.add(orderRecord);
			}
			return orderRecordList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(stm, result, conn);
		}
		return null;
	}

}
