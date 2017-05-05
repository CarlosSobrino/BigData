package Dominio;

import java.util.LinkedList;

import org.bson.Document;
import org.json.simple.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import Persistencia.ReadExcel;

public class Agente {
	
	MongoClient mongo = null;
	private MongoDatabase mongodb; 
	
	
	public void conexion(){
	        try {
	            mongo = new MongoClient("localhost", 27017);
	            mongodb = mongo.getDatabase("test");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public void insertar(){
		ReadExcel RE = new ReadExcel();
		LinkedList<Document> lista = RE.leerArchivoExcel();
		
		while(!lista.isEmpty()){
			mongodb.getCollection("movil").insertOne(lista.remove());
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
		
}
