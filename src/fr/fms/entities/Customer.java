package fr.fms.entities;
/**
 * Classe des clients possédant 7 attributs
 * @author ChevinA 2023
 *
 */
public class Customer {
	private int idCustomer;
	private String name;
	private String firstname;
	private String email;
	private String address;
	private String phone;
	private int idUser;
/**
 * Constructeur permettant la création d'un client, il prend 7 paramètres
 * @param idCustomer int
 * @param name String
 * @param firstname String
 * @param email String
 * @param address String
 * @param phone String
 * @param idUser int
 */
	public Customer(int idCustomer, String name, String firstname, String email, String address, String phone,
			int idUser) {
		this.idCustomer = idCustomer;
		this.name = name;
		this.firstname = firstname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.idUser = idUser;
	}
/**
 * Constructeur permettant la création d'un client, il prend 6 paramètres
 * @param name String
 * @param firstname String
 * @param email String
 * @param address String
 * @param phone String
 * @param idUser int
 */
	public Customer(String name, String firstname, String email, String address, String phone, int idUser) {
		this.name = name;
		this.firstname = firstname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.idUser = idUser;
	}
/**
 * Méthode permettant de récupérer l'id du client
 * @return idCustomer int
 */
	public int getIdCustomer() {
		return idCustomer;
	}
/**
 * Méthode permettant de modifier l'id du client
 * @param idCustomer int
 */
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
/**
 * Méthode permettant de récupérer le nom du client
 * @return name String
 */
	public String getName() {
		return name;
	}
/**
 * Méthode permettant de modifier le nom du client
 * @param name String
 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * Méthode permettant de récupérer le prénom du client
 * @return firstname String
 */
	public String getFirstname() {
		return firstname;
	}
/**
 * Méthode permettant de modifier le prénom du client
 * @param firstname String
 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
/**
 * Méthode permettant de récupérer l'email du client
 * @return email String
 */
	public String getEmail() {
		return email;
	}
/**
 * Méthode permettant de modifier l'email du client
 * @param email String
 */
	public void setEmail(String email) {
		this.email = email;
	}
/**
 * Méthode permettant de récupérer l'adresse du client
 * @return adress String
 */
	public String getAddress() {
		return address;
	}
/**
 * Méthode permettant de modifier l'adresse du client
 * @param adress String
 */
	public void setAddress(String adress) {
		this.address = adress;
	}
/**
 * Méthode permettant de récupérer le num du phone du client
 * @return phone String
 */
	public String getPhone() {
		return phone;
	}
/**
 * Méthode permettant de modifier le num de phone du client
 * @param phone String
 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
/**
 * Méthode permettant de récupérer l'id de l'utilisateur du client
 * @return idUser int
 */
	public int getIdUser() {
		return idUser;
	}
/**
 * Méthode permettant de modifier l'id de l'utilisateur du client
 * @param idUser int
 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
/**
 * Méthode toString redéfinie, elle retourne l'affichage de l'id, du nom, du prénom, 
 * de l'adresse et du num phon du client
 * 
 */
	@Override
	public String toString() {
		return  idCustomer + " " + name + " " + firstname + " " + email
				+ " " + address + " " + phone;
	}
}
