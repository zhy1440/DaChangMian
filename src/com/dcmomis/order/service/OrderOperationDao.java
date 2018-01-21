package com.dcmomis.order.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dcmomis.common.ResponseBean;
import com.dcmomis.order.OrderRecordBean;
import com.dcmomis.utils.DBUtils;
import com.dcmomis.utils.DicUtils;
import com.dcmomis.utils.StringUtils;

public class OrderOperationDao {
	public static String placeOrderRecord(OrderRecordBean orb) {
		Connection conn = null;
		PreparedStatement pstm = null;
		//PreparedStatement pstmLog = null;
		ResponseBean rb = new ResponseBean();
		String insertSql = "INSERT INTO `bd_dw_dcm_order_record` "
				+ "(ORDER_TIME, GROUP_ID, CST_ID, DCM_ID, LINK, COMMODITY_NAME, "
				+ "COMMODITY_DESC, UNIT_PRICE, AMOUNT, GOODS_COLOR, " + "GOODS_SIZE, DISCOUNT_FINAL, COMMENTS, PICTURE,FINAL_PRICE) "
				+ "VALUES " + "( DATE_FORMAT(NOW(), '%Y-%m-%d %T'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*		String insertLogSql= "INSERT INTO `bd_dw_dcm_order_op_log`"
				+ "(ORDER_ID, OPERATOR, OP_TIME) VALUES (?, 'auto', ( DATE_FORMAT(NOW(), '%Y-%m-%d %T'))";*/
		try {
			conn = DBUtils.getDBConnection();
			pstm = conn.prepareStatement(insertSql);
			pstm.setString(1, getGroupId(orb.getLink()));
			pstm.setString(2, orb.getCstId());
			pstm.setString(3, orb.getDcmId());
			pstm.setString(4, orb.getLink());
			pstm.setString(5, orb.getCommodityName());
			pstm.setString(6, orb.getCommodityDesc());
			pstm.setString(7, orb.getUnitPrice());
			pstm.setString(8, orb.getAmount());
			pstm.setString(9, orb.getGoodsColor());
			pstm.setString(10, orb.getGoodsSize());
			pstm.setString(11, orb.getDiscountDesc());
			pstm.setString(12, orb.getComments());
			if (-1 == orb.getPicture().indexOf("downloadpic")) {
				pstm.setString(13, storeImage(orb.getPicture()));
			} else {
				pstm.setString(13, orb.getPicture());
			}
			pstm.setFloat(14, Float.parseFloat(orb.getUnitPrice()) * Float.parseFloat(orb.getAmount())
					* Float.parseFloat(orb.getDiscountDesc()));
			pstm.addBatch();
			System.out.println("zyDebug---------:" + insertSql + "--------------" + orb.getCstId());
			pstm.executeBatch();
			
/*			pstmLog = conn.prepareStatement(insertLogSql);
			pstmLog.setString(1, getGroupId(orb.getLink()));
			pstmLog.addBatch();
			System.out.println("zyDebugLog---------:" + insertLogSql + "--------------");
			pstmLog.executeBatch();*/
			
		} catch (Exception e) {
			e.printStackTrace();
			rb.setErrorMsg("下单出错啦！");
			rb.setSuccess(false);
			String result = StringUtils.listToJson(rb, false);
			return result;
		} finally {
			DBUtils.release(pstm, null, conn);
		}
		rb.setSuccessMsg("下单成功,是否前往我的订单?");
		rb.setSuccess(true);

		String result = StringUtils.listToJson(rb, false);
		return result;
	}

	/**
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

	/**
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

	public static String storeImage(String strUrl) throws Exception {
		// newh??URL????
		URL url = new URL(strUrl);
		// ??????
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// ??????????"GET"
		conn.setRequestMethod("GET");
		// ??????????5??
		conn.setConnectTimeout(5 * 1000);
		// ??????????????????
		InputStream inStream = conn.getInputStream();
		// ?锟�????K????????????????????锟�???????????????
		byte[] data = readInputStream(inStream);
		// newh???l?????????????????I?????j??????锟�
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");// ??????????
		// ?????j????????锟�??
		String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println(t);
		int num = t.indexOf(".metadata");
		System.out.println(num);
		if (-1 != num) {
			t = t.substring(1, num);
		} else {
			int n = t.indexOf("DcmWorkspace");
			t = t.substring(1, n);
		}
		System.out.println(t);

		String path = t.replace('/', '\\') + "DcmWorkspace\\kefu\\downloadpic\\";
		System.out.println(path);
		String fileName = df.format(new Date()) + ".jpg";
		// String fileName ="\\aqaaaa.jpg";
		File imageFile = new File(path + fileName);
		// boolean a = imageFile.createNewFile();

		// ?????????
		FileOutputStream outStream = new FileOutputStream(imageFile);
		// ???????
		outStream.write(data);
		// ????????
		outStream.close();
		// outStream.flush();// ????????l?????????
		
		return "downloadpic\\" + fileName;
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		// ????h??Buffer?????
		byte[] buffer = new byte[1024];
		// 锟�????????????????????-1???????????????
		int len = 0;
		// '??h??????????buffer?????????????
		while ((len = inStream.read(buffer)) != -1) {
			// ?????????buffer??????????????????????????锟�?'????len???????????
			outStream.write(buffer, 0, len);
		}
		// ?????????
		inStream.close();
		// ??outStream?????????????
		return outStream.toByteArray();
	}

	/**
	 * 获取团号
	 * @param link
	 * @return
	 */
	public static String getGroupId(String link) {
		String groupId = "unknown";
		Connection conn = null;
		Statement stm = null;
		ResultSet result = null;
		String str_link = link.substring(0, link.indexOf(".com")!=-1? link.indexOf(".com"):link.length()); //process link string remove the string after ".com"
		String queryString = "SELECT UPPER(DIC_VALUE) as DIC_VALUE FROM bd_dic_dcm_common WHERE DIC_TYPE = 'GROUP_ID' ORDER BY DIC_VALUE DESC";
		try {
			conn = DBUtils.getDBConnection();
			stm = conn.createStatement();
			result = stm.executeQuery(queryString);
			while (result.next()) {
				String tmpGroupId = result.getString("DIC_VALUE");
				int ret = str_link.toUpperCase().indexOf(tmpGroupId);
				if (ret != -1) {
					groupId = tmpGroupId;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(stm, result, conn);
		}
		return groupId;
	}

}
