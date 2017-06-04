Ext.define('app.store.feedbacks.OrderFeedbackRecord', {
			extend : 'Ext.data.Store',

			alias : 'store.orderfeedbackrecord',

			fields : ['orderId', 'orderTime', 'orderStatus', 'groupId',
					'cstId', 'link', 'commodityName', 'commodityDesc',
					'unitPrice', 'amount', 'totalPrice', 'goodsColor', 'goodsSize',
					'discountDesc', 'discountFinal', 'finalPrice',
					'comments', 'picture', 'overseasFreigh', 'inlandFreigh']
});
