define([
        'jquery',
        'underscore',
	'backbone',
	'handlebars',
	'text!templates/mainViewLogin.html',
	'models/loginModel'
], function(
        $,
        _,
	Backbone,
	Handlebars,
	loginTemplate,
	LoginModel
) {
	var MainLoginView = Backbone.View.extend({
                loginTemp:  Handlebars.compile(loginTemplate),
		
		initialize: function(options) {
		},
		render: function(){
			this.$el.append(this.loginTemp());
		},
                events: {
			"click #logIn" : "logInClicked",
			"click #logOut" : "logOutClicked"
                },
                doSearch: function() {
                },
                onShow: function() {
                },
		logInClicked : function() {
			LoginModel.sendLoginRequest()	
		},
		logOutClicked : function() {
			LoginModel.sendLogOutRequest()
		},
		setViewAsLogged : function() {
			//to pewnie będzie lepiej zmaienić na 
			//przypisanie jakiejś klasy css, albo
			//w ogóle wczytać jako nowy template
			var userName = this.$el.find('#login').val();
		        LoginModel.name = userName;
			LoginModel.pass =  this.$el.find('#pass').val();
	
			this.$el.find('#login').hide();
			this.$el.find('#pass').hide();
			this.$el.find('#logIn').hide();
			this.$el.find('#pLogin').text(userName);
			this.$el.find('#pPass').hide();
			this.$el.find('#logOut').show();
		},
		setViewAsUnlogged : function() {
			this.$el.find('#login').show();
			this.$el.find('#pass').show();
			this.$el.find('#logIn').show();
			this.$el.find('#pPass').show();
			this.$el.find('#logOut').hide();
		}
	});
	return new MainLoginView();
});
