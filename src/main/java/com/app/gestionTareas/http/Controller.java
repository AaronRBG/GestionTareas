package com.app.gestionTareas.http;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.gestionTareas.dominio.Manager;

@RestController
public class Controller {

  /*  @PostMapping("/enviar")
    public void enviar(HttpSession session, @RequestBody Map<String, Object> credenciales) throws JSONException{
        JSONObject jso = new JSONObject(credenciales);
        String email = jso.getString("email");
        String nombre = jso.getString("nombre");
		try {
			Manager.get().enviar(session, email, nombre);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        
    }
	*/
}
