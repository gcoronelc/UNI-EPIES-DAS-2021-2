package pe.edu.uni.sisteventasapp.prueba;

import pe.edu.uni.sisteventasapp.dto.VentaDto;
import pe.edu.uni.sisteventasapp.service.VentaService;
import pe.edu.uni.sisteventasapp.service.impl.VentaServiceImpl;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class Prueba08 {

	public static void main(String[] args) {
		try {
			// Variables
			VentaDto bean = new VentaDto();
			// Dato
			bean.setIdauto(1);
			bean.setIdcliente(2);
			bean.setVendedor(1);
			bean.setImporte(0.0);
			bean.setImpuesto(0.0);
			bean.setTotal(0.0);
			// Proceso
			VentaService ventaService = new VentaServiceImpl();
			ventaService.grabarVenta(bean);
			// Reporte
			System.out.println("Proceso ok.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
