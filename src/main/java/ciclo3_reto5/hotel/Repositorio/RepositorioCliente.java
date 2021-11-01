/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto5.hotel.Repositorio;

import ciclo3_reto5.hotel.Interfaces.InterfaceCliente;
import ciclo3_reto5.hotel.modelo.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maria Ligia Huertas Moreno
 */
@Repository
public class RepositorioCliente {
    @Autowired
    private InterfaceCliente crud3;
    
    public List<Cliente> getAll(){
        return (List<Cliente>) crud3.findAll();
    }
    
    public Optional <Cliente> getCliente(int id){
        return crud3.findById(id);
    }
    
    public Cliente save (Cliente cliente){
        return crud3.save(cliente);
    }
    
    public void delete(Cliente cliente){
        crud3.delete(cliente);
    
    }
    
}
