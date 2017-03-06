/**
 * This view is an example list of people.
 */
Ext.define('app.view.admin.user.CustomerInfoList', {
    extend: 'Ext.grid.Panel',
    xtype: 'customerinfolist',
    ui: 'dark',
    requires: [
        'app.store.user.CustomerInfo'
    ],

    title: '客户资料',

    store: {
        type: 'customerinfo'
    },

    columns: [
        { text: '顾客id', dataIndex: 'userId', flex: 1 },
        { text: '会员等级', dataIndex: 'memberLevel', flex: 1 },
        { text: '现行利率', dataIndex: 'exchangRate', flex: 1 },
        { text: '常用地址', dataIndex: 'commonAddr', flex: 1 }
    ],
    listeners: {
//        select: 'onItemSelected'
    }
});
