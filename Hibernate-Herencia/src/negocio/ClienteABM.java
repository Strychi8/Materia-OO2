package negocio;

import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.Contacto;
import datos.InscripcionAfip;
import datos.PersonaFisica;
import datos.PersonaJuridica;

public class ClienteABM {
	private static ClienteABM instancia = null;// Patrón Singleton

	protected ClienteABM() {}

	public static ClienteABM getInstance() {
		if (instancia == null)
			instancia = new ClienteABM();
		return instancia;
	}

	public Cliente traer(int idCliente) throws Exception {
		if(ClienteDao.getInstance().traer(idCliente) == null) {
			throw new Exception("ERROR: El cliente solicitado no existe");
		}
		return ClienteDao.getInstance().traer(idCliente);
	}
	
	public Cliente traerDni(int dni) throws Exception {
		if(ClienteDao.getInstance().traerDni(dni) == null) {
			throw new Exception("ERROR: El cliente solicitado no existe");
		}
		return ClienteDao.getInstance().traerDni(dni);
	}
	
	public Cliente traerCuit(String cuit) throws Exception {
		if(ClienteDao.getInstance().traerCuit(cuit) == null) {
			throw new Exception("ERROR: No existe ningun cliente con ese CUIT");
		}
		return ClienteDao.getInstance().traerCuit(cuit);
	}

	public List<Cliente> traer() {
		return ClienteDao.getInstance().traer();
	}
	
	public Cliente traerPersonaFisica(int idCliente) throws Exception {
		Cliente cliente = traer(idCliente);
		if(!(cliente instanceof PersonaFisica)) {
			throw new Exception("ERROR: El cliente no pertenece a esa clase");
		}
		return ClienteDao.getInstance().traer(idCliente);
	}
	
	public Cliente traerPersonaJuridica(int idCliente) throws Exception {
		Cliente cliente = traer(idCliente);
		if(!(cliente instanceof PersonaJuridica)) {
			throw new Exception("ERROR: El cliente no pertenece a esa clase");
		}
		return ClienteDao.getInstance().traer(idCliente);
	}
	
	public Cliente traerClienteEInscripcionAfip(int idCliente) {
		return ClienteDao.getInstance().traerClienteEInscripcionAfip(idCliente);
	}
	
	public int agregarPersonaFisica(String nroCliente,String apellido, String nombre, int dni) throws Exception {
		PersonaFisica personaFisica = new PersonaFisica(nroCliente,apellido,nombre,dni);
		if(ClienteDao.getInstance().traerDni(dni) != null) {
			throw new Exception("ERROR: Ya existe un cliente con ese DNI");
		}
		return ClienteDao.getInstance().agregar(personaFisica);
	}
	
	public int agregarPersonaJuridica(String nroCliente, String razonSocial, String cuit) throws Exception {
		PersonaJuridica personaJuridica = new PersonaJuridica(nroCliente,razonSocial,cuit);
		if(ClienteDao.getInstance().traerCuit(cuit) != null) {
			throw new Exception("ERROR: Ya existe un cliente con ese CUIT");
		}
		return ClienteDao.getInstance().agregar(personaJuridica);
	}
	
	public void eliminarCliente(int idCliente) throws Exception {
		Cliente cliente = ClienteDao.getInstance().traer(idCliente);
		if(ClienteDao.getInstance().traer(idCliente) == null) {
			throw new Exception("ERROR: No hay ningun cliente con esa ID");
		}
		ClienteDao.getInstance().eliminar(cliente);
	}
	
	public int agregarPersonaFisica(Cliente cliente) throws Exception {
		int dni = ((PersonaFisica)cliente).getDni();
		if(ClienteDao.getInstance().traerDni(dni) != null) {
			throw new Exception("ERROR: El cliente ya existe");
		}
		return ClienteDao.getInstance().agregar(cliente);
	}
	
	public int agregarPersonaJuridica(Cliente cliente) throws Exception {
		String cuit = ((PersonaJuridica)cliente).getCuit();
		if(ClienteDao.getInstance().traerCuit(cuit) != null) {
			throw new Exception("ERROR: El cliente ya existe");
		}
		return ClienteDao.getInstance().agregar(cliente);
	}
	
	public int agregarContacto(String email, String telefonoFijo, String movil, Cliente cliente) {
		ClienteDao.getInstance().agregar(cliente);
		Contacto contacto = new Contacto(email,telefonoFijo,movil,cliente);
		return ContactoAbm.getInstance().agregarContacto(contacto);
	}
	
	public int agregarInscripcionAfip(String inscripcionAfip,Cliente cliente) {
		ClienteDao.getInstance().agregar(cliente);
		InscripcionAfip inscripcion = new InscripcionAfip(inscripcionAfip,cliente);
		return InscripcionAfipAbm.getInstance().agregarInscripcionAfip(inscripcion);
	}
	
	public int agregarCliente(Cliente cliente) throws Exception {
		if(ClienteDao.getInstance().traer(cliente.getIdCliente()) != null) {
			throw new Exception("ERROR: Ya hay un cliente con esa ID");
		}
		return ClienteDao.getInstance().agregar(cliente);
	}
	
	public void actualizarCliente(Cliente cliente) {
		ClienteDao.getInstance().actualizar(cliente);
	}

}
