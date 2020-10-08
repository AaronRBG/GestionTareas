package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;

public class agenteDB {
	
	private Connection connection;
	
    private agenteDB() {
    	try {
			this.connection = DriverManager.getConnection("mongodb+srv://david:david123@clusterequipo1.idibk.mongodb.net/User?retryWrites=true&w=majority");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    /*

	public static void main(String args[]) {
		MongoClientURI uri = new MongoClientURI("mongodb+srv://david:david123@clusterequipo1.idibk.mongodb.net/<dbname>?retryWrites=true&w=majority");
		
		try(MongoClient mongoClient = new MongoClient(uri)){
				
			MongoDatabase database = mongoClient.getDatabase("BD_Equipo1");
			MongoCollection<Document> collection = database.getCollection("User");
			Document query = new Document("_id", new ObjectId("5f7d911ca1d9414ac992387a"));
			Document result = collection.find(query).iterator().next();
			
			System.out.println("nombre: " + result.getString("nombre"));
			}
	} */

    private static class BrokerHolder {
        static agenteDB singleton = new agenteDB();
    }

    public static agenteDB get() {
        return BrokerHolder.singleton;
    }

    public Connection getBd() throws SQLException{
    	if(this.connection.isClosed()) {
    		this.connection = DriverManager.getConnection("jdbc:h2:~/test");
    	}
        return this.connection;
    }
	
}