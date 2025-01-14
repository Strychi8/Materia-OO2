package test;

import java.time.LocalDate;
import java.time.LocalTime;

import negocio.ClienteABM;
import negocio.EventoABM;

public class TestEvento {

	public static void main(String[] args) {
		ClienteABM clienteABM = new ClienteABM();
		EventoABM eventoABM = new EventoABM();

		// CREAR EVENTO
		/*
		 * String nombre= "Junta de obras"; 
		 * LocalDate fecha = LocalDate.of(2023, 2, 13);
		 * LocalTime hora = LocalTime.of(18, 0); 
		 * try { eventoABM.agregar(nombre, fecha,hora); 
		 * } catch (Exception e) { 
		 * System.out.println(e.getMessage()); 
		 * }
		 * 
		 */

		// CREAR CLIENTE
		/*
		String nombre = "Rafael";
		String apellido = "Perez";
		int dni = 39678563;
		LocalDate fechaDeNacimiento = LocalDate.of(2001, 3, 21);
		try {
			clienteABM.agregar(nombre,apellido,dni,fechaDeNacimiento);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		// AGREGAR CLIENTE A EVENTO
		try {
			eventoABM.agregarClienteAEvento(1, 3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// ELIMINAR CLIENTE A EVENTO 
		try {
			eventoABM.eliminarClienteAEvento(2, 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// CORREGIR ELIMINAR
	}

}
