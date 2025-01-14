package test;

import java.time.LocalDate;

import dao.CuotaDao;
import negocio.ClienteABM;
import negocio.CuotaABM;
import negocio.PrestamoABM;

public class TestAgregarCuota {

	public static void main(String[] args) {

		ClienteABM clAbm = new ClienteABM();
		PrestamoABM pAbm = new PrestamoABM();
		CuotaABM cAbm = new CuotaABM();
		cAbm.agregar(2, LocalDate.of(2023, 5, 24), 250, LocalDate.of(2023, 5, 21), 3, pAbm.traerPrestamo(2L));
	}

}
