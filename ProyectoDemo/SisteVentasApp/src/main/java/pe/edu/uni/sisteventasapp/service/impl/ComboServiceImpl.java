package pe.edu.uni.sisteventasapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.sisteventasapp.db.AccesoDB;
import pe.edu.uni.sisteventasapp.dto.ClienteDto;
import pe.edu.uni.sisteventasapp.dto.ComboDto;
import pe.edu.uni.sisteventasapp.service.ComboService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class ComboServiceImpl implements ComboService {

	@Override
	public List<ComboDto> obtenerClientes() {
		String sql = "select idcliente codigo, concat(APELLIDO, ', ', NOMBRE) texto from cliente order by 2";
		return obtenerLista(sql);
	}

	@Override
	public List<ComboDto> obtenerMarcas() {
		String sql = "select idmarca codigo, nombre texto from marca order by 2";
		return obtenerLista(sql);
	}

	@Override
	public List<ComboDto> obtenerAutosDisponibles(Integer idMarca) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	
	}

	@Override
	public List<ComboDto> obtenerAutosReservados(Integer idMarca) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public ComboDto mapRow(ResultSet rs) throws SQLException {
		ComboDto dto = new ComboDto();
		dto.setCodigo(rs.getInt("codigo"));
		dto.setTexto(rs.getString("texto"));
		return dto;
	}
	
	private List<ComboDto> obtenerLista(String sql){
		List<ComboDto> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ComboDto bean = mapRow(rs);
				lista.add(bean);
			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			System.err.println("Error al consultar combo, SQL " + sql);
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}

}
