package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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
	
	public static int getNextId(String tableName){

		List<HashMap<String, String>> rs = sql.ExecuteQuery("SELECT MAX(id) as max_val FROM `" + tableName + "`");
		
		if(rs.size() < 1){
			return -1;
		}
		
		//debugPrint(rs);
		
		int id;
		id = Integer.parseInt(rs.get(0).get("max_val"));
		return id+1;
	}
	
	public static boolean signUp(String email, String password){
		if(!existsUser(email)){
			int rs = sql.ExecuteUpdate(
						"INSERT INTO user (id,email,password,guidemode,level_id,info) VALUES (?,?,?,0,1,'')",
						String.valueOf(getNextId("user")),email,password);
			return true;
		}
		return false;
	}
	
	
	static void debugPrint(List<HashMap<String,String>> list){
		System.out.println("Printing shit of size :" + list.size());
		for(HashMap<String,String> map : list){
			for(Entry<String,String> e : map.entrySet()) {
				System.out.printf("%20s", e.getValue());
				
			}
			System.out.println();
		}
	}
	
	
}
