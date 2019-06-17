/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Multa;
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
public class MultaDAO {
    
    public void incluir(Multa parametro) throws SQLException {

        //Cria a instrução SQL para a inserção no banco
        String sql = "INSERT INTO multa (descricao, valor) VALUES(?,?);";

        //Criando o objeto para a conexao
        Connection cnn = util.Conexao.getConexao();
        //Connection cnn = util.ConexaoSingleton.getConnection();

        //Cria o objeto para executar os comandos no banco
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        //Substitui as variveis do sql pelos valores passados
        //como parametro
        prd.setString(1, parametro.getDescricao());
        prd.setDouble(2, parametro.getValor());
        
        //Executa o comando
        prd.execute();

        //Recupera o id gerado
        String sql2 = "SELECT currval('multa_id_seq') as id";

        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql2);

        if (rs.next()) {
            parametro.setId(rs.getInt("id"));
        }

        rs.close();
        cnn.close();

    }

    public void alterar(Multa parametro) throws SQLException {

        String sql = "UPDATE multa SET descricao = ?, valor = ? WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setString(1, parametro.getDescricao());
        prd.setDouble(2, parametro.getValor());
        prd.setInt(3, parametro.getId());

        prd.execute();
        cnn.close();

    }

    public void excluir(int id) throws SQLException {

        String sql = "DELETE FROM multa WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, id);

        prd.execute();
        cnn.close();

    }

    public Multa consultar(int id) throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, descricao, valor FROM multa WHERE id = ?";

        PreparedStatement stm = cnn.prepareStatement(sql);
        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();
        
        
        Multa multa = new Multa();
        
        if (rs.next()) {
            
            multa.setId(rs.getInt("id"));
            multa.setDescricao(rs.getString("descricao"));
            multa.setValor(rs.getDouble("valor"));
        }
        
        rs.close();
        cnn.close();

        return multa;
    }

    public List<Multa> listar() throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, descricao, valor FROM multa";

        Statement stm = cnn.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        List<Multa> lista = new ArrayList<>();

        while (rs.next()) {
            Multa multa = new Multa();
            multa.setId(rs.getInt("id"));
            multa.setDescricao(rs.getString("descricao"));
            multa.setValor(rs.getDouble("valor"));
            lista.add(multa);
        }
        rs.close();
        cnn.close();

        return lista;
    }
    
    public List<String> comboBox() throws SQLException {

        List<String> strList = new ArrayList<String>();

        Connection cnn = util.ConexaoSingleton.getConnection();

        String sql = "SELECT descricao FROM multa";

        PreparedStatement prd = cnn.prepareStatement(sql);

        ResultSet rs = prd.executeQuery();

        while (rs.next()) {
            strList.add(rs.getString("descricao"));
        }
        prd.close();
        return strList;
    }
    
    public int pegaId(String item) throws SQLException {

        int id = 0;

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id FROM multa WHERE descricao = ?";

        PreparedStatement stm = cnn.prepareStatement(sql);
        stm.setString(1, item);

        ResultSet rs = stm.executeQuery();

        if (rs.next()) {
            id = rs.getInt("id");
        }

        return id;

    }
    
}
