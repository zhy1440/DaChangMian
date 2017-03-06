Ext.define('app.store.order.CustomerOrderRecord', {
			extend : 'Ext.data.Store',

			alias : 'store.customerorderrecord',

			fields : ['orderId', 'orderTime', 'orderStatus', 'groupId',
					'cstId', 'link', 'commodityName', 'commodityDesc',
					'unitPrice', 'amount', 'goodsColor', 'goodsSize',
					'discountDesc', 'discountFinal', 'totalPrice', 'finalPrice',
					'comments', 'picture', 'overseasFreigh', 'inlandFreigh'],

			proxy : {
				type : 'ajax',
				url : './OrderOperation?action=queryOrderRecordbyUid&uid='
						+ localStorage.getItem("LoggedInUid"),
				reader : {
					type : 'json',
					rootProperty : 'orders'
				}
			},
			autoLoad : true
		});
