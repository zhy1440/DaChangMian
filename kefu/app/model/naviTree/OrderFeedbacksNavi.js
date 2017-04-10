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