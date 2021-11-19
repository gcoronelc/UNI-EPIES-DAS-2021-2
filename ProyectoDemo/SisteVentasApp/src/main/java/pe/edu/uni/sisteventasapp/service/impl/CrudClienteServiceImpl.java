package pe.edu.uni.sisteventasapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.sisteventasapp.db.AccesoDB;
import pe.edu.uni.sisteventasapp.dto.ClienteDto;
import pe.edu.uni.sisteventasapp.dto.EmpleadoDto;
import pe.edu.uni.sisteventasapp.service.CrudClienteService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class CrudClienteServiceImpl implements CrudClienteService{
	
	private final String SELECT_BASE = "SELECT IDCLIENTE, NOMBRE, APELLIDO, DNI, TELEFONO, CORREO FROM CLIENTE ";
	private final String INSERT = "INSERT INTO CLIENTE(NOMBRE,APELLIDO,DNI,TELEFONO,CORREO) VALUES(?,?,?,?,?)";
	private final String SELECT_ID = "SELECT @@IDENTITY AS ID";
	private final String DELETE = "DELETE FROM CLIENTE WHERE IDCLIENTE=?";
	private final String UPDATE = "UPDATE CLIENTE SET NOMBRE=?,APELLIDO=?,DNI=?,TELEFONO=?,CORREO=? WHERE IDCLIENTE=?";
	
	@Override
	public ClienteDto read(Integer id) {
		ClienteDto clienteDto = null;
		String query = SELECT_BASE + " where idcliente=?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(query);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				clienteDto = mapRow(rs);
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
		return clienteDto;
	}

	@Override
	public List<ClienteDto> read(ClienteDto bean) {
		List<ClienteDto> lista = new ArrayList<>();
		String query = SELECT_BASE 
				  + "WHERE idcliente = iif(?=0,idcliente, ?) " 
				  + "and nombre like iif(? is null,nombre, ?) " 
				  + "and apellido like iif(? is null,apellido, ?) ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection cn = null;
		// Preparando el bean
		bean.setIdcliente(UtilService.nullToCero(bean.getIdcliente()));
		bean.setApellido(UtilService.preparaString(bean.getApellido()));
		bean.setNombre(UtilService.preparaString(bean.getNombre()));
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(query);
			pstm.setInt(1, bean.getIdcliente());
			pstm.setInt(2, bean.getIdcliente());
			pstm.setString(3, bean.getNombre());
			pstm.setString(4, bean.getNombre());
			pstm.setString(5, bean.getApellido());
			pstm.setString(6, bean.getApellido());
			rs = pstm.executeQuery();
			while (rs.next()) {
				ClienteDto dto = mapRow(rs);
				lista.add(dto);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error en el proceso, intenteo de nuevo.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}

	@Override
	public List<ClienteDto> readAll() {
		List<ClienteDto> lista = new ArrayList<>();
		String query = SELECT_BASE;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(query);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ClienteDto bean = mapRow(rs);
				lista.add(bean);
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
		return lista;
	}

	@Override
	public void create(ClienteDto bean) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// Inicio de transacción
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Insertar registro
			pstm = cn.prepareStatement(INSERT);
			pstm.setString(1, bean.getNombre());
			pstm.setString(2, bean.getApellido());
			pstm.setString(3, bean.getDni());
			pstm.setString(4, bean.getTelefono());
			pstm.setString(5, bean.getCorreo());
			pstm.executeUpdate();
			pstm.close();
			// Leer el codigo generado
			pstm = cn.prepareStatement(SELECT_ID);
			rs = pstm.executeQuery();
			rs.next();
			bean.setIdcliente(rs.getInt("ID"));
			rs.close();
			pstm.close();
			// Confirmar transacción
			cn.commit();
		} catch (SQLException e) {
			try {
				cn.rollback();
			} catch (Exception e1) {
			}
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e1) {
			}
			throw new RuntimeException("Error en el proceso, intentelo mas tarde.");
		}finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void update(ClienteDto bean) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// Inicio de transacción
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Insertar registro
			pstm = cn.prepareStatement(UPDATE);
			pstm.setString(1, bean.getNombre());
			pstm.setString(2, bean.getApellido());
			pstm.setString(3, bean.getDni());
			pstm.setString(4, bean.getTelefono());
			pstm.setString(5, bean.getCorreo());
			pstm.setInt(6, bean.getIdcliente());
			int nroFilas = pstm.executeUpdate();
			pstm.close();
			// Verificar
			if(nroFilas!=1){
				throw new SQLException("Error, datos incorrectos, corriga e intente de nuevp.");
			}
			// Confirmar transacción
			cn.commit();
		} catch (SQLException e) {
			try {
				cn.rollback();
			} catch (Exception e1) {
			}
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e1) {
			}
			throw new RuntimeException("Error en el proceso, intentelo mas tarde.");
		}finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void delete(Integer id) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// Inicio de transacción
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Validacion
			// Se debe verificar si el cliente tiene comprobantes, 
			// En ese caso debe generar un error.
			
			// Insertar registro
			pstm = cn.prepareStatement(DELETE);
			pstm.setInt(1, id);
			int nroFilas = pstm.executeUpdate();
			pstm.close();
			// Verificar
			if(nroFilas!=1){
				throw new SQLException("Error, datos incorrectos, corriga e intente de nuevp.");
			}
			// Confirmar transacción
			cn.commit();
		} catch (SQLException e) {
			try {
				cn.rollback();
			} catch (Exception e1) {
			}
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e1) {
			}
			throw new RuntimeException("Error en el proceso, intentelo mas tarde.");
		}finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public ClienteDto mapRow(ResultSet rs) throws SQLException {
		ClienteDto dto = new ClienteDto();
		dto.setIdcliente(rs.getInt("idcliente"));
		dto.setNombre(rs.getString("nombre"));
		dto.setApellido(rs.getString("apellido"));
		dto.setDni(rs.getString("dni"));
		dto.setTelefono(rs.getString("telefono"));
		dto.setCorreo(rs.getString("correo"));
		return dto;
	}

}
