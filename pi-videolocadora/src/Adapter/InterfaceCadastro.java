/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import entidade.Funcionario;
import java.sql.SQLException;

/**
 *
 * @author rafael
 */
public interface InterfaceCadastro {
    
    public void incluir(Funcionario parametro) throws SQLException;
    
}
