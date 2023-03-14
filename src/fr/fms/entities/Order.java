package fr.fms.entities;
import java.util.Date;
/**
 * Classe des commandes possédant 4 attributs.
 * @author ChevinA 2023
 *
 */
public class Order {
	private int idOrder;
	private double amount;
	private Date date;
	private int idCustomer;
/**
 * Constructeur permettant la création d'une commande, il prend 4 paramètres
 * @param idOrder int 
 * @param amount double
 * @param date Date
 * @param idCustomer int
 */
	public Order(int idOrder, double amount, Date date, int idCustomer) {
		this.idOrder = idOrder;
		this.amount = amount;
		this.date = date;
		this.idCustomer = idCustomer;
	}
/**
 * Constructeur permettant la création d'une commande, il prend 3 paramètres
 * @param amount double
 * @param date Date
 * @param idCustomer int
 */
	public Order(double amount, Date date, int idCustomer) {
		this.amount = amount;
		this.date = date;
		this.idCustomer = idCustomer;
	}
/**
 * Méthode permettant de récupérer l'id de la commande
 * @return idOrder int
 */
	public int getIdOrder() {
		return idOrder;
	}
/**
 * Méthode permettant de modifier l'id de la commande.
 * @param idOrder
 */
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
/**
 * Méthode permettant de récupérer la somme de la commande.
 * @return amount double
 */
	public double getAmount() {
		return amount;
	}
/**
 * Méthode permettant de modifier la somme de la commande.
 * @param amount double
 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
/**
 * Méthode permettant de récupérer la date de la commande.
 * @return date Date
 */
	public Date getDate() {
		return date;
	}
/**
 * Méthode permettant de modifier la date de la commande
 * @param date Date
 */
	public void setDate(Date date) {
		this.date = date;
	}
/**
 * Méthode permettant de récupérer l'id du client de la commande
 * @return idCustomer int
 */
	public int getIdCustomer() {
		return idCustomer;
	}
/**
 * Méthode permettant de modifier l'id du client de la commande
 * @param idCustomer int
 */
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
/**
* Méthode toString redéfinie, elle retourne l'affichage de l'id, de la somme et de la date de la commande. 
*/
	@Override
	public String toString() {
		return idOrder + " - " + amount + " - " + date;
	}
	
}
