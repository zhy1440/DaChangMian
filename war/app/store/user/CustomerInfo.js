Ext.define('app.store.user.CustomerInfo', {
    extend: 'Ext.data.Store',

    alias: 'store.customerinfo',

    fields: [
             'userId','memberLevel','exchangRate','commonAddr'
    ],

    proxy: {
        type: 'ajax',
        url: './CustomerManagement?action=queryCustomerInfo',
        reader: {
            type: 'json',
            rootProperty: 'customers'
        }
    },
    autoLoad: true
});
