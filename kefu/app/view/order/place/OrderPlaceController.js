/**
 * This class is the controller for the main view for the application. It is
 * specified as the "controller" of the Main view class.
 * 
 * TODO - Replace this content of this view to suite the needs of your
 * application.
 */
Ext.define('app.view.order.place.OrderPlaceController', {
	extend : 'Ext.app.ViewController',

	alias : 'controller.orderPlace',

	onNullClick : function(btn) {
		Ext.getCmp(btn.value).setValue('无');
	},

	onImgUploadClick : function() {
		this.imageUploadHandler();
	},

	onOkClick : function(sender, record) {
		Ext.Msg.confirm('下单确认', '是否确认下单?', 'onConfirm', this);
	},

	onResetClick : function(sender, record) {
		this.getView().getForm().reset();
		Ext.getCmp('image').setSrc('');
		Ext.getCmp('picUrl').setValue('');
		
	},

	onConfirm : function(choice) {
		var me = this;
		if (choice === 'yes') {
			var form = this.getView().getForm();
			var param = form.getFieldValues();
			param.unitPrice = param.unitPrice.trim().replace(/\,|\$/g, "");

			if (form.isValid()) {
				form.submit({
					url : './orderPlace',
					method : 'POST',
					waitMsg : '正在提交订单信息...',
					params : param,
					success : function(form, action) {
						// server responded with success = true
						var result = action.result.successMsg;
						var myMsg = Ext.create('Ext.window.MessageBox', {
					    	closeAction: 'destroy',
						    buttons: [{ 
						  		id: 'yes', 
						  		text: '前往我的订单',
						  		handler: function() {
							  		console.log('go to my orders');
									Ext.getCmp('kefuMain').setActiveTab(1);
									//Ext.getCmp('orderFeedbackNaviTree')//.store.reload();
							  		myMsg.destroy();
						  		}
						  	}, { 
						  		id: 'no', 
						  		text: '继续下单',
							  	handler:function() {
							  		//Ext.getCmp('orderFeedback').store.reload();
							  		form.reset();
							  		Ext.getCmp('image').setSrc('');
									Ext.getCmp('picUrl').setValue('');
							  		myMsg.destroy();
							  	}
							}]
						}).show({
							title : '提交成功',
							message : result,
							icon : Ext.Msg.QUESTION
						});
					},
					failure : function(form, action) {
						if (action.failureType === Ext.form.action.Action.CONNECT_FAILURE) {
							Ext.Msg.alert('Error', 'Status:'
											+ action.response.status + ': '
											+ action.response.statusText);
						}
						if (action.failureType === Ext.form.action.Action.SERVER_INVALID) {
							// server responded with success = false
							Ext.Msg.alert('Invalid', action.result.errorMsg);
						}
					}
				});
			}
		}
	},
	
	imageUploadHandler : function() {
		Ext.create('Ext.window.Window', {
			title : '上传图片',
			width : 500,
			height : 162,
			layout : 'fit',
			items : {
				xtype : 'tabpanel',
				width : 500,
				enableTabScroll : true,
				activeTab : 0,
				items : [{
					title : "本地图片",
					items : [{
						xtype : 'form',
						bodyPadding : 10,
						items : [{
									xtype : 'filefield',
									name : 'photo',
									fieldLabel : '本地图片',
									labelWidth : 100,
									msgTarget : 'side',
									allowBlank : false,
									anchor : '100%',
									buttonText : '选择图片'
								}],

						buttons : [{
							text : '确定',
							handler : function() {
								var form = this.up('form').getForm();
								var panel = this.up('panel');
								var param = form.getFieldValues();
								if (form.isValid()) {
									form.submit({
										url : './ImageUpload',
										method : 'POST',
										waitMsg : '正在上传图片。。。',
										panel : panel,
										success : function(fp, o) {
											console.log('Success! fileName: ', o.result.fileName);
											Ext.getCmp('image').setSrc(o.result.fileName);
											Ext.getCmp('picUrl').setValue(o.result.fileName);
											panel.up('window').destroy();
										}
									});
								}
							}
						}]
					}]
				}, {
					title : "网络图片",
					bodyPadding : 10,
					items : [{
								xtype : 'textfield',
								labelWidth : 100,
								name : 'picture',
								id : 'pic',
								width : '100%',
								fieldLabel : '网络图片',
								allowBlank : false
							}],
					buttons : [{
								text : '确定',
								handler : function() {
									var panel = this.up('panel');
									var imgUrl = panel.getChildByElement('pic').value;
									Ext.getCmp('image').setSrc(imgUrl);
									Ext.getCmp('picUrl').setValue(imgUrl);
									Ext.getCmp('kefuMain').setActiveTab(0);
									panel.up('window').destroy();
								}
							}]
				}]
			}

		}).show();

	}

});
