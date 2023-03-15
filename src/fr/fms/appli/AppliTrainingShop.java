package fr.fms.appli;

import java.util.Scanner;

public class AppliTrainingShop {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Bonjour et bienvenu dans la boutique de formations informatiques ");
		
		int choice = 0;
		while(choice != 8) {
			displayMenu();
			choice = scanInt();
			switch(choice) {
				case 1 : 				
					break;					
				case 2 : //removeArticle();
					break;					
				case 3 :// displayCart(true);
					break;					
				case 4 : //displayArticles();
					break;						
				case 5 : //displayCategories();
					break;
				case 6 : //displayArticlesByCategoryId();
					break;
				case 7 :// connection();
					break;
				case 8 : System.out.println("A bientôt dans notre boutique :)");
					break;					
				default : System.out.println("Veuillez saisir une valeur entre 1 et 8");
			}
		}

	}
	public static void displayMenu() {	
		System.out.println("\n" + "Pour réaliser une action, saisissez le code correspondant");
		System.out.println("1 : Afficher toutes les formations disponibles");
		System.out.println("2 : Afficher les formations par catégorie");
		System.out.println("3 : Afficher les formations par mot clé");
		System.out.println("4 : Afficher les formations par localisation");
		System.out.println("5 : ");
		System.out.println("6 : ");
		System.out.println("7 : Connexion(Deconnexion) à votre compte");
		System.out.println("8 : Sortir de l'application");
	}
	public static int scanInt() {
		while(!scan.hasNextInt()) {
			System.out.println("saisissez une valeur entière svp");
			scan.next();
		}
		return scan.nextInt();
	}
}
