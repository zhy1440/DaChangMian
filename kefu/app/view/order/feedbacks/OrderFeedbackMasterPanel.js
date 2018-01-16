/**
 * This view is for customer to place an order.
 */
Ext.define('app.view.order.feedbacks.OrderFeedbackMasterPanel', {
    extend: 'Ext.Panel',
    xtype: 'orderfeedback',
    requires: ['app.view.order.feedbacks.OrderFeedbackGridPanel',
        'app.view.order.feedbacks.OrderFeedbackNaviTreePanel',
        'app.view.order.feedbacks.OrderFeedbackMasterPanelController'
    ],
    controller: 'orderFeedbackMaster',
    height: 750,
    layout: 'border',
    scrollable: true,
    items: [{
        xtype: 'container',
        layout: {
            type: 'vbox'
        },
        region: 'west',
        border: 1,
        default: {
            marginBottom: '10px',
            padding: '10px'
        },
        items: [{
            xtype: 'button',
            text: '新增团号',
            handler: 'onCreateGrouIdClick'
        }, {
            id: 'orderFeedbackNaviTree',
            xtype: 'orderfeedbacknavitree',
            margins: '5 0 0 0',
            cmargins: '5 5 0 0',
            width: 250,
            minSize: 100,
            maxSize: 250
        }]
    }, {
        xtype: 'orderfeedbackgrid',
        region: 'center',
        margins: '5 0 0 0'
    }]
});
