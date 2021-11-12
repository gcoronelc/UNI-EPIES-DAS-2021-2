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
public class Prueba05 {

	public static void main(String[] args) {
		try {
			// Variables
			List<ClienteDto> lista;
			// Proceso
			CrudClienteService clienteService = new CrudClienteServiceImpl();
			lista = clienteService.readAll();
			// Reporte
			for (ClienteDto bean : lista) {
				System.out.println(bean.getIdcliente() + " - " 
						  + bean.getApellido() + " - " + bean.getNombre() + " - " +  bean.getCorreo());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
