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
	
	public void Insertar(String p,String a, String d){
		
		if (mongo != null) {
			 
            //Si no existe la base de datos la crea
            DB db = mongo.getDB("moviles");
 
            //Crea una tabla si no existe y agrega datos
            DBCollection table = db.getCollection("Movilesdat");
 
            //Crea los objectos básicos
            BasicDBObject da = new BasicDBObject();
            da.put("Pais",p);
            da.put("Anyo", a);
            da.put("Dato", d);
            
            table.insert(da);
            
            
		}
		
		
		
		
	}
	
	
	
}
