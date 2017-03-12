/**
 * This view is an example list of people.
 */
//var toolbar = 
Ext.define('app.view.feedbacks.OrderFeedbackGridPanelController', {
    extend : 'Ext.app.ViewController',
    alias : 'controller.orderFeedback',
    onAbletoorderClick: function() {
        var me = this,
            selected = me.getView().down('panel');

        alert("selected");
    }

 
});