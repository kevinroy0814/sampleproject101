requirejs.config({
	paths: {
		'text' : '../lib/require/text',
		'durandal' : '../lib/durandal/js',
		'plugins' : '../lib/durandal/js/plugins',
		'transitions' : '../lib/durandal/js/transitions',
		'knockout' : '../lib/knockout/knockout-3.1.0',
		'jquery' : '../lib/jquery/jquery-1.9.1',
		'bootstrap' : '../lib/bootstrap/js/bootstrap.min',
		'jquery-ui' : '../lib/fileupload/vendor/jquery.ui.widget',
		'iframe-transport' : '../lib/fileupload/jquery.iframe-transport'
	},
    shim: {
        'bootstrap': {
            deps: ['jquery'],
            exports: 'jQuery'
       },
       'jquery-ui': {
    	   deps: ['jquery'],
    	   exports: 'jQuery'
       },
       'iframe-transport': {
    	   deps: ['jquery'],
    	   exports: 'jQuery.ajaxTransport'
       },
       'fileupload': {
    	   deps: ['jquery', 'jquery-ui', 'iframe-transport'],
    	   exports: 'jQuery.jqueryFileUpload'
       }
    }
});

define(['durandal/system', 'durandal/app', 'durandal/viewLocator', 'customModal', 'fileupload'], function (system, app, viewLocator, CustomModal) {
	//var system = require('durandal/system'),
	//	app = require('durandal/app');
	
	system.debug(true);
	
	app.title = 'Durandal Starter Kits';
	
	app.configurePlugins({
        router: true,
        dialog: true,
        widget: true
    });
	
	app.start().then(function() {
		viewLocator.useConvention();
		//app.showDialog(new CustomModal());
		app.setRoot('shell', 'entrance');
	});
});