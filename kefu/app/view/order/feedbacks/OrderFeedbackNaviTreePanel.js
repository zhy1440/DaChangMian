/**
 * This view is navitree on orderFeedbacks page.
 */
Ext.define('app.view.order.feedbacks.OrderFeedbackNaviTreePanel', {
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
	listeners: {
		//在展开前调用，发送请求，请求中应有节点信息  
		'itemclick': function(record, index) {
			if (index.raw.leaf == true) {
				var me = this;
				Ext.Ajax.request({
					url: './feedbacks',
					params: {
						action: 'getOrderList',
						node: index.raw.id
					},
					success: function(response) {
						var obj = Ext.decode(response.responseText),
							myGrid = me.up('panel').down('grid');
						myGrid.store.loadData(obj);
						if (index.raw.id == "0#unknown") {
							myGrid.store.sort([
							    { property: 'link',  direction: 'ASC' },
							    { property: 'orderId',  direction: 'DESC' }
							]);
						} else {
							myGrid.store.sort([
							    { property: 'orderId',  direction: 'DESC' }
							]);
						}
					}
				});

			}
			//this.proxy.extraParams.root = node.raw.ids;  
		}
	}
});