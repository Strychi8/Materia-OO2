package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import dao.ClienteDao;
import dao.EventoDao;
import datos.Cliente;
import datos.Evento;

public class EventoABM {
     EventoDao dao = new EventoDao();
     ClienteDao daoC = new ClienteDao();
     
     public Evento traerId(long idEvento) {
    	 Evento evento = dao.traer(idEvento);
    	 return evento;
     }
     
     public List<Evento> traerListaEventos(){
    	 return dao.traer();
     }
     
     public Evento traerEventoYClientes(long idEvento) {
        return dao.traerEventoYClientes(idEvento);
     }
     
     public int agregarEvento(String evento,LocalDate fecha,LocalTime hora, Set<Cliente> clientes) {
    	 Evento event = new Evento(evento,fecha,hora,clientes);
    	 return dao.agregar(event);
     }
     
     public void agregarEventoACliente(long idEvento,long idCliente) throws Exception {
    	 Evento evento = dao.traer(idEvento);
    	 if(evento == null) {
    		 throw new Exception("ERROR: No existe un evento con esa ID");
    	 }
    	 Cliente cliente = daoC.traerClienteYEventos(idCliente);
    	 if(cliente == null) {
    		 throw new Exception("ERROR: No existe un cliente con esa ID");
    	 }
    	 
    	 for(Evento e: cliente.getEventos()) {
    		 if(e.getIdEvento() == cliente.getIdCliente()) {
    			 throw new Exception("ERROR: El cliente ya existe en la lista");
    		 }
    	 }
    	 cliente.getEventos().add(evento);
    	 daoC.actualizar(cliente); 
     }
     
     public void eliminarEventoACliente(long idEvento,long idCliente) throws Exception {
    	 Evento evento = dao.traer(idEvento);
    	 if(evento == null) {
    		 throw new Exception("ERROR: No existe un evento con esa ID");
    	 }
    	 Cliente cliente = daoC.traerClienteYEventos(idCliente);
    	 if(cliente == null) {
    		 throw new Exception("ERROR: No existe un cliente con esa ID");
    	 }
    	 cliente.getEventos().remove(evento);
    	 daoC.actualizar(cliente);
     }
     
     public void eliminarEvento(long idEvento) {
    	 Evento event = dao.traer(idEvento);
    	 dao.eliminar(event);
     }
}
