/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto5.hotel.Repositorio;

import ciclo3_reto5.hotel.Interfaces.InterfaceReservacion;
import ciclo3_reto5.hotel.modelo.Cliente;
import ciclo3_reto5.hotel.modelo.Reservacion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maria Ligia Huertas Moreno
 */
@Repository
public class RepositorioReservacion {
    @Autowired
    private InterfaceReservacion crud5;
    
    public List<Reservacion> getAll(){
        return (List<Reservacion>) crud5.findAll();
    }
    
    public Optional <Reservacion> getReservacion(int id){
        return crud5.findById(id);
    }
    
    public Reservacion save (Reservacion reservacion){
        return crud5.save(reservacion);
    }
    
    public void delete(Reservacion reservacion){
        crud5.delete(reservacion);
    
    }
    public List<Reservacion> ReservacionStatusRepositorio (String status){
	         return crud5.findAllByStatus(status);
	     }
	     
	     public List<Reservacion> ReservacionTiempoRepositorio (Date a, Date b){
	         return crud5.findAllByStartDateAfterAndStartDateBefore(a, b);
	     
	     }
	     
	     public List<ContadorClientes> getClientesRepositorio(){
	         List<ContadorClientes> res = new ArrayList<>();
	         List<Object[]> report = crud5.countTotalReservationByCliente();
	         for(int i=0; i<report.size(); i++){
	             res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
	         }
	         return res;
	     }
    
    
}
