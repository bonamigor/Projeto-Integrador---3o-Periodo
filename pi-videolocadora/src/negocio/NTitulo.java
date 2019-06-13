/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Titulo;
import java.sql.SQLException;
import java.util.List;
import persistencia.TituloDAO;

/**
 *
 * @author rafael
 */
public class NTitulo {
    
    private TituloDAO per;
    
    public NTitulo(){
        per = new TituloDAO();
    }
    
    public void salvar(Titulo parametro) throws Exception {

        if (parametro.getNome().equals("")) {
            throw new Exception("É necessário preencher o nome");
        }
        
        if(parametro.getGenero().equals("")){
            throw new Exception("É necessário preencher o gênero");
        }
        
        if(parametro.getDiretor().equals("")){
            throw new Exception("É necessário preencher o diretor");
        }
        
        if(parametro.getAtor().equals("")){
            throw new Exception("É necessário preencher o ator");
        }
        
        if(parametro.getDataLancamento().toString().equals("")){
            throw new Exception("É necessário preencher a data de lançamento");
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
    
    public Titulo consultar(int id) throws Exception{
        return per.consultar(id);
    }
    
    public List<Titulo> listar() throws Exception{
        return per.listar();
    }
    
    public List<Titulo> procurandoNomes(String nome) throws SQLException {
        return per.procurandoNomes(nome);
    }    
}
