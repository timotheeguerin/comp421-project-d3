package main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBProcess{
	public static SQLConnection sql = new SQLConnection("bendodev.no-ip.org","comp421project", "root", "madremia350");

	static boolean firstResult(ResultSet rs){
		try{
			
			if(!rs.next()){
				return false;
			}
			
			return true;
		} catch (SQLException e) {
			System.out.println("Caca");
			return false;
		}
		
	}
	
	public static int loginUser(String email, String pass) {
		ResultSet rs = sql.ExecuteQuery("SELECT id FROM user WHERE email = ? AND password = ?", email, pass);
		
		if(!firstResult(rs)){
			
			return -1;
		}
		
		int id;
		try {
			id = rs.getInt(1);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	
	
}
