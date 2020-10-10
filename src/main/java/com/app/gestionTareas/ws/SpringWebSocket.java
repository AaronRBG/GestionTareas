package com.app.gestionTareas.ws;

import java.util.List;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.app.gestionTareas.dominio.Manager;

@Component
public class SpringWebSocket extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        HttpHeaders headers = session.getHandshakeHeaders();
        List<String> cookies = headers.get("cookie");
        for (String cookie : cookies)
            if (cookie.startsWith("JSESSIONID=")) {
                String httpSessionId = cookie.substring("JSESSIONID=".length());
                break;
            }
    }
    
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        JSONObject jso = new JSONObject(message.getPayload().toString());
        if (jso.getString("type").equals("ready")) {
            session.sendMessage(new TextMessage(Manager.get().leer().toString()));
        }

        if(jso.getString("type").equals("insertar")){
        	Manager.get().insertar((String)jso.get("nombre"));
        }
        
        if(jso.getString("type").equals("actualizar")){
        	Manager.get().actualizar((String)jso.get("nombre"));
        }

        if(jso.getString("type").equals("eliminar")){
        	Manager.get().eliminar((String)jso.get("nombre"));
        }
        
    }
  
}
