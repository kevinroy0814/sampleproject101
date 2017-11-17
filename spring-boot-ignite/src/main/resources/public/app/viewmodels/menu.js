define(['plugins/router', 'knockout'], function(router, ko) {
	return {
		router : router,
		activate : function() {
			router.map([
			   { route : '', title: 'Home', moduleId: 'home', nav: true }
			]).buildNavigationModel();
			
			return router.activate();
		}
	};
});