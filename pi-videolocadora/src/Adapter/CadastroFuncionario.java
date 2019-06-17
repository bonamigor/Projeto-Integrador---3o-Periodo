/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import entidade.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rafael
 */
public class CadastroFuncionario {

    public void incluir(Funcionario parametro) throws SQLException {
        //Cria a instrução SQL para a inserção no banco
        String sql = "INSERT INTO funcionario (cargo, nome) VALUES(?,?);";

        //Criando o objeto para a conexao
        Connection cnn = util.Conexao.getConexao();

        //Cria o objeto para executar os comandos no banco
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Substitui as variveis do sql pelos valores passados
        //como parametro
        prd.setString(1, parametro.getCargo());
        prd.setString(2, parametro.getNome());

        //Executa o comando
        prd.execute();

        //Recupera o id gerado
        String sql2 = "SELECT currval('funcionario_id_seq') as id";

        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql2);

        if (rs.next()) {
            parametro.setId(rs.getInt("id"));
        }

        rs.close();
        cnn.close();

    }

}
