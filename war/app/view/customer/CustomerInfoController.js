/**
 * This class is the controller for the main view for the application. It is
 * specified as the "controller" of the Main view class.
 * 
 * TODO - Replace this content of this view to suite the needs of your
 * application.
 */
Ext.define('app.view.customer.CustomerInfoController', {
	extend : 'Ext.app.ViewController',

	alias : 'controller.customerInfo',

	onAddAddrClick : function() {
		// 添加收货地址
		var me = this;
		var win = Ext.create('Ext.window.Window', {
			title : '添加收货地址',
			width : 500,
			height : 162,
			layout : 'fit',
			items : {
				xtype : 'form',
				width : 500,
				bodyPadding : 10,
				items : [{
							xtype : 'textfield',
							name : 'addrType',
							fieldLabel : '地址类型',
							labelWidth : 100,
							msgTarget : 'side',
							allowBlank : false,
							anchor : '100%'
						}, {
							xtype : 'textfield',
							name : 'address',
							fieldLabel : '收货地址',
							labelWidth : 100,
							msgTarget : 'side',
							allowBlank : false,
							anchor : '100%'
						}],

				buttons : [{
					text : '添加',
					handler : function() {
						// submit新增地址
						var form = this.up('form').getForm();
						var panel = this.up('panel');
						var param = form.getFieldValues();
						if (form.isValid()) {
							form.submit({
								url : './addrManagement?action=insertCustomerAddrByUid&uid='
										+ localStorage.getItem("LoggedInUid"),
								method : 'POST',
								waitMsg : '正在上传收货地址。。。',
								// panel : panel,
								params : param,
								success : function(fp, o) {
									Ext.Msg.alert('Success',
											o.result.successMsg);

									panel.up('window').destroy();

									// 刷新地址列表
									//onRefreshClick();
								}
							});
						}

					}
				}]
			}
		}).show();
		// Ext.promise.Promise(win.show()).then(alert(1));
	},
	onRefreshClick : function() {
		var grid = this.getView().down('grid');
		grid.store.reload();
	}

});
