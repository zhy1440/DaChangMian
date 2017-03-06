/**
 * This class is the controller for the main view for the application. It is
 * specified as the "controller" of the Main view class.
 * 
 * TODO - Replace this content of this view to suite the needs of your
 * application.
 */
Ext.define('app.view.customer.OrderManagementController', {
			extend : 'Ext.app.ViewController',
			requires : ['app.view.customer.OrderPlace','app.view.customer.OrderDetail'],
			alias : 'controller.orderManagement',

			onDetailClick : function(grid, rowIndex, colIndex) {
				var rec = grid.getStore().getAt(rowIndex);

				var config = {
					customTest : 'ckk',
					customTest111111 : 'aaaaa'
				};
				//alert();
/*				Ext.Window({  
			        title: '测试',  
			        height: 300,  
			        draggable: false,  
			        width: 300,  
			        items: {  
			            xtype: 'orderdetail',  
							title : '订单详情',
							width : 600,
							height : 700,
							layout : 'fit',
							record: rec,
							config : config 
			        }
				}).show();*/
				Ext.create('Ext.window.Window', {
					title : '订单详情', 
					width : 750,
					height : 700,
				    layout: 'fit',
				    items: {  // Let's put an empty grid in just to illustrate fit layout
 							xtype: 'orderdetail', 
							//layout : 'fit',
							record: rec,
							config : config 
				    }
				}).show();
				// Ext.getCmp('myOrder').record = rec;
				//detail.show();
				// alert("订单详情" + rec.get('orderStatus'));
			}

		});
