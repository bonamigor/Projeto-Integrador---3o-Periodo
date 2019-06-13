/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Midia;
import java.util.List;
import persistencia.MidiaDAO;

/**
 *
 * @author rafael
 */
public class NMidia {
    
    private MidiaDAO per;
    
    public NMidia(){
        per = new MidiaDAO();
    }
    
    public void salvar(Midia parametro) throws Exception {

        if (parametro.getPreco() <= 0) {
            throw new Exception("É necessário digitar o Preço");
        }
        
        if(parametro.getQuantidade() <= 0){
            throw new Exception("É necessário preencher a Quantidade");
        }
        
        if(parametro.getTipoMidia().equals("")){
            throw new Exception("É necessário preencher o tipo da mídia");
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
    
    public Midia consultar(int id) throws Exception{
        return per.consultar(id);
    }
    
    public List<Midia> listar() throws Exception{
        return per.listar();
    }
    
}
