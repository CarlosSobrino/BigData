package Dominio;

import java.util.LinkedList;

import org.bson.Document;
import org.json.simple.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import Persistencia.ReadExcel;

public class Agente {
	
	MongoClient mongo = null;
	private MongoDatabase mongodb; 
	
	
	public void conexion(){
	        try {
	            mongo = new MongoClient("localhost", 27017);
	            mongodb = mongo.getDatabase("movil");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public void insertar(){
		ReadExcel RE = new ReadExcel();
		LinkedList<Document> lista = RE.leerArchivoExcel();
		
		while(!lista.isEmpty()){
			mongodb.getCollection("datamovil").insertOne(lista.remove());
		}
		
	}
	
	public MongoClient getMongo() {
		return mongo;
	}

	public void setMongo(MongoClient mongo) {
		this.mongo = mongo;
	}

	public MongoDatabase getMongodb() {
		return mongodb;
	}

	public void setMongodb(MongoDatabase mongodb) {
		this.mongodb = mongodb;
	}
	
	public void listMoviles(){ 
        // To return all documents in a collection, call the find method without a criteria document.
        // Para devolver todos los documentos en una colección, llamamos al método find sin ningún documento <b>criteria</b>
        FindIterable<Document> iterable = mongodb.getCollection("datamovil").find(new Document("Pais", "Andorra"));
        // Iterate the results and apply a block to each resulting document.
        // Iteramos los resultados y aplicacimos un bloque para cada documento.
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });   
    }
		
}
