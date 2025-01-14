package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
		Cliente aux = dao.traer(dni);
		if (aux != null) {
			throw new Exception("ERROR: Ya existe un cliente con ese DNI.");
		}
		return dao.agregar(new Cliente(apellido, nombre, dni, fechaDeNacimiento));
	}

	public void modificar(Cliente c) {
		dao.actualizar(c);
	}

	public void eliminar(long idCliente) throws Exception {
		Cliente c = dao.traer(idCliente);
		if (c == null) {
			throw new Exception("ERROR: No existe un cliente con ese ID.");
		}
		dao.eliminar(c);
	}

	public Cliente traer(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}

	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
	}

	public List<Cliente> traer() {
		return dao.traer();
	}

	public Cliente traerClienteYPrestamos(long idCliente) {
		return dao.traerClienteYPrestamos(idCliente);
	}

}