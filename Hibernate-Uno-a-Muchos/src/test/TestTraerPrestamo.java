package test;

import java.time.LocalDate;
import java.util.List;
import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerPrestamo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrestamoABM prestamoABM = new PrestamoABM();
		ClienteABM clienteABM = new ClienteABM();
				
		// implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
		
		int dni = 14000000;
		System.out.println("\n2) TraerPrestamos del Cliente con ID=" + clienteABM.traer(dni));
	
		System.out.println("\n3)Lista de Prestamos:\n" + prestamoABM.traerPrestamos(clienteABM.traer(dni)));
	
		// implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
		/*for (Prestamo o : prestamos)
			System.out.println("\n" + o);*/
		
		System.out.println("\n4)Traer todos los prestamos de un cliente que estén impagos:\n" + prestamoABM.traerPrestamos(clienteABM.traer(dni), false));
		System.out.println("\n5)Lista de Prestamos por Fecha:\n" + prestamoABM.traerPrestamos(LocalDate.of(2015, 11, 02)));
		System.out.println("\n6)Lista de Prestamos por rango:\n" + prestamoABM.traerPrestamos(LocalDate.of(2015, 10, 10), LocalDate.of(2016, 02, 7)));
		System.out.println("\n7)Lista de Prestamos que tengan una cuota que vence en una fecha:\n" + prestamoABM.traerPrestamos1(LocalDate.of(2023, 04, 06)));
		
		
	}

}
