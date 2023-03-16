package fr.fms.appli;

import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.dao.CategoryDao;
import fr.fms.dao.TrainingDao;
import fr.fms.entities.Category;
import fr.fms.entities.Training;

public class TestShop {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Training> trainings = new ArrayList<Training>();
		ArrayList<Category> categories = new ArrayList<Category>();
		Training t1;
		CategoryDao categoryDao = new CategoryDao();
		TrainingDao trainingDao = new TrainingDao();
		t1 = trainingDao.read(1); System.out.println(t1);
		categories = categoryDao.readAll();
		categories.forEach((c) -> {System.out.println(c);});
		System.out.println();
//		trainings = trainingDao.readAllByCategory(1);
//		trainings = trainingDao.readAllByLocalisation("Distanc1el");
		trainings = trainingDao.readAllByKeyWord("q");
		System.out.println();
//		trainings = trainingDao.readAll();
		trainings.forEach((t) -> {System.out.println(t);});
		
	}

}
