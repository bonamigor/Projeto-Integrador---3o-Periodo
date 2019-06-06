/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Template;

import entidade.Dependente;
import entidade.Funcionario;

/**
 *
 * @author rafael
 */
public class OrdenarNomeFuncionario extends TemplateFuncionario {

    @Override
    public boolean ePrimeiro(Funcionario funcionario1, Funcionario funcionario2) {
        if (funcionario1.getNome().compareToIgnoreCase(funcionario2.getNome()) <= 0) {
            return true;
        } else {
            return false;
        }
    }

}
