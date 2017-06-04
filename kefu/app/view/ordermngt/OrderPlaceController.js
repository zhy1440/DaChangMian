/**
 * This class is the controller for the main view for the application. It is
 * specified as the "controller" of the Main view class.
 * 
 * TODO - Replace this content of this view to suite the needs of your
 * application.
 */
Ext.define('app.view.ordermngt.OrderPlaceController', {
	extend : 'Ext.app.ViewController',

	alias : 'controller.orderPlace',

	onOkOrderClick : function(sender, record) {
		Ext.Msg.confirm('下单确认', '是否确认下单?', 'onConfirm', this);
	},
	onResetClick : function(sender, record) {
		this.getView().getForm().reset();
		Ext.getCmp('image').setSrc('');
		Ext.getCmp('picUrl').setValue('');
		
	},
	OkRenewClick : function(sender, record) {
		Ext.Msg.confirm('下单确认', '是否确认下单?', 'onConfirm', this);
	},

	onConfirm : function(choice) {
		var me = this;
		if (choice === 'yes') {
			var form = this.getView().getForm();
			var param = form.getFieldValues();

			if (form.isValid()) {
				form.submit({
					url : './orderPlaceKefu',
					method : 'POST',
					waitMsg : 'Submitting your data...',
					params : param,
					success : function(form, action) {
						// server responded with
						// success = true
						var result = action.result.successMsg;
						var myMsg = Ext.create('Ext.window.MessageBox', {
						    closeAction: 'destroy',
						    buttons: [ { 
						  		id: 'yes', 
						  		text: '前往我的订单',
						  		handler: function(){
						  		console.log('go to my orders');
											Ext.getCmp('kefuMain')
													.setActiveTab(1);
											//Ext.getCmp('orderFeedbackNaviTree')//.store.reload();
									  		myMsg.destroy();
						  	}
						  }, { 
						  		id: 'no', 
						  		text: '继续下单',
							  	handler:function(){
							  		//Ext.getCmp('orderFeedback').store.reload();
							  		form.reset();
							  		Ext.getCmp('image').setSrc('');
									Ext.getCmp('picUrl').setValue('');
							  		myMsg.destroy();
							  	}
							  }
						]
						}).show({
									title : '提交成功',
									message : result,
									icon : Ext.Msg.QUESTION
						});
/*						Ext.Msg.show({
									title : '提交成功',
									message : result,
									buttons : Ext.Msg.YESNO,
									icon : Ext.Msg.QUESTION,
									fn : function(btn) {
										if (btn === 'yes') {
											console.log('go to my orders');
											Ext.getCmp('customermain')
													.setActiveTab(0);
											Ext.getCmp('orderFeedback').store.reload();
											// window.location='./index.jsp';
										} else if (btn === 'no') {
											console.log('No pressed');
										}
									}
								});*/
					},
					failure : function(form, action) {
						if (action.failureType === Ext.form.action.Action.CONNECT_FAILURE) {
							Ext.Msg.alert('Error', 'Status:'
											+ action.response.status + ': '
											+ action.response.statusText);
						}
						if (action.failureType === Ext.form.action.Action.SERVER_INVALID) {
							// server responded with
							// success = false
							Ext.Msg.alert('Invalid', action.result.errorMsg);
						}
					}
				});
			}
		}
	},
	onNullClick : function(btn) {
		Ext.getCmp(btn.value).setValue('无');
	},
	onImgDispClick : function() {
		var form = this.getView().getForm();
		var imgUrl = form.findField('picture').value;
		// var strPhoto = form.findField('photo').value;
		// if(!strPhoto){
		Ext.getCmp('image').setSrc(imgUrl);
		// }
		Ext.getCmp('kefuMain').setActiveTab(1);
		// alert('You clicked the button!');
	},
	onImgUploadClick : function() {
		Ext.create('Ext.window.Window', {
			title : '上传图片',
			width : 500,
			height : 162,
			layout : 'fit',
			items : {
				xtype : 'tabpanel',
				width : 500,
				// height : 162,
				enableTabScroll : true,
				activeTab : 0,
				items : [{
					title : "本地图片",
					items : [{
						xtype : 'form',
						// width : 480,
						bodyPadding : 10,
						// frame : true,
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
										// params : {"abc":"heihei"},
										success : function(fp, o) {
											console.log('Success! fileName: ', o.result.fileName);
											Ext.getCmp('image').setSrc(o.result.fileName);
											Ext.getCmp('picUrl').setValue(o.result.fileName);
											// }
											Ext.getCmp('kefuMain').setActiveTab(0);
											// alert('You clicked the
											// button!');
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
									// var strPhoto =
									// form.findField('photo').value;
									// if(!strPhoto){
									Ext.getCmp('image').setSrc(imgUrl);
									Ext.getCmp('picUrl').setValue(imgUrl);
									// }
									Ext.getCmp('kefuMain').setActiveTab(0);
									// alert('You clicked the button!');
									panel.up('window').destroy();
								}
							}]
				}]
			}

		}).show();

	}

});
