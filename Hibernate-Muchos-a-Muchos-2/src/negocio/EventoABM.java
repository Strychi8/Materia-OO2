package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import dao.ClienteDao;
import dao.EventoDao;
import datos.Cliente;
import datos.Evento;

public class EventoABM {

	// ATRIBUTOS
	EventoDao dao = new EventoDao();
	ClienteDao daoC = new ClienteDao();

	// TRAER ID
	public Evento traer(long idEvento) throws Exception {
		Evento e = dao.traer(idEvento);
		if (e == null) {
			throw new Exception("ERROR no existe un evento con ese id");
		}
		return e;
	}

	// TRAER LISTA
	public List<Evento> traer() throws Exception {
		return dao.traer();
	}

	// TRAER CLIENTE Y EVENTOS
	public Evento traerEventoYClientes(long idEvento) throws Exception {
		Evento e = dao.traerEventoYClientes(idEvento);

		if (e == null) {
			throw new Exception("ERROR no existe un evento con ese id");
		}

		if (e.getClientes().isEmpty()) {
			throw new Exception("ERROR el evento no tiene clientes");
		}

		return e;
	}

	// AGREGAR
	public int agregar(String evento, LocalDate fecha, LocalTime hora) throws Exception {
		Evento e = new Evento(evento, fecha, hora);
		return dao.agregar(e);
	}

	// ACTUALIZAR
	public void actualizar(Evento e) throws Exception {
		dao.actualizar(e);
	}

	// ELIMINAR
	public void eliminar(long idEvento) throws Exception {
		Evento e = dao.traer(idEvento);
		if (e == null) {
			throw new Exception("ERROR no existe un evento con ese id");
		}

		dao.eliminar(e);
	}

	// AGREGAR CLIENTE A EVENTO
	public void agregarClienteAEvento(long idCliente, long idEvento) throws Exception {
		Cliente c = daoC.traer(idCliente);
		if (c == null) {
			throw new Exception("ERROR no existe un cliente con ese id");
		}

		Evento e = dao.traerEventoYClientes(idEvento);
		if (e == null) {
			throw new Exception("ERROR no existe un evento con ese id");
		}

		for (Cliente cliente : e.getClientes()) {
			if (cliente.getIdCliente() == c.getIdCliente()) {
				throw new Exception("ERROR el cliente ya esta en lista");
			}
		}

		e.getClientes().add(c);
		dao.actualizar(e);
	}

	// ELIMINAR CLIENTE A EVENTO
	public void eliminarClienteAEvento(long idCliente, long idEvento) throws Exception {
		Cliente c = daoC.traer(idCliente);
		if (c == null) {
			throw new Exception("ERROR no existe un cliente con ese id");
		}

		Evento e = dao.traerEventoYClientes(idEvento);
		if (e == null) {
			throw new Exception("ERROR no existe un evento con ese id");
		}

		//if(!e.getClientes().contains(c)) {
		//	throw new Exception("ERROR el cliente no esta en lista");
		//}

		e.getClientes().remove(c);
		dao.actualizar(e);
	}
}
