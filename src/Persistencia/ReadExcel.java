package Persistencia;

import java.io.File;

import jxl.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Dominio.Agente;


public class ReadExcel {
	
	
	public void leerArchivoExcel() {
		String archivoDestino = "Moviles.xls";
		JSONObject obj = new JSONObject();
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
				
				for (int fila = 1; fila < numFilas; fila++) { // Recorre cada fila de la hoja 
					for (int columna = 1; columna < numColumnas; columna++) { // Recorre cada  columna de la fila 
						
						anyo = hoja.getCell(columna,0).getContents();
						Pais = hoja.getCell(0, fila).getContents();
						dato = hoja.getCell(columna, fila).getContents();
						
						
						IO=crearJson(Pais, anyo,dato);
						obj.put("id"+fila+""+columna, IO);
						
					} 
				} 
			} 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		
		try {

			FileWriter file = new FileWriter("prueba.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			//manejar error
		}

	} 
	
	public JSONObject  crearJson(String p, String a, String d){
		
		
		JSONObject innerObj = new JSONObject();
		innerObj.put("Pais",p);
		innerObj.put("Año", a);
		innerObj.put("Dato",d);
		
		
		return innerObj;
		
	}


}
