package fr.fms.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
/**
 * Programme permettant de générer le fichier de configuration
 * @author ChevinA 
 *
 */
public class CreateConfigFile {

	public static void main(String[] args) {
		try (OutputStream ops = new FileOutputStream("files/config.properties")) {		
			Properties properties = new Properties();	
			properties.setProperty("db.driver", "org.mariadb.jdbc.Driver");
			properties.setProperty("db.url", "jdbc:mariadb://localhost:3306/TrainingShop");
			properties.setProperty("db.login", "AuroreC");
			properties.setProperty("db.password", "kwak09");			
			properties.store(ops,"C'est un fichier pour la configuration");
			System.out.println("Fichier créé !");
		}
		 catch (IOException io) {
	            io.printStackTrace();
		}

	}

}
