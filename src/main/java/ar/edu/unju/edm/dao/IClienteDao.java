package ar.edu.unju.edm.dao;

import java.util.List;

import ar.edu.unju.edm.model.Cliente;

public interface IClienteDao {

	public void guardarCliente(Cliente cliente);
	public void borrarCliente(Cliente cliente);
	public List<Cliente> obtenerTodosClientes();
	public Cliente buscarCliente(Long cod);
}
