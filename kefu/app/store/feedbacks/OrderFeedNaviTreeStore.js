Ext.define('app.store.feedbacks.OrderFeedNaviTreeStore', {
	extend: 'Ext.data.TreeStore',

	alias: 'store.orderfeedbackNavi',
	autoLoad: true,
	proxy: {
		type: 'ajax',
		url: 'getNaviTree', //请求  
		reader: {
			type: 'json',
			root: 'menus' //数据  
		},
		extraParams: {
			root: '' //节点参数  
		}

	},
	root: {
		text: '文章预览',
		expanded: true
	},
	listeners: {
		//在展开前调用，发送请求，请求中应有节点信息  
		'beforeexpand': function(node, eOpts) {
			//alert(node.raw.ids);  
			this.proxy.extraParams.root = node.raw.ids;
		}
	}
	/*	root: {
			id: 0,
			expanded: true,
			children: [{
				text: '待拼'
			}, {
				text: '可下单'
			}, {
				text: '已成团'
			}, {
				text: '流团'
			}]
		}*/
	/*
	proxy: {
			type: 'ajax',
			url: './OrderOperation?action=queryOrderRecordbyUid&uid=' + localStorage.getItem("LoggedInUid"),
			reader: {
				type: 'json',
				rootProperty: 'orders'
			}
		}, */

});