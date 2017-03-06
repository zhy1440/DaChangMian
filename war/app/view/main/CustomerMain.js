/**
 * This class is the main view for the application. It is specified in app.js as
 * the "mainView" property. That setting automatically applies the "viewport"
 * plugin causing this view to become the body element (i.e., the viewport).
 * 
 * TODO - Replace this content of this view to suite the needs of your
 * application.
 */
Ext.define('app.view.main.CustomerMain', {
			extend : 'Ext.tab.Panel',
			xtype : 'app-customermain',

			requires : ['Ext.plugin.Viewport', 'Ext.window.MessageBox',
					'app.view.main.CustomerMainController',
					'app.view.main.MainModel', 'app.view.main.List',
					'app.view.customer.OrderManagement',
					'app.view.customer.CustomerInfo'],

			controller : 'customermain',
			viewModel : 'main',
			plugins : 'viewport',

			ui : 'navigation',

			tabBarHeaderPosition : 1,
			titleRotation : 0,
			tabRotation : 0,
			id : 'customermain',

			header : {
				layout : {
					align : 'stretchmax'
				},
				title : {
					bind : {
						text : '{name}'
					},
					flex : 0
				},
				iconCls : 'fa-th-list',
				items : [{
							xtype : 'label',
							text : "您好，"
									+ localStorage.getItem("LoggedInUserName"),
							margin : '10 0'
						}]
			},

			tabBar : {
				flex : 1,
				layout : {
					align : 'stretch',
					overflowHandler : 'none'
				}
			},

			responsiveConfig : {
				tall : {
					headerPosition : 'top'
				},
				wide : {
					headerPosition : 'left'
				}
			},

			defaults : {
				bodyPadding : 20,
				tabConfig : {
					plugins : 'responsive',
					responsiveConfig : {
						wide : {
							iconAlign : 'left',
							textAlign : 'left'
						},
						tall : {
							iconAlign : 'top',
							textAlign : 'center',
							width : 120
						}
					}
				},
				autoScroll : true
			},

			items : [
					/*
					 * { iconCls : 'fa-home', bind : { title :
					 * '{menu.order_input}' }, // The following grid shares a
					 * store with the classic version's grid as // well! items : [ {
					 * xtype : 'mainlist' } ] },
					 */
					{
				iconCls : 'fa-cog',
				bind : {
					// html : '{loremIpsum}',
					title : '{cstMenu.cst_order_management}'
				},
				items : [{
							id : 'myOder',
							xtype : 'ordermanagement'
						}]
			}, {
				iconCls : 'fa-cog',
				bind : {
					// html: '{loremIpsum}',
					title : '{cstMenu.cst_order_place}'

				},
				items : [{
							xtype : 'orderplace'
						}]
			}],
			listeners : {
				activate : function() {
					this.getUpdater().refresh();
					// Ext.getCmp('image').up('panel').update();

				}
			}
		});
