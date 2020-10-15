package com.app.gestionTareas.persistencia;

import java.util.ArrayList;
import org.bson.Document;
import org.springframework.stereotype.Repository;
import com.app.gestionTareas.dominio.Tarea;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

@Repository
public class TareaDAO {

	public static ArrayList<Tarea> leer() {

		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
		Document document;
		Tarea t;

		MongoCollection<Document> coleccion = agenteDB.get().getBd();

		MongoCursor<Document> iter = coleccion.find().iterator();

		while ((iter.hasNext())) {
			document = iter.next();
			t = new Tarea(document.getString("nombre"), document.getBoolean("done"));
			tareas.add(t);
		}

		return tareas;
	}

	public static void insertar(String nombre) {
		Document document;

		MongoCollection<Document> coleccion = agenteDB.get().getBd();
		document = new Document("nombre", nombre);
		document.append("done", false);
		coleccion.insertOne(document);

	}

	public static void actualizar(String nombre, boolean done) {
		Document document;
		Document documentAUX;

		MongoCollection<Document> coleccion = agenteDB.get().getBd();

		document = new Document("nombre", nombre);
		if (done) {
			documentAUX = new Document("$set", new Document("done", true));
		} else {
			documentAUX = new Document("$set", new Document("done", false));
		}
		// document2.put("done", 1);

		coleccion.findOneAndUpdate(document, documentAUX);

	}

	public static void eliminar(String nombre) {
		Document document;

		MongoCollection<Document> coleccion = agenteDB.get().getBd();

		document = new Document("nombre", nombre);

		coleccion.findOneAndDelete(document);

	}

}
