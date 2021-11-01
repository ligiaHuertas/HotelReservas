/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto5.hotel.Repositorio;

import ciclo3_reto5.hotel.Interfaces.InterfaceMensaje;
import ciclo3_reto5.hotel.modelo.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maria Ligia Huertas Moreno
 */
@Repository
public class RepositorioMensaje {
    @Autowired
    private InterfaceMensaje crud4;
    
    public List<Mensaje> getAll(){
        return (List<Mensaje>) crud4.findAll();
    }
    
    public Optional <Mensaje> getMensaje(int id){
        return crud4.findById(id);
    }
    
    public Mensaje save (Mensaje mensaje){
        return crud4.save(mensaje);
    }
    
    public void delete(Mensaje mensaje){
        crud4.delete(mensaje);
    
    }
    
}
