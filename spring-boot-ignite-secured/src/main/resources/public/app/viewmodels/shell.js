define(['plugins/router', 'durandal/app', 'modules/securityservice'], function (router, app, securityService) {
	var homeroute = [
	    { route: ['', 'home'], moduleId: 'viewmodels/home', title: 'Home', nav: true }
	];
	
    return {
        router: router,
        
        user: app.user,
        
        activate: function () {
        	var self = this;
        	var routes = homeroute;
        	
            router.map(routes).buildNavigationModel();
            
            return router.activate();
        },
        
        logout: function() {
        	securityService.logout().done(function() {
        		location.href = '/';
        	});
        }
    };
});