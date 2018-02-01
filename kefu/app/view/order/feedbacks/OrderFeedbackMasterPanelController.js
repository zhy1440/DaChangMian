Ext.define('app.view.order.feedbacks.OrderFeedbackMasterPanelController', {
    extend : 'Ext.app.ViewController',
    alias : 'controller.orderFeedbackMaster',
    
    onCreateGrouIdClick : function() {
        var me = this;
        Ext.create('Ext.window.Window', {
            title : '新建团号',
            width : 300,
            height : 130,
            layout : 'fit',
            items : [{
                xtype : 'form',
                bodyPadding : 10,
                items : [{
                        xtype : 'textfield',
                        labelWidth : 40,
                        name : 'groupId',
                        id : 'groupId',
                        width : '100%',
                        fieldLabel : '团号',
                        allowBlank : false
                }],
                buttons : [{
                            text : '确定',
                            handler : function() {
                                var panel = this.up('form');
                                var groupId = panel.getChildByElement('groupId').value;
                                me.createGroupIdHandler(groupId);
                                panel.up('window').destroy();
                            }
                }]
            }]
        }).show();
    },

    createGroupIdHandler: function(groupId) {
        Ext.Ajax.request({
            url: './feedbacks',
            method : 'POST',
            waitMsg : '正在新建团号。。。',
            params: {
                action: 'createGroupId',
                groupId: groupId
            },

            success : function(response) {
                var result = Ext.decode(response.responseText);
                if (result.success) {
                    Ext.Msg.show({
                        title : '创建成功',
                        message : result.successMsg,
                        buttons : Ext.Msg.OK,
                        icon : Ext.Msg.SUCCESS
                    });
                } else {
                    Ext.Msg.show({
                        title : '创建失败',
                        message : result.errorMsg,
                        buttons : Ext.Msg.OK,
                        icon : Ext.Msg.ERROR
                    });
                }
            },
            
            failure : function(response) {
                var result = Ext.decode(response.responseText);
                Ext.Msg.show({
                    title : '创建失败',
                    message : result.errorMsg,
                    buttons : Ext.Msg.OK,
                    icon : Ext.Msg.ERROR
                });
            }
        });
    }
});