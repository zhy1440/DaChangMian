/**
 * This class is the main view for the application. It is specified in app.js as
 * the "mainView" property. That setting automatically applies the "viewport"
 * plugin causing this view to become the body element (i.e., the viewport).
 * 
 * TODO - Replace this content of this view to suite the needs of your
 * application.
 */
Ext.define('app.view.main.Main', {
	extend : 'Ext.tab.Panel',
	xtype : 'app-main',

	requires : [ 'Ext.plugin.Viewport', 'Ext.window.MessageBox',
			'app.view.main.MainController', 'app.view.main.MainModel' ],

	controller : 'main',
	viewModel : 'main',
	plugins: 'viewport',
	
	ui : 'navigation',
	id : 'kefuMain',

	tabBarHeaderPosition : 1,
	titleRotation : 0,
	tabRotation : 0,

	header : {
		layout : {
			align : 'stretchmax'
		},
		title : {
			bind : {
				text : '{name}'
			},
			flex : 0
		}/*,
		iconCls : 'fa-th-list',
		items : [ {
			xtype : 'label',
			text : "您好，" + localStorage.getItem("LoggedInUserName"),
			margin : '10 0'
		} ]*/
	},

	tabBar : {
		flex : 1,
		layout : {
			align : 'stretch',
			overflowHandler : 'none'
		}
	},

	responsiveConfig : {
		tall : {
			headerPosition : 'top'
		},
		wide : {
			headerPosition : 'top'
		}
	},

	defaults : {
		bodyPadding : 20,
		tabConfig : {
			plugins : 'responsive',
			responsiveConfig : {
				wide : {
					iconAlign : 'left',
					textAlign : 'left'
				},
				tall : {
					iconAlign : 'top',
					textAlign : 'center',
					width : 120
				}
			}
		},
		autoScroll : true
	},

	items : [
	/*
	 * { iconCls : 'fa-home', bind : { title : '{menu.order_input}' }, // The
	 * following grid shares a store with the classic version's grid as // well!
	 * items : [ { xtype : 'mainlist' } ] },
	 */
	{
		iconCls : 'fa-users',
		items : [ {
			xtype : 'orderplace'
		} ],
		bind : {
			title : '{menu.order_input}'
		}
	}, {
		iconCls : 'fa-user',
		items : [ {
			id : 'orderFeedback',
			xtype : 'orderfeedback'
		} ],
		bind : {
			// html: '{loremIpsum}',
			title : '{menu.group_succ_feedback}'
		}
	}, {
		iconCls : 'fa-cog',
		bind : {
			title : '{menu.group_succ_review}',
			html : '{loremIpsum}'
		}
	}, {
		iconCls : 'fa-cog',
		bind : {
			html : '{loremIpsum}',
			title : '{menu.transform_pick_up}'
		}
	}, {
		iconCls : 'fa-cog',
		bind : {
			// html : '{loremIpsum}',
			title : '{menu.customer_info}'
		},
		items : [ {
			xtype : 'customerinfolist'
		} ]
	}, {
		iconCls : 'fa-cog',
		bind : {
			html : '{loremIpsum}',
			title : '{menu.turnover}'
		}
	}, {
		iconCls : 'fa-cog',
		bind : {
			html : '{loremIpsum}',
			title : '{menu.balance}'

		}
	}],
	listeners:{// 添加监听器，点击此页面的tab时候要重新加载（刷新功能）
     	activate:function(){
      	this.getUpdater().refresh(); 
//	      	Ext.MessageBox.alert("提示","系统参数信息");
     	}
    }
});
