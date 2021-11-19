package pe.edu.uni.sisteventasapp.controller;

import java.util.List;
import pe.edu.uni.sisteventasapp.dto.ClienteDto;
import pe.edu.uni.sisteventasapp.service.CrudClienteService;
import pe.edu.uni.sisteventasapp.service.impl.CrudClienteServiceImpl;
import pe.edu.uni.sisteventasapp.view.UtilView;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class ClienteController {

	private CrudClienteService clienteService;

	public ClienteController() {
		clienteService = new CrudClienteServiceImpl();
	}

	public List<ClienteDto> read(ClienteDto bean) {
		return clienteService.read(bean);
	}

	public void procesar(String accion, ClienteDto bean) {
		switch(accion){
			case UtilView.CRUD_CREATE:
				clienteService.create(bean);
				break;
			case UtilView.CRUD_UPDATE:
				clienteService.update(bean);
				break;
			case UtilView.CRUD_DELETE:
				clienteService.delete(bean.getIdcliente());
				break;
		}
	}

}
