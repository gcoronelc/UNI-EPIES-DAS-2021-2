package pe.edu.uni.sisteventasapp.dto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public class AutoDto {

	private Integer idauto;
	private String matricula;
	private Integer idmarca;
	private String modelo;
	private Double precio;
	private String color;
	private Integer vendido;

	public AutoDto() {
	}

	public Integer getIdauto() {
		return idauto;
	}

	public void setIdauto(Integer idauto) {
		this.idauto = idauto;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getIdmarca() {
		return idmarca;
	}

	public void setIdmarca(Integer idmarca) {
		this.idmarca = idmarca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getVendido() {
		return vendido;
	}

	public void setVendido(Integer vendido) {
		this.vendido = vendido;
	}

}
