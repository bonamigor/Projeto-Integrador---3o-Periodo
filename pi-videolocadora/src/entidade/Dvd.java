/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author rafael
 */
public class Dvd {
    
    private Integer id;
    private Double preco;
    private Integer midia_id;

    public Dvd(Integer id, Double preco, Integer midia_id) {
        this.id = id;
        this.preco = preco;
        this.midia_id = midia_id;
    }

    public Dvd() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getMidia_id() {
        return midia_id;
    }

    public void setMidia_id(Integer midia_id) {
        this.midia_id = midia_id;
    }
    
}
