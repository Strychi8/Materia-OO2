package test;
import datos.Cliente;
import negocio.ClienteABM;


public class TestActualizarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abm = new ClienteABM();
		long id = 9;
		// traer el obj a modificar
		Cliente c = abm.traer(id);
		System.out.println("Cliente a Modificar -->" + c);
		// modificar por set los atributos
		c.setDni(42999888);;
		try {
			abm.modificar(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 // update del objeto
		int dni = 42999888;
		Cliente cModif = abm.traer(dni);
		
		System.out.println("Cliente Modificado -->" + cModif);
		}
   
	}
