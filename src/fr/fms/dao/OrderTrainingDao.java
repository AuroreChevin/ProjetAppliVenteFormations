package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.OrderTraining;

public class OrderTrainingDao implements Dao<OrderTraining>{

	@Override
	public boolean create(OrderTraining obj) {
		String str = "INSERT INTO T_OrderTraining (IdTraining, Quantity, UnitaryPrice, IdOrder) VALUES (?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){	
			ps.setInt(1, obj.getIdTraining());
			ps.setInt(2, obj.getQuantity());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(4, obj.getIdOrder());
			
			ps.executeUpdate();			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(OrderTraining obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(OrderTraining obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderTraining read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderTraining> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
