/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Dependente;
import java.util.List;
import persistencia.DependenteDAO;

/**
 *
 * @author rafael
 */
public class NDependente {
    
    private DependenteDAO per;

    public NDependente() {
        per = new DependenteDAO();
    }

    public void salvar(Dependente parametro) throws Exception {

        if (parametro.getNome().equals("")) {
            throw new Exception("É necessário preencher o nome");
        }
        
        if (parametro.getTelefone().equals("")) {
            throw new Exception("É necessário preencher o telefone com até 11 dígitos. \nExemplo: 629XXXX-XXXX");
        }
        
        if (parametro.getCliente_id() == null) {
            throw new Exception("É necessário selecionar um titular para este dependente.");
        }
        
        if (parametro.getDataNascimento().toString().equals("")) {
            throw new Exception("É necessário preencher a Data de Nascimento.");
        }
        
        if(parametro.getId() == 0){
            per.incluir(parametro);
        }else{
            per.alterar(parametro);
        }
            

    }
    
    public void excluir(int id) throws Exception{
        per.excluir(id);
    }
    
    public Dependente consultar(int id) throws Exception{
        return per.consultar(id);
    }
    
    public List<Dependente> listar() throws Exception{
        return per.listar();
    }
    
}
