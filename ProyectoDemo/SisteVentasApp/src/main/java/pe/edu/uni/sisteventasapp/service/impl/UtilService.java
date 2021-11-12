package pe.edu.uni.sisteventasapp.service.impl;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class UtilService {

	private UtilService() {
	}
	
	public static Integer ceroToNull(Integer dato){
		if( dato != null && dato.intValue() == 0 ){
			dato = null;
		}
		return dato;
	}
	
	public static String preparaString(String dato){
		if(dato != null){
			dato = dato.trim();
			if(dato.length() == 0){
				dato = null;
			} else {
				dato = "%" + dato + "%";
			}
		}
		return dato;
	}
	
	public static void main(String[] args) {
		
		String dato = "   ";
		dato = preparaString(dato);
		System.out.println(dato);
		
	}

}
