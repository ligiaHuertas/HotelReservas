/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ciclo3_reto5.hotel.Interfaces;

import ciclo3_reto5.hotel.modelo.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Maria Ligia Huertas Moreno
 */
public interface InterfaceCategoria extends CrudRepository<Categoria, Integer>  {
    
}
