package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Customer;

public class CustomerDao implements Dao<Customer>{

	@Override
	public boolean create(Customer obj) {
		String str = "INSERT INTO T_Customers (Name,FirstName,Email,Phone,address,idUser) VALUES (?,?,?,?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getFirstname());			
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getPhone());
			ps.setString(5, obj.getAddress());
			ps.setInt(6, obj.getIdUser());
			ps.execute();
			try(ResultSet generatedKeySet = ps.getGeneratedKeys()){
				if(generatedKeySet.next()) {
					//obj.setIdCustomer(0);
					return true;
				}	
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} 				
		return false;
	}

	@Override
	public Customer read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Customer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Customer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String strSql = "SELECT * FROM T_Customers";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int idCustomer = resultSet.getInt(1);	
					String name = resultSet.getString(2);
					String fisrtName = resultSet.getString(3);
					String email = resultSet.getString(4);
					String tel = resultSet.getString(5);
					String address = resultSet.getString(5);
					int idUser = resultSet.getInt(6);
					customers.add((new Customer(idCustomer,name,fisrtName,email,tel,address,idUser)));						
				}
			return customers;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return null;
	}

}
