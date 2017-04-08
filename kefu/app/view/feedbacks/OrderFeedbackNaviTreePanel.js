/**
 * This view is for customer to place an order.
 */
Ext.define('Navi', {
	extend: 'Ext.data.Model',
	fields: [
		'id', {
			name: 'name',
			type: 'string'
		}
	],
	proxy: {
		type: 'jsonp',
		url: 'http://localhost:8080/application/getNaviTree'//部署后需要修改
			/*,
			        api: {
			            create: 'createPersons',
			            read: 'getNaviTree',
			            update: 'updatePersons',
			            destroy: 'destroyPersons'
			        }*/
	}

});

var store = Ext.create('Ext.data.TreeStore', {
	model: 'Navi',
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
});

Ext.define('app.view.feedbacks.OrderFeedbackNaviTreePanel', {
	extend: 'Ext.tree.Panel',
	xtype: 'orderfeedbacknavitree',
	requires: ['app.view.feedbacks.OrderFeedbackGridPanel'],
	ui: 'dark',
	//id: "myTreePanel",
	store: store,
	/*    columns: [{
	        xtype: 'treecolumn', 
	        header: 'Name', 
	        dataIndex: 'name', 
	        flex: 1
	    }],*/
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