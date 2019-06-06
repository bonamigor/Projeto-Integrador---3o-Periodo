/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Dependente;
import entidade.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael
 */
public class FuncionarioDAO {
    
    public void incluir(Funcionario parametro) throws SQLException {

        //Cria a instrução SQL para a inserção no banco
        String sql = "INSERT INTO funcionario (cargo, nome, id_cliente) VALUES(?,?,?,?);";

        //Criando o objeto para a conexao
        //Connection cnn = util.Conexao.getConexao();
        Connection cnn = util.ConexaoSingleton.getConnection();

        //Cria o objeto para executar os comandos no banco
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Substitui as variveis do sql pelos valores passados
        //como parametro
        prd.setString(1, parametro.getCargo());
        prd.setString(2, parametro.getNome());
        prd.setInt(3, parametro.getCliente_id());

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

    public void alterar(Funcionario parametro) throws SQLException {

        String sql = "UPDATE funcionario SET cargo = ?, nome = ?, id_cliente = ? WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setString(1, parametro.getCargo());
        prd.setString(2, parametro.getNome());
        prd.setInt(3, parametro.getCliente_id());
        prd.setInt(4, parametro.getId());

        prd.execute();
        cnn.close();

    }

    public void excluir(int id) throws SQLException {

        String sql = "DELETE FROM funcionario WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, id);

        prd.execute();
        cnn.close();

    }

    public Funcionario consultar(int id) throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, cargo, nome, id_cliente FROM funcionario WHERE id = ?";

        PreparedStatement stm = cnn.prepareStatement(sql);
        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();
        
        Funcionario funcionario = new Funcionario();
        if (rs.next()) {
            funcionario.setId(rs.getInt("id"));
            funcionario.setCargo(rs.getString("cargo"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setCliente_id(rs.getInt("id_cliente"));
        }
        rs.close();
        cnn.close();

        return funcionario;
    }

    public List<Funcionario> listar() throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, nome, cargo, id_cliente FROM funcionario";

        Statement stm = cnn.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        List<Funcionario> lista = new ArrayList<>();

        while (rs.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt("id"));
            funcionario.setCargo(rs.getString("cargo"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setCliente_id(rs.getInt("id_cliente"));
            lista.add(funcionario);
        }
        rs.close();
        cnn.close();

        return lista;
    }
    
}
