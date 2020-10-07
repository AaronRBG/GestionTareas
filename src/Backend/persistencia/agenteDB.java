import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;

public class agenteDB {

	public static void main(String args[]) {
		MongoClientURI uri = new MongoClientURI("mongodb+srv://david:david123@clusterequipo1.idibk.mongodb.net/<dbname>?retryWrites=true&w=majority");
		
		try(MongoClient mongoClient = new MongoClient(uri)){
				
			MongoDatabase database = mongoClient.getDatabase("BD_Equipo1");
			MongoCollection<Document> collection = database.getCollection("User");
			Document query = new Document("_id", new ObjectId("5f7d911ca1d9414ac992387a"));
			Document result = collection.find(query).iterator().next();
			
			System.out.println("nombre: " + result.getString("nombre"));
			}
	}
}