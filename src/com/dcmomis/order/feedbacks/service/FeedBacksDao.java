package com.dcmomis.order.feedbacks.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dcmomis.common.ResponseBean;
import com.dcmomis.order.OrderRecordBean;
import com.dcmomis.order.place.service.OrderPlaceDao;
import com.dcmomis.utils.DBUtils;
import com.dcmomis.utils.DicUtils;
import com.dcmomis.utils.StringUtils;

public class FeedBacksDao {
	/**
	 * 根据点击的节点获取订单
	 * 
	 * @param node
	 * @return
	 */
	public static String getOrderListbyTreeNode(String node) {
		// TODO Auto-generated method stub
		String result = null;
		
		// node格式：orderType#yyyy#yyyy-mm#yyyy-mm-dd#groupId
		String[]  p= node.split("#");
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
		return result;
	}

	/**
	 *  根据sql查询订单记录
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
	 * 更改某条订单的订单类型
	 * 
	 * @param orderId, orderType
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
			rb.setErrorMsg("移动失败");
			System.out.println("移动失败");
			rb.setSuccess(false);
			String result = StringUtils.listToJson(rb, false);
			return result;
		} finally {
			DBUtils.release(pstm, null, conn);
		}
		rb.setSuccessMsg("移动成功");
		System.out.println("移动成功");
		rb.setSuccess(true);

		String result = StringUtils.listToJson(rb, false);
		return result;
	}
	/**
	 * 修改折后价
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
			System.out.println("=== 修改折后价sql =====>: " + updateSql + " ===> 修改值：" + finalPrice + " ===> 订单号：" + Integer.parseInt(orderId));
			pstm.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
			rb.setErrorMsg("折后价修改失败");
			System.out.println("折后价修改失败");
			rb.setSuccess(false);
			String result = StringUtils.listToJson(rb, false);
			return result;
		} finally {
			DBUtils.release(pstm, null, conn);
		}
		rb.setSuccessMsg("折后价修改成功");
		System.out.println("折后价修改成功");
		rb.setSuccess(true);

		String result = StringUtils.listToJson(rb, false);
		return result;
	}
	
	/**
	 * 创建团号
	 * @param groupId
	 * @return
	 */
	public static String createGroupId(String groupId) {
		// 新建团号
		ResponseBean rb = new ResponseBean();
		String rstGroupId = OrderPlaceDao.getGroupId(groupId);
		if (rstGroupId !="unknown") {
			rb.setErrorMsg("团号"+ groupId +"已存在");
			rb.setSuccess(false);
			String result = StringUtils.listToJson(rb, false);
			return result;
		}
		Connection conn = null;
		PreparedStatement pstm = null;
		//PreparedStatement pstmLog = null;
		String updateSql = "INSERT INTO bd_dic_dcm_common (DIC_VALUE, DIC_NAME, DIC_TYPE, DIC_TYPE_DESC) VALUES (?, ?, 'GROUP_ID', '团号');";
		try {
			conn = DBUtils.getDBConnection();
			pstm = conn.prepareStatement(updateSql);
			pstm.setString(1, groupId);
			pstm.setString(2, groupId);
			pstm.addBatch();
			pstm.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
			rb.setErrorMsg("创建失败!");
			System.out.println("===> 团号创建失败!");
			rb.setSuccess(false);
			String result = StringUtils.listToJson(rb, false);
			return result;
		} finally {
			DBUtils.release(pstm, null, conn);
		}
		rb.setSuccessMsg("创建成功!");
		System.out.println("===> 团号创建成功!");
		rb.setSuccess(true);

		String result = StringUtils.listToJson(rb, false);
		return result;
	}
	
	
	/**暂未使用
	 * ?????锟�?id??????锟�??????????绯簊on
	 * 
	 * @param id
	 * @return
	 */
	public static String queryOrderRecordbyUid(String id) {
		String result = null;
		List<OrderRecordBean> orderRecordList = getOrderRecordListbyUid(id);
		result = StringUtils.listToJson("orders", orderRecordList);
		return result;
	}

	/**暂未使用
	 * ?????锟�?id??????锟�??????????绯絠st
	 * 
	 * @param id
	 * @return
	 */
	public static List<OrderRecordBean> getOrderRecordListbyUid(String id) {
		Connection conn = null;
		Statement stm = null;
		ResultSet result = null;
		String queryString = "SELECT "
				+ "ORDER_ID, ORDER_STATUS, ORDER_TIME, GROUP_ID, CST_ID, LINK, COMMODITY_NAME, COMMODITY_DESC,"
				+ "UNIT_PRICE, AMOUNT, GOODS_COLOR, GOODS_SIZE, DISCOUNT_FINAL, DISCOUNT_FINAL, TOTAL_PRICE,"
				+ "COMMENTS, PICTURE, OVERSEAS_FREIGH, INLAND_FREIGH " + "FROM BD_DW_DCM_ORDER_RECORD "
				+ "WHERE DCM_ID = '" + id + "' ORDER BY ORDER_ID DESC";
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
				orderRecord.setLink(result.getString("LINK"));
				orderRecord.setCommodityName(result.getString("COMMODITY_NAME"));
				orderRecord.setCommodityDesc(result.getString("COMMODITY_DESC"));
				orderRecord.setAmount(result.getString("AMOUNT"));
				orderRecord.setGoodsColor(result.getString("GOODS_COLOR"));
				orderRecord.setUnitPrice(result.getString("UNIT_PRICE"));
				orderRecord.setGoodsSize(result.getString("GOODS_SIZE"));
				orderRecord.setDiscountDesc(result.getString("DISCOUNT_FINAL"));
				orderRecord.setComments(result.getString("COMMENTS"));
				orderRecord.setPicture("<img src=\"" + result.getString("PICTURE") + "\"/  width=\"200\">");
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
