/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Funcionario;
import java.util.List;
import persistencia.FuncionarioDAO;

/**
 *
 * @author rafael
 */
public class NFuncionario {
    
    private FuncionarioDAO per;
    
    public NFuncionario(){
        per = new FuncionarioDAO();
    }
    
    public void salvar(Funcionario parametro) throws Exception {

        if (parametro.getNome().equals("")) {
            throw new Exception("É necessário preencher o nome");
        }
        
        if(parametro.getCargo().equals("")){
            throw new Exception("É necessário preencher o cargo");
        }
        
        if(parametro.getId() == null){
            per.incluir(parametro);
        }else{
            per.alterar(parametro);
        }
            

    }
    
    public void excluir(int id) throws Exception{
        per.excluir(id);
    }
    
    public Funcionario consultar(int id) throws Exception{
        return per.consultar(id);
    }
    
    public List<Funcionario> listar() throws Exception{
        return per.listar();
    }
    
}
