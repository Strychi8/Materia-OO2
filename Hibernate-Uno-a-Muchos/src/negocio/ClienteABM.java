package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public Cliente traer(long idCliente) {
		return dao.traer(idCliente);
	}

	public Cliente traer(int dni){
		return dao.traer(dni);
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
		Cliente cliente = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		if(traer(dni) != null) {
			throw new Exception("ERROR: Ya existe un cliente con el mismo DNI");
		}
		return dao.agregar(cliente);
	}
	
	public int agregar(Cliente cliente) throws Exception {
		if((traer(cliente.getDni()) != null)) {
			throw new Exception("ERROR: Ya existe ese cliente con ese DNI");
		}
		return dao.agregar(cliente);
	}

	public void modificar(Cliente cliente) throws Exception {
		if(traer(cliente.getIdCliente()) == null) {
			throw new Exception("ERROR: El cliente no se puede modificar porque no hay un cliente con ese ID");
		}
		Cliente c = traer(cliente.getDni());
		if(c != null && c.getIdCliente() != cliente.getIdCliente()) {
			throw new Exception("ERROR: El cliente no se puede modificar porque ya existe un cliente con ese DNI");
		}
		dao.actualizar(cliente);
	}

	public void eliminar(long idCliente) throws Exception {
		Cliente cliente = dao.traer(idCliente);
		if(cliente == null) {
			throw new Exception("ERROR: No existe ningun cliente con esa ID");
		}
		dao.eliminar(cliente);
	}
	
	public void eliminar(Cliente cliente) throws Exception {
		if(cliente != null) {
			if(!traer(cliente.getIdCliente()).getPrestamos().isEmpty()) {
				throw new Exception("ERROR: No se puede eliminar un cliente con prestamos");
			}
			if(cliente.getIdCliente() == 0) {
				throw new Exception("ERROR: Un cliente no tiene ID");
			}
		}else {
			throw new Exception("ERROR: No se puede eliminar un Cliente nulo");
		}
		dao.eliminar(cliente);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}

	public Cliente traerClienteYPrestamos(long idCliente) {
		return dao.traerClienteYPrestamos(idCliente);
	}

}
