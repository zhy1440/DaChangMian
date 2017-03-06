Ext.define('app.store.feedbacks.OrderFeedbackRecord', {
			extend : 'Ext.data.Store',

			alias : 'store.orderfeedbackrecord',

			fields : ['orderId', 'orderTime', 'orderStatus', 'groupId',
					'cstId', 'link', 'commodityName', 'commodityDesc',
					'unitPrice', 'amount', 'totalPrice', 'goodsColor', 'goodsSize',
					'discountDesc', 'discountFinal', 'totalPrice', 'finalPrice',
					'comments', 'picture', 'overseasFreigh', 'inlandFreigh']/*,

			proxy : {
				type : 'jsonp',
				url : './feedbacks?action=getOrderList',
				reader : {
					type : 'json',
					rootProperty : 'orders'
				}
			},*/
			//autoLoad : true
		});
