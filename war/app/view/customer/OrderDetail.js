/**
 * This view is for customer to place an order.
 */
Ext.define('app.view.customer.OrderDetail', {
			extend : 'Ext.Panel',
			xtype : 'orderdetail',

			ui : 'dark',
			height : 750,
			width : 700,
			record : {},
			config : {
				customTest : undefined
			},
			// frame : true,
			customTest111111 : undefined,
			layout : {
				type : 'vbox', // Arrange child items vertically
				align : 'stretch', // Each takes up full width
				padding : 5
			},
			initComponent : function() {
				var me = this;
				me.items = [{ // Results grid specified as a config object
								// with an
					// xtype of 'grid'
					title : '订单概况',
					bodyPadding : 10,
					layout : {
						type : 'form',
						// The total column count must be specified here
						columns : 1
					},
					defaultType : 'displayfield',
					defaults : {// 设置默认属性
						bodyStyle : 'padding:20px',
						labelWidth : 130
					},
					items : [{
								fieldLabel : '订单编号',
								name : 'orderId',
								value : me.record.get('orderId')
							}, {
								fieldLabel : '订单状态',
								name : 'orderStatus',
								value : me.record.get('orderStatus')
							}, {
								fieldLabel : '下单时间',
								name : 'orderTime',
								value : me.record.get('orderTime')
							}, {
								fieldLabel : '订单总计（不含运费）',
								name : 'totalPrice',
								value : me.record.get('totalPrice')
							}, {
								fieldLabel : '折扣备注',
								name : 'discountDesc',
								value : me.record.get('discountDesc')
							}, {
								fieldLabel : '订单备注',
								name : 'comments',
								value : me.record.get('comments')
							}]

				}, {
					xtype : 'splitter' // A splitter between the two child
										// items
				}, {	// Details Panel specified as a config object (no
							// xtype defaults to 'panel').
							title : '订单明细',
							bodyPadding : 10,
							layout : {
								type : 'form',
								// The total column count must be specified here
								columns : 1
							},
							defaultType : 'displayfield',
							defaults : {// 设置默认属性
								bodyStyle : 'padding:20px',
								labelWidth : 200
							},
							items : [{
										xtype : 'displayfield',
										fieldLabel : '商品名称',
										name : 'commodityName',
										value : me.record.get('commodityName')
									}, {
										xtype : 'displayfield',
										fieldLabel : '链接',
										name : 'link',
										value : "<p><b><a href='"
												+ me.record.get('link')
												+ "' target='_blank'>"
												+ me.record.get('link')
												+ "</a></b></p>"
										// value : '<a
										// herf="javascript:showPurchaseWin()">'+me.record.get('link')+'</a>'
									}, {
										xtype : 'displayfield',
										fieldLabel : '单价',
										name : 'unitPrice',
										value : me.record.get('unitPrice')
									}, {
										xtype : 'displayfield',
										fieldLabel : '数量',
										name : 'amount',
										value : me.record.get('amount')
									}, {
										xtype : 'displayfield',
										fieldLabel : '颜色',
										name : 'goodsColor',
										value : me.record.get('goodsColor')
									}, {
										xtype : 'displayfield',
										fieldLabel : '尺寸（不含运费）',
										name : 'goodsSize',
										value : me.record.get('goodsSize')
									}, {
										xtype : 'displayfield',
										fieldLabel : '最终折扣',
										name : 'discountFinal',
										value : me.record.get('discountFinal')
									}, {
										xtype : 'displayfield',
										fieldLabel : '总计（不含运费）',
										name : 'finalPrice',
										value : me.record.get('finalPrice')
									}],
							flex : 2
							// Use 2/3 of Container's height (hint to Box
							// layout)
						}]

				this.callParent(arguments);
			}
		});