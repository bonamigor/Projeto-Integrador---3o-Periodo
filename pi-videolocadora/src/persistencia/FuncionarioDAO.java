/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Adapter.InterfaceCadastro;
import entidade.Funcionario;
import java.sql.Connection;
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
public class FuncionarioDAO implements InterfaceCadastro{
    
    @Override
    public void incluir(Funcionario parametro) throws SQLException {

        //Cria a instrução SQL para a inserção no banco
        String sql = "INSERT INTO funcionario (nome) VALUES(?);";

        //Criando o objeto para a conexao
        Connection cnn = util.Conexao.getConexao();

        //Cria o objeto para executar os comandos no banco
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Substitui as variveis do sql pelos valores passados
        //como parametro
        prd.setString(1, parametro.getNome());

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

        String sql = "UPDATE funcionario SET cargo = ?, nome = ? WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setString(1, parametro.getCargo());
        prd.setString(2, parametro.getNome());
        prd.setInt(3, parametro.getId());

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

        String sql = "SELECT id, cargo, nome FROM funcionario WHERE id = ?";

        PreparedStatement stm = cnn.prepareStatement(sql);
        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();
        
        Funcionario funcionario = new Funcionario();
        if (rs.next()) {
            funcionario.setId(rs.getInt("id"));
            funcionario.setCargo(rs.getString("cargo"));
            funcionario.setNome(rs.getString("nome"));
        }
        rs.close();
        cnn.close();

        return funcionario;
    }

    public List<Funcionario> listar() throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, nome, cargo FROM funcionario";

        Statement stm = cnn.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        List<Funcionario> lista = new ArrayList<>();

        while (rs.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt("id"));
            funcionario.setCargo(rs.getString("cargo"));
            funcionario.setNome(rs.getString("nome"));
            lista.add(funcionario);
        }
        rs.close();
        cnn.close();

        return lista;
    }
    
    public List<String> comboBox() throws SQLException {

        List<String> strList = new ArrayList<String>();

        Connection cnn = util.ConexaoSingleton.getConnection();

        String sql = "SELECT nome FROM funcionario";

        PreparedStatement prd = cnn.prepareStatement(sql);

        ResultSet rs = prd.executeQuery();

        while (rs.next()) {
            strList.add(rs.getString("nome"));
        }
        prd.close();
        return strList;
    }
    
    public int pegaId(String item) throws SQLException {

        int id = 0;

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id FROM funcionario WHERE nome = ?";

        PreparedStatement stm = cnn.prepareStatement(sql);
        stm.setString(1, item);

        ResultSet rs = stm.executeQuery();

        if (rs.next()) {
            id = rs.getInt("id");
        }

        return id;

    }
    
}
