/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import entidade.Cliente;

/**
 *
 * @author rafael
 */
public class Bronze extends TipoCliente{
    
    private Cliente cliente;
    public Bronze(Cliente cliente){
        this.cliente = cliente;
    }

    @Override
    public String getNome() {
        return cliente.getNome() + " do tipo Bronze ";
    }
    
}
