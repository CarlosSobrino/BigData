package Dominio;




import com.mongodb.MongoClient;

public class Agente {
	
	
	public void conexion(){
		 MongoClient mongo = null;
	        try {
	            mongo = new MongoClient("localhost", 27017);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
}
