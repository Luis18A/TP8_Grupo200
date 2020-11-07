package ar.edu.unju.edm.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.edm.config.EmfSingleton;
import ar.edu.unju.edm.dao.IFacturaDao;
import ar.edu.unju.edm.model.DetalleFactura;
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
	public void borrarFactura(Factura factura, Long nroFactura) {
		manager.getTransaction().begin();
//		se eliminan los detalles de factura relacionados con la factura, y luego la misma factura. Se realiza esto porque de otra forma
//		salta error, suponemos que es por el hecho de que la clase propietaria de la relación es DetalleFactura y no Factura, por lo que la eliminación
//		en cascada no funciona en ese caso, ya que deseamos que los detalles de factura se eliminen cuando se elimine la factura, y no al revés.
//		Lo mismo se hizo en la relacion de cliente con factura
		List<DetalleFactura> todosDetallesFacturas = (List<DetalleFactura>) manager.createQuery("SELECT e FROM DetalleFactura e").getResultList();
		for(DetalleFactura detalle:todosDetallesFacturas) {
			if(detalle.getFactura().getNroFactura()==nroFactura) {
				manager.remove(detalle);
			}
		}
		manager.remove(factura);
		manager.getTransaction().commit();
	}


}
