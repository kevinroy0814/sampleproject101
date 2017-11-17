define(function (require) {
  var app = require('durandal/app'),
      ko = require('knockout'),
      Inner = require('viewmodels/inner');
 
  var Instance = function(name, search) {
	this.name = name;  
	this.search = search;
	this.inner = new Inner('Chai Choi');
  };
  
  Instance.prototype.changeName = function() {
	  this.name = 'Krizia';
  }
  
  return Instance;
});