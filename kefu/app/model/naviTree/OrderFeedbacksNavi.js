Ext.define('app.model.naviTree.OrderFeedbacksNavi', {
	extend: 'Ext.data.Model',
	alias : 'model.orderFeedbacksNavi',
	fields: [
		'id', {
			name: 'name',
			type: 'string'
		}
	],
	proxy: {
		type: 'ajax',
		url: './getNaviTree'
	}

});