define(function(require) {
	var backend = function(name) {
		this.name = name;
	}
	
	backend.prototype.getCustomers = function() {
		//alert('name is: ' + this.name);
	};
	
	backend.prototype.getNames = function() {
		//alert('names');
	}
	
	backend.prototype.getParams = function(param1, param2) {
		//alert(param1 + ' ' + param2);
	}
	
	return backend;
});