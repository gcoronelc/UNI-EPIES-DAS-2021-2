package pe.edu.uni.sisteventasapp.controller;

import java.util.List;
import pe.edu.uni.sisteventasapp.dto.AutoDto;
import pe.edu.uni.sisteventasapp.dto.ClienteDto;
import pe.edu.uni.sisteventasapp.dto.ComboDto;
import pe.edu.uni.sisteventasapp.service.ComboService;
import pe.edu.uni.sisteventasapp.service.CrudAutoService;
import pe.edu.uni.sisteventasapp.service.CrudClienteService;
import pe.edu.uni.sisteventasapp.service.impl.ComboServiceImpl;
import pe.edu.uni.sisteventasapp.service.impl.CrudAutoServiceImpl;
import pe.edu.uni.sisteventasapp.service.impl.CrudClienteServiceImpl;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class VentaController {
	
	private ComboService comboService;
	private CrudAutoService autoService;

	public VentaController() {
		comboService = new ComboServiceImpl();
		autoService = new CrudAutoServiceImpl();
	}
	
	public List<ComboDto> obtenerClientes(){
		return comboService.obtenerClientes();
	}
	
	public List<ComboDto> obtenerMarcas(){
		return comboService.obtenerMarcas();
	}
	
	public List<ComboDto> obtenerAutosDisponibles(Integer idMarca) {
		return comboService.obtenerAutosDisponibles(idMarca);
	}
	
	public AutoDto traerAutoPorId(Integer id){
		return autoService.read(id);
	}
	

}
