define([
        'jquery',
        'underscore',
	'backbone',
	'handlebars',
	'marionette',
	'templates/loginLayout',
	'templates/contentLayout',
	'models/contentModel'
], function(
        $,
        _,
	Backbone,
	Handlebars,
	Marionette,
	LoginLayout,
	ContentLayout,
	mod
) {
	var MainPage  = new Marionette.Application();
       	var a = mod;
	MainPage.addRegions({
		loginRegion: "#loginDiv",
		contentRegion: "#contentDiv"
	});
        
	MainPage.on("initialize:after", function() {
	       var loginView = LoginLayout;
	       var contentView = ContentLayout;		
	mod.sendTrigger();


	       MainPage.loginRegion.show(loginView);
	       MainPage.contentRegion.show(contentView);
        });
	
	MainPage.on("viewContent:change", function(){
		alert("asd");
		MainPage.contentRegion.show(LoginLayout);
	});        
	// obsłużyć zdarzeenie wysłąne z contentLayout i przeładować
	// widok
	return MainPage;
});
