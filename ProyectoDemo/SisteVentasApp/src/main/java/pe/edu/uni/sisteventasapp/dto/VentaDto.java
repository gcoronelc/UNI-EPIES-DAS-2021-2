package pe.edu.uni.sisteventasapp.dto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class VentaDto {

	private Integer idventa;
	private Integer idauto;
	private Integer idcliente;
	private String fecharegistro;
	private String fechapago;
	private Integer vendedor;
	private Integer caja;
	private Double importe;
	private Double impuesto;
	private Double total;
	private Integer estado;

	public VentaDto() {
	}

	public Integer getIdventa() {
		return idventa;
	}

	public void setIdventa(Integer idventa) {
		this.idventa = idventa;
	}

	public Integer getIdauto() {
		return idauto;
	}

	public void setIdauto(Integer idauto) {
		this.idauto = idauto;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(String fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getFechapago() {
		return fechapago;
	}

	public void setFechapago(String fechapago) {
		this.fechapago = fechapago;
	}

	public Integer getVendedor() {
		return vendedor;
	}

	public void setVendedor(Integer vendedor) {
		this.vendedor = vendedor;
	}

	public Integer getCaja() {
		return caja;
	}

	public void setCaja(Integer caja) {
		this.caja = caja;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
	

}
