package test;

import java.time.LocalDate;

import datos.Empleado;
import negocio.LlamadaAbm;
import negocio.PersonaAbm;

public class TestOO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaAbm personaAbm = new PersonaAbm();
		LlamadaAbm llamadaAbm = new LlamadaAbm();

		System.out.println("\n1) Agregar los siguientes objetos a la bd:\n");
		try {
			personaAbm.agregarPersona("Emp 1", "Ape 3", 33333333, 10000);
			personaAbm.agregarPersona("Emp 2", "Ape 4", 44444444, 9000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}

		System.out.println("\n2) Tratar de agregar el siguiente Empleado:\n");

		try {
			personaAbm.agregarPersona("Emp 5", "Ape 5", 33333333, 9500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}

		System.out.println("\n3) Agregar las siguientes llamadas a la lista llamadas e imprimir la lista:\n");

		/*
		 * llamadaAbm.agregarLlamada(LocalDate.of(2023, 7, 1), (Cliente)
		 * personaAbm.traerPersona(11111111), (Empleado)
		 * personaAbm.traerPersona(33333333), 5);
		 * llamadaAbm.agregarLlamada(LocalDate.of(2023, 7, 1), (Cliente)
		 * personaAbm.traerPersona(22222222), (Empleado)
		 * personaAbm.traerPersona(33333333), 2);
		 * llamadaAbm.agregarLlamada(LocalDate.of(2023, 7, 2), (Cliente)
		 * personaAbm.traerPersona(11111111), (Empleado)
		 * personaAbm.traerPersona(33333333), 5);
		 * 
		 * llamadaAbm.agregarLlamada(LocalDate.of(2023, 7, 2), (Cliente)
		 * personaAbm.traerPersona(11111111), (Empleado)
		 * personaAbm.traerPersona(33333333), 4);
		 * llamadaAbm.agregarLlamada(LocalDate.of(2023, 7, 2), (Cliente)
		 * personaAbm.traerPersona(11111111), (Empleado)
		 * personaAbm.traerPersona(44444444), 5);
		 * llamadaAbm.agregarLlamada(LocalDate.of(2023, 7, 2), (Cliente)
		 * personaAbm.traerPersona(11111111), (Empleado)
		 * personaAbm.traerPersona(33333333), 5);
		 * llamadaAbm.agregarLlamada(LocalDate.of(2023, 7, 3), (Cliente)
		 * personaAbm.traerPersona(11111111), (Empleado)
		 * personaAbm.traerPersona(33333333), 5);
		 */

		System.out.println("\nLista de Llamadas: \n" + llamadaAbm.traerLlamadas());

		System.out.println("\n4) Traer e imprimir las llamadas entre el 2/7/2023 al 3/7/2023:\n"
				+ llamadaAbm.traerLlamada(LocalDate.of(2023, 7, 2), LocalDate.of(2023, 7, 3)));
		System.out.println("\n5) Traer e imprimir las llamadas entre el 2/7/2023 al 3/7/2023 del empleado con dni=33333333:\n"
						+ llamadaAbm.traerLlamada(LocalDate.of(2023, 7, 2), LocalDate.of(2023, 7, 3),
								(Empleado) personaAbm.traerPersona(33333333)));
	}

}
