package com.dcmomis.kefu.order.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dcmomis.order.OrderRecordBean;
import com.dcmomis.utils.DBUtils;
import com.dcmomis.utils.DicUtils;
import com.dcmomis.utils.StringUtils;

public class OrderManagementDao {
	/**
	 * 查询子节点
	 * 
	 * @param node
	 * @return
	 */
	public static String getOrderList(String node) {
		// TODO Auto-generated method stub
		String result = null;

		String[] p = node.split("#");

		String orderType = p[0];
		String groupId = p[p.length - 1];
		String queryString = "SELECT "
				+ "ORDER_ID, ORDER_STATUS, ORDER_TIME, GROUP_ID, CST_ID, LINK, COMMODITY_NAME, COMMODITY_DESC,"
				+ "UNIT_PRICE, AMOUNT, UNIT_PRICE*AMOUNT*DISCOUNT_FINAL AS TOTAL_PRICE, FINAL_PRICE, GOODS_COLOR, GOODS_SIZE, DISCOUNT_FINAL, DISCOUNT_FINAL, "
				+ "COMMENTS, PICTURE, OVERSEAS_FREIGH, INLAND_FREIGH " + "FROM BD_DW_DCM_ORDER_RECORD "
				+ "WHERE ORDER_TYPE = '" + orderType + "' AND GROUP_ID = '" + groupId;
		if (5 == p.length) {
			String date = p[p.length - 2];
			queryString = queryString + "' AND SUBSTR(ORDER_TIME, 1, 10) = '" + date;
		}
		queryString = queryString + "' ORDER BY ORDER_ID DESC";
		List<OrderRecordBean> orderRecordList = getOrderRecordList(queryString);
		result = StringUtils.listToJson(orderRecordList, true);

		// List<TreeNodeBean> childNodesBean = getChildNodesbyParant(node);
		// result = StringUtils.listToJson("children", childNodesBean);
		return result;
	}

	/**
	 * 根据用户id查询该用户所有订单记录list
	 * 
	 * @param id
	 * @return
	 */
	public static List<OrderRecordBean> getOrderRecordList(String sql) {
		Connection conn = null;
		Statement stm = null;
		ResultSet result = null;
		String queryString = sql;
		try {
			conn = DBUtils.getDBConnection();
			stm = conn.createStatement();
			result = stm.executeQuery(queryString);
			List<OrderRecordBean> orderRecordList = new ArrayList<OrderRecordBean>();
			while (result.next()) {
				OrderRecordBean orderRecord = new OrderRecordBean();
				orderRecord.setOrderId(result.getString("ORDER_ID"));
				orderRecord.setOrderTime(result.getString("ORDER_TIME"));
				orderRecord.setOrderStatus(DicUtils.GetDicDescbyId(result.getString("ORDER_STATUS"), "ORDER_STATUS"));
				orderRecord.setGroupId(result.getString("GROUP_ID"));
				orderRecord.setCstId(result.getString("CST_ID"));
				orderRecord.setLink("<p><b><a href='"
						+ result.getString("LINK")
						+ "' target='_blank'>"
						+ result.getString("LINK")
						+ "</a></b></p>");
				orderRecord.setCommodityName(result.getString("COMMODITY_NAME"));
				orderRecord.setCommodityDesc(result.getString("COMMODITY_DESC"));
				orderRecord.setAmount(result.getString("AMOUNT"));
				orderRecord.setTotalPrice(result.getString("TOTAL_PRICE"));
				orderRecord.setGoodsColor(result.getString("GOODS_COLOR"));
				orderRecord.setUnitPrice(result.getString("UNIT_PRICE"));
				orderRecord.setGoodsSize(result.getString("GOODS_SIZE"));
				orderRecord.setDiscountDesc(result.getString("DISCOUNT_FINAL"));
				orderRecord.setComments(result.getString("COMMENTS"));
				orderRecord.setPicture("<img src=\"/" + result.getString("PICTURE") + "\"/  height=\"200\">");//http://www.dachangmian.cn:8888
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
