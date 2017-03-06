Ext.define('app.store.order.OrderRecord', {
    extend: 'Ext.data.Store',

    alias: 'store.orderrecord',

    fields: [
             'orderId','orderDate','groupId','cstId','link','commodityName','commodityDesc',
             'unitPrice','amount','goodsColor','goodsSize','discount1','discount2','totalPrice',
             'comments','picture','overseasFreigh','inlandFreigh'
    ],

    proxy: {
        type: 'ajax',
        url: './OrderOperation?action=queryOrderRecord',
        reader: {
            type: 'json',
            rootProperty: 'orders'
        }
    },
    autoLoad: true
});
