package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.UserModel;
public class UserDao {

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/project7";
	String u = "root";
	String p = "74159";
	String add_user = "insert into users values (default , ? , ? , ?)";
	String update_user = "update users set name=? , email=? , country=? where id=? ";
	String delete_user = "delete from users where id=?";
	String select_user_by_id = "select * from users where id=?";
	String select_all_users = "select* from users";
	
	public Connection get_connection() throws SQLException, ClassNotFoundException {
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,u,p);
		return con;
	}
	
	public int add_user(String name , String email , String country) throws SQLException, ClassNotFoundException {
		
		PreparedStatement ps = get_connection().prepareStatement(add_user);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, country);
		int result = ps.executeUpdate();
		
		return result;
		
	}
	
	public int update_user( int id , String user , String email , String country ) throws SQLException, ClassNotFoundException {
		
		PreparedStatement ps = get_connection().prepareStatement(update_user);
		ps.setInt(4, id);
		ps.setString(1, user);
		ps.setString(2, email);
		ps.setString(3, country);
		int result = ps.executeUpdate();
		return result ;	
	}
	
	public int  delete_user(int id) throws SQLException, ClassNotFoundException {
		
		PreparedStatement ps = get_connection().prepareStatement(delete_user);
		ps.setInt(1, id);
		int result = ps.executeUpdate();
		return result;
	}
	
	public UserModel select_user_by_id(int id) throws SQLException, ClassNotFoundException {
		
		PreparedStatement ps = get_connection().prepareStatement(select_user_by_id);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		UserModel um = new UserModel();
		if(rs.next()) {
			
			um.setId(rs.getInt(1));
			um.setName(rs.getString(2));
			um.setEmail(rs.getString(3));
			um.setCountry(rs.getString(4));
		}
			return um ;
			
		}
		
	public List<UserModel> select_all_user() throws SQLException, ClassNotFoundException {
		
		PreparedStatement ps = get_connection().prepareStatement("select * from users" , PreparedStatement.RETURN_GENERATED_KEYS);
		ps.getGeneratedKeys();
		ResultSet rs = ps.executeQuery();
		List<UserModel>um = new ArrayList<>();
		while(rs.next()) {
		 um.add(new UserModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		}
		return um ;
	}	
		
		
	} 
	

