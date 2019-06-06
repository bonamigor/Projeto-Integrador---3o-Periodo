/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Cliente;
import java.util.List;
import persistencia.ClienteDAO;

/**
 *
 * @author rafael
 */
public class NCliente {
    
    private ClienteDAO per;

    public NCliente() {
        per = new ClienteDAO();
    }

    public void salvar(Cliente parametro) throws Exception {

        if (parametro.getNome().equals("")) {
            throw new Exception("É necessário preencher o nome");
        }
        
        if (parametro.getCpf().equals("")) {
            throw new Exception("É necessário preencher o CPF com até 11 dígitos.");
        }
        
        if (parametro.getTelefone().equals("")) {
            throw new Exception("É necessário preencher o telefone com até 11 dígitos. \nExemplo: 629XXXX-XXXX");
        }

        if (parametro.getEndereco().equals("")) {
            throw new Exception("É necessário preencher o endereço");
        }
        
        if (parametro.getEmail().equals("")) {
            throw new Exception("É necessário preencher o E-mail.");
        }
        
        if (parametro.getData_nascimento().toString().equals("")) {
            throw new Exception("É necessário preencher a Data de Nascimento.");
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
    
    public Cliente consultar(int id) throws Exception{
        return per.consultar(id);
    }
    
    public List<Cliente> listar() throws Exception{
        return per.listar();
    }
    
}
