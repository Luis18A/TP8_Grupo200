package ar.edu.unju.edm.dao;

import java.util.List;

import ar.edu.unju.edm.model.Factura;

public interface IFacturaDao {

	public void guardarFactura(Factura factura);
	public void borrarFactura(Factura factura);
	public List<Factura> obtenerTodasFacturas();
	public Factura buscarfactura(Long nroFactura);
}
