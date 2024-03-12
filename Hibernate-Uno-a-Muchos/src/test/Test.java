package test;

import java.util.List;

import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.CuotaABM;
import negocio.PrestamoABM;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         CuotaABM cuotaAbm = new CuotaABM();
         PrestamoABM prestamoAbm = new PrestamoABM();
         ClienteABM clienteAbm = new ClienteABM();
         
         System.out.println("\n1) Traer Cuota por ID:\n" + cuotaAbm.traerIdCuota(2l));
         
        /* try {
			System.out.println("\n2) Traer Prestamo por ID:\n" + prestamoAbm.traerPrestamo(2));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.err.println(e1.getMessage());
		}*/
         
         try {
			System.out.println("\n3) Traer Prestamo y sus Cuotas por ID:\n" + prestamoAbm.traerPrestamoYCuotas(2l));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
       
         
         try {
			System.out.println("\n4) Traer Cuota por NroCuota e idPrestamo:\n" + cuotaAbm.traerNroCuotaYPrestamo(1, 1l));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
         
        
        
         
         
	} 

}
