/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto5.hotel.Repositorio;

import ciclo3_reto5.hotel.Interfaces.InterfaceRoom;
import ciclo3_reto5.hotel.modelo.Room;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maria ligia Huertas Moreno
 */
@Repository
public class RepositorioRoom {
    @Autowired
    private InterfaceRoom crud1;
    
    public List<Room> getAll(){
        return (List<Room>) crud1.findAll();
    }
    
    public Optional <Room> getRoom(int id){
        return crud1.findById(id);
    }
    
    public Room save (Room room){
        return crud1.save(room);
    }
    
    public void delete(Room room){
        crud1.delete(room);
    
    }
    
}
