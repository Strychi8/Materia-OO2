package test;

import java.time.LocalDate;

import datos.Telepeaje;
import negocio.AbonadoAbm;
import negocio.PeajeAbm;
import negocio.RodadoAbm;

public class TestOO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PeajeAbm peajeAbm = new PeajeAbm();
		RodadoAbm rodadoAbm = new RodadoAbm();
		AbonadoAbm abonadoAbm = new AbonadoAbm();
		
		
        System.out.println("\n1) Traer Manual: \n" + peajeAbm.traerManual());
        System.out.println("\n2) Traer Telepeaje: \n" + peajeAbm.traerTelepeaje());
        System.out.println("\n3) Traer e imprimir los peajes Manual de fecha: \n" + peajeAbm.traerManual(LocalDate.of(2020, 11, 01)));
        System.out.println("\n4) Calcular e imprimir el total de caja: \n" + peajeAbm.cerrarCaja(LocalDate.of(2020, 11, 01)));
        System.out.println("\n5) Traer rodado con dominio: \n" + rodadoAbm.traerRodado("AAA111"));
        System.out.println("\n6) Traer Lista Telepeaje Rodado:\n" + peajeAbm.traerTelepeaje(rodadoAbm.traerRodado("AAA111")));
        double descuento = 0;
        for(Telepeaje t: peajeAbm.traerTelepeaje(rodadoAbm.traerRodado("AAA111"))) { //ME FALTA HACER BIEN LA FECHA
        	descuento = descuento + t.calcularDescuento(50);
        }
        System.out.println("\n6-1) El descuento para el Rodado es: \n" + descuento);
        System.out.println("\n7) Traer abonado con dni=111111111:\n" + abonadoAbm.traerAbonado(11111111));
        System.out.println("\n8) Traer Lista Telepaje Abonado:\n" + peajeAbm.traerTelepeaje(abonadoAbm.traerAbonado(11111111)));
	}

}
