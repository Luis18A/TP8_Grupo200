package ar.edu.unju.edm.clases;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Id;

public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long nroFactura;
	private LocalDate fecha; //(LocalDate) fecha actual
	private Cliente cliente; 
	private String domicilio;
	private double total ;// total de todos los productos vendidos.
	public Factura() {
		// TODO Auto-generated constructor stub
	}
	public Long getNroFactura() {
		return nroFactura;
	}
	public void setNroFactura(Long nroFactura) {
		this.nroFactura = nroFactura;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Factura [nroFactura=" + nroFactura + ", fecha=" + fecha + ", cliente=" + cliente + ", domicilio="
				+ domicilio + ", total=" + total + "]";
	}
	public Factura(Long nroFactura, LocalDate fecha, Cliente cliente, String domicilio, double total) {
		super();
		this.nroFactura = nroFactura;
		this.fecha = fecha;
		this.cliente = cliente;
		this.domicilio = domicilio;
		this.total = total;
	}

	
}
