package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.CuotaDao;
import datos.Cuota;
import datos.Prestamo;

public class CuotaABM {
	CuotaDao dao = new CuotaDao();

	public int agregar(int nroCuota, LocalDate fechaVencimiento, double saldoPendiente, LocalDate fechaDePago,
			double punitorios, Prestamo prestamo) {
		return dao.agregar(new Cuota(nroCuota, fechaVencimiento, saldoPendiente, fechaDePago, punitorios, prestamo));
	}

	public int agregar(int nroCuota, LocalDate fechaVencimiento, double saldoPendiente, double amortizacion,
			double interesCuota, double cuota, double deuda, LocalDate fechaDePago, double punitorios) {
		return dao.agregar(new Cuota(nroCuota, fechaVencimiento, saldoPendiente, amortizacion, interesCuota, cuota,
				deuda, fechaDePago, punitorios));
	}

	public void modificar(Cuota c) {
		dao.actualizar(c);
	}

	public void eliminar(long idCuota) throws Exception {
		Cuota c = dao.traer(idCuota);
		if (c == null) {
			throw new Exception("ERROR: No existe una cuota con ese ID.");
		}
		dao.eliminar(c);
	}

	public Cuota traer(long idCuota) {
		return dao.traer(idCuota);
	}

	public Cuota traer(int nroCuota) {
		return dao.traer(nroCuota);
	}

	public List<Cuota> traer() {
		return dao.traer();
	}
}
