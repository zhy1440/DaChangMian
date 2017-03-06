/**
 * This class is the view model for the Main view of the application.
 */
Ext.define('app.view.main.MainModel', {
    extend: 'Ext.app.ViewModel',

    alias: 'viewmodel.main',

    data: {
        name: '大肠面订单管理系统',

        loremIpsum: '不要急。。。一样样来。。。',
        menu: {
          order_input: '捞单录入',
          group_succ_feedback: '成团反馈',
          split_group_proc: '分团处理',
          group_succ_review: '成团查看',
          transform_pick_up: '发货选取',
          customer_info: '顾客资料',
          turnover: '营业额查看',
          balance: '余款'
        },
		cstMenu:{
	          cst_order_management: '订单管理',
	          cst_my_info: '我的信息',
	          cst_order_place: '顾客下单'
		}
    }

    // TODO - add data, formulas and/or methods to support your view
});
