package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PrestamoDao;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	PrestamoDao dao = new PrestamoDao();

	public Prestamo traerPrestamo(long idPrestamo) {
		return dao.traer(idPrestamo);
	}

	public Prestamo traerPrestamoYCuotas(long idPrestamo) {
		return dao.traerPrestamoYCuota(idPrestamo);
	}

	public List<Prestamo> traerPrestamo(Cliente c) {
		return dao.traer(c);
	}

	public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente) {
		return dao.agregar(new Prestamo(fecha, monto, interes, cantCuotas, cliente));
	}

	public void modificar(Prestamo p) {
		dao.actualizar(p);
	}

	public void eliminar(long idPrestamo) throws Exception {
		Prestamo p = dao.traer(idPrestamo);
		if (p == null) {
			throw new Exception("ERROR: No existe un prestamo con ese ID");
		}
		dao.eliminar(p);
	}
}