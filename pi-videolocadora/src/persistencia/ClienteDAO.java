/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class ClienteDAO {

    public void incluir(Cliente parametro) throws SQLException {
        Connection cnn = util.Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {

            //Cria a instrução SQL para a inserção no banco
            String sql = "INSERT INTO cliente (nome, cpf, telefone, endereco, email, data_nascimento) "
                    + " VALUES(?,?,?,?,?,?);";

            //Criando o objeto para a conexao
            //Connection cnn = util.Conexao.getConexao();
            //Cria o objeto para executar os comandos no banco
            PreparedStatement prd = cnn.prepareStatement(sql);

            java.sql.Date dataSQL = new Date(parametro.getData_nascimento().getTime());

            //Substitui as variveis do sql pelos valores passados
            //como parametro
            prd.setString(1, parametro.getNome());
            prd.setString(2, parametro.getCpf());
            prd.setString(3, parametro.getTelefone());
            prd.setString(4, parametro.getEndereco());
            prd.setString(5, parametro.getEmail());
            prd.setDate(6, dataSQL);

            //Executa o comando
            prd.execute();

            //Recupera o id gerado
            String sql2 = "SELECT currval('cliente_id_seq') as id";

            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sql2);

            if (rs.next()) {
                parametro.setId(rs.getInt("id"));
            }

            rs.close();
            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        cnn.close();

    }

    public void alterar(Cliente parametro) throws SQLException {
        Connection cnn = util.Conexao.getConexao();
        cnn.setAutoCommit(false);
        
        try {

            String sql = "UPDATE cliente SET"
                    + " nome = ?, cpf = ?, telefone = ?, endereco = ?, email = ?, data_nascimento = ?"
                    + " WHERE id = ?";

            PreparedStatement prd = cnn.prepareStatement(sql);

            java.sql.Date dataSQL = new Date(parametro.getData_nascimento().getTime());

            prd.setString(1, parametro.getNome());
            prd.setString(2, parametro.getCpf());
            prd.setString(3, parametro.getTelefone());
            prd.setString(4, parametro.getEndereco());
            prd.setString(5, parametro.getEmail());
            prd.setDate(6, dataSQL);
            prd.setInt(7, parametro.getId());

            prd.execute();

        } catch (Exception e) {
            //Desfaz as alterações no banco de dados 
            cnn.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        cnn.close();

    }

    public void excluir(int id) throws SQLException {
        
        Connection cnn = util.Conexao.getConexao();
        cnn.setAutoCommit(false);
        
        try{
            
        String sql = "DELETE FROM cliente"
                + " WHERE id = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, id);

        prd.execute();
        } catch (Exception e) {
            //Desfaz as alterações no banco de dados 
            cnn.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        cnn.close();

    }

    public Cliente consultar(int id) throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, nome, cpf, telefone, endereco, email, data_nascimento"
                + " FROM cliente "
                + " WHERE id = ?";

        PreparedStatement stm = cnn.prepareStatement(sql);
        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();

        Cliente cliente = new Cliente();
        if (rs.next()) {
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setEmail(rs.getString("email"));
            cliente.setData_nascimento(rs.getDate("data_nascimento"));
        }
        rs.close();
        cnn.close();

        return cliente;
    }

    public List<Cliente> listar() throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, nome, cpf, telefone, endereco, email, data_nascimento"
                + " FROM cliente ";

        Statement stm = cnn.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        List<Cliente> lista = new ArrayList<>();

        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setEmail(rs.getString("email"));
            cliente.setData_nascimento(rs.getDate("data_nascimento"));
            lista.add(cliente);
        }
        rs.close();
        cnn.close();

        return lista;
    }

    public List<Cliente> listarNomes() throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT nome FROM cliente ";

        Statement stm = cnn.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        List<Cliente> lista = new ArrayList<>();

        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setNome(rs.getString("nome"));
            lista.add(cliente);
        }
        rs.close();
        cnn.close();

        return lista;
    }

}
