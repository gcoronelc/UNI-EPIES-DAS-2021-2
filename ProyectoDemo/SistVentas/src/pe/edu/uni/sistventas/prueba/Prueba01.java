package pe.edu.uni.sistventas.prueba;

import java.sql.*;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba01 {

	public static void main(String[] args) {

		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String urlDB = "jdbc:sqlserver://EGCC2020:1433;databaseName=bdautos";
		String user = "sa";
		String pass = "sql";

		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			Connection cn = DriverManager.getConnection(urlDB, user, pass);
			System.out.println("Conexión ok.");
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
