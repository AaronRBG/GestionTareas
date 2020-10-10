package com.app.gestionTareas.dominio;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.app.gestionTareas.persistencia.TareaDAO;

public class Manager {

	private Manager() {
	}

	private static class ManagerHolder {
		static Manager singleton = new Manager();
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

	public JSONObject leer() {

		JSONArray jsa = new JSONArray();
		JSONObject jso = new JSONObject();
		ArrayList<Tarea> tareas = TareaDAO.leer();

		if (!tareas.isEmpty()) {
			for (Tarea t : tareas) {
				jsa.put(t.toJSON());
			}
		}

		jso.put("tareas", jsa);

		return jso;

	}

}