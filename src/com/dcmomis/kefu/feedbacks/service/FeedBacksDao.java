package com.dcmomis.kefu.feedbacks.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dcmomis.common.ResponseBean;
import com.dcmomis.common.TreeNodeBean;
import com.dcmomis.order.OrderRecordBean;
import com.dcmomis.order.service.OrderOperationDao;
import com.dcmomis.user.CustomerAddrBean;
import com.dcmomis.utils.DBUtils;
import com.dcmomis.utils.DicUtils;
import com.dcmomis.utils.StringUtils;

public class FeedBacksDao {
	/**
	 * 閿熸枻鎷疯閿熸帴鑺傜鎷�
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
				+ "UNIT_PRICE, AMOUNT, UNIT_PRICE*AMOUNT*DISCOUNT_FINAL AS TOTAL_PRICE, GOODS_COLOR, GOODS_SIZE, FINAL_PRICE, DISCOUNT_FINAL, "
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
	 * 閿熸枻鎷烽敓鏂ゆ嫹閿熺煫浼欐嫹id閿熸枻鎷疯閿熸枻鎷烽敓鐭紮鎷烽敓鏂ゆ嫹閿熷彨璁规嫹閿熸枻鎷烽敓鏂ゆ嫹褰昹ist
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
				orderRecord.setFinalPrice(result.getString("FINAL_PRICE"));
				orderRecord.setGoodsColor(result.getString("GOODS_COLOR"));
				orderRecord.setUnitPrice(result.getString("UNIT_PRICE"));
				orderRecord.setGoodsSize(result.getString("GOODS_SIZE"));
				orderRecord.setDiscountDesc(result.getString("DISCOUNT_FINAL"));
				orderRecord.setComments(result.getString("COMMENTS"));
				orderRecord.setPicture("<img src=\"" + result.getString("PICTURE") + "\"  height=\"200\">");//http://www.dachangmian.cn:8888
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

	/**
	 * 閿熸枻鎷烽敓鎹疯鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹钖蜂憨閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
	 * 
	 * @param orderId,orderType
	 * @return
	 */
	public static String updateOrderType(String orderId, String orderType) {
		Connection conn = null;
		PreparedStatement pstm = null;
		//PreparedStatement pstmLog = null;
		ResponseBean rb = new ResponseBean();
		String updateSql = "UPDATE bd_dw_dcm_order_record r set r.ORDER_TYPE = ? where r.ORDER_ID = ? ";
		try {
			conn = DBUtils.getDBConnection();
			pstm = conn.prepareStatement(updateSql);
			pstm.setString(1, orderType);
			pstm.setInt(2, Integer.parseInt(orderId));
			pstm.addBatch();
			System.out.println("zyDebug---------:" + updateSql + "--------------" + orderType + "----------" + Integer.parseInt(orderId));
			pstm.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
			rb.setErrorMsg("绉诲姩澶辫触");
			System.out.println("绉诲姩澶辫触");
			rb.setSuccess(false);
			String result = StringUtils.listToJson(rb, false);
			return result;
		} finally {
			DBUtils.release(pstm, null, conn);
		}
		rb.setSuccessMsg("绉诲姩鎴愬姛");
		System.out.println("绉诲姩鎴愬姛");
		rb.setSuccess(true);

		String result = StringUtils.listToJson(rb, false);
		return result;
	}
	/**
	 * 閿熸枻鎷烽敓鎹疯鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹钖烽敓鏂ゆ嫹閰嗛敓鏂ゆ嫹
	 * 
	 * @param orderId,finalPrice
	 * @return
	 */
	public static String updateFinalPrice(String orderId, String finalPrice) {
		// update Final Price
		Connection conn = null;
		PreparedStatement pstm = null;
		//PreparedStatement pstmLog = null;
		ResponseBean rb = new ResponseBean();
		String updateSql = "UPDATE bd_dw_dcm_order_record r set r.FINAL_PRICE = ? where r.ORDER_ID = ? ";
		try {
			conn = DBUtils.getDBConnection();
			pstm = conn.prepareStatement(updateSql);
			pstm.setFloat(1, Float.parseFloat(finalPrice));
			pstm.setInt(2, Integer.parseInt(orderId));
			pstm.addBatch();
			System.out.println("zyDebug---------:" + updateSql + "--------------" + finalPrice + "----------" + Integer.parseInt(orderId));
			pstm.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
			rb.setErrorMsg("閿熸鐚存嫹閿熸枻鎷疯柗鏌愰敓鏂ゆ嫹閿熸枻鎷烽敓锟�");
			System.out.println("閿熸鐚存嫹閿熸枻鎷疯柗鏌愰敓鏂ゆ嫹閿燂拷");
			rb.setSuccess(false);
			String result = StringUtils.listToJson(rb, false);
			return result;
		} finally {
			DBUtils.release(pstm, null, conn);
		}
		rb.setSuccessMsg("閿熸鐚存嫹閿熸枻鎷疯柗鏌愭檼閿燂拷");
		System.out.println("閿熸鐚存嫹閿熸枻鎷疯柗鏌愭檼閿燂拷");
		rb.setSuccess(true);

		String result = StringUtils.listToJson(rb, false);
		return result;
	}
	
	public static String createGroupId(String groupId) {
		// 新建团号
		
		if (OrderOperationDao.getGroupId(group) =='unknown') {
			return
		}
		Connection conn = null;
		PreparedStatement pstm = null;
		//PreparedStatement pstmLog = null;
		ResponseBean rb = new ResponseBean();
		String updateSql = "UPDATE bd_dw_dcm_order_record r set r.FINAL_PRICE = ? where r.ORDER_ID = ? ";
		try {
			conn = DBUtils.getDBConnection();
			pstm = conn.prepareStatement(updateSql);
			pstm.setFloat(1, Float.parseFloat(finalPrice));
			pstm.setInt(2, Integer.parseInt(orderId));
			pstm.addBatch();
			System.out.println("zyDebug---------:" + updateSql + "--------------" + finalPrice + "----------" + Integer.parseInt(orderId));
			pstm.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
			rb.setErrorMsg("閿熸鐚存嫹閿熸枻鎷疯柗鏌愰敓鏂ゆ嫹閿熸枻鎷烽敓锟�");
			System.out.println("閿熸鐚存嫹閿熸枻鎷疯柗鏌愰敓鏂ゆ嫹閿燂拷");
			rb.setSuccess(false);
			String result = StringUtils.listToJson(rb, false);
			return result;
		} finally {
			DBUtils.release(pstm, null, conn);
		}
		rb.setSuccessMsg("閿熸鐚存嫹閿熸枻鎷疯柗鏌愭檼閿燂拷");
		System.out.println("閿熸鐚存嫹閿熸枻鎷疯柗鏌愭檼閿燂拷");
		rb.setSuccess(true);

		String result = StringUtils.listToJson(rb, false);
		return result;
		
		return true;
	}
}
