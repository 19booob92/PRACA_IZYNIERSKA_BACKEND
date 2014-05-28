require.config({
	paths: {
		'jquery': 'libs/jquery.min',
		'handlebars': 'libs/handlebars.min',
		'marionette': 'libs/backbone.marionette',
		'underscore': 'libs/underscore',
		'backbone': 'libs/backbone',
		'text': 'libs/text',
		'wreq': 'liba/backbone.wreqr',
		'babysitter': 'liba/backbone.babysitter'
	}, 
		shim: {
		'jquery-ui': {
			deps: [ 'jquery' ]
		},
		'underscore': {
			exports: '_'
		},
		'backbone': {
			exports: 'Backbone',
			deps: ['underscore', 'jquery']
		},
		'handlebars': {
			exports: 'Handlebars'
		},
		'marionette': {
		        exports: 'Marionette',
		        deps: ['backbone']
		}
	}
});

require([
        'jquery',
	'mainPageController'
], function(
	$,
	MainPage
	) {     
	        MainPage.start();
});
