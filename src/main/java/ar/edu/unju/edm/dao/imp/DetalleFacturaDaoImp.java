package ar.edu.unju.edm.dao.imp;

import javax.persistence.EntityManager;

import ar.edu.unju.edm.config.EmfSingleton;
import ar.edu.unju.edm.dao.IDetalleFacturaDao;
import ar.edu.unju.edm.model.DetalleFactura;

public class DetalleFacturaDaoImp implements IDetalleFacturaDao {

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public void guardarDetalleFactura(DetalleFactura detalleFactura) {
		manager.getTransaction().begin();
		manager.persist(detalleFactura);
		manager.getTransaction().commit();
	}
	
}
