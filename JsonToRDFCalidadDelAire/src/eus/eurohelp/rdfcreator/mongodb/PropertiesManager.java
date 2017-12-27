package eus.eurohelp.rdfcreator.mongodb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author dmuchuari
 * @17/11/2017
 */
public class PropertiesManager {
	private static PropertiesManager INSTANCE = null;
	private Properties properties;


	/**
	 * Constructor
	 * @throws IOException
	 */
	private PropertiesManager() throws IOException {
		properties = new Properties();
		InputStream input = new FileInputStream("JsonToRDFCalidadDelAire/main/resources/config.properties");
		try {
			properties.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Obtiene el valor de la propiedad que se le pasa por parametro
	 * @param pPropertyName
	 * @return
	 */
	public String getProperty(String pPropertyName) {
		return properties.getProperty(pPropertyName);
	}
	
	/**
	 * Devuelve la instancia de la clase 
	 * @return
	 * @throws IOException
	 */
	public synchronized static PropertiesManager getINSTANCE() throws IOException {
		if (INSTANCE == null) {
			INSTANCE = new PropertiesManager();
		}
		return INSTANCE;
	}
}