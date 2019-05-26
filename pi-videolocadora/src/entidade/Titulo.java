/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Date;

/**
 *
 * @author bonamigo
 */
public class Titulo {
    
    private Integer id;
    private Date dataLancamento;
    private String genero;
    private boolean disponibilidade;
    private String diretor;
    private String ator;
    private String nome;
    private Integer atendimento_id;

    public Titulo(Integer id, Date dataLancamento, String genero, boolean disponibilidade, String diretor, String ator, String nome, Integer atendimento_id) {
        this.id = id;
        this.dataLancamento = dataLancamento;
        this.genero = genero;
        this.disponibilidade = disponibilidade;
        this.diretor = diretor;
        this.ator = ator;
        this.nome = nome;
        this.atendimento_id = atendimento_id;
    }

    public Titulo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getAtor() {
        return ator;
    }

    public void setAtor(String ator) {
        this.ator = ator;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAtendimento_id() {
        return atendimento_id;
    }

    public void setAtendimento_id(Integer atendimento_id) {
        this.atendimento_id = atendimento_id;
    }
    
}
