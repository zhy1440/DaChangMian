package com.dcmomis.kefu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dcmomis.common.ResponseBean;
import com.dcmomis.common.TreeNodeBean;
import com.dcmomis.order.OrderRecordBean;
import com.dcmomis.user.CustomerAddrBean;
import com.dcmomis.utils.DBUtils;
import com.dcmomis.utils.StringUtils;

public class NaviTreeDao {
	/**
	 * 查询子节点
	 * 
	 * @param node
	 * @return
	 */
	public static String getChildren(String node) {
		// TODO Auto-generated method stub
		String result = null;
		List<TreeNodeBean> childNodesBean = getChildNodesbyParant(node);
		result = StringUtils.listToJson("children", childNodesBean);
		return result;
	}

	public static List<TreeNodeBean> getChildNodesbyParant(String node) {
		Connection conn = null;
		Statement stm = null;
		ResultSet result = null;
		String[] p = node.split("#");
		String parent = p[p.length-1];//处理parent
		String queryString01 = "SELECT DISTINCT r.GROUP_ID, dic.DIC_NAME as GROUP_NAME "
				+ "FROM bd_dw_dcm_order_record r "
				+ "LEFT JOIN bd_dic_dcm_common dic ON r.GROUP_ID = dic.DIC_VALUE "
				+ "WHERE r.ORDER_TYPE = '" + p[0]
				+ "'";
		String queryString23 = "SELECT DISTINCT SUBSTR(r.ORDER_TIME,1,4) AS YEAR "
				+ "FROM bd_dw_dcm_order_record r where r.ORDER_TYPE='" + p[0]
				+ "'";
		String queryStringYear ="SELECT DISTINCT SUBSTR(r.ORDER_TIME,1,7) AS MONTH FROM bd_dw_dcm_order_record r where r.ORDER_TYPE='" + p[0]
				+ "' and SUBSTR(r.ORDER_TIME,1,4) = '"+parent+"'";
		String queryStringMonth ="SELECT DISTINCT SUBSTR(r.ORDER_TIME,1,10) AS DAY FROM bd_dw_dcm_order_record r where r.ORDER_TYPE='" + p[0]
				+ "' and SUBSTR(r.ORDER_TIME,1,7) = '"+parent+"'";
		try {
			conn = DBUtils.getDBConnection();
			stm = conn.createStatement();
			List<TreeNodeBean> childNodesList = new ArrayList<TreeNodeBean>();
			switch(p.length){
				case 1: {
					if(parent.equals("0")|| parent.equals("1")){
						result = stm.executeQuery(queryString01);
						while (result.next()) {
							TreeNodeBean childNode = new TreeNodeBean();
							childNode.setId(node +'#'+result.getString("GROUP_ID"));
							childNode.setText(result.getString("GROUP_NAME"));
							childNode.setLeaf(true);
							childNodesList.add(childNode);
						}
					}else if (parent.equals("2")|| parent.equals("3")){
						result = stm.executeQuery(queryString23);
						while (result.next()) {
							TreeNodeBean childNode = new TreeNodeBean();
							childNode.setId(node +'#'+result.getString("YEAR"));
							childNode.setText(result.getString("YEAR"));
							childNode.setLeaf(false);
							childNodesList.add(childNode);
						}
					}
					break;
				}
				case 2: {
					result = stm.executeQuery(queryStringYear);
					while (result.next()) {
						TreeNodeBean childNode = new TreeNodeBean();
						childNode.setId(node +'#'+result.getString("MONTH"));
						childNode.setText(result.getString("MONTH"));
						childNode.setLeaf(false);
						childNodesList.add(childNode);
					}
					break;
				}
				case 3:{
					result = stm.executeQuery(queryStringMonth);
					while (result.next()) {
						TreeNodeBean childNode = new TreeNodeBean();
						childNode.setId(node +'#'+result.getString("DAY"));
						childNode.setText(result.getString("DAY"));
						childNode.setLeaf(false);
						childNodesList.add(childNode);
					}
					break;
				}
				case 4:{
					String qsql = queryString01+" and SUBSTR(r.ORDER_TIME,1,10) = '"+parent+"'";
					System.out.println(qsql);
					result = stm.executeQuery(qsql);
					while (result.next()) {
						TreeNodeBean childNode = new TreeNodeBean();
						childNode.setId(node +'#'+result.getString("GROUP_ID"));
						childNode.setText(result.getString("GROUP_NAME"));
						childNode.setLeaf(true);
						childNodesList.add(childNode);
					}
					break;
				}
				case 5:{
					break;
				}
			}
			return childNodesList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(stm, result, conn);
		}
		return null;
	}

}
