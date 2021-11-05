package pe.edu.uni.sistventas.service;

import pe.edu.uni.sistventas.dto.EmpleadoDto;
import java.sql.*;
import pe.edu.uni.sistventas.db.AccesoDB;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class LogonService {

	public EmpleadoDto validar(String usuario, String clave) {
		EmpleadoDto empleadoDto = null;
		String query = "select IDEMPLEADO, NOMBRE, APELLIDO, DNI, "
				  + "TELEFONO, CORREO, IDROL, USUARIO, '******' CLAVE "
				  + "from empleado "
				  + "where usuario=? and clave=?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(query);
			pstm.setString(1, usuario);
			pstm.setString(2, clave);
			rs = pstm.executeQuery();
			if (rs.next()) {
				empleadoDto = new EmpleadoDto();
				empleadoDto.setIdempleado(rs.getInt("IDEMPLEADO"));
				empleadoDto.setNombre(rs.getString("NOMBRE"));
				empleadoDto.setApellido(rs.getString("APELLIDO"));
				empleadoDto.setDni(rs.getString("DNI"));
				empleadoDto.setTelefono(rs.getString("TELEFONO"));
				empleadoDto.setCorreo(rs.getString("CORREO"));
				empleadoDto.setIdrol(rs.getInt("IDROL"));
				empleadoDto.setUsuario(rs.getString("USUARIO"));
				empleadoDto.setClave(rs.getString("CLAVE"));
			}
			rs.close();
			pstm.close();
			if (empleadoDto == null) {
				throw new SQLException("Datos incorrectos.");
			}
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
		return empleadoDto;
	}
}
