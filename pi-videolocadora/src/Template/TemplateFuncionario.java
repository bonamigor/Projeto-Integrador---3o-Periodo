/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Template;

import entidade.Funcionario;
import java.util.Iterator;
import java.util.List;
import negocio.NDependente;
import negocio.NFuncionario;

/**
 *
 * @author rafael
 */
public abstract class TemplateFuncionario {
    
    public abstract boolean ePrimeiro(Funcionario funcionario1, Funcionario funcionario2);

    public Iterator<Funcionario> listagemDependentes() throws Exception {
        try {

            List<Funcionario> array = new NFuncionario().listar();

            for (int i = 0; i < array.size(); i++) {
                for (int j = i; j < array.size(); j++) {

                    if (!ePrimeiro(array.get(i), array.get(j))) {
                        Funcionario temp = array.get(j);
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
