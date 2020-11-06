package ar.edu.unju.edm.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="facturas")
@NamedQuery(name ="verFacturas", query="SELECT e FROM Factura e")
public class Factura implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long nroFactura;
	private LocalDate fecha;
	private String domicilio;
	private double total;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	@OneToMany(mappedBy = "factura", fetch=FetchType.EAGER, cascade= {CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval=true)
	private List<DetalleFactura> detallesFacturas = new ArrayList<DetalleFactura>();
	
	
	
	
	public Factura() {
		// TODO Auto-generated constructor stub
	}

	public long getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(long nroFactura) {
		this.nroFactura = nroFactura;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFactura> getDetallesFacturas() {
		return detallesFacturas;
	}

	public void setDetallesFacturas(List<DetalleFactura> detallesFacturas) {
		this.detallesFacturas = detallesFacturas;
	}

	public Factura(LocalDate fecha, String domicilio, double total, Cliente cliente,
			List<DetalleFactura> detallesFacturas) {
		super();
		this.fecha = fecha;
		this.domicilio = domicilio;
		this.total = total;
		this.cliente = cliente;
		this.detallesFacturas = detallesFacturas;
	}

	@Override
	public String toString() {
		return "Factura [nroFactura=" + nroFactura + ", fecha=" + fecha + ", domicilio=" + domicilio + ", total="
				+ total + ", cliente=" + cliente + ", detallesFacturas=" + detallesFacturas + "]";
	}
	
	
	
	
}
