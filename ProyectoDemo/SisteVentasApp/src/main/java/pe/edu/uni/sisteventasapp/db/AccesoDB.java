package pe.edu.uni.sisteventasapp.db;

import java.sql.*;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class AccesoDB {

	private AccesoDB() {
	}

	public static Connection getConnection() throws SQLException {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String urlDB = "jdbc:sqlserver://EGCC2020:1433;databaseName=bdautos";
		String user = "sa";
		String password = "sql";
		Connection cn = null;
		try {
			// Paso 1: Cargar el driver a memoria 
			Class.forName(driver).getDeclaredConstructor().newInstance();
			// Paso 2: Obtener el objeto Connection 
			cn = DriverManager.getConnection(urlDB, user, password);
		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw new SQLException("No se encontró el driver de la base de datos.");
		} catch (Exception e) {
			throw new SQLException("No se puede establecer la conexión con la BD.");
		}
		return cn;
	}

}
