package fr.fms.business;

import java.util.ArrayList;

import fr.fms.entities.Category;
import fr.fms.entities.Training;

public interface Job {
/**
* Méthode qui renvoie toutes les de la table t_trainings en bdd
* @return Liste t_trainings en base
*/
	public ArrayList<Training> readTraining();		
/**
 * Méthode qui renvoie la formation correspondant à l'id
* @param id de la formation à renvoyer
* @return training correspondant si trouvé, null sinon
*/
	public Training readOneTraining(int id);	
	
/**
* Méthode qui renvoie toutes les catégories de la table t_categories en bdd
* @return Liste de catégories en base
*/
	public ArrayList<Category> readCategories();
/**
 * 	Méthode qui renvoie les formations correspondant à l'id d'une catégorie
 * @param id de la catégorie
 * @return Liste des formations par catégorie
 */
	public ArrayList<Training> readTrainingByCat(int id);
/**
 * Méthode qui renvoie la catégorie correspondant à l'id
 * @param id d'un catégorie
 * @return une catégorie
 */
	public Category readOneCategory(int id);
/**
 * Méthode qui renvoie la liste des formations contenant un mot clé
 * @param str
 * @return liste des formations
 */
	public ArrayList<Training> findTrainingByKeyWord(String str);

	public ArrayList<Training> findTrainingByLocalisation(String str);
/**
* méthode qui ajoute un article au panier
* @param article à ajouter
*/
	public void addToCart(Training training);
}
