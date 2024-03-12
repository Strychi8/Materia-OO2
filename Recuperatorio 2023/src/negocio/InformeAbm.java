package negocio;

import datos.Informe;

public class InformeAbm {
  	private OrdenMantenimientoAbm ordenMantenimiento = new OrdenMantenimientoAbm();
	
	public Informe traerInforme(boolean pagada) {
		return new Informe(ordenMantenimiento.traer(pagada));
	}
}
