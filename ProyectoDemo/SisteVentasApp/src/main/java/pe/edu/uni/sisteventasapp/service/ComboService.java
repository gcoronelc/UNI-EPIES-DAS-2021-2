package pe.edu.uni.sisteventasapp.service;

import java.util.List;
import pe.edu.uni.sisteventasapp.dto.ComboDto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public interface ComboService extends RowMapper<ComboDto> {

	List<ComboDto> obtenerClientes();

	List<ComboDto> obtenerMarcas();

	List<ComboDto> obtenerAutosDisponibles(Integer idMarca);

	List<ComboDto> obtenerAutosReservados(Integer idMarca);
}
