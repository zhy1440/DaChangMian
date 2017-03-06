/**
 * This view is for customer to place an order.
 */
var redStar = '<font color = "red">*</font>';
Ext.define('app.view.customer.OrderPlace', {
			extend : 'Ext.form.FormPanel',
			xtype : 'orderplace',
			requires : ['app.view.customer.OrderPlaceController'],
			controller : 'orderPlace',

			// The form will submit an AJAX request to this URL when
			// submitted
			// url: './OrderOperation?action=placeOrderRecord',

			ui : 'dark',
			//title : '<a name="orderPlace"></a>',
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
						fieldLabel : '折扣'
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
						// height: 500,
						// src
						// :'https://gdp.alicdn.com/imgextra/i4/2456386471/TB2PKCToFXXXXaKXpXXXXXXXXXX_!!2456386471.jpg',
						maxWidth : 250,
						maxHeight : 500
					}
			/*
			 * , { name : 'picture', fieldLabel : '网络图片', allowBlank : false }, {
			 * xtype: 'filefield', name: 'photo', fieldLabel: '本地图片',
			 * //labelWidth: 0, msgTarget: 'side', buttonText: '选择图片' }, { xtype :
			 * 'image', name : 'image', id : 'image', // src :
			 * 'http://www.sencha.com/img/20110215-feat-html5.png', width : 184,
			 * height : 90 }, { xtype : 'button', text : '显示图片', handler :
			 * 'onImgDispClick' }
			 */
			],

			buttons : [{
						id : 'okOrder',
						text : '确认下单',
						formBind : true, // only enabled once the form is
						// valid
						handler : 'onOkOrderClick'
					}, {
						id : 'reset',
						text : '重置',
						handler : 'onResetClick'
					}]
		});
