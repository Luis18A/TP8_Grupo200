package ar.edu.unju.edm.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.edm.config.EmfSingleton;
import ar.edu.unju.edm.dao.IFacturaDao;
import ar.edu.unju.edm.model.Factura;

public class FacturaDaoImp implements IFacturaDao{

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	

	@Override
	public void guardarFactura(Factura factura) {
		manager.getTransaction().begin();
		manager.persist(factura);
		manager.getTransaction().commit();
	}
	
	@Override
	public List<Factura> obtenerTodasFacturas() {
		@SuppressWarnings("unchecked")
		List<Factura> todasFacturas = (List<Factura>) manager.createQuery("SELECT e FROM Factura e").getResultList();
		return todasFacturas;
	}

	@Override
	public Factura buscarfactura(Long nroFactura) {
		return manager.find(Factura.class,nroFactura);
	}

	@Override
	public void borrarFactura(Factura factura) {
		manager.getTransaction().begin();
		manager.remove(manager.merge(factura));
		manager.getTransaction().commit();
	}


}
