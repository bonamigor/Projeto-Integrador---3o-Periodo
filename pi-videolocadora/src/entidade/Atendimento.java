/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Date;

/**
 *
 * @author rafael
 */
public class Atendimento {
    
    private Integer id;
    private Integer funcionario_id;
    private Integer cliente_id;
    private Integer dependente_id;
    private Integer multa_id;
    private Integer titulo_id;
    private Integer midia_id;
    private Integer quantidadeMidias;
    private Date dataEntrada;
    private Date dataSaida;
    private Integer duracao;
    private Double desconto;
    private Double valorTotal;
    private boolean status;

    public Atendimento(Integer id, Integer funcionario_id, Integer cliente_id, Integer dependente_id, Integer multa_id, Integer titulo_id, Integer midia_id, Integer quantidadeMidias, Date dataEntrada, Date dataSaida,  Integer duracao, Double desconto, Double valorTotal, boolean status) {
        this.id = id;
        this.funcionario_id = funcionario_id;
        this.cliente_id = cliente_id;
        this.dependente_id = dependente_id;
        this.multa_id = multa_id;
        this.titulo_id = titulo_id;
        this.midia_id = midia_id;
        this.quantidadeMidias = quantidadeMidias;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.duracao = duracao;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
        this.status = status;
    }
    
   public Atendimento(){
       
   }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(Integer funcionario_id) {
        this.funcionario_id = funcionario_id;
    }
    
    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Integer getDependente_id() {
        return dependente_id;
    }

    public void setDependente_id(Integer dependente_id) {
        this.dependente_id = dependente_id;
    }

    public Integer getMulta_id() {
        return multa_id;
    }

    public void setMulta_id(Integer multa_id) {
        this.multa_id = multa_id;
    }

    public Integer getTitulo_id() {
        return titulo_id;
    }

    public void setTitulo_id(Integer titulo_id) {
        this.titulo_id = titulo_id;
    }

    public Integer getMidia_id() {
        return midia_id;
    }

    public void setMidia_id(Integer midia_id) {
        this.midia_id = midia_id;
    }
    
    public Integer getQuantidadeMidias() {
        return quantidadeMidias;
    }

    public void setQuantidadeMidias(Integer quantidadeMidias) {
        this.quantidadeMidias = quantidadeMidias;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }       
    
}
