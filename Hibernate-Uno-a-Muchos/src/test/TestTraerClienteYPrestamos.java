package test;

import negocio.ClienteABM;
import datos.Cliente;
import datos.Prestamo;

public class TestTraerClienteYPrestamos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long idCliente = 1;
		ClienteABM cliAbm = new ClienteABM();
		Cliente cliente = cliAbm.traerClienteYPrestamos(idCliente);
		System.out.println("\n1) Traer Cliente y Prestamos idCliente: " + idCliente);
		System.out.println("\n" + cliente);
		// implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
         /*for(Prestamo p: cliente.getPrestamos()) {
        	 System.out.println("\n" + p);
         }*/
	}

}
