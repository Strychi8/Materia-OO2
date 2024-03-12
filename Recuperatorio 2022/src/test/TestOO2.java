package test;

import java.time.LocalDate;

import negocio.MateriaAbm;
import negocio.NotaPedidoAbm;

public class TestOO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MateriaAbm materiaAbm = new MateriaAbm();
        NotaPedidoAbm notaPedidoAbm = new NotaPedidoAbm();
        
        System.out.println("\n1) Traer la materia con id=1:\n" + materiaAbm.traerMateria(1));
        System.out.println("\n2) Traer una nota pedido con id=1 con info de la materia:\n" + notaPedidoAbm.traerNotaPedidoConMateria(1));
	    System.out.println("\n3) Traer la info completa de cada nota pedido:\n" + notaPedidoAbm.traer(LocalDate.of(2022, 03, 01)));
	    System.out.println("\n4) Traer la info completa de cada nota pedido con fecha de Final entre las fechas:\n" 
	    + notaPedidoAbm.traerFinales(LocalDate.of(2022, 05, 10), LocalDate.of(2022, 05, 11)));
	    System.out.println("\n5) Traer la info completa de cada nota pedido con fecha de Final entre 2 fechas y el id de la Materia:\n" 
	    + notaPedidoAbm.traerFinales(LocalDate.of(2022, 05, 10), LocalDate.of(2022, 05, 11), materiaAbm.traerMateria(3)));
	    System.out.println("\n6) Agregar el sig objeto a la bd:\n" + notaPedidoAbm.agregar(LocalDate.of(2022, 06, 15), 100, materiaAbm.traerMateria(3), "cod 101"));
	
	}
	

}
