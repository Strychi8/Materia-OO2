package test;
import java.time.LocalDate;
import negocio.ClienteABM;


public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String apellido = "Fernandez";
		String nombre = "Mauro";
		int documento = 42000555;
		// tu fecha de nacimiento
		LocalDate fechaDeNacimiento = LocalDate.now();
		ClienteABM abm = new ClienteABM();
		try {
		  abm.agregar(apellido, nombre, documento,fechaDeNacimiento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());;
		}
		}

	}
