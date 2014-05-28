define([
        'jquery',
        'underscore',
	'backbone',
	'handlebars',
	'text!templates/mainViewContent.html',
	'models/contentModel'
], function(
        $,
        _,
	Backbone,
	Handlebars,
	contentTemplate,
	ContentModel
) {
	var ContentView = Backbone.View.extend({
		contTemp: Handlebars.compile(contentTemplate),

		initialize: function(options) {
		},
		render: function(){
			this.$el.append(this.contTemp())
		},
                events: {
			"click #newTest": "sendEvent"
                },
                doSearch: function() {
                },
                onShow: function() {
                },
		sendEvent: function() {
			ContentModel.sendTrigger()
		}
		// nałożyć triiger na button i wysłac zdarzenie do kontrolera
		// (mainPageController)
	});

	return new ContentView();
});
