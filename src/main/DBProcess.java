package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

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
		List<HashMap<String, String>> rs = sql.ExecuteQuery("SELECT id FROM user WHERE email = ? AND password = ?", email, pass);
		
		if(rs.size() < 1){
			return -1;
		}
		
		int id;
		id = Integer.parseInt(rs.get(0).get("id"));
		return id;
	}
	
	public static boolean existsUser(String email){
		List<HashMap<String, String>> rs = sql.ExecuteQuery("SELECT id FROM user WHERE email = ?",email);
		
		if(rs.size() < 1){
			return false;
		}
		
		int id;
		id = Integer.parseInt(rs.get(0).get("id"));
		
		return (id!=-1);
	}
	
	public static int getNextId(){
		int a = 0;
		return a;
	}
	
	public static boolean signUp(String email, String password){
		if(!existsUser(email)){
			List<HashMap<String, String>> rs = sql.ExecuteQuery("INSERT INTO user (id,email,password,guidemode,level_id,info) VALUES (?,?,?,0,1)",email,password);
		}
		return false;
	}
	
	
	
}
