package pe.edu.uni.sisteventasapp.controller;

import java.util.List;
import java.util.Map;
import pe.edu.uni.sisteventasapp.service.ConsultaService;
import pe.edu.uni.sisteventasapp.service.impl.ConsultaServiceImpl;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class ConsultaController {
	
	private ConsultaService consultaService;

	public ConsultaController() {
		consultaService = new ConsultaServiceImpl();
	}
	
	public List<Map<String, ?>> consultaComision(Integer anio, Integer mes) {
		return consultaService.consultaComision(anio, mes);
	}
}
