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
	
	private static String SELECT_BASE = "select idcliente, nombre, apellido, dni, telefono, correo from cliente ";

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
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void update(ClienteDto bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void delete(Integer id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
