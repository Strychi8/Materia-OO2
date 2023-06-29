package test;

import datos.Cliente;
import datos.Contacto;
import datos.PersonaFisica;
import negocio.ClienteABM;
import negocio.ContactoAbm;
import negocio.InscripcionAfipAbm;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente = new PersonaFisica("1022","Strycharski","Tomas",42828997);
		int idCliente;
		/*try {
			idCliente = ClienteABM.getInstance().agregarCliente(cliente);
			ClienteABM.getInstance().traer(idCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
	    System.out.println("\n0) Agregar Contacto a Cliente");
		Contacto contacto = new Contacto("tomas40@gmail.com","22-2222-2222","02-222-222",cliente);
		ContactoAbm.getInstance().agregarContacto(contacto);*/
		
		try {
			System.out.println("\n1) Traer Cliente por CUIT:\n" + ClienteABM.getInstance().traerCuit("300000001"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		idCliente=1;
		try {
			System.out.println("\n2) Traer Cliente(Persona Fisica) por ID:\n" + ClienteABM.getInstance().traerPersonaFisica(idCliente));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	
		idCliente=2;
		try {
			System.out.println("\n3) Traer Cliente(Persona Juridica) por ID:\n" + ClienteABM.getInstance().traerPersonaJuridica(idCliente));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		System.out.println("\n4) Traer Lista de Clientes: " + ClienteABM.getInstance().traer());
		
		/*try {
			System.out.println("\n5) Agregar Persona Fisica:\n" + ClienteABM.getInstance().agregarPersonaFisica("33333333","Carlos","Talisco",33333333));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		try {
			System.out.println("\n6) Agregar Persona Juridica:\n" + ClienteABM.getInstance().agregarPersonaJuridica("44444444","Uade","435556660"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}*/
		
		System.out.println("\n7) Traer Contacto con ID:\n" + ContactoAbm.getInstance().traer(1));
		System.out.println("\n8) Traer InscripcionAfip por ID:\n" + InscripcionAfipAbm.getInstance().traer(1));
		
       
	}

}
