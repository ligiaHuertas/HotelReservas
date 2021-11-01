/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto5.hotel.Servicios;
import ciclo3_reto5.hotel.Repositorio.ContadorClientes;
import ciclo3_reto5.hotel.Repositorio.RepositorioReservacion;
import ciclo3_reto5.hotel.Repositorio.StatusReservacion;
import ciclo3_reto5.hotel.modelo.Reservacion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maria Ligia Huertas Moreno
 */
@Service
public class ServiciosReservacion {
    @Autowired
    private RepositorioReservacion metodosCrud;

    public List<Reservacion> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Reservacion> getReservacion(int reservationId) {
        return metodosCrud.getReservacion(reservationId);
    }

    public Reservacion save(Reservacion reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservacion> e= metodosCrud.getReservacion(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservacion update(Reservacion reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservacion> e= metodosCrud.getReservacion(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservacion(int reservationId) {
        Boolean aBoolean = getReservacion(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public StatusReservacion reporteStatusServicio (){
	        List<Reservacion>completed= metodosCrud.ReservacionStatusRepositorio("completed");
	        List<Reservacion>cancelled= metodosCrud.ReservacionStatusRepositorio("cancelled");
	        
	        return new StatusReservacion(completed.size(), cancelled.size() );
                
    }
    public List<Reservacion> reporteTiempoServicio (String datoA, String datoB){
	        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
	        
	        Date datoUno = new Date();
	        Date datoDos = new Date();
	        
	        try{
	             datoUno = parser.parse(datoA);
	             datoDos = parser.parse(datoB);
	        }catch(ParseException evt){
	            evt.printStackTrace();
	        }if(datoUno.before(datoDos)){
	            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
	        }else{
	            return new ArrayList<>();
	        
	        } 
    }
    public List<ContadorClientes> reporteClientesServicio(){
	        return metodosCrud.getClientesRepositorio();
    }
    
}
