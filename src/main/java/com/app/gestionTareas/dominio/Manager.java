package com.app.gestionTareas.dominio;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import com.app.gestionTareas.persistencia.TareaDAO;

public class Manager {
	
	private Manager() {		
	}
	
	private static class ManagerHolder {
		static Manager singleton=new Manager();
	}
	
	public static Manager get() {
		return ManagerHolder.singleton;
	}
	
	public void insertar(String nombre) {
					
		TareaDAO.insertar(nombre);
		
	}
	
	public void actualizar(String nombre) {
		
		TareaDAO.actualizar(nombre);
		
	}
	
	public void eliminar(String nombre) {
		
		TareaDAO.eliminar(nombre);
		
	}
	
	public JSONArray leer() {
		
		JSONArray jsa = new JSONArray();
		ArrayList<Tarea> tareas = TareaDAO.leer();
		
		for(Tarea t: tareas) {
			jsa.put(t.toJSON());
		}
		
		return jsa;
		
	}
	
}