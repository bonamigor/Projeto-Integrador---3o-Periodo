/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import entidade.Cliente;
import entidade.Funcionario;
import java.sql.SQLException;

/**
 *
 * @author rafael
 */
public class Adapter implements InterfaceCadastro{
    
    private CadastroFuncionario ncs;

    public Adapter(CadastroFuncionario ncs) {
        this.ncs = ncs;
    }

    @Override
    public void incluir(Funcionario parametro) throws SQLException {
        this.ncs.incluir(parametro);
    }
    
}
