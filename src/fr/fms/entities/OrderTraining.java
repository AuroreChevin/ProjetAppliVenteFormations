package fr.fms.entities;
/**
 * Classe de commande synthétisée possédant 4 attirbuts 
 * @author ChevinA 2023
 *
 */
public class OrderTraining {
	private int idOrderTraining;
	private int idTraining;
	private int quantity;
	private double price;
	private int idOrder;
/**
 * Constructeur permettant la création d'une commande synthétisé, il prend 4 paramètres
 * @param idOrderTraining int  
 * @param idTraining int 
 * @param quantity int  
 * @param price double
 */
	public OrderTraining(int idOrderTraining, int idTraining, int quantity, double price, int idOrder) {
		this.idOrderTraining = idOrderTraining;
		this.idTraining = idTraining;
		this.quantity = quantity;
		this.price = price;
		this.idOrder = idOrder;
	}
/**
 * Méthode permettant de récupérer l'id de la commande synthétisée
 * @return idOrderTraining int
 */
	public int getIdOrderTraining() {
		return idOrderTraining;
	}
/**
 * Méthode permettant de modifier l'id de la commande synthétisée
 * @param idOrderTraining int
 */
	public void setIdOrderTraining(int idOrderTraining) {
		this.idOrderTraining = idOrderTraining;
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
 * Méthode permettant de récupérer l'id de la commande
 * @return idOrder int
 */
	public int getIdOrder() {
		return idOrder;
	}
/**
 * Méthode permettant de modifier l'id de la commande
 * @param idOrder int
 */
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
/**
 * Méthode toString redéfinie, elle retourne l'affichage de l'id, de la somme et de la date de la commande
 */
	@Override
	public String toString() {
		return idOrderTraining + " - " + idTraining + " - "
				+ quantity + " - " + price+ " - "+idOrder;
	}
	
	
}
