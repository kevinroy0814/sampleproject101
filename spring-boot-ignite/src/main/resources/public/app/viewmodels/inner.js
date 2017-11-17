define(function (require) {
  var app = require('durandal/app'),
      ko = require('knockout');
 
  var Inner = function(name) {
	this.name = name;  
  };
  
  return Inner;
});