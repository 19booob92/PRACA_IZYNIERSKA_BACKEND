define([
        'jquery',
        'underscore',
	'backbone',
	'handlebars',
	'marionette',
	'templates/loginLayout',
	'templates/contentLayout',
	'templates/formLayout',
	'models/contentModel',
	'models/loginModel'
], function(
        $,
        _,
	Backbone,
	Handlebars,
	Marionette,
	LoginLayout,
	ContentLayout,
	FormLayout,
	ContentModel,
	LoginModel
) {
	var MainPage  = new Marionette.Application();
	var accountType = "aaa";

	MainPage.addRegions({
		loginRegion: "#loginDiv",
		contentRegion: "#contentDiv"
	});
        
	MainPage.on("initialize:after", function() {
		
		if (accountType === "aaaa") {
			this.contentRegion.show(ContentLayout);
		} else {
			this.contentRegion.show(FormLayout);
		}
	       this.loginRegion.show(LoginLayout);
        });
	
	ContentModel.on("viewContent:change", function(){
		alert('kliknieto przycisk');
	});        
	
	LoginModel.on("loginView:logOut", function(){
		LoginLayout.setViewAsUnlogged();
	});        

	LoginModel.on("loginView:logged", function() {
		LoginLayout.setViewAsLogged();
	});
	return MainPage;
});
