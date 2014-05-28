define([
        'jquery',
        'underscore',
	'backbone',
	'handlebars',
	'text!templates/formView.html'
], function(
        $,
        _,
	Backbone,
	Handlebars,
	formTemplate
) {
	var FormView = Backbone.View.extend({
		fTemp: Handlebars.compile(formTemplate),

		initialize: function(options) {
		},
		render: function(){
			this.$el.append(this.fTemp())
		},
                events: {
			"keyup #questCount": "createFields"
                },
                doSearch: function() {
                },
                onShow: function() {
                },
		createFields: function() {
			var questCount =  this.$el.find("#questCount").val();
			if (questCount < 5) {
				this.$el.find("#questions").empty();
				for (i = 0; i < questCount; i++) {
					this.$el.find("#questions").append("</br><input type=\"text\" id=\"qField\"" + i + "/><input type=\"checkbox\" id=\"chBox\"" + i + "/>");
				}
			} else {
				alert("Za dużo odpowiedzi");
			}
		}	
	});

	return new FormView();
});
