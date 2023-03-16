package fr.fms.appli;

import java.util.HashMap;
import java.util.Scanner;
import fr.fms.business.JobImpl;
import fr.fms.entities.Training;
/**
 * Application console de vente de formations permettant d'exploiter une couche métier/dao 
 * pour créer un panier en ajoutant ou retirant des formations, puis passer commande, 
 * cela crée une commande en base avec tous les éléments associés
 * @author ChevinA 2023
 *
 */
public class AppliTrainingShop {
	public static Scanner scan = new Scanner(System.in);
	public static JobImpl business = new JobImpl();
	public static void main(String[] args) {
		System.out.println("Bonjour et bienvenu dans la boutique de formations informatiques ");
		
		int choice = 0;
		while(choice != 8) {
			displayMenu();
			choice = scanInt();
			switch(choice) {
				case 1 : displayAllTrainings();				
					break;					
				case 2 : displayTrainingsByCat();
					break;					
				case 3 : displayTrainingByWord();
					break;					
				case 4 : displayTrainingByLocalisation();
					break;						
				case 5 : addTraining();
					break;
				case 6 : removeTraining();
					break;
				case 7 :// connection();
					break;
				case 8 :// connection();
					break;
				case 9 : System.out.println("A bientôt dans notre boutique :)");
					break;					
				default : System.out.println("Veuillez saisir une valeur entre 1 et 8");
			}
		}

	}
/**
* Méthode qui affiche le menu principale
*/
	public static void displayMenu() {	
		System.out.println("\n" + "Pour réaliser une action, saisissez le chiffre correspondant");
		System.out.println("1 : Afficher toutes les formations disponibles");
		System.out.println("2 : Afficher les formations par catégorie");
		System.out.println("3 : Afficher les formations par mot clé");
		System.out.println("4 : Afficher les formations par mode d'apprentissage");
		System.out.println("5 : Ajouter une formation au panier");
		System.out.println("6 : Retirer une formation du panier");
		System.out.println("7 : Afficher mon panier + total pour passer commande");
		System.out.println("8 : Connexion(Deconnexion) à votre compte");
		System.out.println("9 : Sortir de l'application");
	}
	public static int scanInt() {
		while(!scan.hasNextInt()) {
			System.out.println("saisissez une valeur entière svp");
			scan.next();
		}
		return scan.nextInt();
	}
	public static String scanString() {
		scan.nextLine();
		while(scan.hasNextInt()) {
			System.out.println("saisissez un mot svp");
			scan.nextLine();
		}
		return scan.nextLine();
	}
	public static void displayAllTrainings() {
		System.out.println("Voici la liste de nos formations disponibles :\n ");
		business.readTraining().forEach(System.out::println);
	}
/**
* Méthode qui affiche toutes les formations par catégorie
*/
	public static void displayTrainingsByCat() {
		System.out.println("Voici la liste des catégories des formations :\n ");
		business.readCategories().forEach(System.out::println);
		System.out.println("Saisissez le chiffre de la catégorie que vous avez choisi : ");
		int choiceCat = scanInt();
		if(business.readOneCategory(choiceCat) != null) {
			System.out.println("Vous avez choisi la catégorie : "+business.readOneCategory(choiceCat).getCatName());
			business.readTrainingByCat(choiceCat).forEach(System.out::println);
		}
		else
			System.out.println("Cette catégorie n'existe pas");
	}
/**
* Méthode qui affiche toutes les formations par mot saisi
*/
	public static void displayTrainingByWord() {		
		System.out.println("Saisissez un mot : ");
		String keyWord = scanString();
		if(business.findTrainingByKeyWord(keyWord) != null) {
			System.out.println("Voici les formations contenant le mot : " +keyWord);
			business.findTrainingByKeyWord(keyWord).forEach(System.out::println);
		}
		else
			System.out.println("Aucune formation ne contient le mot : " +keyWord);
	}
/**
* Méthode qui affiche toutes les formations par mode d'apprentissage
*/
	public static void displayTrainingByLocalisation() {
//		int choice = 0;
		String str = "";
//		while(choice > 2 || choice == 0) {
			System.out.println("\nVoici les modes d'apprentissage des formations : Présentiel ou Distanciel");
			System.out.println("Saisissez le mode choisi : ");
			str = scanString().toLowerCase();
			if(str.matches("présentiel") || str.matches("distanciel")) {
			if(business.findTrainingByLocalisation(str) != null) {
				System.out.println("Vous avez choisi le mode : "+str);
				business.findTrainingByLocalisation(str).forEach(System.out::println);
			}}
//			System.out.println("1 : Présentiel ");
//			System.out.println("2 : Distanciel ");
//			choice = scanInt();
//			if(choice >0 && choice <= 2) {
//				System.out.println("Vous avez choisi le mode : "+business.readOneTraining(choice).getLocalisation());
//				business.findTrainingByLocalisation(business.readOneTraining(choice).getLocalisation()).forEach(System.out::println);
//			}
			else System.out.println("Je n'ai pas compris votre choix");
//		}
	}
/**
* Méthode qui ajoute une formation au panier
*/
	public static void addTraining() {
		displayAllTrainings();
		System.out.println("\nSaisissez le chiffre de la formation à ajouter au panier");
		int choice = scanInt();
		Training training = business.readOneTraining(choice);
		if(training != null) {
			business.addToCart(training);
			displayCart();
		}
		else System.out.println("Votre saisie ne correspond à aucune formation");
	}
/**
* Méthode qui affiche le contenu du panier
*/
	public static void displayCart() {
		if(business.cartIsEmpty()) System.out.println("VOTRE PANIER EST VIDE");
		else{
			System.out.println("CONTENU DU PANIER");
			for(Training t : business.getCart()) System.out.println(t+" - Quantité : " +t.getQuantity());
		}
		
	}
/**
 * Méthode qui retire une formation du panier
 */
	public static void removeTraining() {
		displayCart();
		System.out.println("Saisissez le chiffre de la formation que vous voulez supprimer : ");
		int choice = scanInt();
		business.removeTrainingFromCart(choice);
		displayCart();
	}
	
}
