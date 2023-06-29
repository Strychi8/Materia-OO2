package test;
import negocio.ClienteABM;

public class TestTraerTodosLosClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           ClienteABM abm = new ClienteABM();
           System.out.println("\nTraer todos los clientes: \n"+ abm.traer()); 
       
	}

}
