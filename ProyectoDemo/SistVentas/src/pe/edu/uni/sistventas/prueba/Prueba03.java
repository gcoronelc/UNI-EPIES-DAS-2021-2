package pe.edu.uni.sistventas.prueba;

import java.sql.*;
import pe.edu.uni.sistventas.db.AccesoDB;
import pe.edu.uni.sistventas.dto.EmpleadoDto;
import pe.edu.uni.sistventas.service.LogonService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba03 {

	public static void main(String[] args) {

		try {
			// Datos
			String usuario = "lruiz";
			String clave = "123456";
			// Proceso
			LogonService logonService = new LogonService();
			EmpleadoDto dto = logonService.validar(usuario, clave);
			// Reporte
			System.out.println("Hola " + dto.getNombre() + " " + dto.getApellido());
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

}
