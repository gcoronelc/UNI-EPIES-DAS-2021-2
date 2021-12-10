package pe.edu.uni.sisteventasapp.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pe.edu.uni.sisteventasapp.db.AccesoDB;
import pe.edu.uni.sisteventasapp.service.ConsultaService;
import pe.uni.app.service.JdbcUtil;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class ConsultaServiceImpl implements ConsultaService{

	@Override
	public List<Map<String, ?>> consultaComision(Integer anio, Integer mes) {
		final String SQL = "EXEC USP_REPO_COMISON ?,?";
		List<Map<String, ?>> lista = new ArrayList<>();
		CallableStatement cstm;
		ResultSet rs;
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			cstm = cn.prepareCall(SQL);
			cstm.setInt(1, anio);
			cstm.setInt(2, mes);
			rs = cstm.executeQuery();
			lista = JdbcUtil.rsToList(rs);
			rs.close();
			cstm.close();
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
		return lista;
	}

}
