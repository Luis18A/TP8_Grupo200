package ar.edu.unju.edm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="detallesFacturas")
@NamedQuery(name ="verDetallesFacturas", query="SELECT e FROM DetalleFactura e")
public class DetalleFactura implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String descripcion;
	private double precioUnitario;
	private int cantidad;
	private double subtotal;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="factura_id")
	private Factura factura;

	
	
	
	public DetalleFactura() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public DetalleFactura(String descripcion, double precioUnitario, int cantidad, double subtotal, Factura factura) {
		super();
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", factura=" + factura + "]";
	}
	
	

}
