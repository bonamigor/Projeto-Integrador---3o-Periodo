/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Template;

import entidade.Dependente;

/**
 *
 * @author rafael
 */
public class OrdenarNomeDependente extends TemplateDependente {

    @Override
    public boolean ePrimeiro(Dependente dependente1, Dependente dependente2) {
        if (dependente1.getNome().compareToIgnoreCase(dependente2.getNome()) <= 0) {
            return true;
        } else {
            return false;
        }
    }

}
