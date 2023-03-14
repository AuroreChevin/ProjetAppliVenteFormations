package fr.fms.entities;
/**
 * Classe des formations possédant 7 attributs
 * @author ChevinA 2023
 *
 */
public class Training {
	private int idTraining;
	private String name;
	private String description;
	private int nbOfDays;
	private String localisation;
	private double price;
	private int idCategory;
	private int quantity=1;
/**
 * Constructeur permettant la création d'une formation, il prend 7 paramètres
 * @param idTraining int
 * @param name String
 * @param description String
 * @param nbOfDays int
 * @param localisation String
 * @param price double
 * @param idCategory int
 */
	public Training(int idTraining, String name, String description, int nbOfDays, String localisation, double price, int idCategory) {
		this.idTraining = idTraining;
		this.name = name;
		this.description = description;
		this.nbOfDays = nbOfDays;
		this.localisation = localisation;
		this.price = price;
		this.idCategory = idCategory;
	}
/**
 * Constructeur permettant la création d'une formation, il prend 6 paramètres
 * @param idTraining int
 * @param name String
 * @param description String
 * @param nbOfDays int
 * @param localisation String
 * @param price double
 */
	public Training(int idTraining, String name, String description, int nbOfDays, String localisation, double price) {
		this.idTraining = idTraining;
		this.name = name;
		this.description = description;
		this.nbOfDays = nbOfDays;
		this.localisation = localisation;
		this.price = price;
	}
/**
 * Constructeur permettant la création d'une formation, il prend 5 paramètres	
 * @param name String
 * @param description String
 * @param nbOfDays int
 * @param localisation String
 * @param price double
 */
	public Training(String name, String description, int nbOfDays, String localisation, double price) {
		this.idTraining = 0;
		this.name = name;
		this.description = description;
		this.nbOfDays = nbOfDays;
		this.localisation = localisation;
		this.price = price;
	}
/**
 * Méthode permettant de récupérer l'id de la formation
 * @return idTraining int
 */
	public int getIdTraining() {
		return idTraining;
	}
/**
 * Méthode permettant de modifier l'id de la formation
 * @param idTraining int
 */
	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
	}
/**
 * Méthode permettant de récupérer le nom de la formation
 * @return name String
 */
	public String getName() {
		return name;
	}
/**
 * Méthode permettant de modifier le nom de la formation
 * @param name String
 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * Méthode permettant de récupérer la description de la formation
 * @return description String
 */
	public String getDescription() {
		return description;
	}
/**
 * Méthode permettant de modifier la description de la formation
 * @param description String
 */
	public void setDescription(String description) {
		this.description = description;
	}
/**
 * Méthode permettant de récupérer le nombre de jours de la formation
 * @return nbOfDays int
 */
	public int getNbOfDays() {
		return nbOfDays;
	}
/**
 * Méthode permettant de modifier le nombre de jours de la formation
 * @param nbOfDays int
 */
	public void setNbOfDays(int nbOfDays) {
		this.nbOfDays = nbOfDays;
	}
/**
 * Méthode permettant de récupérer le nombre de jours de la formation
 * @return localisation String
 */
	public String getLocalisation() {
		return localisation;
	}
/**
 * Méthode permettant de modifier la localisation de la formation
 * @param localisation String
 */
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
/**
 * Méthode permettant de récupérer le prix de la formation
 * @return price double
 */
	public double getPrice() {
		return price;
	}
/**
 * Méthode permettant de modifier le prix de la formation
 * @param price double
 */
	public void setPrice(double price) {
		this.price = price;
	}
/**
 * Méthode permettant de récupérer l'id de la catégorie de la formation
 * @return idCategory int
 */
	public int getIdCategory() {
		return idCategory;
	}
/**
 * Méthode permettant de modifier l'id de la catégorie de la formation
 * @param idCategory int
 */
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
/**
 * Méthode permettant de récupérer la quantité de formation
 * @return quantity int
 */
	public int getQuantity() {
		return quantity;
	}
/**
 * Méthode permettant de modifier la quantité de formation
 * @param quantity int 
 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
/**
 * Méthode toString redéfinie, elle retourne l'affichage de l'id, du nom, de la description, 
 * du nombre de jours, de la localsation et le prix pour une formation
 */
	@Override
	public String toString() {
		return idTraining + " - " + name + " - " + description + " - "
				+ nbOfDays + " - " + localisation + " - " + price;
	}
	
	
	
}
