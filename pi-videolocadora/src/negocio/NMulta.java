/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Multa;
import java.util.List;
import persistencia.MultaDAO;

/**
 *
 * @author rafael
 */
public class NMulta {

    private MultaDAO per;

    public NMulta() {
        per = new MultaDAO();
    }

    public void salvar(Multa parametro) throws Exception {

        if (parametro.getDescricao().equalsIgnoreCase("")) {
            throw new Exception("É necessário digitar a descrição");
        }

        if (parametro.getValor() >= 0) {
            throw new Exception("É necessário preencher o valor da multa");
        }

        if (parametro.getId() == null) {
            per.incluir(parametro);
        } else {
            per.alterar(parametro);
        }

    }

    public void excluir(int id) throws Exception {
        per.excluir(id);
    }

    public Multa consultar(int id) throws Exception {
        return per.consultar(id);
    }

    public List<Multa> listar() throws Exception {
        return per.listar();
    }

}
