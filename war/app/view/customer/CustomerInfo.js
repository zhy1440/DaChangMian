/**
 * This view is for customer to place an order.
 */
Ext.define('app.view.customer.CustomerInfo', {
	extend : 'Ext.Panel',
	xtype : 'customerinfo',
	requires : ['app.store.customer.CustomerAddrRecord',
			'app.view.customer.CustomerInfoController'],
	controller : 'customerInfo',
	store : {
		type : 'customeraddrrecord'
	},
	ui : 'dark',
	// title : '我的信息',
	width : 800,
	height : 600,
	layout : {
		type : 'vbox', // Arrange child items vertically
		align : 'stretch', // Each takes up full width
		padding : 5
	},
	items : [{ // Results grid specified as a config object with an
		// xtype of 'grid'
		title : '个人资料',
		bodyPadding : 10,
		layout : {
			type : 'table',
			// The total column count must be specified here
			columns : 1
		},
		defaultType : 'displayfield',
		defaults : {// 设置默认属性
			bodyStyle : 'padding:20px',
			labelWidth : 100
		},
		items : [{
					fieldLabel : 'ID',
					name : 'userId',
					value : localStorage.getItem("LoggedInUserName")
				}, {
					fieldLabel : '手机',
					name : 'orderStatus',
					value : localStorage.getItem("LoggedInMobile")
				}, {
					fieldLabel : '邮箱',
					name : 'totalPrice',
					value : localStorage.getItem("LoggedInEmail")
				}, {
					fieldLabel : '用户等级',
					name : 'memberLevel',
					value : ''
				}, {
					fieldLabel : '用户特权',
					name : 'exchangRate',
					value : ''
				}, {
					fieldLabel : '默认收货地址',
					name : 'commonAddr',
					value : ''
				}],
		height : 260
	}, {
		title : '收货地址管理',
		height : 340,
		xtype : 'grid',
		columns : [{
					header : '地址类型',
					dataIndex : 'addrType'
				}, {
					header : '地址',
					dataIndex : 'address',
					flex : 3
				}, {
					text : '操作',
					xtype : 'actioncolumn',
					width : 100,
					items : [/*{
								icon : 'packages/image/icon_detail.png',
								// Use a URL in the icon config
								tooltip : '修改'
							},*/ {
								icon : 'packages/image/icon_chedan.jpg',
								tooltip : '删除',
								handler : function(grid, rowIndex, colIndex) {
									var rec = grid.getStore().getAt(rowIndex);
									Ext.Ajax.request({
										url : './addrManagement?action=deleteCustomerAddrByUid',
										method : 'POST',
										params : {
											"uid" : localStorage
													.getItem("LoggedInUid"),
											"rowIdInner" : rec
													.get('rowIdInner')
										}
									}).then(function(response, opts) {
										var obj = Ext
												.decode(response.responseText);
										//console.dir(obj);
										//调用grid刷新
												
												
												
										Ext.Msg.alert('Success',obj.successMsg);
									}, function(response, opts) {
										console.log('server-side failure with status code '
														+ response.status);
									});
								}
							}]
				}], // One header just for show. There's no
		// data,
		store : {
			type : 'customeraddrrecord'
		},
		tools : [{
					type : 'refresh',
					callback : 'onRefreshClick'
				}, {
					type : 'plus',
					callback : 'onAddAddrClick'
				}]
	}]
});