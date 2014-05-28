define([
        'jquery',
        'underscore',
	'backbone',
	'handlebars',
	'text!templates/mainViewLogin.html',
	'text!templates/mainViewContent.html'
], function(
        $,
        _,
	Backbone,
	Handlebars,
	loginTemplate,
	contentTemplate
) {
	var MainView = Backbone.View.extend({
                loginTemp:  Handlebars.compile(loginTemplate),
		contTemp: Handlebars.compile(contentTemplate),

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
