package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {

	// ATRIBUTOS
	ClienteDao dao = new ClienteDao();

	// TRAER ID
	public Cliente traer(long idCliente) throws Exception {
		Cliente c = dao.traer(idCliente);
		if (c == null) {
			throw new Exception("ERROR no existe un cliente con ese id");
		}
		return c;
	}

	// TRAER DNI
	public Cliente traer(int dni) throws Exception {
		Cliente c = dao.traer(dni);
		if (c == null) {
			throw new Exception("ERROR no existe un cliente con ese dni");
		}
		return c;
	}

	// TRAER LISTA
	public List<Cliente> traer() throws Exception {
		return dao.traer();
	}

	// TRAER CLIENTE Y EVENTOS
	public Cliente traerClienteYEventos(long idCliente) throws Exception {
		Cliente c = dao.traerClienteYEventos(idCliente);
		
		if(c==null) {
			throw new Exception("ERROR no existe un cliente con ese id");
		}
		
		if(c.getEventos().isEmpty()) {
			throw new Exception("ERROR el cliente no tiene eventos");
		}
		
		return c;
				
	}

	// AGREGAR
	public int agregar(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento) throws Exception {
		if(dao.traer(dni)!=null) {
			throw new Exception("ERROR ya existe un cliente con ese dni");
		}
		
		Cliente c = new Cliente(apellido,nombre,dni,fechaDeNacimiento);
		return dao.agregar(c);
	}

	// ACTUALIZAR
	public void actualizar(Cliente c) throws Exception {
		if(dao.traer(c.getDni())!=null && c.getIdCliente() != dao.traer(c.getDni()).getIdCliente()) {
			throw new Exception("ERROR: Ya existe un cliente con ese dni"); 
		}
		
		dao.actualizar(c);
	}

	// ELIMINAR
	public void eliminar(long idCliente) throws Exception {
		Cliente c = dao.traer(idCliente);
		if(c==null) {
			throw new Exception("ERROR: No existe un cliente con ese id");
		}
		dao.eliminar(c);
	}

}
