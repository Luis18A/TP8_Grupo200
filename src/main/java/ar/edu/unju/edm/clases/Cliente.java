package ar.edu.unju.edm.clases;

import java.io.Serializable;

import javax.persistence.Id;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	Long C�digo;
	String Nombre; 
	String Apellido; 
	String Domicilio; 
	int Dni;
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public Long getC�digo() {
		return C�digo;
	}
	public void setC�digo(Long c�digo) {
		C�digo = c�digo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getDomicilio() {
		return Domicilio;
	}
	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}
	public int getDni() {
		return Dni;
	}
	public void setDni(int dni) {
		Dni = dni;
	}
	public Cliente(Long c�digo, String nombre, String apellido, String domicilio, int dni) {
		super();
		C�digo = c�digo;
		Nombre = nombre;
		Apellido = apellido;
		Domicilio = domicilio;
		Dni = dni;
	}
	@Override
	public String toString() {
		return "Cliente [C�digo=" + C�digo + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Domicilio="
				+ Domicilio + ", Dni=" + Dni + "]";
	}
	
	
	
}
