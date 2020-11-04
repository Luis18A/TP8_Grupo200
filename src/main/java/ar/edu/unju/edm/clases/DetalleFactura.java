package ar.edu.unju.edm.clases;

import java.io.Serializable;
import javax.persistence.Id;

public class DetalleFactura implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	Long Id;
	String Descripcion;
	double precioUnitario ;
	int cantidad;	
	double subtotal ;// representa el resultado de multiplicar cantidad * precioUnitario

	public DetalleFactura() {
		// TODO Auto-generated constructor stub
	}

	public DetalleFactura(Long id, String descripcion, double precioUnitario, int cantidad, double subtotal) {
		super();
		Id = id;
		Descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "DetalleFactura [Id=" + Id + ", Descripci�n=" + Descripcion + ", precioUnitario=" + precioUnitario
				+ ", cantidad=" + cantidad + ", subtotal=" + subtotal + "]";
	}
	
	
	
}
