package test;
import datos.Cliente;
import negocio.ClienteABM;

public class TestEliminarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abm = new ClienteABM();
		long id = 8;
		Cliente c = abm.traer(id);
		System.out.println("Cliente a eliminar --> "+ c);
		try {
			abm.eliminar(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

}
