package test;

import java.time.LocalDate;

import datos.Lugar;
import negocio.LugarAbm;
import negocio.PermisoAbm;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       PermisoAbm permisoAbm = new PermisoAbm();
       LugarAbm lugarAbm = new LugarAbm();
       Lugar lugar = null;
       
       System.out.println("\n1) Traer Permiso:\n" + permisoAbm.traerPermiso(4));
    
       System.out.println("\n2) Traer Localidad:\n");
		try {
			lugar = lugarAbm.traerLocalidad(3);
			System.out.println(lugar);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
       System.out.println("\n3) \n" + lugar.ingresoHabilitado(4, LocalDate.of(2021, 5, 12)));
       System.out.println("\n4) \n" + lugar.ingresoHabilitado(4, LocalDate.of(2021, 5, 20)));
       System.out.println("\n5) \n" + lugar.ingresoHabilitado(4, LocalDate.of(2021, 5, 25)));
       
       System.out.println("\n6) Traer Ubicacion:\n");
		try {
			lugar = lugarAbm.traerUbicacion(4);
			System.out.println(lugar);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("\n7) \n" + lugar.ingresoHabilitado(3, LocalDate.of(2021, 4, 30)));
	    System.out.println("\n8) \n" + lugar.ingresoHabilitado(3, LocalDate.of(2021, 3, 31)));
       
       
	}

}
