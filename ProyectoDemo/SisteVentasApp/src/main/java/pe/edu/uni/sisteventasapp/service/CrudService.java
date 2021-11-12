package pe.edu.uni.sisteventasapp.service;

import java.util.List;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public interface CrudService<T> {
	
	T read(Integer id);
	
	List<T> read(T bean);
	
	List<T> readAll();	
	
	void create(T bean);
	
	void update(T bean);
	
	void delete(Integer id);

}
