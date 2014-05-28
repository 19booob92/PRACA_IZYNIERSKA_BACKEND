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

		var sendTrigger = function() {
			alert('wysylam');
			ContentModel.trigger("viewContent:change");
		}
	});
	return new ContentModel();
});
