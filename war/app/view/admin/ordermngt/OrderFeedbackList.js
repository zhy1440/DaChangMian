/**
 * This view is an example list of people.
 */
Ext.define('app.view.admin.ordermngt.OrderFeedbackList', {
    extend: 'Ext.grid.Panel',
    xtype: 'orderfeedbacklist',
    ui: 'dark',
    requires: [
        'app.store.order.OrderRecord'
    ],

    title: '订单列表',

    store: {
        type: 'orderrecord'
    },

    columns: [
        { text: '订单号',  dataIndex: 'orderId' },
        { text: '下单日期', dataIndex: 'orderDate', flex: 1 },
        { text: '团号（id）', dataIndex: 'groupId', flex: 1 },
        { text: '顾客id', dataIndex: 'cstId', flex: 1 },
        { text: '链接', dataIndex: 'link', flex: 1 },
        { text: '商品英文名称', dataIndex: 'commodityName', flex: 1 },
        { text: '商品中文描述', dataIndex: 'commodityDesc', flex: 1 },
        { text: '单价', dataIndex: 'unitPrice', flex: 1 },
        { text: '数量', dataIndex: 'amount', flex: 1 },
        { text: '总价', dataIndex: 'totalPrice', flex: 1 },
        { text: '颜色', dataIndex: 'goodsColor', flex: 1 },
        { text: '尺寸', dataIndex: 'goodsSize', flex: 1 },
        { text: '折扣', dataIndex: 'discount1', flex: 1 },
//        { text: 'discount2', dataIndex: 'discount2', flex: 1 },
//        { text: 'totalPrice', dataIndex: 'totalPrice', flex: 1 },
        { text: '备注', dataIndex: 'comments', flex: 1 },
        { text: '图片', dataIndex: 'picture', flex: 1 }
//        { text: '国际运费', dataIndex: 'overseasFreigh', flex: 1 },
//        { text: '国内运费', dataIndex: 'inlandFreigh', flex: 1 }
    ],
    listeners: {
        select: 'onItemSelected'
    }
});
