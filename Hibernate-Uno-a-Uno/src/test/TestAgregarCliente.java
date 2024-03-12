package test;

import java.time.LocalDate;

import datos.Cliente;
import datos.Contacto;
import negocio.ClienteABM;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM clienteAbm = new ClienteABM();
		Contacto contacto = new Contacto("ajaramillo@unla.edu.ar","11-1111-1111","011-1111-1111");
		
		/*System.out.println("\n1) Agregar cliente:\n ");
		try {
			clienteAbm.agregar("Alonso", "Javier", 36000999, LocalDate.of(1987, 6, 10),contacto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}*/
		System.out.println("\n2) Modificar cliente:\n");
		long id = 6;
		Cliente cliente = clienteAbm.traer(id);
		System.out.println("Cliente a Modificar -->" + cliente);
		cliente.setDni(20000000);
		try {
			clienteAbm.modificar(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		int dni = 20000000;
		System.out.println("Cliente modificado: " + clienteAbm.traer(dni));	
		
		/*
		System.out.println("\n2) Eliminar cliente:\n ");
		try {
			clienteAbm.eliminar(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}*/
	}

}
