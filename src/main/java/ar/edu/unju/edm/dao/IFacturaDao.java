package ar.edu.unju.edm.dao;

import java.util.List;

import ar.edu.unju.edm.model.DetalleFactura;
import ar.edu.unju.edm.model.Factura;

public interface IFacturaDao {

	public void guardarFactura(Factura factura);
	public void borrarFactura(Factura factura, Long nroFac);
	public List<Factura> obtenerTodasFacturas();
	public Factura buscarfactura(Long nroFactura);
}
