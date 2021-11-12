package pe.edu.uni.sisteventasapp.controller;

import pe.edu.uni.sisteventasapp.dto.EmpleadoDto;
import pe.edu.uni.sisteventasapp.service.impl.LogonServiceImpl;
import pe.edu.uni.sisteventasapp.util.Session;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class LogonController {

	private LogonServiceImpl logonService;

	public LogonController() {
		logonService = new LogonServiceImpl();
	}

	public void validarUsuario(String usuario, String clave) {
		EmpleadoDto dto = logonService.validarUsuario(usuario, clave);
		Session.put("USUARIO", dto);
	}

}
