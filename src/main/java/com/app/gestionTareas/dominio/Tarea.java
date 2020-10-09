package com.app.gestionTareas.dominio;

import org.json.JSONObject;

public class Tarea {

	private String nombre;
	private boolean done;
	private String id;
	
	public Tarea(String nombre){
		this.nombre = nombre;
		this.done = false;
	}
	
	
    public JSONObject toJSON() {
        JSONObject jso = new JSONObject();
        jso.put("nombre", this.getNombre());
        jso.put("done", this.getDone());
        return jso;
    }

}
