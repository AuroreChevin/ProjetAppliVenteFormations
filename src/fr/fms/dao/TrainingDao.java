package fr.fms.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.fms.entities.Training;
/**
 * Composant d'accès aux données de la table T_Trainings dans la base de données TrainingShop
 * @author ChevinA 2023
 *
 */
public class TrainingDao implements Dao<Training> {
/**
 * Méthode qui créé une nouvelle formation dans la table t_trainings, elle renvoie true
 * lorsque l'insertion est réussie
 */
	@Override
	public boolean create(Training obj) {
		String str = "INSERT INTO T_Trainings (Name, Description, NbOfDays, Localisation, UnitaryPrice, IdCategory) VALUES (?,?,?,?,?,?);";
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getNbOfDays());
			ps.setString(4, obj.getLocalisation());
			ps.setDouble(5, obj.getPrice());
			ps.setInt(6, obj.getIdCategory());
			if(ps.executeUpdate() == 1)  return true;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Training read(int id) {		
		try(Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Trainings WHERE IdTraining = " + id + ";";
			ResultSet rs = statement.executeQuery(str);
				if(rs.next()) return new Training(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDouble(6),rs.getInt(7));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
/**
* Méthode qui met à jour une formation dans la table t_trainings, elle renvoie true
 * lorsque la mise à jour est réussie
*/
	@Override
	public boolean update(Training obj) {
		String str = "UPDATE T_Trainings set Name = ?, Description=? , NbOfDays= ?, Localisation = ?, UnitaryPrice=? where idArticle=?;";
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getNbOfDays());
			ps.setString(4, obj.getLocalisation());
			ps.setDouble(5, obj.getPrice());
			if(ps.executeUpdate() == 1)  return true;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Méthode qui supprime une formation dans la table t_trainings, elle renvoie true
	 * lorsque la suppression est réussie
	 */
	@Override
	public boolean delete(Training obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Trainings where IdTrainings =" + obj.getIdTraining() + ";";									
			statement.executeUpdate(str);		
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
/**
* Méthode qui renvoie la liste des formations contenues dans la table t_trainings
*/
	@Override
	public ArrayList<Training> readAll() {
		ArrayList<Training> trainings = new ArrayList<Training>();
		String str = "SELECT * FROM T_Trainings";
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(str)){				
				while(resultSet.next()) {
					int rsIdUser = resultSet.getInt(1);
					String rsName= resultSet.getString(2);
					String rsDescription = resultSet.getString(3);
					int rsNbOfDays = resultSet.getInt(4);
					String rsLocalisation = resultSet.getString(5);
					double rsPrice = resultSet.getDouble(6);
					trainings.add((new Training(rsIdUser, rsName, rsDescription, rsNbOfDays, rsLocalisation, rsPrice)));
				}
				return trainings;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
/**
 * Méthode qui lit les formations d'une catégorie choisie
 * @param id
 * @return liste des formations d'une catégorie
 */
	public ArrayList<Training> readAllByCategory(int id) {
		ArrayList<Training> trainings = new ArrayList<Training>();
		String strSql = "SELECT * FROM T_Trainings where idCategory=" + id;		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);
					String rsName= resultSet.getString(2);
					String rsDescription = resultSet.getString(3);
					int rsNbOfDays = resultSet.getInt(4);
					String rsLocalisation = resultSet.getString(5);
					double rsPrice = resultSet.getDouble(6);		
					trainings.add((new Training(rsId,rsName,rsDescription,rsNbOfDays,rsLocalisation,rsPrice)));						
				}	
				return trainings;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return null;
	}
	/**
	 * Méthode qui lit les formations d'un mode d'apprentissage choisi
	 * @param str localisation
	 * @return liste des formations d'un mode d'apprentissage 
	 */
	public ArrayList<Training> readAllByLocalisation(String str) {
		ArrayList<Training> trainings = new ArrayList<Training>();
		String strSql = "SELECT * FROM T_Trainings where Localisation IN ('"+ str+"')";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);
					String rsName= resultSet.getString(2);
					String rsDescription = resultSet.getString(3);
					int rsNbOfDays = resultSet.getInt(4);
					String rsLocalisation = resultSet.getString(5);
					double rsPrice = resultSet.getDouble(6);		
					trainings.add((new Training(rsId,rsName,rsDescription,rsNbOfDays,rsLocalisation,rsPrice)));						
				}
				return trainings;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return null;
	}
	/**
	 * Méthode qui lit les formations contenant un mot clé
	 * @param str mot clé
	 * @return liste des formations contenant le mot clé 
	 */
	public ArrayList<Training> readAllByKeyWord(String str) {
		ArrayList<Training> trainings = new ArrayList<Training>();
		String strSql = "SELECT * FROM T_Trainings inner join t_categories on t_trainings.idcategory = t_categories.idcategory WHERE name LIKE '%"+ str+"%' "
				+ "or t_trainings.description like '%"+ str+"%' or Localisation like '%"+ str+"%' or t_categories.description like '%"+ str+"%' or catname like '%"+ str+"%'";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);
					String rsName= resultSet.getString(2);
					String rsDescription = resultSet.getString(3);
					int rsNbOfDays = resultSet.getInt(4);
					String rsLocalisation = resultSet.getString(5);
					double rsPrice = resultSet.getDouble(6);		
					trainings.add((new Training(rsId,rsName,rsDescription,rsNbOfDays,rsLocalisation,rsPrice)));						
				}
				return trainings;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return null;
	}
}
