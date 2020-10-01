import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

import Prueba.Connection;

import java.net.*;
import java.util.logging.Level;
import java.util.logging.logger;

public class agente {
	DB BaseDatos;
	DBCollection coleccion;
	BasicDBObject document = new BasicDBObject();
	
	public Connection() {
		try {
			Mongo mongo = new Mongo("localhost",27017);
			BaseDatos = mongo.getDB("ToDo");
			coleccion = BaseDatos.getCollection("ToDo");
			System.out.println("Conectado");
		} catch (Exception e) {
			// TODO: handle exception
			logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null,ex);
		}
	}
	public void mostrar() {
		DBCursor cursor = coleccion.find();
		while(cursor.hasNext()) {
			System.out.println(cursor.next());		
		}
	}
	public boolean insertar(String accion) {
		document.put("accion",accion);
		coleccion.insert(document);
		return true;
	}
	public boolean actualizar(String accion) {
		document.put("accion",accionVieja);
		BasicDBObject documentNuevo = new BasicDBObject();
		documentNuevo.put("accion",accionNueva);
		coleccion.findAndMOdify(document, documentNuevo);
		return true;
		
		
	}
	public boolean eliminar(String accion) {
		document.put("accion",accion);
		coleccion.remove(document);
		return true;
	}

}
