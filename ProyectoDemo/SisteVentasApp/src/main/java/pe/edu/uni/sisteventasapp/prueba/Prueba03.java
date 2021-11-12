package pe.edu.uni.sisteventasapp.prueba;

import pe.edu.uni.sisteventasapp.dto.EmpleadoDto;
import pe.edu.uni.sisteventasapp.service.impl.LogonServiceImpl;


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
			LogonServiceImpl logonService = new LogonServiceImpl();
			EmpleadoDto dto = logonService.validarUsuario(usuario, clave);
			// Reporte
			System.out.println("Hola " + dto.getNombre() + " " + dto.getApellido());
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

}
