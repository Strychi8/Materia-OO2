package negocio;

import dao.ContactoDao;
import datos.Contacto;

public class ContactoABM {
	ContactoDao dao = new ContactoDao();

	public Contacto traer(long idContacto) {
		return dao.traer(idContacto);
	}

	public int agregar(String email, String movil, String fijo) {
		return dao.agregar(new Contacto(email, movil, fijo));
	}

	public void modificar(Contacto contacto) {
		dao.actualizar(contacto);
	}

	public void eliminar(long idContacto) throws Exception {
		Contacto contacto = dao.traer(idContacto);
		if(contacto == null) {
			throw new Exception("ERROR: No existe ningun contacto con esa ID");
		}
		dao.eliminar(contacto);
	}
}
