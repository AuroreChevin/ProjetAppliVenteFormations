package fr.fms.business;

import java.util.ArrayList;
import java.util.HashMap;

import fr.fms.dao.CategoryDao;
import fr.fms.dao.TrainingDao;
import fr.fms.entities.Category;
import fr.fms.entities.Training;

public class JobImpl implements Job {
	private HashMap<Integer,Training> cart;
	private TrainingDao trainingDao = new TrainingDao();
	private CategoryDao categoryDao = new CategoryDao();
	
	public JobImpl() {
		this.cart = new HashMap<Integer,Training>();
	}

	@Override
	public ArrayList<Training> readTraining() {
		return trainingDao.readAll();
	}

	@Override
	public Training readOneTraining(int id) {
		return trainingDao.read(id);
	}

	@Override
	public ArrayList<Category> readCategories() {
		return categoryDao.readAll();
	}

	@Override
	public ArrayList<Training> readTrainingByCat(int id) {
		return trainingDao.readAllByCategory(id);
	}

	@Override
	public Category readOneCategory(int id) {
		return categoryDao.read(id);
	}

	@Override
	public ArrayList<Training> findTrainingByKeyWord(String str) {
		return trainingDao.readAllByKeyWord(str);
	}

	@Override
	public ArrayList<Training> findTrainingByLocalisation(String str) {
		return trainingDao.readAllByLocalisation(str);
	}

	@Override
	public void addToCart(Training training) {
		Training trg = cart.get(training.getIdTraining());
		if(trg != null) {
			trg.setQuantity(trg.getQuantity() +1);
		}
		else
			cart.put(training.getIdTraining(), training);
		
	}

	public ArrayList<Training> getCart() {
		return new ArrayList<Training> (cart.values());
	}

//	public void setCart(HashMap<Integer, Training> cart) {
//		this.cart = cart;
//	}
//	
}
