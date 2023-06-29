package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public Cliente traer(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}

	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
		// consultar si existe un cliente con el mismo dni, si existe arrojar la
		// Excepcion
		if(traer(dni) != null) {
			throw new Exception("ERROR: Ya existe un cliente con ese DNI");
		}
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(c);
	}

	public void modificar(Cliente c) throws Exception  {
		// implementar antes de actualizar que no exista un cliente con el mismo
		// documento a modificar y con el mismo id, lanzar la Exception
		if (traer(c.getIdCliente()) == null) { /*Que exista un cliente con ese ID*/
			throw new Exception("ERROR: El cliente no se puede modificar porque no existe uno con el ID: "+c.getIdCliente());
		}
		else if(traer(c.getDni()) != null) {	/*Que el documento que se quiere poner no este ya siendo utilizado por otro*/
			throw new Exception("ERROR: El cliente no se puede modificar porque ya existe un cliente con el documento: "+c.getDni());
		}
		dao.actualizar(c);
	}

	public void eliminar(long idCliente) throws Exception {
		// en este caso es física en gral. no se aplicaría este caso de uso, si
		// se hiciera habría que validar que el cliente no tenga dependencias
		Cliente c = dao.traer(idCliente);
		// Implementar que si es null que arroje la Excepción
		if(c == null) {
			throw new Exception("ERROR: El cliente no existe");
		}
		dao.eliminar(c);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}

}
