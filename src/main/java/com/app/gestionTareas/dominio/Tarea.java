package com.app.gestionTareas.dominio;

import org.json.JSONObject;

public class Tarea {

	private String nombre;
	private boolean done;
	
	public Tarea(String nombre){
		this.nombre = nombre;
		this.done = false;
	}
	
	public Tarea(String nombre, boolean done){
		this.nombre = nombre;
		this.done = done;
	}
	
    public JSONObject toJSON() {
        JSONObject jso = new JSONObject();
        jso.put("nombre", this.getNombre());
        jso.put("done", this.isDone());
        return jso;
    }

	public String getNombre() {
		return nombre;
	}

	public boolean isDone() {
		return done;
	}

}
