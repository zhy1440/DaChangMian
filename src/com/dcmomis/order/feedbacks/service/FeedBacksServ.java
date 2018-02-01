package com.dcmomis.order.feedbacks.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedBacksServ extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6807097886350064208L;

	// execute GET request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String output = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String action = (String) request.getParameter("action");
		// String userName = (String)request.getParameter("userName");
		// deal with different Action
		if (action.equals("getOrderList")) {
			// 根据点击的节点获取订单
			try {
				String node = (String) request.getParameter("node");
				output = FeedBacksDao.getOrderListbyTreeNode(node);
			} catch (Exception e) {
			} finally {
			}
			/* 暫不使用 */
			// } else if (action.equals("queryOrderRecordbyUid")) {
			// // 根据用户id查询该用户所有订单记录
			// try {
			// String id = (String) request.getParameter("uid");
			// output = OrderOperationDao.queryOrderRecordbyUid(id);
			// } catch (Exception e) {
			// } finally {
			// }
		} else if (action.equals("updateOrderType")) {
			// 移动订单记录
			try {
				String orderId = (String) request.getParameter("orderId");
				String orderType = (String) request.getParameter("orderType");
				output = FeedBacksDao.updateOrderType(orderId, orderType);
			} catch (Exception e) {
			} finally {
			}
		} else if (action.equals("updateFinalPrice")) {
			// 修改价格
			try {
				String orderId = (String) request.getParameter("orderId");
				String finalPrice = (String) request.getParameter("finalPrice");
				output = FeedBacksDao.updateFinalPrice(orderId, finalPrice);
			} catch (Exception e) {
			} finally {
			}
		} else if (action.equals("createGroupId")) {
			// 新建团号
			try {
				String groupId = (String) request.getParameter("groupId");
				output = FeedBacksDao.createGroupId(groupId);
			} catch (Exception e) {
			} finally {
			}
		}

		// jsonp设置
		boolean jsonP = false;
		String cb = request.getParameter("callback");
		if (cb != null) {
			jsonP = true;
			response.setContentType("text/javascript");
		} else {
			response.setContentType("application/x-json");
		}
		if (jsonP) {
			output = cb + "(" + output;
		}

		if (jsonP) {
			output = output + ");";
		}
		System.out.println("=== " + action + " ===>" + output);
		out.print(output);

		out.flush();
		out.close();

	}

	public String data() {
		String a = "{\"success\": true,\"children\": [{ \"id\": 5, \"name\": \"Evan\", \"leaf\": true }]}";
		return a;
	}

}
