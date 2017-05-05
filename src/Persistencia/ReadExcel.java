package Persistencia;

import java.io.File;

import jxl.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Dominio.Agente;


public class ReadExcel {
	
	
	public LinkedList<Document> leerArchivoExcel() {
		String archivoDestino = "Moviles.xls";
		JSONObject obj;
		LinkedList<Document> documentos= new LinkedList<Document>();
		
		try { 
			Workbook archivoExcel = Workbook.getWorkbook(new File( 
					archivoDestino)); 
			System.out.println("Número de Hojas\t" 
					+ archivoExcel.getNumberOfSheets()); 
			for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) // Recorre 
				// cada    
				// hoja                                                                                                                                                       
			{ 
				Sheet hoja = archivoExcel.getSheet(sheetNo); 
				int numColumnas = hoja.getColumns(); 
				int numFilas = hoja.getRows();
				
				String dato;
				String Pais;
				String anyo;
				
				JSONObject IO = new JSONObject();
				Document nuevo = new Document();
				
				for (int fila = 1; fila < numFilas; fila++) { // Recorre cada fila de la hoja 
					for (int columna = 1; columna < numColumnas; columna++) { // Recorre cada  columna de la fila 
						obj = new JSONObject();
						nuevo = new Document();
						anyo = hoja.getCell(columna,0).getContents();
						Pais = hoja.getCell(0, fila).getContents();
						dato = hoja.getCell(columna, fila).getContents();
						
						
						IO=crearJson(Pais, anyo,dato);
						nuevo = crearDocumento(Pais, anyo,dato);
						//obj.put("id"+fila+""+columna, IO);
						documentos.add(nuevo);
						System.out.println(nuevo.toString());
					} 
				} 
			} 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		}
		return documentos;
	} 
	
	public JSONObject  crearJson(String p, String a, String d){
		
		JSONObject innerObj = new JSONObject();
		innerObj.put("Pais",p);
		innerObj.put("Año", a);
		innerObj.put("Dato",d);
		
		return innerObj;
		
	}
	
public Document  crearDocumento(String p, String a, String d){
		
		Document documento = new Document();
		documento.put("Pais",p);
		documento.put("Año", a);
		documento.put("Dato",d);
		
		return documento;
		
	}
}
