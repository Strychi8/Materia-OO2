package negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import dao.ClienteDao;
import dao.EventoDao;
import datos.Cliente;
import datos.Evento;

public class ClienteABM {
     ClienteDao dao = new ClienteDao();
     EventoDao daoE = new EventoDao();
     
     public Cliente traerId(long idCliente) {
    	 Cliente cliente = dao.traer(idCliente);
    	 return cliente;
     }
     
     public Cliente traerDni(int dni) {
    	 Cliente cliente = dao.traer(dni);
    	 return cliente;
     }
     
     public List<Cliente> traerListaClientes(){
    	 return dao.traer();
     }
     
     public Cliente traerClienteYEventos(long idCliente) {
    	 Cliente c = dao.traerClienteYEventos(idCliente);
    	 
    	 /*if(c == null) {
    		 throw new Exception("ERROR: No existe ningun cliente con esa ID");
    	 }
    	 if(c.getEventos().isEmpty()) {
    		 throw new Exception("ERROR: El cliente no tiene eventos");
    	 }*/
   
    	 return c;
     }
     
     public void agregarClienteAEvento(long idCliente,long idEvento) throws Exception {
    	 Cliente cliente = dao.traer(idCliente);
    	 if(cliente == null) {
    		 throw new Exception("ERROR: No existe un cliente con esa ID");
    	 }
    	 Evento evento = daoE.traerEventoYClientes(idEvento);  
    	 if(evento == null) {
    		 throw new Exception("ERROR: No existe un evento con esa ID");
    	 }
    	 
    	 for(Cliente c: evento.getClientes()) {
    		 if(c.getIdCliente() == cliente.getIdCliente()) {
    			 throw new Exception("ERROR: El cliente ya existe en la lista");
    		 }
    	 }
    	 evento.getClientes().add(cliente);
    	 daoE.actualizar(evento);  
     }
     
     public void eliminarClienteAEvento(long idCliente,long idEvento) throws Exception {
    	 Cliente cliente = dao.traer(idCliente);
    	 if(cliente == null) {
    		 throw new Exception("ERROR: No existe ningun cliente con esa ID");
    	 }
    	 Evento evento = daoE.traerEventoYClientes(idEvento);
    	 if(evento == null) {
    		 throw new Exception("ERROR: No existe ningun evento con esa ID");
    	 }
    	 
    	 evento.getClientes().remove(cliente);
    	 daoE.actualizar(evento);
    	 
     }
     public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento,Set<Evento> eventos) throws Exception {
    	 Cliente cliente = new Cliente(apellido,nombre,dni,fechaDeNacimiento,eventos);
    	 if(traerDni(dni) != null) {
    		 throw new Exception("ERROR: Ya existe un cliente con ese DNI");
    	 }
    	 return dao.agregar(cliente);
     }
     
     public void modificar(Cliente cliente) throws Exception {
    	 if(traerId(cliente.getIdCliente()) == null) {
    		 throw new Exception("ERROR: No se puede modificar el Cliente porque no existe la ID");
    	 }else if(traerDni(cliente.getDni()) != null) {
    		 throw new Exception("ERROR: No se puede modificar el Cliente porque ya existe un cliente con el DNI: " + cliente.getDni());
    	 }
    	 dao.actualizar(cliente);
     }
     public void eliminar(long idCliente) throws Exception {
    	 Cliente cliente = dao.traer(idCliente);
    	 if(cliente == null) {
    		 throw new Exception("ERROR: No existe ningun cliente con esa ID");
    	 }
    	 dao.eliminar(cliente);
     }
}
