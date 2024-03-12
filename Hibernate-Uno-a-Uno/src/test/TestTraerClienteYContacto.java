package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestTraerClienteYContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abmCliente = new ClienteABM();
		long idCliente = 1;
		Cliente cliente = abmCliente.traerClienteYContacto(idCliente);
		System.out.println("\n1) Traer Cliente y Contacto\n" + cliente + "\n" + cliente.getContacto());	

	}

}
