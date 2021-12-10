package pe.edu.uni.sisteventasapp.prueba;

import java.util.List;
import java.util.Map;
import pe.edu.uni.sisteventasapp.dto.ClienteDto;
import pe.edu.uni.sisteventasapp.service.ConsultaService;
import pe.edu.uni.sisteventasapp.service.CrudClienteService;
import pe.edu.uni.sisteventasapp.service.impl.ConsultaServiceImpl;
import pe.edu.uni.sisteventasapp.service.impl.CrudClienteServiceImpl;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba09 {
	
	public static void main(String[] args) {
		try {
			// Variables
			ConsultaService service = new ConsultaServiceImpl();
			List<Map<String, ?>> lista = null;
			// Proceso
			lista = service.consultaComision(2021, 12);
			// Reporte
			for (Map<String, ?> rec : lista) {
				System.out.println(rec.get("NOMBRE") + " - "
						  + rec.get("COMISION"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
