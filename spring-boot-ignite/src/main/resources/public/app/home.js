define(function (require) {
  var app = require('durandal/app'),
      ko = require('knockout'),
      $ = require('jquery'),
      fd = require('fd'),
      Instance = require('viewmodels/instance');
 
  var isearch = function() {
	  alert('searching...' + instance.name);
  };
  
  var instance = new Instance('Kevin Roy', isearch); 
  
  return {
     name: ko.observable(),
     loading: ko.observable('hey'),
     instance: instance,
     sayHello: function() {
       app.showMessage('Hello ' + this.name() + '! Nice to meet you.', 'Greetings');
     },
     
     downloadFile: function() {
    	 var self = this;
    	 
    	 self.loading('currently loading...');
    	 $.fileDownload('/dlpdf', {
    		    successCallback: function (url) {
    		    	self.loading('finished loading...');
    		        
    		    },
    		    failCallback: function (html, url) {
    		 
    		        alert('Your file download just failed for this URL:' + url + '\r\n' +
    		                'Here was the resulting error HTML: \r\n' + html
    		                );
    		    }
    		});
     },
     
     printDiv: function() {
    	 alert(window.location.href);
     }
   };
});