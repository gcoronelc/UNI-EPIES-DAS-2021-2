package pe.edu.uni.sisteventasapp.prueba;

import java.util.List;
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
public class Prueba07 {

	public static void main(String[] args) {
		try {
			// Variables
			ClienteDto bean = new ClienteDto();
			// Dato
			bean.setNombre("JOSE");
			bean.setApellido("RUIZ");
			bean.setDni("54679823");
			bean.setTelefono("987645897");
			bean.setCorreo("jruiz@hotmail.com");
			// Proceso
			CrudClienteService clienteService = new CrudClienteServiceImpl();
			clienteService.create(bean);
			// Reporte
			System.out.println("Código del cliente: " + bean.getIdcliente());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
