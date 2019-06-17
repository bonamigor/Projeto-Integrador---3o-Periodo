/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Atendimento;
import java.util.List;
import persistencia.AtendimentoDAO;

/**
 *
 * @author rafael
 */
public class NAtendimento {
    
    private AtendimentoDAO per;

    public NAtendimento() {
        per = new AtendimentoDAO();
    }

    public void salvar(Atendimento parametro) throws Exception {

        if (parametro.getQuantidadeMidias().equals("")) {
            throw new Exception("É necessário preencher a quantidade de Mídias");
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
    
    public Atendimento consultar(int id) throws Exception{
        return per.consultar(id);
    }
    
    public List<Atendimento> listar() throws Exception{
        return per.listar();
    }
    
    
}
