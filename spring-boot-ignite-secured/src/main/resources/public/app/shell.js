define(['plugins/router', 'knockout', 'bootstrap'], function(router, ko, bootstrap) {
	var routes = [
	                {
	                    route: ['', 'home'],
	                    moduleId: 'home',
	                    title: 'Validation test',
	                    nav: true
	                },
	                {
	                    route: 'knockout-samples',
	                    moduleId: 'viewmodels/ko/index',
	                    moduleRootId: 'viewmodels/ko', // Custom property to make child routes easier              
	                    title: 'Knockout Samples',
	                    nav: true,
	                    hash: '#knockout-samples',
	                    childRoutes: [
	                        { route: 'simpleList', moduleId: 'simpleList', title: 'SimpleList',  nav: true, hash : 'simpleList' },
	                        { route: 'clickCounter', moduleId: 'clickCounter', title: 'Click Counter', nav: true, hash : 'clickCounter' }
	                    ]
	                }
	            ];
	
	$.each(routes, function(index, route) {
        if (route.childRoutes === undefined)
            return
        $.each(route.childRoutes, function(index, childRoute) {
            childRoute.route = route.route + '/' + childRoute.route;
            childRoute.moduleId = route.moduleRootId + '/' + childRoute.moduleId;
            childRoute.title = route.title + '/' + childRoute.title;
            childRoute.hash = route.hash + '/' + childRoute.hash;
            childRoute.parent = route.moduleRootId;
        });
        routes = routes.concat(route.childRoutes);
    });
	
	return router.map(routes)
    .buildNavigationModel()
    .activate();
});