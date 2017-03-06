/**
 * The main application class. An instance of this class is created by app.js
 * when it calls Ext.application(). This is the ideal place to handle
 * application launch and initialization details.
 */
Ext.define('app.Application', {
	extend : 'Ext.app.Application',

	name : 'app',

	stores : [
	// TODO: add global / shared stores here
	],
	requires : [ 'app.view.main.Main'],

	 views : [ 'app.view.main.Main' ],
	launch : function() {
		// TODO - Launch the application
		Ext.create({
			xtype : 'app-main'
		});
/*		var params = Ext.urlDecode(location.search.substring(1));
		var id = params['uid'], userName = params['userName'];
		Ext.Ajax.request({
			url : './UserLogin?uid=' + id,

			success : function(response, opts) {
				var user= JSON.parse(response.responseText);

				localStorage.setItem("LoggedInUserName", user.userName);
				localStorage.setItem("LoggedInMobile", user.mobile);
				localStorage.setItem("LoggedInEmail", user.email);
				Ext.create({
					xtype : 'app-customermain'
				});
			},

			failure : function(response, opts) {
				console.log('server-side failure with status code '
						+ response.status);
			}
		});
		localStorage.setItem("LoggedInUid", id);*/
		
		
	},

	onAppUpdate : function() {
		Ext.Msg.confirm('Application Update',
				'This application has an update, reload?', function(choice) {
					if (choice === 'yes') {
						window.location.reload();
					}
				});
	}
});
