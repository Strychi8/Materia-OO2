package test;

import java.time.LocalDate;

import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;
import negocio.CuotaABM;

public class TestTraerPrestamoYCuotas {
	public static void main(String[] args) {
		ClienteABM cabm = new ClienteABM();
		PrestamoABM pabm = new PrestamoABM();
		CuotaABM cuAbm = new CuotaABM();
		
//		try {
//			cabm.agregar("Vazquez", "Juan Cruz", 44168580, LocalDate.of(2002, 6, 22));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		pabm.agregar(LocalDate.now(), 123, 23, 2, cabm.traer(2));
		
//		Cliente c = cabm.traerClienteYPrestamos(2L);
//		for (Prestamo p : c.getPrestamos()) {
//			System.out.println(p.toString());
//		}
		
		
		Cuota c = cuAbm.traer(1L);
		System.out.println(c.toString());
		// Cuota [idCuota=1, nroCuota=1, fechaVencimiento=2023-05-23, saldoPendiente=15000.0, amortizacion=NaN, interesCuota=300000.0, cuota=NaN, deuda=NaN, cancelada=false, fechaDePago=2023-05-21, punitorios=3.0]
		
		
//		Prestamo p = pabm.traerPrestamoYCuotas(1L);
//		for (Cuota c : p.getCuotas()) {
//			System.out.println(c.toString());
//		}
		
		
		
	}
}
