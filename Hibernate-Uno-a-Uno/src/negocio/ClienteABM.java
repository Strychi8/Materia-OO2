package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.Contacto;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public Cliente traer(long idCliente) {
		return dao.traer(idCliente);
	}

	public Cliente traer(int dni) {
		return dao.traer(dni);
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento, Contacto contacto) throws Exception {
		// consultar si existe un cliente con el mismo dni, si existe arrojar la
		// 
		if(traer(dni) != null) {
			throw new Exception("ERROR: Ya existe un cliente con el mismo DNI");
		}
		return dao.agregar(new Cliente(apellido, nombre, dni, fechaDeNacimiento,contacto));
	}

	public void modificar(Cliente cliente) throws Exception {
		// implementar antes de actualizar que no exista un cliente con el mismo
		// documento a modificar y con el mismo id, lanzar la Exception
		if(traer(cliente.getIdCliente()) == null) {
			throw new Exception("ERROR: El cliente no se puede modificar porque no hay un cliene con el ID " + cliente.getIdCliente());
		}else if(traer(cliente.getDni()) != null) {
			throw new Exception("ERROR: El cliente no se puede modificar porque ya existe un cliente con el DNI " + cliente.getDni());
		}
		dao.actualizar(cliente);
	}

	public void eliminar(long idCliente) throws Exception {
		// en este caso es física en gral. no se se aplicaría este caso de uso, si
		// se hiciera habría que validar que el cliente no tenga dependencias
		Cliente cliente = dao.traer(idCliente);
		// Implementar que si es null que arroje la Excepción
		if(cliente == null) {
			throw new Exception("ERROR: No existe ningun Cliente con ese ID");
		}
		dao.eliminar(cliente);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}
	public Cliente traerClienteYContacto(long idCliente){
		return dao.traerClienteYContacto(idCliente);
	}
	
}
