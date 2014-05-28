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
	var ContentModel = Backbone.Model.extend({

		sendTrigger : function() {
			this.trigger("viewContent:change");
		}

	});
	return new ContentModel();
});
