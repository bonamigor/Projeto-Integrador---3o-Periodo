/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import entidade.Cliente;
import java.util.Iterator;
import java.util.List;
import negocio.NCliente;

/**
 *
 * @author rafael
 */
public class ListarIterator {
    
    public Iterator<Cliente> listagemClientes() throws Exception{
        List<Cliente> listaCliente = new NCliente().listar();
        
        return listaCliente.iterator();
    }
    
}
