Ext.define('app.store.customer.CustomerAddrRecord', {
			extend : 'Ext.data.Store',

			alias : 'store.customeraddrrecord',

			fields : ['addrType', 'address','rowIdInner'],

			proxy : {
				type : 'ajax',
				url : './addrManagement?action=getCustomerAddrByUid&uid='
						+ localStorage.getItem("LoggedInUid"),
				reader : {
					type : 'json',
					rootProperty : 'orders'
				}
			},
			autoLoad : true
		});
