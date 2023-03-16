package fr.fms.business;

import java.util.ArrayList;
import java.util.HashMap;

import fr.fms.dao.CategoryDao;
import fr.fms.dao.CustomerDao;
import fr.fms.dao.OrderDao;
import fr.fms.dao.TrainingDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.Training;
import fr.fms.entities.User;

public class JobImpl implements Job {
	private HashMap<Integer,Training> cart;
	private TrainingDao trainingDao = new TrainingDao();
	private CategoryDao categoryDao = new CategoryDao();
	private OrderDao orderDao = new OrderDao();
	private UserDao userDao = new UserDao();
	private CustomerDao customerDao = new CustomerDao();
	
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
	@Override
	public ArrayList<Training> getCart() {
		return new ArrayList<Training> (cart.values());
	}

	@Override
	public void removeTrainingFromCart(int id) {
		Training training = cart.get(id);
		if(training != null) {
			if(training.getQuantity() == 1) cart.remove(id);
			else training.setQuantity(training.getQuantity() -1);
		}
		
	}
	
	public boolean cartIsEmpty() {
		return cart.isEmpty();
	}
	public double total() {
		double total []= {0};
		cart.values().forEach((a)->total [0] +=a.getQuantity()*a.getPrice());
		 return total[0];
	}
//	public void Order() {
//		Order order = cart.values();
//		if(orderDao.create(order))
//	}
	public boolean findUserByLogin(String log) {
		User user = userDao.readUserByLogin(log);
		if(user != null) return true;
		else return false;
	}
	public boolean findUserByLoginAndPwd(String log, String pwd) {
		User user = userDao.readUserByLaP(log,pwd);
		if(user != null) return true;
		else return false;
	}
	public void clearCart() {
		cart.clear();		
	}
	public void addUser(String log, String pwd) {
		userDao.create(new User(log, pwd));
	}
	public void addCustomer(Customer customer) {
		customerDao.create(customer);
	}
}
