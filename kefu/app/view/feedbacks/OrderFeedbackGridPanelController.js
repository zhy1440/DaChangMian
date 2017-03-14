/**
 * This view is an example list of people.
 */
Ext.define('app.view.feedbacks.OrderFeedbackGridPanelController', {
    extend : 'Ext.app.ViewController',
    alias : 'controller.orderFeedback',

    updateOrderType: function(orderIds, orderType) {
        alert(orderIds);
        Ext.data.JsonP.request({
            url: 'http://localhost:8080/application/feedbacks',//部署后需要修改
            method : 'POST',
            contentType: "atext/html; charset=utf-8",
            waitMsg : 'Submitting your data...',
            params: {
                action: 'updateOrderType',
                orderId: orderIds,
                orderType: orderType
            },
            success : function(result) {
                Ext.Msg.show({
                    title : '提交成功',
                    message : result.successMsg,
                    buttons : Ext.Msg.OK,
                    icon : Ext.Msg.QUESTION
                });
            },
            failure : function(form, action) {
                if (action.failureType === Ext.form.action.Action.CONNECT_FAILURE) {
                    Ext.Msg.alert('Error', 'Status:'
                                    + action.response.status + ': '
                                    + action.response.statusText);
                }
                if (action.failureType === Ext.form.action.Action.SERVER_INVALID) {
                    Ext.Msg.alert('Invalid', action.result.errorMsg);
                }
            }
        });
    },
    onDaiPinClick: function() {
        var me = this,
            selected = me.getView().getSelection();
            selected.forEach(function  (element,index, array) {
                // body...
                me.updateOrderType(element.data.orderId,0);
            })
    },
    onKeXiaDanClick: function() {
        var me = this,
            selected = me.getView().getSelection();
            selected.forEach(function  (element,index, array) {
                // body...
                me.updateOrderType(element.data.orderId, 1);
            })
    },
    onYiChengTuanClick: function() {
        var me = this,
            selected = me.getView().getSelection();
            selected.forEach(function  (element,index, array) {
                // body...
                me.updateOrderType(element.data.orderId, 2);
            })
    },
    onLiuTuanClick: function() {
        var me = this,
            selected = me.getView().getSelection();
            selected.forEach(function  (element,index, array) {
                // body...
                me.updateOrderType(element.data.orderId, 3);
            })
    },

    onSelectionChange: function(me, selected) {
                var sumTotalPrice = 0,
                    sumAmount = 0;
                selected.forEach(function(element, index, array) {
                    sumTotalPrice += eval(element.data.totalPrice);
                    sumAmount += eval(element.data.amount);
                });
                this.getView().dockedItems.items[1].items.items[0].setText('数量合计：<font color = "red">' + sumAmount + '</font>');
                this.getView().dockedItems.items[1].items.items[2].setText('总价合计：<font color = "red">' + sumTotalPrice + '</font>');
                //alert(sum);
    }
});