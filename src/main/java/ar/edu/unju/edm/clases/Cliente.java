package ar.edu.unju.edm.clases;

import java.io.Serializable;

import javax.persistence.Id;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	Long Código;
	String Nombre; 
	String Apellido; 
	String Domicilio; 
	int Dni;
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public Long getCódigo() {
		return Código;
	}
	public void setCódigo(Long código) {
		Código = código;
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
	public Cliente(Long código, String nombre, String apellido, String domicilio, int dni) {
		super();
		Código = código;
		Nombre = nombre;
		Apellido = apellido;
		Domicilio = domicilio;
		Dni = dni;
	}
	@Override
	public String toString() {
		return "Cliente [Código=" + Código + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Domicilio="
				+ Domicilio + ", Dni=" + Dni + "]";
	}
	
	
	
}
