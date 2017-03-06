/**
 * This view is for customer to place an order.
 */
Ext.define('app.view.feedbacks.OrderFeedbackMain', {
			extend : 'Ext.Panel',
			xtype : 'orderfeedback',
			requires : [ 'app.view.feedbacks.OrderFeedbackGridPanel','app.view.feedbacks.OrderFeedbackNaviTreePanel' ],
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
			    //title: 'Navigation',
			    region:'west',
			    id: 'orderFeedbackNaviTree',
			    xtype:'orderfeedbacknavitree',
			    margins: '5 0 0 0',
			    cmargins: '5 5 0 0',
			    width: 250,
			    minSize: 100,
			    maxSize: 250
			},{
			    //title: 'Main Content',
			    //collapsible: false,
			    xtype: 'orderfeedbackgrid',
		        region:'center',
		        margins: '5 0 0 0'
		    }]
		});

