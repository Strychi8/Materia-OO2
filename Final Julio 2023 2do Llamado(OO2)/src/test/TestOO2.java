package test;

import java.time.LocalDateTime;

import negocio.CargaAbm;
import negocio.ClienteAbm;
import negocio.VueloAbm;

public class TestOO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ClienteAbm clienteAbm = new ClienteAbm();
      CargaAbm cargaAbm = new CargaAbm();
      VueloAbm vueloAbm = new VueloAbm();
     
      System.out.println("\n1) Traer e imprimir cliente con dni=12569874: \n" + clienteAbm.traer(12569874));
      System.out.println("\n2) Traer e imprimir todas las cargas con todos los atributos: \n" + cargaAbm.traer(clienteAbm.traer(12569874)));
      System.out.println("\n3) Traer e imprimir vuelo AR2234: \n" + vueloAbm.traer("AR2234"));
      System.out.println("\n4) Traer e imprimir equipajes del vuelo=AR2234:\n" + cargaAbm.traer(vueloAbm.traer("AR2234"), true));
      System.out.println("\n5) Traer envios recibidos el 26/06/2023: \n" + cargaAbm.traer(LocalDateTime.of(2023, 06, 26, 0, 0), LocalDateTime.of(2023, 06, 26, 23, 59)));
      
	}

}
