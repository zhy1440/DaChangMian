/**
 * This view is an example list of people.
 */
var toolbar = Ext.create('Ext.toolbar.Toolbar', {
    //renderTo: document.body,
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
        // begin using the right-justified button container
        '->', // same as { xtype: 'tbfill' }
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
                        text: '可下单',
                        handler: function() {
                            alert(selected);
                        }
                    }, {
                        text: '流团',
                        handler: function() {
                            alert("流团clicked");
                        }
                    }
                ]
            })
        }
        /*, {
                    xtype: 'textfield',
                    name: 'field1',
                    emptyText: 'enter search term'
                },
                // add a vertical separator bar between toolbar items
                '-', // same as {xtype: 'tbseparator'} to create Ext.toolbar.Separator
                'text 1', // same as {xtype: 'tbtext', text: 'text1'} to create Ext.toolbar.TextItem
                {
                    xtype: 'tbspacer'
                }, // same as ' ' to create Ext.toolbar.Spacer
                'text 2', {
                    xtype: 'tbspacer',
                    width: 50
                }, // add a 50px space
                'text 3'*/
    ]
});
Ext.define('app.view.feedbacks.OrderFeedbackGridPanel', {
    extend: 'Ext.grid.Panel',
    xtype: 'orderfeedbackgrid',
    ui: 'dark',
    requires: [
        'app.store.feedbacks.OrderFeedbackRecord'
    ],

    //title: '订单列表',
    store: {
        type: 'orderfeedbackrecord'
    },
    selModel: {
        selType: 'checkboxmodel',
        mode: 'MULTI',
        checkOnly: true,
        listeners: {
            selectionchange: function(me, selected) {
                var sumTotalPrice = 0,
                    sumAmount = 0;
                selected.forEach(function(element, index, array) {
                    sumTotalPrice += eval(element.data.totalPrice);
                    sumAmount += eval(element.data.amount);
                });
                toolbar.items.items[0].setText('数量合计：<font color = "red">' + sumAmount + '</font>');
                toolbar.items.items[2].setText('总价合计：<font color = "red">' + sumTotalPrice + '</font>');
                //alert(sum);
            }

        }
    },
    dockedItems: toolbar,
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
            hidden: true
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
            dataIndex: 'totalPrice',
            width: 80
        }, {
            text: '折后价',
            dataIndex: 'finalPrice',
            width: 80
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