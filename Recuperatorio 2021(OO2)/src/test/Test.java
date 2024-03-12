package test;

import java.time.LocalTime;

import negocio.DosisABM;
import negocio.PersonaABM;
import negocio.VacunaABM;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        VacunaABM vacunaAbm = new VacunaABM();
        PersonaABM personaAbm = new PersonaABM();
        DosisABM dosisAbm = new DosisABM();
        
        System.out.println("\n1) Traer vacuna por codigo:\n" + vacunaAbm.traerVacuna(800011));
        //System.out.println("\n2) Traer personas entre 30 y 40 años:\n " + personaAbm.traerPersona(30, 40));
        System.out.println("\n3) Traer dosis con vacuna:\n" + dosisAbm.traerDosis(vacunaAbm.traerVacuna(800011)));
        System.out.println("\n4) Traer dosis con hora:\n" + dosisAbm.traerDosis(LocalTime.of(11, 15, 00), LocalTime.of(11, 45, 00)));
        System.out.println("\n5) Traer dosis con hora y comorbilidad:\n" + dosisAbm.traerDosis(LocalTime.of(11, 15, 00), LocalTime.of(11, 45, 00),false));
	}

}
