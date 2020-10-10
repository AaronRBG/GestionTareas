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
    		uri = new MongoClientURI("mongodb://alberto:alberto123@clusterequipo1-shard-00-00.idibk.mongodb.net:27017,clusterequipo1-shard-00-01.idibk.mongodb.net:27017,clusterequipo1-shard-00-02.idibk.mongodb.net:27017/BD_Equipo1?ssl=true&replicaSet=atlas-13i99e-shard-0&authSource=admin&retryWrites=true&w=majority");
    		mongoClient = new MongoClient(uri);
    		database = mongoClient.getDatabase("BD_Equipo1");
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
    		uri = new MongoClientURI("mongodb://alberto:alberto123@clusterequipo1-shard-00-00.idibk.mongodb.net:27017,clusterequipo1-shard-00-01.idibk.mongodb.net:27017,clusterequipo1-shard-00-02.idibk.mongodb.net:27017/BD_Equipo1?ssl=true&replicaSet=atlas-13i99e-shard-0&authSource=admin&retryWrites=true&w=majority");
    		mongoClient = new MongoClient(uri);
    		database = mongoClient.getDatabase("BD_Equipo1");
			collection = database.getCollection("Tareas");
		}
        return this.collection;
    }
	
}