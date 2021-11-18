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
public class Prueba06 {

	public static void main(String[] args) {
		try {
			// Variables
			ClienteDto dto = new ClienteDto();
			List<ClienteDto> lista;
			// Dato
			//dto.setIdcliente(5);
			dto.setNombre("SA");
			dto.setApellido("RA");
			// Proceso
			CrudClienteService clienteService = new CrudClienteServiceImpl();
			lista = clienteService.read(dto);
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
