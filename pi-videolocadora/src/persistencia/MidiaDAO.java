/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Midia;
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
public class MidiaDAO {
    
    public void incluir(Midia parametro) throws SQLException {

        //Cria a instrução SQL para a inserção no banco
        String sql = "INSERT INTO midia (quantidade, disponibilidade, titulo_id, preco, tipomidia) VALUES(?,?,?,?,?);";

        //Criando o objeto para a conexao
        Connection cnn = util.Conexao.getConexao();
        //Connection cnn = util.ConexaoSingleton.getConnection();

        //Cria o objeto para executar os comandos no banco
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        //Substitui as variveis do sql pelos valores passados
        //como parametro
        prd.setInt(1, parametro.getQuantidade());   
        prd.setBoolean(2, parametro.isDisponibilidade());
        prd.setInt(3, parametro.getTitulo_id());
        prd.setDouble(4, parametro.getPreco());
        prd.setString(5, parametro.getTipoMidia());
        
        //Executa o comando
        prd.execute();

        //Recupera o id gerado
        String sql2 = "SELECT currval('midia_id_seq') as id";

        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql2);

        if (rs.next()) {
            parametro.setId(rs.getInt("id"));
        }

        rs.close();
        cnn.close();

    }

    public void alterar(Midia parametro) throws SQLException {

        String sql = "UPDATE midia SET quantidade = ?, disponibilidade = ?, titulo_id = ?, preco = ?, tipomidia = ? WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setInt(1, parametro.getQuantidade());   
        prd.setBoolean(2, parametro.isDisponibilidade());
        prd.setInt(3, parametro.getTitulo_id());
        prd.setDouble(4, parametro.getPreco());
        prd.setString(5, parametro.getTipoMidia());
        prd.setInt(6, parametro.getId());

        prd.execute();
        cnn.close();

    }

    public void excluir(int id) throws SQLException {

        String sql = "DELETE FROM midia WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, id);

        prd.execute();
        cnn.close();

    }

    public Midia consultar(int id) throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, quantidade, disponibilidade, titulo_id, preco, tipomidia FROM midia WHERE id = ?";

        PreparedStatement stm = cnn.prepareStatement(sql);
        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();
        
        
        Midia midia = new Midia();
        
        if (rs.next()) {
            midia.setId(rs.getInt("id"));
            midia.setQuantidade(rs.getInt("quantidade"));
            midia.setDisponibilidade(rs.getBoolean("disponibilidade"));
            midia.setTitulo_id(rs.getInt("titulo_id"));
            midia.setPreco(rs.getDouble("preco"));
            midia.setTipoMidia(rs.getString("tipomidia"));
        }
        rs.close();
        cnn.close();

        return midia;
    }

    public List<Midia> listar() throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, quantidade, disponibilidade, titulo_id, preco, tipomidia FROM midia";

        Statement stm = cnn.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        List<Midia> lista = new ArrayList<>();

        while (rs.next()) {
            Midia midia = new Midia();
            midia.setId(rs.getInt("id"));
            midia.setQuantidade(rs.getInt("quantidade"));
            midia.setDisponibilidade(rs.getBoolean("disponibilidade"));
            midia.setTitulo_id(rs.getInt("titulo_id"));
            midia.setPreco(rs.getDouble("preco"));
            midia.setTipoMidia(rs.getString("tipomidia"));
            lista.add(midia);
        }
        rs.close();
        cnn.close();

        return lista;
    }
    
    public int pegaId(String nome) throws SQLException {

        int id = 0;

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id FROM titulo WHERE nome = ?";

        PreparedStatement stm = cnn.prepareStatement(sql);
        stm.setString(1, nome);

        ResultSet rs = stm.executeQuery();

        if (rs.next()) {
            id = rs.getInt("id");
        }

        return id;

    }
    
}
