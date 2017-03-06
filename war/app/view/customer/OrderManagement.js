/**
 * This view is an example list of people.
 */
Ext.define('app.view.customer.OrderManagement', {
	extend : 'Ext.grid.Panel',
	xtype : 'ordermanagement',
	ui : 'dark',
	requires : ['app.store.order.CustomerOrderRecord',
			'app.view.customer.OrderManagementController'],
	controller : 'orderManagement',
	title : '订单列表',
	width : 1200,

	store : {
		type : 'customerorderrecord'
	},

	columns : [
			// { text: '订单号', dataIndex: 'orderId' },
			// { text: '下单日期', dataIndex: 'orderDate', flex: 1 },
			// { text: '团号（id）', dataIndex: 'groupId', flex: 1 },
			// { text: '顾客id', dataIndex: 'cstId', flex: 1 },
			// { text: '链接', dataIndex: 'link', flex: 1 },
			/*
			 * { text: '订单商品', dataIndex: 'commodityName', flex: 1 }, { text:
			 * '订单状态', dataIndex: 'orderStatus', flex: 1 }, { text: '操作',
			 * dataIndex: 'operType', flex: 1 }
			 */

			/*
			 * //{ text: '商品中文描述', dataIndex: 'commodityDesc', flex: 1 }, {
			 * text: '单价', dataIndex: 'unitPrice', flex: 1 }, { text: '数量',
			 * dataIndex: 'amount', flex: 1 }, { text: '总价', dataIndex:
			 * 'totalPrice', flex: 1 }, { text: '颜色', dataIndex: 'goodsColor',
			 * flex: 1 }, { text: '尺寸', dataIndex: 'goodsSize', flex: 1 }, {
			 * text: '折扣', dataIndex: 'discount1', flex: 1 }, // { text:
			 * 'discount2', dataIndex: 'discount2', flex: 1 }, // { text:
			 * 'totalPrice', dataIndex: 'totalPrice', flex: 1 }, { text: '备注',
			 * dataIndex: 'comments', flex: 1 }, { text: '图片', dataIndex:
			 * 'picture', flex: 1 } // { text: '国际运费', dataIndex:
			 * 'overseasFreigh', flex: 1 }, // { text: '国内运费', dataIndex:
			 * 'inlandFreigh', flex: 1 }
			 */
			{
		text : '订单商品',
		xtype : 'templatecolumn',
		tpl : '订单编号： {orderId}&nbsp;&nbsp;&nbsp;&nbsp;下单日期：{orderTime}<br><br>{commodityName}<br><br>{picture}&nbsp;×{amount}',
		flex : 1
	}, {
		text : '订单状态',
		xtype : 'templatecolumn',
		tpl : '{orderStatus}',
		width : 150
	}, {
		text : '操作',
		xtype : 'actioncolumn',
		width : 100,
		items : [{
					icon : 'packages/image/icon_detail.png',
					// Use a URL in the icon config
					tooltip : '订单详情',
					handler : 'onDetailClick'
				}, {
					icon : 'packages/image/icon_chedan.jpg',
					tooltip : '撤单',
					disabled : true,
					handler : function(grid, rowIndex, colIndex) {
						var rec = grid.getStore().getAt(rowIndex);
						alert("撤单 " + rec.get('orderTime'));
					}
				}]
	}]
});
