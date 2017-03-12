/**
 * This view is an example list of people.
 */
//var toolbar = 
Ext.define('app.view.feedbacks.OrderFeedbackGridPanelController', {
    extend : 'Ext.app.ViewController',
    alias : 'controller.orderFeedback',
    onAbletoorderClick: function() {
        var me = this,
            selected = me.getView().getSelection();
            selected.forEach(function  (element,index, array) {
                // body...
                alert(element.data.totalPrice);
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