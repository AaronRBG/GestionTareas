package com.app.gestionTareas.persistencia;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class agenteDB {
	
	private MongoClientURI uri;
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
    private agenteDB() {
    	try {
    		uri = new MongoClientURI("mongodb://user:user123@gestiontareas.82ebk.mongodb.net/Tareas?retryWrites=true&w=majority");
    		mongoClient = new MongoClient(uri);
    		database = mongoClient.getDatabase("Tareas");
			collection = database.getCollection("Tareas");
  		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    private static class BrokerHolder {
        static agenteDB singleton = new agenteDB();
    }

    public static agenteDB get() {
        return BrokerHolder.singleton;
    }

    public MongoCollection<Document> getBd(){
    	if(this.collection != null) {
    		uri = new MongoClientURI("mongodb://user:user123@gestiontareas-shard-00-02.82ebk.mongodb.net/Tareas?retryWrites=true&w=majority");
    		mongoClient = new MongoClient(uri);
    		database = mongoClient.getDatabase("Tareas");
			collection = database.getCollection("Tareas");
		}
        return this.collection;
    }
	
}