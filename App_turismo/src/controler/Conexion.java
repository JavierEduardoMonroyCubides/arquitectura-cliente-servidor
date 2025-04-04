package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public Connection conectarDB() {
		//crear e inicializar un objeto de la clase connection
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_compañia_turismo","root", "2556229");
			System.out.println("conected with the database successful*ly");
		}catch (SQLException e) {
			System.out.println("error:" + e.getMessage());
		}
		
		return connection;//retorna la conexion abierta con la BD
	}
	
}