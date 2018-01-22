/**
 * This view is for customer to place an order.
 */
var redStar = '<font color = "red">*</font>';
Ext.define('app.view.order.place.OrderPlace', {
			extend : 'Ext.form.FormPanel',
			xtype : 'orderplace',
			requires : ['app.view.order.place.OrderPlaceController'],
			controller : 'orderPlace',

			// The form will submit an AJAX request to this URL when
			// submitted
			// url: './orderPlace',

			ui : 'dark',
			aligh: 'center',
			defaultType : 'textfield',
			buttonAlign : 'center',
			frame : true,
			width : 400,
			defaults : {
				labelAlign : 'right',
				labelWidth : 70,
				width : 400
			},
			items : [{
						xtype : 'hiddenfield',
						name : 'dcmId',
						value : localStorage.getItem("LoggedInUid")
					}, {
						xtype : 'hiddenfield',
						name : 'picUrl',
						id : 'picUrl'
					}, {
						name : 'cstId',
						fieldLabel : 'ID' + redStar,
						allowBlank : false
					}, {
						name : 'link',
						fieldLabel : '网站链接' + redStar,
						allowBlank : false
					}, {
						name : 'commodityName',
						fieldLabel : '商品名称' + redStar,
						allowBlank : false
					}, {
						name : 'unitPrice',
						fieldLabel : '单价' + redStar,
						allowBlank : false
					}, {
						name : 'amount',
						fieldLabel : '数量' + redStar,
						allowBlank : false
					}, {
						xtype : 'form',
						layout : 'column',
						frame : false,
						buttonAlign : 'center',
						width : 400,
						defaults : {
							labelAlign : 'right',
							labelWidth : 70,
							width : 350
						},
						items : [{
									xtype : 'textfield',
									name : 'goodsColor',
									id : 'goodsColor',
									fieldLabel : '颜色' + redStar,
									allowBlank : false,
									buttonText : '无'
								}, {
									xtype : 'button',
									text : '无',
									value: 'goodsColor',
									handler : 'onNullClick',
									width : 40
								}]
					}, {
						xtype : 'form',
						layout : 'column',
						frame : false,
						buttonAlign : 'center',
						width : 400,
						defaults : {
							labelAlign : 'right',
							labelWidth : 70,
							width : 350
						},
						items : [{
									xtype : 'textfield',
									name : 'goodsSize',
									id : 'goodsSize',
									fieldLabel : '尺寸' + redStar,
									allowBlank : false
								}, {
									xtype : 'button',
									text : '无',
									value: 'goodsSize',
									handler : 'onNullClick',
									width : 40
								}]
					}, {
						name : 'discountDesc',
						fieldLabel : '折扣' + redStar,
						allowBlank : false
					}, {
						name : 'comments',
						fieldLabel : '备注'
					}, {
						xtype : 'button',
						text : '上传图片',
						handler : 'onImgUploadClick',
						width : 70,
						height : 50
					}, {
						xtype : 'image',
						name : 'image',
						id : 'image',
						margin : '0 0 0 5',
						width : 250,
						maxWidth : 250,
						maxHeight : 500
					}
			],

			buttons : [{
						id : 'okOrder',
						text : '确认下单',
						formBind : true, 
						handler : 'onOkClick'
					}, {
						id : 'reset',
						text : '重置',
						handler : 'onResetClick'
					}]
		});
