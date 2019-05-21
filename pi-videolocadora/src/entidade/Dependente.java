/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author bonamigo
 */
public class Dependente {
    
    private Integer id;
    private String nome;
    private String telefone;
    private Integer cliente_id;

    public Dependente(Integer id, String nome, String telefone, Integer cliente_id) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cliente_id = cliente_id;
    }
    
    public Dependente(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }
    
    
    
    
}
