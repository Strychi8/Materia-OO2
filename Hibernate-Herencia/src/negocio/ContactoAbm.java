package negocio;

import java.util.List;

import dao.ContactoDao;
import datos.Contacto;

public class ContactoAbm {
	private static ContactoAbm instancia = null;// Patrón Singleton

	protected ContactoAbm() {}

	public static ContactoAbm getInstance() {
		if (instancia == null)
			instancia = new ContactoAbm();
		return instancia;
	}

	public Contacto traer(int idContacto) {
		return ContactoDao.getInstance().traer(idContacto);
	}

	public List<Contacto> traer() {
		return ContactoDao.getInstance().traer();
	}
	
	public int agregarContacto(Contacto contacto) {
		return ContactoDao.getInstance().agregar(contacto);
	}
	
	public void eliminarContacto(int idContacto) throws Exception {
		Contacto c = ContactoDao.getInstance().traer(idContacto);
		if(c == null) {
			throw new Exception("ERROR: No hay ningun Contacto con esa ID");
		}
		ContactoDao.getInstance().eliminar(c);
	}
}
