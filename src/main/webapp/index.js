var self;

function ViewModel() {
	self = this;
	self.listaTareas = ko.observableArray([]);
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
				if(self.listaTareas().some(t=> t.nombre=== tarea.nombre ) === false){
				self.listaTareas.push(new Tarea(tarea.nombre, tarea.done));
				}
			}
			for (var i = 0; i < self.listaTareas().length; i++) {
          	  if(tareas[i].done === true){
          		  document.getElementsByClassName("form-check-input")[i].checked = true;
          	  }
          	  else{
          		document.getElementsByClassName("form-check-input")[i].checked = false;
          	  }
          	  
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
	                    for (var i = 0; i < self.listaTareas().length; i++) {
	                    	if(self.listaTareas()[i].nombre === this.nombre)
	                    	self.listaTareas.splice(i, 1);
	                    }
	    }
	    actualizarTarea(){
	    	var pos;
	    	for (var i = 0; i < self.listaTareas().length; i++) {
            	if(self.listaTareas()[i].nombre === this.nombre)
            	pos = i;
            }
	    	 var p = {
                     type : "actualizar",
                     nombre: this.nombre,
                     done: document.getElementsByClassName("form-check-input")[pos].checked
                 };
                 self.sws.send(JSON.stringify(p));
                 
                 
	    	}
	    }
	
	}
	var vm = new ViewModel();
	ko.applyBindings(vm);