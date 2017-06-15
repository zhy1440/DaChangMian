/**
 * This view is for customer to place an order.
 */
Ext.define('app.view.feedbacks.OrderFeedbackMasterPanel', {
    extend: 'Ext.Panel',
    xtype: 'orderfeedback',
    requires: ['app.view.feedbacks.OrderFeedbackGridPanel',
        'app.view.feedbacks.OrderFeedbackNaviTreePanel',
        'app.view.feedbacks.OrderFeedbackMasterPanelController'
    ],
    //ui : 'dark',
    controller: 'orderFeedbackMaster',
    height: 750,
    //width : 700,
    //record : {},
    layout: 'border',
    scrollable: true,
    /*          initComponent : function() {
                    var me = this;
                    me.items = [{ // Results grid specified as a config object
                        xtype:'orderfeedbacknavitree'

                    }, {
                        xtype : 'splitter' // A splitter between the two child
                                            // items
                    }, {    
                        xtype: 'orderfeedbackgrid'
                    }];

                    this.callParent(arguments);
                },*/
    items: [{
        xtype: 'container',
        layout: {
            type: 'vbox'
        },
        region: 'west',
        //border: 1,
        default: {
            marginBottom: '10px',
            padding: '10px'
        },
        items: [{
            xtype: 'button',
            text: '新增团号',
            handler: 'onNewGrouIdClick'
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
