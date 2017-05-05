package Dominio;




import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Agente {
	
	MongoClient mongo = null;
	public void conexion(){
	        try {
	            mongo = new MongoClient("localhost", 27017);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	


	
	
}
