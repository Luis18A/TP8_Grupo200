package ar.edu.unju.edm.principal;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ar.edu.unju.edm.dao.IClienteDao;
import ar.edu.unju.edm.dao.IDetalleFacturaDao;
import ar.edu.unju.edm.dao.IFacturaDao;
import ar.edu.unju.edm.dao.imp.ClienteDaoImp;
import ar.edu.unju.edm.dao.imp.DetalleFacturaDaoImp;
import ar.edu.unju.edm.dao.imp.FacturaDaoImp;
import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.model.DetalleFactura;
import ar.edu.unju.edm.model.Factura;

public class Principal {

	public static EntityManager manager;
	public static EntityManagerFactory emf;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 //creamos un gestor de persistencia. ahora está en la clase EmfSingleton.java
		emf = Persistence.createEntityManagerFactory("TestPersistence");
		manager = emf.createEntityManager();

		
		Scanner sc = new Scanner(System.in);
		int op=0;
		boolean ing;
		IClienteDao clienteDao = new ClienteDaoImp();
		IFacturaDao facturaDao = new FacturaDaoImp();
		IDetalleFacturaDao detalleFacturaDao = new DetalleFacturaDaoImp();
		do {
			do {
				System.out.println("\n---------------------------MENU----------------------------");
				System.out.println("1. Agregar un cliente.");
				System.out.println("2. Eliminar un cliente.");
				System.out.println("3. Crear una nueva factura.");
				System.out.println("4. Eliminar una factura.");
				System.out.println("5. Buscar una factura.");
				System.out.println("6. Mostrar todas las facturas.");
				System.out.println("7. Mostrar todos los clientes.");
				System.out.println("8. Mostrar las facturas que superen el total de $1000");
				System.out.println("9. Salir");
				System.out.println("\nIngrese opción: ");
				ing=true;
				try {
					op=sc.nextInt();
				}catch(InputMismatchException i){
					System.out.println("\nIngreso inválido. Debe ingresar una opción numérica.");
					sc.next();
					ing=false;
					}
			}while(ing==false);
			
			switch(op) {
			case 1: Cliente cliente = new Cliente();
					System.out.println("Ingrese nombre: ");
					cliente.setNombre(sc.next());
					System.out.println("Ingrese apellido: ");
					cliente.setApellido(sc.next());					
					boolean ing2;
					int dniIngresado=0;
					do {
						ing2=true;
						System.out.println("Ingrese dni: ");
						try {
							dniIngresado = sc.nextInt();
						}catch(InputMismatchException i) {
							System.out.println("\nINGRESO ERRONEO. Debe ingresar un número de DNI.\n");
							sc.next();
							ing2=false;
						}
					}while (ing2==false);
					cliente.setDni(dniIngresado);
					System.out.println("Ingrese domicilio: ");
					cliente.setDomicilio(sc.next());
					clienteDao.guardarCliente(cliente);
				break;
			case 2: 
					System.out.println("Ingrese código del cliente que desea eliminar: ");
					long codElim= sc.nextLong();
					
//					 recuperar un objeto de la tabla clientes
					Cliente clienteEliminado = clienteDao.buscarCliente(codElim);
					if(clienteEliminado != null) {
						System.out.print("\nSe eliminará el siguiente cliente: ");
						System.out.println(clienteEliminado+"\n");
		
//						 borrar el objeto de la tabla clientes
						clienteDao.borrarCliente(clienteDao.buscarCliente(codElim),codElim);
						System.out.println("\nEl cliente fue eliminado");
						}else {
							System.out.println("\nNo existe el cliente!");
						}

				break;
			case 3: 
					System.out.println("Ingrese código del cliente dueño de la factura:");
					long codBusc=sc.nextLong();
					//se busca el cliente
					Cliente clienteBuscado = manager.find(Cliente.class, codBusc);
					if(clienteBuscado != null) {
						System.out.print("\nEl dueño de la siguiente factura es el cliente: ");
						System.out.println(clienteBuscado+"\n");
					//se crea la factura
					Factura factura = new Factura();
					facturaDao.guardarFactura(factura);
					factura.setCliente(clienteBuscado);
					factura.setFecha(LocalDate.now());
					factura.setDomicilio(clienteBuscado.getDomicilio());
					String ingresado;
					double total=0;
					do {						
						DetalleFactura detalleFactura= new DetalleFactura();
						System.out.println("\nAgregando un producto...");
						System.out.println("\nIngrese descripción del producto: ");
						detalleFactura.setDescripcion(sc.next());
						boolean ing3;
						double precioUnitario=0;
						do {
							ing3=true;
							System.out.println("Ingrese precio unitario:");
							try {
								precioUnitario = sc.nextDouble();
							}catch(InputMismatchException i) {
								System.out.println("\nINGRESO ERRONEO. Debe ingresar un número.\n");
								sc.next();
								ing3=false;
							}
						}while (ing3==false);
						detalleFactura.setPrecioUnitario(precioUnitario);
						boolean ing4;
						int cantidad=0;
						do {
							ing4=true;
							System.out.println("Ingrese cantidad: ");
							try {
								cantidad = sc.nextInt();
							}catch(InputMismatchException i) {
								System.out.println("\nINGRESO ERRONEO. Debe ingresar un número.\n");
								sc.next();
								ing4=false;
							}
						}while (ing4==false);
						detalleFactura.setCantidad(cantidad);
						detalleFactura.setSubtotal(precioUnitario*cantidad);
						total=total+detalleFactura.getSubtotal();
						detalleFactura.setFactura(factura);
						detalleFacturaDao.guardarDetalleFactura(detalleFactura);
						boolean bienIngresado=false;
						do {
							System.out.println("Ingrese S si desea agregar otro producto y N si no lo desea: ");
							ingresado=sc.next();
							if(ingresado.equalsIgnoreCase("s")||ingresado.equalsIgnoreCase("n")) {
								bienIngresado=true;
							}
						}while(bienIngresado==false);
					}while(ingresado.equalsIgnoreCase("s"));
//					SE ACTUALIZA LA FACTURA YA CON EL TOTAL
					factura.setTotal(total);
					facturaDao.guardarFactura(factura);
					System.out.println("La factura se ha creado con éxito!");
					}
					else {
						System.out.println("\nNo existe el cliente!");
					}
				break;
			case 4:
				System.out.println("Ingrese número de la factura que desea eliminar: ");
				long nroFac= sc.nextLong();

				if(facturaDao.buscarfactura(nroFac) != null) {
					System.out.print("\nSe eliminará la siguiente factura: ");
					System.out.println(facturaDao.buscarfactura(nroFac)+"\n");
											
					// borrar el objeto de la tabla clientes
					facturaDao.borrarFactura(facturaDao.buscarfactura(nroFac),nroFac);
					System.out.println("\nLa factura fue eliminada");
				}else {
					System.out.println("\nNo existe la factura!");
				}
				break;
			case 5: 
				System.out.println("Ingrese número de factura: ");
				long nroFactura= sc.nextLong();
				if(facturaDao.buscarfactura(nroFactura) != null) {
					System.out.println(facturaDao.buscarfactura(nroFactura));
				}
				else {
					System.out.println("La factura no existe");
				}
				break;
			case 6: 
				if(facturaDao.obtenerTodasFacturas().isEmpty()) {
					System.out.println("No hay facturas cargadas!");
				}else {
					facturaDao.obtenerTodasFacturas().stream().forEach(System.out::println);
				}
				break;
			case 7: 
				if(clienteDao.obtenerTodosClientes().isEmpty()) {
					System.out.println("No hay clientes cargados!");
				}else {
					clienteDao.obtenerTodosClientes().stream().forEach(System.out::println);

				}
//				otra forma
//				List<Cliente> clientes = clienteDao.obtenerTodosClientes();	
//				for(Cliente client:clientes) {
//						System.out.println(client);
//					}
				break;
			case 8: if(facturaDao.obtenerTodasFacturas().stream().filter(f->f.getTotal()>1000).count()==0) {
				System.out.println("No hay facturas con un total superior a $1000");
			}else {
				facturaDao.obtenerTodasFacturas().stream().filter(f->f.getTotal()>1000).forEach(System.out::println);
			}
				break;
			case 9:System.out.println("Saliendo...");
				break;
			default: System.out.println("\nOpción inválida!");
				break;
				
			}
		}while(op!=9);
		
		
		
		
		
		}
}
