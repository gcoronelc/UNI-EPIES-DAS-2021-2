package pe.edu.uni.sisteventasapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.sisteventasapp.db.AccesoDB;
import pe.edu.uni.sisteventasapp.dto.AutoDto;
import pe.edu.uni.sisteventasapp.dto.ClienteDto;
import pe.edu.uni.sisteventasapp.service.CrudAutoService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class CrudAutoServiceImpl implements CrudAutoService {
	
	private final String SELECT_BASE = "SELECT IDAUTO, MATRICULA, IDMARCA, MODELO, PRECIO, COLOR, VENDIDO FROM AUTO ";

	@Override
	public AutoDto read(Integer id) {
		AutoDto autoDto = null;
		String query = SELECT_BASE + " where idauto=?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(query);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				autoDto = mapRow(rs);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso, intenteo de nuevo.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return autoDto;
	}

	@Override
	public List<AutoDto> read(AutoDto bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<AutoDto> readAll() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void create(AutoDto bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void update(AutoDto bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void delete(Integer id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public AutoDto mapRow(ResultSet rs) throws SQLException {
		AutoDto dto = new AutoDto();
		dto.setIdauto(rs.getInt("idauto"));
		dto.setMatricula(rs.getString("matricula"));
		dto.setIdmarca(rs.getInt("idmarca"));
		dto.setModelo(rs.getString("modelo"));
		dto.setPrecio(rs.getDouble("precio"));
		dto.setColor(rs.getString("color"));
		dto.setVendido(rs.getInt("vendido"));
		return dto;
	}
}
