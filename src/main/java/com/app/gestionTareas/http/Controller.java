package com.app.gestionTareas.http;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.gestionTareas.dominio.Manager;

@RestController
public class Controller {

    @PostMapping("/insertar")
    public void insertar(HttpSession session, @RequestBody Map<String, Object> credenciales) throws JSONException{
        JSONObject jso = new JSONObject(credenciales);
        String nombre = jso.getString("nombre");
        
		try {
			Manager.get().insertar(nombre);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        
    }
    
    @PostMapping("/actualizar")
    public void actualizar(HttpSession session, @RequestBody Map<String, Object> credenciales) throws JSONException{
        JSONObject jso = new JSONObject(credenciales);
        String nombre = jso.getString("nombre");
        String donette = jso.getString("done");
        boolean done = Boolean.parseBoolean(donette);       
        
		try {
			Manager.get().actualizar(nombre);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        
    }
    
    @PostMapping("/eliminar")
    public void eliminar(HttpSession session, @RequestBody Map<String, Object> credenciales) throws JSONException{
        JSONObject jso = new JSONObject(credenciales);
        String nombre = jso.getString("nombre");
        
		try {
			Manager.get().eliminar(nombre);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        
    }
    
    @GetMapping("/leer")
    public JSONObject leer(HttpSession session){
        return Manager.get().leer();
    }
	
}
