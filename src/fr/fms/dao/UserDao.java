package fr.fms.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.fms.entities.User;

public class UserDao implements Dao<User>{

	@Override
	public boolean create(User obj) {
		String str = "INSERT INTO T_Users (Login,Password) VALUES (?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());			
			if( ps.executeUpdate() == 1)	return true;				
		} catch (SQLException e) {
			e.printStackTrace();;
		} 
		return false;
	}

	@Override
	public User read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Users where IdUser=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) 
				return new User(rs.getInt(1) , rs.getString(2) , rs.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public boolean update(User obj) {
		try (PreparedStatement ps = connection.prepareStatement("UPDATE T_Users SET Login =?, Password =? WHERE IdUser =?;")){
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());
			ps.setInt(3, obj.getIdUser());			
			if(ps.executeUpdate() == 1) {  System.out.println("update ok");	return true;}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(User obj) {
		try(PreparedStatement ps = connection.prepareStatement("DELETE FROM T_Users WHERE IdUser = ?;")){
			ps.setInt(1, obj.getIdUser());
			if(ps.executeUpdate() == 1) { System.out.println("delete ok");return true;}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<User> readAll() {
		ArrayList<User> users = new ArrayList<User>();
		try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM T_Users")){
			try(ResultSet resultset = ps.executeQuery()){				
				while(resultset.next()) {
					int rsIdUser = resultset.getInt(1);
					String rsLogin = resultset.getString(2);
					String rsPassword = resultset.getString(3);
					users.add(new User(rsIdUser, rsLogin, rsPassword));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
}
