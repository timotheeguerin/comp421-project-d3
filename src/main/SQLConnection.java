package main;

import java.sql.*;

public class SQLConnection {
	//bendodev.no-ip.org:3306/comp421project?" + "user=root&password=madremia350");
	private final String MYSQL_DRIVER_CLASS = "org.gjt.mm.mysql.Driver";
	
	public Connection db;
	
	public SQLConnection(String url,String dbName, String user, String password) {
		try {
			Class.forName(MYSQL_DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			System.out.println("Class: " + MYSQL_DRIVER_CLASS + " not found.");
			e.printStackTrace();
		}
		
		try {
			db = DriverManager.getConnection("jdbc:mysql://" + url + "/"+ dbName + "?" +  "user=" + user + "&password=" + password);
		} catch (SQLException e) {
			System.out.println("Couldn't connect to " + url + ".");
			e.printStackTrace();
		}
	}
	
	public void CloseConnection() {
		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Couldnt close DB Connection");
			e.printStackTrace();
		}
	}
	
	public ResultSet ExecuteQuery(String query, String... args) {
		try {
			PreparedStatement st = db.prepareStatement(query);
			for(int i = 0;i<args.length;i++){
				st.setString(i+1, args[i]);
			}
			System.out.println(st.toString());
			ResultSet rs = st.executeQuery();
			return rs;
		} catch(SQLException e){
			System.out.println("Couldn't execute query");
			e.printStackTrace();
			return null;
		}
	}

	
}
