package fr.fms.entities;
/**
 * Classe des utilisateurs possédant 3 attributs
 * @author ChevinA 2023
 *
 */
public class User {
	private int idUser;
	private String login;
	private String password;
/**
 * Constructeur permettant la création d'un utilisateur, il prend 3 paramètres
 * @param idUser int 
 * @param login String
 * @param password String
 */
	public User(int idUser, String login, String password) {
		this.idUser = idUser;
		this.login = login;
		this.password = password;
	}
/**
 * Constructeur permettant la création d'un utilisateur, il prend 2 paramètres	
 * @param login String
 * @param password String
 */
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
/**
 *Méthode permettant de récupérer l'id de l'utilisateur 
 * @return idUser int
 */
	public int getIdUser() {
		return idUser;
	}
/**
 * Méthode permettant de modifier l'id de l'utilisateur
 * @param idUser int
 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
/**
 * Méthode permettant de récupérer le login de l'utilisateur 
 * @return login String
 */
	public String getLogin() {
		return login;
	}
/**
 * Méthode permettant de modifier le login de l'utilisateur
 * @param login String
 */
	public void setLogin(String login) {
		this.login = login;
	}
/**
 * Méthode permettant de récupérer le password de l'utilisateur 
 * @return password String
 */
	public String getPassword() {
		return password;
	}
/**
 * Méthode permettant de modifier le password de l'utilisateur
 * @param password String
 */
	public void setPassword(String password) {
		this.password = password;
	}
/**
 * Méthode toString redéfinie, elle retourne l'affichage de l'id, du login et du password d'un utilisateur  
 */
	@Override
	public String toString() {
		return idUser + " - " + login + " - " + password;
	}
}
