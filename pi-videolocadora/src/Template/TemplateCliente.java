/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Template;

import entidade.*;
import java.util.Iterator;
import java.util.List;
import negocio.NCliente;
import persistencia.ClienteDAO;

/**
 *
 * @author rafael
 */
public abstract class TemplateCliente {

    public abstract boolean ePrimeiro(Cliente cliente1, Cliente cliente2);

    public Iterator<Cliente> listagemClientes() throws Exception {
        try {

            List<Cliente> array = new NCliente().listar();

            for (int i = 0; i < array.size(); i++) {
                for (int j = i; j < array.size(); j++) {

                    if (!ePrimeiro(array.get(i), array.get(j))) {
                        Cliente temp = array.get(j);
                        array.set(j, array.get(i));
                        array.set(i, temp);
                    }
                }
            }

            return array.iterator();

        } catch (Exception erro) {
            throw erro;
        }
    }

}
