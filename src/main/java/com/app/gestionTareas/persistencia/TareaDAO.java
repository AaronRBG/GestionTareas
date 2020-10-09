package com.app.gestionTareas.persistencia;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.gestionTareas.dominio.Tarea;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;


@Repository
public interface TareaDAO extends CrudRepository<Tarea, String> {
	
	public static void insertar(String nombre, boolean done) {
		Document document;
		int c=0;
		if (done) {
			c=1;
		}
		MongoCollection <Document> coleccion = agenteDB.get().getBd();
		document = new Document();
		document.put("nombre",nombre);
		document.put("done",c);
		coleccion.insertOne(document);

	}
	public static void actualizar(String nombre, boolean done, String id) {
		Document document;
		Document document2;
		int c=0;
		if (done) {
			c=1;
		}
		MongoCollection <Document> coleccion = agenteDB.get().getBd();
		
		
		document = new Document("_id",new ObjectId(id));
		document2 = new Document();
		
		document2.put("_id",new ObjectId(id));
		
		document2.put("nombre",nombre);
		document2.put("done",c);
		
		coleccion.updateOne(document, document);
		
		
		
	}
	public static void eliminar(String accion) {
		document.put("accion",accion);
		coleccion.remove(document);
		return true;
	}
		
	
	
}
