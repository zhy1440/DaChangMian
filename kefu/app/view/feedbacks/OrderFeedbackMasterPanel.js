/**
 * This view is for customer to place an order.
 */
Ext.define('app.view.feedbacks.OrderFeedbackMasterPanel', {
			extend : 'Ext.Panel',
			xtype : 'orderfeedback',
			requires : [ 'app.view.feedbacks.OrderFeedbackGridPanel', 'app.view.feedbacks.OrderFeedbackNaviTreePanel' ],
			//ui : 'dark',
			height : 750,
			//width : 700,
			//record : {},
			layout:'border',
			scrollable :true,
/*			initComponent : function() {
				var me = this;
				me.items = [{ // Results grid specified as a config object
					xtype:'orderfeedbacknavitree'

				}, {
					xtype : 'splitter' // A splitter between the two child
										// items
				}, {	
					xtype: 'orderfeedbackgrid'
				}];

				this.callParent(arguments);
			},*/
			items: [{
				layout: {
				    type: 'vbox'
				},
				width: 400,
				border: 1,
				style: {borderColor:'#000000', borderStyle:'solid', borderWidth:'1px'},
				defaults: {
				    labelWidth: 80,
				    // implicitly create Container by specifying xtype
				    xtype: 'datefield',
				    flex: 1,
				    style: {
				        padding: '10px'
				    }
				},
				items: [{
				    region:'west',
				    id: 'orderFeedbackNaviTree',
				    xtype:'orderfeedbacknavitree',
				    margins: '5 0 0 0',
				    cmargins: '5 5 0 0',
				    width: 250,
				    minSize: 100,
				    maxSize: 250
				},{
				    xtype: 'orderfeedbackgrid',
			        region:'center',
			        margins: '5 0 0 0'
			    }]
			}]
		});

