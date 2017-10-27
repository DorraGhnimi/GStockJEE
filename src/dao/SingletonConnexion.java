package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//pour ne pas creer une connexion a chaque requet(our tous les utilisatuers)
public class SingletonConnexion {

	
	private static Connection connection;
	
	//bloc static va s'execute le premier lorsque la classe est chargee 
	static {
		
		
		try {
			//charger le pilote jdbc
			Class.forName("com.mysql.jdbc.Driver");
			
			//creer la cnx
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GStockJEE","root","");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public static Connection getConnection() {
		return connection;
	}
	
	
	
	
}
