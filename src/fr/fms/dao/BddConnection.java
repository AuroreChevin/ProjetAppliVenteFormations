package fr.fms.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
* Gestion de la connexion à la base à partir des données dans le fichier config.properties
* Afin d'assurer qu'une seule connexion est établie pour tous les composants d'accès aux données,
* utilisation d'un singleton à l'aide du constructeur privé
* @author ChevinA 2023
*
*/
public class BddConnection {
	private static Connection connection = null;
	private static String driver;
	private static String url;
	private static String login;
	private static String password;
	private BddConnection() {
		try {
			getConfigFile();								
			Class.forName(driver);	
			connection = DriverManager.getConnection(url,login,password);				
			
			}			
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
		}
	}
/**
* méthode qui retourne une connection, si inexistante, il l'a crée une seule fois
* @return Connection
*/
	public static Connection getConnection() {	
		if(connection == null) 	new BddConnection();
		return connection;
	}
	
/**
* méthode qui ouvre le fichier de config d'une connection
* @throws FileNotFoundException
* @throws IOException
*/
	private static void getConfigFile() throws FileNotFoundException, IOException {
		Properties props = new Properties();		
		try (FileInputStream fis = new FileInputStream("files/config.properties")){
			props.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		driver = props.getProperty("db.driver");
		url = props.getProperty("db.url");
		login = props.getProperty("db.login");
		password = props.getProperty("db.password");
	}
}
