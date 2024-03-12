package negocio;

import dao.PrestamoDao;
import java.time.LocalDate;
import java.util.List;

import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao = new PrestamoDao();

	public Prestamo traerPrestamo(long idPrestamo) throws Exception {
		//Implementar: si no existe el prestamo lanzar la excepción
		Prestamo prestamo = dao.traer(idPrestamo);
		if(prestamo == null) {
			throw new Exception("ERROR: No existe ningun prestamo con esa ID");
		}
		return prestamo;
	}

	public List<Prestamo> traerPrestamos(Cliente cliente) {
		return dao.traer(cliente);
	}
	
	public List<Prestamo> traerPrestamos(Cliente cliente, boolean prestamoFinalizado){
		return dao.traer(cliente, prestamoFinalizado);
	}
	
	public List<Prestamo> traerPrestamos(LocalDate fecha){
		return dao.traer(fecha);
	}
	
	public List<Prestamo> traerPrestamos(LocalDate desde, LocalDate hasta){
		return dao.traer(desde, hasta);
	}
	
	public List<Prestamo> traerPrestamos1(LocalDate fechaVencimiento){
		return dao.traerFechaVencimiento(fechaVencimiento);
	}
	
	public int agregar(LocalDate fecha,double monto, double interes, int cantCuotas, boolean prestamoFinalizado,Cliente cliente) {
		return dao.agregar(new Prestamo(fecha,monto,interes,cantCuotas,prestamoFinalizado,cliente));
	}
	
	public void modificar(Prestamo prestamo) {
		dao.actualizar(prestamo);
	}
	
	public void eliminar(long idPrestamo) {
		dao.eliminar(dao.traer(idPrestamo));
	}
	
	public Prestamo traerPrestamoYCuotas(long idPrestamo) {
		return dao.traerPrestamoYCuotas(idPrestamo);
	}
}
