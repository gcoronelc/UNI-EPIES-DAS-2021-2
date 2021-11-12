package pe.edu.uni.sisteventasapp.prueba;

import pe.edu.uni.sisteventasapp.dto.ClienteDto;
import pe.edu.uni.sisteventasapp.service.CrudClienteService;
import pe.edu.uni.sisteventasapp.service.impl.CrudClienteServiceImpl;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba04 {

	public static void main(String[] args) {
		try {
			// Datos
			Integer id = 3;
			// Proceso
			CrudClienteService clienteService = new CrudClienteServiceImpl();
			ClienteDto bean = clienteService.read(id);
			// Reporte
			System.out.println("Id: " + bean.getIdcliente());
			System.out.println("Apellido: " + bean.getApellido());
			System.out.println("Nombre: " + bean.getNombre());
			System.out.println("Correo: " + bean.getCorreo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
