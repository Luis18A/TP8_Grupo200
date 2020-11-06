package ar.edu.unju.edm.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.edm.config.EmfSingleton;
import ar.edu.unju.edm.dao.IClienteDao;
import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.model.Factura;

public class ClienteDaoImp implements IClienteDao{

	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public void guardarCliente(Cliente cliente) {
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
	}

	@Override
	public void borrarCliente(Cliente cliente) {
		manager.getTransaction().begin();
//		manager.clear();
		manager.remove(manager.merge(cliente));
		manager.getTransaction().commit();
	}

	@Override
	public List<Cliente> obtenerTodosClientes() {
		@SuppressWarnings("unchecked")
		List<Cliente> clientes = (List<Cliente>) manager.createQuery("SELECT e FROM Cliente e").getResultList();
		return clientes;
		}

	@Override
	public Cliente buscarCliente(Long cod) {
		return manager.find(Cliente.class,cod);
	}

}
