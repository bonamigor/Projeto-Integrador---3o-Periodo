/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Template;

import entidade.Cliente;
import entidade.Dependente;
import java.util.Iterator;
import java.util.List;
import negocio.NCliente;
import negocio.NDependente;

/**
 *
 * @author rafael
 */
public abstract class TemplateDependente {
    
    public abstract boolean ePrimeiro(Dependente dependente1, Dependente dependente2);

    public Iterator<Dependente> listagemDependentes() throws Exception {
        try {

            List<Dependente> array = new NDependente().listar();

            for (int i = 0; i < array.size(); i++) {
                for (int j = i; j < array.size(); j++) {

                    if (!ePrimeiro(array.get(i), array.get(j))) {
                        Dependente temp = array.get(j);
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
