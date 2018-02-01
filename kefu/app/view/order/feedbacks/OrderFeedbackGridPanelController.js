/**
 * This view is an example list of people.
 */
Ext.define('app.view.order.feedbacks.OrderFeedbackGridPanelController', {
    extend : 'Ext.app.ViewController',
    alias : 'controller.orderFeedback',

    onEdit: function(me, e){
        var finalPrice = e.value,
            orderId = e.record.getData().orderId;

        //alert(finalPrice);
        Ext.Ajax.request({
            url: './feedbacks',
            method : 'POST',
            waitMsg : 'Submitting your data...',
            params: {
                action: 'updateFinalPrice',
                orderId: orderId,
                finalPrice: finalPrice
            },
            // success : function(response) {
            //     var result = Ext.decode(response.responseText);
            //     Ext.Msg.show({
            //         title : '提交成功',
            //         message : result.successMsg,
            //         buttons : Ext.Msg.OK,
            //         icon : Ext.Msg.QUESTION
            //     });
            // },
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

    onOrderTypeSelect: function(item) {
        var me = this,
            selected = me.getView().getSelection();
        if (selected.length == 0) {
            Ext.MessageBox.alert("警告","请选择需要移动的订单！");
            return;
        }
        selected.forEach(function  (element,index, array) {
            me.updateOrderType(element.data.orderId, item.index);
        })
    },
    
    updateOrderType: function(orderIds, orderType) {
        Ext.Ajax.request({
            url: './feedbacks',
            method : 'POST',
            waitMsg : 'Submitting your data...',
            params: {
                action: 'updateOrderType',
                orderId: orderIds,
                orderType: orderType
            },
            success : function(response) {
                var result = Ext.decode(response.responseText);
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

    onOrderByOrderIdClick: function(me,e) {
        this.getView().store.sort([
            { property: 'orderId',  direction: 'DESC' }
        ]);
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
    }

});