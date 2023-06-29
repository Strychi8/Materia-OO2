package test;

import java.time.LocalDateTime;

import negocio.DispositivoABM;
import negocio.EventoABM;

public class TestOO2Tema1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DispositivoABM dispositivoAbm = new DispositivoABM();
        EventoABM eventoAbm = new EventoABM();
        
        System.out.println("\n1) Traer Listado de los dispositivos:\n" + dispositivoAbm.traer());
        System.out.println("\n2) Agregar los eventos a la bd:\n");
        
        try {
			eventoAbm.agregar("Apertura de la cortina", dispositivoAbm.traer("cortina pieza"), LocalDateTime.of(2023, 4, 3, 9, 10));
			eventoAbm.agregar("Cierre de la cortina", dispositivoAbm.traer("cortina pieza"), LocalDateTime.of(2023, 4, 3, 19, 05));
			eventoAbm.agregar("Apertura de la cortina", dispositivoAbm.traer("cortina pieza"), LocalDateTime.of(2023, 4, 4, 9, 00));
			eventoAbm.agregar("Cierre de la cortina", dispositivoAbm.traer("cortina pieza"), LocalDateTime.of(2023, 4, 4, 19, 01));
			
			eventoAbm.agregar("23 grados. Prender Aire Acondicionado", dispositivoAbm.traer("temp pieza"), LocalDateTime.of(2023, 4, 4, 11, 30));
			eventoAbm.agregar("20 grados. Apagar Aire Acondicionado", dispositivoAbm.traer("temp pieza"), LocalDateTime.of(2023, 4, 4, 12, 00));
			eventoAbm.agregar("Apertura de la cortina", dispositivoAbm.traer("cortina pieza"), LocalDateTime.of(2023, 4, 5, 9, 05));
			eventoAbm.agregar("Cierre de la cortina", dispositivoAbm.traer("cortina pieza"), LocalDateTime.of(2023, 4, 5, 19, 05));
           
    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
        
        System.out.println("\n2-1) Lista de Eventos:\n" + eventoAbm.traer());
        
        System.out.println("\n3) Traer los eventos:\n" + eventoAbm.traer(LocalDateTime.of(2023, 04, 03, 12, 00), LocalDateTime.of(2023, 04, 05, 12, 00)));
        System.out.println("\n4) Traer los eventos:\n" + eventoAbm.traer(LocalDateTime.of(2023, 04, 03, 12, 00), LocalDateTime.of(2023, 04, 05, 12, 00), dispositivoAbm.traer("cortina pieza")));
        System.out.println("\n5) Devolver todos los dispositivos tipo sensor temperatura:\n" + dispositivoAbm.traerTodosLosDispositivosSensorTemperatura());
	}

}