define([
        'jquery',
        'underscore',
	'backbone',
	'handlebars',
	'text!templates/mainViewLogin.html',
], function(
        $,
        _,
	Backbone,
	Handlebars,
	loginTemplate,
) {
	var MainView = Backbone.View.extend({
                loginTemp:  Handlebars.compile(loginTemplate),

		initialize: function(options) {
		},
		render: function(){
			this.$el.append(this.loginTemp());
		},
                events: {
                
                },
                doSearch: function() {
                },
                onShow: function() {
                }
	});
	return new MainView();
});
