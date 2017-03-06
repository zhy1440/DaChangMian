package com.dcmomis.user.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dcmomis.common.ResponseBean;
import com.dcmomis.order.OrderRecordBean;
import com.dcmomis.user.CustomerAddrBean;
import com.dcmomis.utils.DBUtils;
import com.dcmomis.utils.StringUtils;

public class AddressManagementDao {
	public static String placeOrderRecord(OrderRecordBean orb) {
		// 入库
		Connection conn = null;
		PreparedStatement pstm = null;
		ResponseBean rb = new ResponseBean();
		String sqlInsert = "INSERT INTO `bd_dw_dcm_order_record` "
				+ "(ORDER_TIME, GROUP_ID, CST_ID, DCM_ID, LINK, COMMODITY_NAME, "
				+ "COMMODITY_DESC, UNIT_PRICE, AMOUNT, GOODS_COLOR, " + "GOODS_SIZE, DISCOUNT_FINAL, COMMENTS, PICTURE) "
				+ "VALUES " + "( DATE_FORMAT(NOW(), '%Y-%m-%d %T'),?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = DBUtils.getDBConnection();
			pstm = conn.prepareStatement(sqlInsert);
			pstm.setString(1, orb.getGroupId());
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
			if (-1 == orb.getPicture().indexOf("downloadpic\\")) {
				//pstm.setString(13, storeImage(orb.getPicture()));
			}else{
				pstm.setString(13, orb.getPicture());
			}
			pstm.addBatch();
			System.out.println("zyDebug---------:" + sqlInsert + "--------------" + orb.getDcmId());
			// ArrayList columnNames=new ArrayList();
			pstm.executeBatch();
			// return customerInfoList;
		} catch (Exception e) {
			e.printStackTrace();
			rb.setErrorMsg("出错啦");
			rb.setSuccess(false);
			String result = StringUtils.listToJson(rb, false);
			return result;
		} finally {
			DBUtils.release(pstm, null, conn);
		}
		rb.setSuccessMsg("下单成功,是否跳转到订单管理？");
		rb.setSuccess(true);

		String result = StringUtils.listToJson(rb, false);
		return result;
	}

/***********************************我是新文件开始的分割线****************************************************************/
/**
 * 查询
 * @param uid
 * @return
 */
	public static String getCustomerAddrByUid(String uid) {
		// TODO Auto-generated method stub
		String result = null;
		List<CustomerAddrBean> customerAddrListBean = getCustomerAddrListByUid(uid);
		result = StringUtils.listToJson("orders", customerAddrListBean);
		return result;
	}
	
	public static List<CustomerAddrBean> getCustomerAddrListByUid(String uid) {
		Connection conn = null;
		Statement stm = null;
		ResultSet result = null;
		String queryString = "SELECT t.ROW_ID_INNER, t.DCM_ID, t.ADDR_TYPE,t.ADDRESS from bd_dw_dcm_customer_addr t where t.DCM_ID= '" + uid + "' "
				+ "AND DATE_FORMAT(NOW(), '%Y%m%d') >= t.START_DATE AND DATE_FORMAT(NOW(), '%Y%m%d') < t.END_DATE ORDER BY t.ADDR_TYPE";
		try {
			conn = DBUtils.getDBConnection();
			stm = conn.createStatement();
			result = stm.executeQuery(queryString);
			List<CustomerAddrBean> customerAddrList = new ArrayList<CustomerAddrBean>();
			while (result.next()) {
				CustomerAddrBean customerAddr = new CustomerAddrBean();
				customerAddr.setUserId(result.getString("DCM_ID"));
				customerAddr.setAddrType(result.getString("ADDR_TYPE"));
				customerAddr.setAddress(result.getString("ADDRESS"));
				customerAddr.setRowIdInner(result.getString("ROW_ID_INNER"));
				customerAddrList.add(customerAddr);
			}
			return customerAddrList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(stm, result, conn);
		}
		return null;
	}
	
	/**
	 * 新增地址
	 * @param customerAddr
	 * @return
	 */
	public static String insertCustomerAddrByUid(CustomerAddrBean customerAddr) {
		// 入库
		Connection conn = null;
		PreparedStatement pstm = null;
		ResponseBean rb = new ResponseBean();
		String sqlInsert = "INSERT INTO `bd_dw_dcm_customer_addr` (DCM_ID,ADDR_TYPE,ADDRESS,START_DATE,END_DATE) "
				+ "VALUES (?, ?, ?, DATE_FORMAT(NOW(), '%Y%m%d'), '99991231')";
		try {
			conn = DBUtils.getDBConnection();
			pstm = conn.prepareStatement(sqlInsert);
			pstm.setString(1, customerAddr.getUserId());
			pstm.setString(2, customerAddr.getAddrType());
			pstm.setString(3, customerAddr.getAddress());
			pstm.addBatch();
			System.out.println("zyDebug---------:" + sqlInsert + "--------------" + customerAddr.getUserId());
			// ArrayList columnNames=new ArrayList();
			pstm.executeBatch();
			// return customerInfoList;
		} catch (Exception e) {
			e.printStackTrace();
			rb.setErrorMsg("出错啦");
			rb.setSuccess(false);
			String result = StringUtils.listToJson(rb, false);
			return result;
		} finally {
			DBUtils.release(pstm, null, conn);
		}
		rb.setSuccessMsg("添加成功");
		rb.setSuccess(true);

		String result = StringUtils.listToJson(rb, false);
		return result;
	}
	public static List<CustomerAddrBean> updateCustomerAddrByUid(String uid) {
		Connection conn = null;
		Statement stm = null;
		ResultSet result = null;
		String updateString = "SELECT t.DCM_ID, t.ADDR_TYPE,t.ADDRESS from bd_dw_dcm_customer_addr t where t.DCM_ID= '" + uid + "' "
				+ "AND DATE_FORMAT(NOW(), '%Y%m%d') >= t.START_DATE AND DATE_FORMAT(NOW(), '%Y%m%d') < t.END_DATE ORDER BY t.ADDR_TYPE";
		try {
			conn = DBUtils.getDBConnection();
			stm = conn.createStatement();
			result = stm.executeQuery(updateString);
			List<CustomerAddrBean> customerAddrList = new ArrayList<CustomerAddrBean>();
			while (result.next()) {
				CustomerAddrBean customerAddr = new CustomerAddrBean();
				customerAddr.setUserId(result.getString("DCM_ID"));
				customerAddr.setAddrType(result.getString("ADDR_TYPE"));
				customerAddr.setAddress(result.getString("ADDRESS"));
				customerAddrList.add(customerAddr);
			}
			return customerAddrList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(stm, result, conn);
		}
		return null;
	}
	public static String deleteCustomerAddrByUid(String uid, String rowIdInner) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResponseBean rb = new ResponseBean();
		String deleteString = "delete from bd_dw_dcm_customer_addr where DCM_ID= ? AND ROW_ID_INNER = ?";
		
		try {
			conn = DBUtils.getDBConnection();
			pstm = conn.prepareStatement(deleteString);
			pstm.setString(1, uid);
			pstm.setInt(2,Integer.parseInt(rowIdInner));
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			rb.setErrorMsg("出错啦");
			rb.setSuccess(false);
			return StringUtils.listToJson(rb, false);
		} finally {
			DBUtils.release(pstm, null, conn);
		}
		rb.setSuccessMsg("删除成功");
		rb.setSuccess(true);

		return StringUtils.listToJson(rb, false);
	}
}
