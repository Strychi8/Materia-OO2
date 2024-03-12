package test;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestAgregarContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abmCliente = new ClienteABM();
		long idCliente = 3;
		Cliente cliente = abmCliente.traer(idCliente);
		System.out.println(cliente);
		ContactoABM abmContacto = new ContactoABM();
	    //abmContacto.agregar("ajaramillo@unla.edu.ar","11-1111-1111","011-1111-1111", cliente);
			
		try {
			abmContacto.eliminar(idCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

}
