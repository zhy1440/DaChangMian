/**
 * This view is an example list of people.
 */
//var toolbar = 
Ext.define('app.view.feedbacks.OrderFeedbackGridPanel', {
    extend: 'Ext.grid.Panel',
    xtype: 'orderfeedbackgrid',
    ui: 'dark',
    requires: [
        'app.store.feedbacks.OrderFeedbackRecord',
        'app.view.admin.ordermngt.OrderPlaceController'
    ],
    controller : 'orderFeedback',

    //title: '订单列表',
    store: {
        type: 'orderfeedbackrecord'
    },
    selModel: {
        selType: 'checkboxmodel',
        mode: 'MULTI',
        checkOnly: true,
        listeners: {
            selectionchange: 'onSelectionChange'
        }
    },
    plugins: [
            Ext.create('Ext.grid.plugin.CellEditing', {
                clicksToEdit: 1,
                listeners: {
                    edit: 'OnEdit'
                }
            })
        ],
    dockedItems: Ext.create('Ext.toolbar.Toolbar', {
            //renderTo: document.body,
            id: 'feedbacksToolbar',
            width: 500,
            items: [{
                    xtype: 'tbtext',
                    text: '数量合计：<font color = "red">0</font>'
                },
                '-', {
                    xtype: 'tbtext',
                    text: '总价合计：<font color = "red">0</font>'
                },
                '-', {
                    xtype: 'tbtext',
                    text: '下单备注：<font color = "blue">暂无</font>'
                },
                '-', {
                    xtype: 'button',
                    id:'refresh',
                    text: '刷新',
                    handler: function() {
                        Ext.getCmp('orderFeedbackNaviTree').store.reload();
                    }
                },
                // begin using the right-justified button container
                '-', // same as { xtype: 'tbfill' }
                {
                    xtype: 'splitbutton',
                    text: '移动到...',
                    handler: function() {
                        //alert("The button was clicked");
                    },
                    menu: new Ext.menu.Menu({
                        items: [
                            // these will render as dropdown menu items when the arrow is clicked:
                            {
                                text: '待拼',
                                handler: 'onDaiPinClick'
                            }, {
                                text: '可下单',
                                handler: 'onKeXiaDanClick'
                            }, {
                                text: '已成团',
                                handler: 'onYiChengTuanClick'
                            }, {
                                text: '流团',
                                handler: 'onLiuTuanClick'
                            }
                        ]
                    })
                }            ]
        }),
    columns: [{
            text: '订单号',
            dataIndex: 'orderId',
            hidden: true
        }, {
            text: '下单日期',
            dataIndex: 'orderTime',
            hidden: true
        },
        /*        { text: '团号（id）', dataIndex: 'groupId', flex: 1 },*/
        {
            text: '顾客id',
            dataIndex: 'cstId',
            hidden: false
        }, {
            text: '商品名称',
            dataIndex: 'commodityName',
            renderer: function(value, meta, record) {
                meta.style = 'overflow:auto;padding: 3px 6px;text-overflow: ellipsis;white-space: nowrap;white-space:normal;line-height:20px;';
                return value;
            },
            width: 200
        }, {
            text: '链接',
            dataIndex: 'link',
/*            renderer: function(value, meta, record) {
                meta.style = 'overflow:auto;padding: 3px 6px;text-overflow: ellipsis;white-space: nowrap;white-space:normal;line-height:20px;';
                return value;
            },*/
            width: 250
        },
        /*        { text: '商品中文描述', dataIndex: 'commodityDesc', flex: 1 },*/
        {
            text: '单价',
            dataIndex: 'unitPrice',
            width: 80
        }, {
            text: '数量',
            dataIndex: 'amount',
            width: 80
        }, {
            text: '折扣',
            dataIndex: 'discountDesc',
            renderer: function(value, meta, record) {
                meta.style = 'overflow:auto;padding: 3px 6px;text-overflow: ellipsis;white-space: nowrap;white-space:normal;line-height:20px;';
                return value;
            },
            width: 80
        }, {
            text: '总价',
            format: '$0,00',
            dataIndex: 'totalPrice',
            width: 80
        }, {
            text: '折后价',
            format: '$0,00',
            dataIndex: 'finalPrice',
            width: 80,
            editor: {
                xtype: 'numberfield',
                allowBlank: false
            }
        }, {
            text: '颜色',
            dataIndex: 'goodsColor',
            width: 80
        }, {
            text: '尺寸',
            dataIndex: 'goodsSize',
            width: 80
        },
        {
            text: '订单备注',
            dataIndex: 'comments',
            renderer: function(value, meta, record) {
                meta.style = 'overflow:auto;padding: 3px 6px;text-overflow: ellipsis;white-space: nowrap;white-space:normal;line-height:20px;';
                return value;
            },
            width: 150
        }, {
            text: '图片',
            dataIndex: 'picture',
            flex: 1
        }
        //        { text: '国际运费', dataIndex: 'overseasFreigh', flex: 1 },
        //        { text: '国内运费', dataIndex: 'inlandFreigh', flex: 1 }
    ]
});