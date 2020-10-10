package com.app.gestionTareas.persistencia;

import java.util.ArrayList;
import org.bson.Document;
import org.springframework.stereotype.Repository;
import com.app.gestionTareas.dominio.Tarea;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.app.gestionTareas.*;

@Repository
public class TareaDAO {
	
	public static ArrayList<Tarea> leer() {
		
		ArrayList<Tarea> tareas = new ArrayList<>();
		Document document;
		Tarea t;

		MongoCollection <Document> coleccion = agenteDB.get().getBd();
		
		MongoCursor<Document> iter = coleccion.find().iterator();
		
		while((document = iter.next()) != null) {
			
			t = new Tarea(document.getString("nombre"), document.getBoolean("done"));
			tareas.add(t);
		}
		
		return tareas;
	}
	
	public static void insertar(String nombre) {
		Document document;

		MongoCollection <Document> coleccion = agenteDB.get().getBd();
		document = new Document("nombre",nombre);
		document.append("done", 0);
		coleccion.insertOne(document);

	}
	
	public static void actualizar(String nombre) {
		Document document;
		Document document2;

		MongoCollection <Document> coleccion = agenteDB.get().getBd();
		
		document = new Document("nombre",nombre);
		document2 = new Document("nombre",nombre);
		document2.put("done", 1);
		
		coleccion.findOneAndUpdate(document, document2);
		
	}
	
	public static void eliminar(String nombre) {
		Document document;

		MongoCollection <Document> coleccion = agenteDB.get().getBd();
		
		document = new Document("nombre",nombre);
		
		coleccion.findOneAndDelete(document);
		
	}
		
	
	
}
