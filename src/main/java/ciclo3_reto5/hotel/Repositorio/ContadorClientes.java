/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3_reto5.hotel.Repositorio;

import ciclo3_reto5.hotel.modelo.Cliente;

/**
 *
 * @author Maria Ligia Huertas Moreno
 */
public class ContadorClientes {
    private long total;
    private Cliente cliente;

    public ContadorClientes(long total, Cliente cliente) {
        this.total = total;
        this.cliente = cliente;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
