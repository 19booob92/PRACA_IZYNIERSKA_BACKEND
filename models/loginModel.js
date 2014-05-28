define([
        'jquery',
        'underscore',
	'backbone',
	'handlebars'
], function(
        $,
        _,
	Backbone,
	Handlebars
) {
	var LoginModel = Backbone.Model.extend({
		name : "",
		pass : "",

		sendLoginRequest : function() {
			this.trigger("loginView:logged");
		},
		sendLogOutRequest : function() {
			this.trigger("loginView:logOut");
		}

	});
	return new LoginModel();
});
