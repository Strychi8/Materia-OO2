package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import datos.Cliente;
import datos.Evento;
import negocio.ClienteABM;
import negocio.EventoABM;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM clienteAbm = new ClienteABM();
		EventoABM eventoAbm = new EventoABM();
		Cliente cliente = clienteAbm.traerClienteYEventos(2l);
		Evento evento = eventoAbm.traerEventoYClientes(1l);

		Set<Evento> eventos = new HashSet<Evento>();
		Evento evento1 = eventoAbm.traerId(2l);
		eventos.add(evento1);
		Set<Cliente> clientes = new HashSet<Cliente>();
		Cliente cliente1 = clienteAbm.traerId(1l);
		clientes.add(cliente1);

		System.out.println("\n1) Traer el cliente con ID=2\n" + clienteAbm.traerId(2l));
		System.out.println("\n2) Traer el evento con ID=2\n" + eventoAbm.traerId(2l));
		System.out.println("\n3) Traer lista de clientes\n" + clienteAbm.traerListaClientes());
		System.out.println("\n4) Traer lista de eventos\n" + eventoAbm.traerListaEventos());

		System.out.println("\n5) Traer Cliente y sus eventos\n" + clienteAbm.traerClienteYEventos(2l));
		/*for (Evento e : cliente.getEventos()) {
			System.out.println("\n" + e);
		}*/

		/*System.out.println("\n6) Traer Evento y sus clientes\n" + eventoAbm.traerEventoYClientes(1l));
		for (Cliente c : evento.getClientes()) {
			System.out.println("\n" + c);
		}*/

		// System.out.println("\n7) Agregar evento a un cliente\n" +
		// eventoAbm.agregarEvento("Creditos para Analistas", LocalDate.of(2016, 4, 10),
		// LocalTime.of(12, 30)));

		/*try {
			System.out.println("\n8) Agregar cliente a eventos\n"
					+ clienteAbm.agregar("Strycharski", "Tomas", 42828997, LocalDate.of(2000, 7, 20), eventos));
		} catch (Exception e) { // TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}

		try {
			System.out.println("\n8) Agregar evento a cliente\n" + eventoAbm.agregarEvento("Despedida de Soltero",
					LocalDate.of(2020, 4, 20), LocalTime.of(22, 00), clientes));
		} catch (Exception e) { // TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}*/

		/*try {
			System.out.println("\n7) Agregar Cliente a Evento\n");
			clienteAbm.agregarClienteAEvento(10l, 5l);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}

		try {
			System.out.println("\n8) Eliminar Cliente a Evento\n");
			clienteAbm.eliminarClienteAEvento(3l, 5l);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}

		try {
			System.out.println("\n9) Agregar Evento a Cliente\n");
			eventoAbm.agregarEventoACliente(5l, 1l);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}

		try {
			System.out.println("\n10) Eliminar Evento a Cliente\n");
			eventoAbm.eliminarEventoACliente(5l, 1l);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}*/

	}

}
