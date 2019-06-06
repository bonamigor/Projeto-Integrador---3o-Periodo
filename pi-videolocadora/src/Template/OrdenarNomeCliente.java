/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Template;

import entidade.Cliente;

/**
 *
 * @author rafael
 */
public class OrdenarNomeCliente extends TemplateCliente {
    @Override
    public boolean ePrimeiro(Cliente cliente1, Cliente cliente2) {

        if (cliente1.getNome().compareToIgnoreCase(cliente2.getNome()) <= 0) {
            return true;
        } else {
            return false;
        }
    }


}
