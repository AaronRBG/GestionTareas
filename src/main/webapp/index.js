var self;

function ViewModel() {
	self = this;
	self.tareas = ko.observableArray([]);
	self.nombreTarea = ko.observable("");
	

	var url = "ws://"+window.location.host+"/GestionTareas";
	self.sws = new WebSocket(url); 

	self.sws.onopen = function(event) {
		var msg = {
			type : "ready"
		};
		self.sws.send(JSON.stringify(msg));
	}

	self.sws.onmessage = function(event) {
		var data= event.data;
		data = JSON.parse(data);
			
			// Listar las tareas
			var tareas = data.tareas;
			for (var i = 0; i < tareas.length; i++) {
				var tarea = tareas[i];
				self.tareas.push(new Tarea(tarea.nombre, tarea.done));
		
	}
	}
	
	 self.insertar = function() {
		 var p = {
	                type : "insertar",
	                nombre : self.nombreTarea()
	            };
	            self.sws.send(JSON.stringify(p));
	    }
	

	 
// ACTUALIZAR
	 

	class Tarea {
	    constructor(nombre,done){
	        this.nombre = nombre;
	        this.done = done;
	    }
	    
	    eliminarTarea() {
	                var p = {
	                        type : "eliminar",
	                        nombre: this.nombre
	                    };
	                    self.sws.send(JSON.stringify(p));
	    }
	    actualizarTarea(){
	    	 var p = {
                     type : "actualizar",
                     nombre: this.nombre
                 };
                 self.sws.send(JSON.stringify(p));
	    	}
	    }
	
	}
	var vm = new ViewModel();
	ko.applyBindings(vm);