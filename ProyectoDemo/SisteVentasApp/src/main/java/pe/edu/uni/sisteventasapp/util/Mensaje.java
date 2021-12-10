package pe.edu.uni.sisteventasapp.util;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Mensaje {

	private Mensaje() {
	}

	public static void info(Component padre, String mensaje) {
		JOptionPane.showMessageDialog(padre, mensaje, "SISTEMAS DE VENTAS - Mensaje",
				  JOptionPane.INFORMATION_MESSAGE);
	}

	public static void error(Component padre, String mensaje) {
		JOptionPane.showMessageDialog(padre, mensaje, "SISTEMAS DE VENTAS - Error",
				  JOptionPane.ERROR_MESSAGE);
	}

	public static String showSelectExcelFile(Component parent) {
		// Variable para el nombre del archivo
		String archivo = "";
		//Creamos el objeto JFileChooser
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Ubicación y nombre del archivo");
		//Creamos el filtro
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.XLS", "xls");
		//Le indicamos el filtro
		fc.setFileFilter(filtro);
		//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
		int seleccion = fc.showOpenDialog(parent);
		// Verificar respuesta
		// Si el usuario, pincha en aceptar
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			// Seleccionamos el fichero
			File fichero = fc.getSelectedFile();
			// Obtener ruta del archivo seleccionado
			archivo = fichero.getAbsolutePath();
			String tipo = archivo.toUpperCase();
			if (!tipo.endsWith(".XLS")) {
				archivo += ".xls";
			}
		}
		return archivo;
	}

}
