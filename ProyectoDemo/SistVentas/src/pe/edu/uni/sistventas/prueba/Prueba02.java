package pe.edu.uni.sistventas.prueba;

import java.sql.*;
import pe.edu.uni.sistventas.db.AccesoDB;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba02 {

	public static void main(String[] args) {

		try {
			Connection cn = AccesoDB.getConnection();
			System.out.println("Conexión ok.");
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
