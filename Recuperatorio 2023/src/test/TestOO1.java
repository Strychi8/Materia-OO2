package test;

import datos.OrdenMantenimiento;
import negocio.AmbienteAbm;
import negocio.InformeAbm;
import negocio.OrdenMantenimientoAbm;

public class TestOO1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       AmbienteAbm ambienteAbm = new AmbienteAbm();
       OrdenMantenimientoAbm ordenMantenimiento = new OrdenMantenimientoAbm();
       InformeAbm informe = new InformeAbm();
       
       System.out.println("\n1) Imprimir ambiente id=2:\n" + ambienteAbm.traer(2));
       System.out.println("\n2) Imprimir Orden de Mantenimiento con Ambiente idAmbiente=2:\n" + ordenMantenimiento.traer(ambienteAbm.traer(2)));
       System.out.println("\n3) Imprimir Orden de Mantenimiento sin terminar ambiente idAmbiente=2:\n" + ordenMantenimiento.traer(ambienteAbm.traer(2), false));
       System.out.println("\n4) Calcular e imprimir el tiempo de ejecucion:\n" );
       for(OrdenMantenimiento orden: ordenMantenimiento.traer(ambienteAbm.traer(2),false)) {
    	   System.err.println("Faltan " + orden.tiempoDeEjecucion() + " dias para terminar");
       }
       System.out.println("\n5) Imprimir el Informe con las ordenes de Mantenimiento: \n" + informe.traerInforme(false));
	}

}
