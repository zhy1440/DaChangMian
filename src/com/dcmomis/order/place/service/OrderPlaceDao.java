package com.dcmomis.order.place.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.dcmomis.common.ResponseBean;
import com.dcmomis.common.service.ImageUploadServ;
import com.dcmomis.order.OrderRecordBean;
import com.dcmomis.utils.DBUtils;
import com.dcmomis.utils.StringUtils;

/**
 * @author Cathy Zhuang
 *
 */
public class OrderPlaceDao {

	public static String placeOrderRecord(OrderRecordBean orb) {
		Connection conn = null;
		PreparedStatement pstm = null;
		//PreparedStatement pstmLog = null;
		ResponseBean rb = new ResponseBean();
		ImageUploadServ imgServ= new ImageUploadServ();
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
			// 获取图片
			if (-1 == orb.getPicture().indexOf("downloadpic")) {
				// 网络图片
				pstm.setString(13, imgServ.storeImage(orb.getPicture()));
			} else {
				// 本地上传图片
				pstm.setString(13, orb.getPicture());
			}
			pstm.setFloat(14, Float.parseFloat(orb.getUnitPrice()) * Float.parseFloat(orb.getAmount())
					* Float.parseFloat(orb.getDiscountDesc()));
			pstm.addBatch();
			System.out.println(">>> Place Order Sql ======>>> " + insertSql);
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
