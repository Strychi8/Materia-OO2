package test;

import java.time.LocalDate;

import negocio.AlquilerABM;
import negocio.PropiedadABM;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       PropiedadABM propiedadAbm = new PropiedadABM();
       AlquilerABM alquilerAbm = new AlquilerABM();
       
       System.out.println("\n1) Traer todas las propiedades:\n" + propiedadAbm.traerPropiedad());
       System.out.println("\n2) Traer Alquiler por ID:\n" + alquilerAbm.traerAlquiler(1));
       System.out.println("\n3) Traer todas las propiedades de subtipo Departamento:\n" + propiedadAbm.traerPropiedad(true));
       System.out.println("\n4) Calcular el precio final para el alquiler ID 1:\n" + alquilerAbm.calcularPrecioFinal(alquilerAbm.traerAlquiler(1)));
      // System.out.println("\n5) Calcular el precio final para los alquileres entre las fechas:\n" + alquilerAbm.calcularPrecioFinal(LocalDate.of(2022, 3, 2), LocalDate.of(2022, 3, 9)));
	}

}
