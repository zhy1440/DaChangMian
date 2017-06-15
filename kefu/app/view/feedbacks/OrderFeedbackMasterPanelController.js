Ext.define('app.view.feedbacks.OrderFeedbackMasterPanelController', {
    extend : 'Ext.app.ViewController',
    alias : 'controller.orderFeedbackMaster',

    onNewGrouIdClick: function() {
        Ext.Ajax.request({
            url: './feedbacks',
            method : 'POST',
            waitMsg : 'Submitting your data...',
            params: {
                action: 'createGroupId',
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

    }
});