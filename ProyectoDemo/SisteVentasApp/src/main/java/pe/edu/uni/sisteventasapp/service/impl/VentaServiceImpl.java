package pe.edu.uni.sisteventasapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.uni.sisteventasapp.db.AccesoDB;
import pe.edu.uni.sisteventasapp.dto.VentaDto;
import pe.edu.uni.sisteventasapp.service.VentaService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class VentaServiceImpl implements VentaService{

	@Override
	public void grabarVenta(VentaDto bean) {
		final String SQL1 = "select count(1) cont from cliente where IDCLIENTE = ?";
		final String SQL2 = "select count(1) cont from auto where IDAUTO = ?";
		final String SQL3 = "select vendido from auto where IDAUTO = ?";
		final String SQL4 = "update auto set vendido=1 where IDAUTO = ? and vendido=0";
		final String SQL5 = "insert into venta(idauto,idcliente,fecha_registro,vendedor,"
				  + "importe,impuesto,total,estado) values(?,?,getdate(),?,?,?,?,1)";
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int cont, vendido, filas;
		try {
			// Inicio de transacción
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false); // Iniciar Tx
			// Verificar que el codigo del cliente existe
			pstm = cn.prepareStatement(SQL1);
			pstm.setInt(1, bean.getIdcliente());
			rs = pstm.executeQuery();
			rs.next();
			cont = rs.getInt("cont");
			rs.close();
			pstm.close();
			if(cont==0){
				throw new SQLException("El cliente no existe.");
			}
			// Verificar si el auto existe
			pstm = cn.prepareStatement(SQL2);
			pstm.setInt(1, bean.getIdauto());
			rs = pstm.executeQuery();
			rs.next();
			cont = rs.getInt("cont");
			rs.close();
			pstm.close();
			if(cont==0){
				throw new SQLException("El auto no existe.");
			}
			// Verificar que el estado del auto es NO VENDIDO (0)
			pstm = cn.prepareStatement(SQL3);
			pstm.setInt(1, bean.getIdauto());
			rs = pstm.executeQuery();
			rs.next();
			vendido = rs.getInt("vendido");
			rs.close();
			pstm.close();
			if(vendido!=0){
				throw new SQLException("El auto no esta disponible.");
			}
			// Cambiar el estado del auto a RESERVADO (1)
			pstm = cn.prepareStatement(SQL4);
			pstm.setInt(1, bean.getIdauto());
			filas = pstm.executeUpdate();
			pstm.close();
			if(filas!=1){
				throw new SQLException("El auto no existe o no esta disponible.");
			}
			// Registrar los datos de la venta.
			pstm = cn.prepareStatement(SQL5);
			pstm.setInt(1, bean.getIdauto());
			pstm.setInt(2, bean.getIdcliente());
			pstm.setInt(3, bean.getVendedor());
			pstm.setDouble(4, bean.getImporte());
			pstm.setDouble(5, bean.getImpuesto());
			pstm.setDouble(6, bean.getTotal());
			pstm.executeUpdate();
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
			e.printStackTrace();
			throw new RuntimeException("Error en el proceso, intentelo mas tarde.");
		}finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}		
	}



}
