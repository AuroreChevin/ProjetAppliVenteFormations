package fr.fms.entities;
/**
 * Classe des catégories possédant 3 attributs
 * @author ChevinA 2023
 *
 */
public class Category {
	private int idCategory;
	private String catName;
	private String description;
/**
 * Constructeur permettant la création d'une catégorie, il prend 3 paramètres
 * @param idCategory int 
 * @param catName String
 * @param description String
 */
	public Category(int idCategory, String catName, String description) {
		this.idCategory = idCategory;
		this.catName = catName;
		this.description = description;
	}
/**
 * 	Constructeur permettant la création d'une catégorie, il prend 2 paramètres
 * @param catName String
 * @param description String
 */
	public Category(String catName, String description) {
		this.catName = catName;
		this.description = description;
	}
/**
 * Méthode permettant de récupérer l'id de la catégorie
 * @return idCategory int
 */
	public int getIdCategory() {
		return idCategory;
	}
/**
* Méthode permettant de modifier l'id de la catégorie
* @param idCategory int
*/
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
/**
 * Méthode permettant de récupérer le nom de la catégorie
 * @return catName String
 */
	public String getCatName() {
		return catName;
	}
/**
 * Méthode permettant de modifier le nom de la catégorie
 * @param catName String
 */
	public void setCatName(String catName) {
		this.catName = catName;
	}
/**
 *Méthode permettant de récupérer la description de la catégorie 
 * @return description String
 */
	public String getDescription() {
		return description;
	}
/**
 * Méthode permettant de modifier la description de la catégorie
 * @param description String
 */
	public void setDescription(String description) {
		this.description = description;
	}
/**
 * Méthode toString redéfinie, elle retourne l'affichage de l'id, du nom et de la description d'une catégorie
 */
	@Override
	public String toString() {
		return idCategory + " - " + catName + " - " + description;
	}

	
}
