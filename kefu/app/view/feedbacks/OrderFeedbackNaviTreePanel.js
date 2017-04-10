/**
 * This view is navitree on orderFeedbacks page.
 */
Ext.define('app.view.feedbacks.OrderFeedbackNaviTreePanel', {
	extend: 'Ext.tree.Panel',
	xtype: 'orderfeedbacknavitree',
	requires: ['app.model.naviTree.OrderFeedbacksNavi'],
	ui: 'dark',
	//id: "myTreePanel",
	store: Ext.create('Ext.data.TreeStore', {
		model: 'app.model.naviTree.OrderFeedbacksNavi',
		root: {
			id: 'naviRoot',
			text: 'root',
			expanded: true,
			children: [{
				id: '0',
				text: '待拼'
			}, {
				id: '1',
				text: '可下单'
			}, {
				id: '2',
				text: '已成团'
			}, {
				id: '3',
				text: '流团'
			}]
		}
	}),
	autoScroll: true,
	containerScorll: true,
	animate: true,
	autoHeight: true,
	width: 300,
	rootVisible: false,
	/*	        listeners : {
		            "itemclick" : {
		                fn : function() {
		                	alert(1);
		                    this.collapseAll();
		                },
		                scope : this
		} 
	}*/
	listeners: {
		//在展开前调用，发送请求，请求中应有节点信息  
		'itemclick': function(record, index) {
			if (index.raw.leaf == true) {
				var me = this;
				//alert(index.raw.id);
				Ext.data.JsonP.request({
					url: 'http://localhost:8080/application/feedbacks',//部署后需要修改
					params: {
						action: 'getOrderList',
						node: index.raw.id
					},
					success: function(Optional) {
						
						me.up('panel').down('grid').store.loadData(Optional);
					}
				});

			}
			//this.proxy.extraParams.root = node.raw.ids;  
		}
	}
});