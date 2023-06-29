package negocio;

import java.util.List;

import dao.InscripcionAfipDao;
import datos.InscripcionAfip;

public class InscripcionAfipAbm {
	private static InscripcionAfipAbm instancia = null;// Patrón Singleton

	protected InscripcionAfipAbm() {}

	public static InscripcionAfipAbm getInstance() {
		if (instancia == null)
			instancia = new InscripcionAfipAbm();
		return instancia;
	}

	public InscripcionAfip traer(int idInscripcionAfip) {
		return InscripcionAfipDao.getInstance().traer(idInscripcionAfip);
	}

	public List<InscripcionAfip> traer() {
		return InscripcionAfipDao.getInstance().traer();
	}
	
	public int agregarInscripcionAfip(InscripcionAfip inscripcion) {
		return InscripcionAfipDao.getInstance().agregar(inscripcion);
	}
}
