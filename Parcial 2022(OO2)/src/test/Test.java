package test;

import java.time.LocalDate;

import datos.Edificio;
import negocio.AulaAbm;
import negocio.EdificioAbm;
import negocio.EspacioAbm;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       EdificioAbm edificioAbm = new EdificioAbm();
       AulaAbm aulaAbm = new AulaAbm();
       EspacioAbm espacioAbm = new EspacioAbm();
       
       Edificio edificio = edificioAbm.traerEdificioConAulas(1);
       System.out.println("\n1) Traer Edificio con Aulas:\n" + edificio);
       System.out.println(edificio.getAulas());
       System.out.println("\n2) Traer Aula con Edificio:\n" + aulaAbm.traer(5));
       System.out.println("\n3) Traer Espacio:\n" + espacioAbm.traer(LocalDate.of(2022, 5, 1), 'M', aulaAbm.traer(5)));
       
       System.out.println("\n4) Intentar agregar espacio:");
       try {
		  espacioAbm.agregar(LocalDate.of(2022, 5, 1), 'M',  aulaAbm.traer(5), true);
	   } catch (Exception e) {
		// TODO Auto-generated catch block
		  System.err.println(e.getMessage());
	   }
       
       System.out.println("\n5) Agregar los objetos espacio:");
       try {
		  espacioAbm.agregarEspacioMes(5, 2022, 'M', aulaAbm.traer(3));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		  System.err.println(e.getMessage());
	}
       
      
	}

}
