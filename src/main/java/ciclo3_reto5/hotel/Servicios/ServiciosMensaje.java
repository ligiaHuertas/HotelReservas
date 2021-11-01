/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto5.hotel.Servicios;
import ciclo3_reto5.hotel.Repositorio.RepositorioMensaje;
import ciclo3_reto5.hotel.modelo.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Maria LIgia Huertas Moreno
 */
@Service
public class ServiciosMensaje {
    @Autowired
    private RepositorioMensaje metodosCrud;
    /**
     * 
     * @return 
     */
    public List<Mensaje> getAll(){
        return metodosCrud.getAll();
    }
    /**
     * 
     * @param messageId
     * @return 
     */
    public Optional<Mensaje> getMensaje(int messageId) {
        return metodosCrud.getMensaje(messageId);
    }
    /**
     * 
     * @param message
     * @return 
     */
    public Mensaje save(Mensaje message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Mensaje> e= metodosCrud.getMensaje(message.getIdMessage());
            if(e.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }
    /**
     * 
     * @param message
     * @return 
     */
    public Mensaje update(Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> e= metodosCrud.getMensaje(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMensaje(int messageId) {
        Boolean aBoolean = getMensaje(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }



    
}
