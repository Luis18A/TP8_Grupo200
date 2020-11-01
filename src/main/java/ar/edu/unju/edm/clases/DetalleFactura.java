package ar.edu.unju.edm.clases;

import java.io.Serializable;
import javax.persistence.Id;

public class DetalleFactura implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	Long Id;
	String Descripci�n;
	double precioUnitario ;
	int cantidad;	
	double subtotal ;// representa el resultado de multiplicar cantidad * precioUnitario

	public DetalleFactura() {
		// TODO Auto-generated constructor stub
	}

	public DetalleFactura(Long id, String descripci�n, double precioUnitario, int cantidad, double subtotal) {
		super();
		Id = id;
		Descripci�n = descripci�n;
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

	public String getDescripci�n() {
		return Descripci�n;
	}

	public void setDescripci�n(String descripci�n) {
		Descripci�n = descripci�n;
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
		return "DetalleFactura [Id=" + Id + ", Descripci�n=" + Descripci�n + ", precioUnitario=" + precioUnitario
				+ ", cantidad=" + cantidad + ", subtotal=" + subtotal + "]";
	}
	
	
	
}
