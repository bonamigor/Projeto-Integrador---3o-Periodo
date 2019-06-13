/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Titulo;
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
public class TituloDAO {
    
    public void incluir(Titulo parametro) throws SQLException {

        //Cria a instrução SQL para a inserção no banco
        //String sql = "INSERT INTO titulo (nome, genero, data_lancamento, diretor, ator, disponibilidade, atendimento_id) VALUES(?,?,?,?,?,?,?);";
        String sql = "INSERT INTO titulo (data_lancamento, genero, disponibilidade, diretor, ator, nome, atendimento_id) VALUES (?,?,?,?,?,?,?);";
        //Criando o objeto para a conexao
        Connection cnn = util.Conexao.getConexao();
        //Connection cnn = util.ConexaoSingleton.getConnection();

        //Cria o objeto para executar os comandos no banco
        PreparedStatement prd = cnn.prepareStatement(sql);

        java.sql.Date dataSQL = new Date(parametro.getDataLancamento().getTime());
        
        //Substitui as variveis do sql pelos valores passados
        //como parametro
        prd.setDate(1, dataSQL);
        prd.setString(2, parametro.getGenero());
        prd.setBoolean(3, true);
        prd.setString(4, parametro.getDiretor());
        prd.setString(5, parametro.getAtor());
        prd.setString(6, parametro.getNome());
        prd.setInt(7, 0);
        
        //Executa o comando
        prd.execute();

        //Recupera o id gerado
        String sql2 = "SELECT currval('titulo_id_seq') as id";

        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql2);

        if (rs.next()) {
            parametro.setId(rs.getInt("id"));
        }

        rs.close();
        cnn.close();

    }

    public void alterar(Titulo parametro) throws SQLException {

        String sql = "UPDATE titulo SET data_lancamento = ?, genero = ?, disponibilidade = ?, diretor = ?, ator = ?, nome = ?, atendimento_id = ? WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);
        
        java.sql.Date dataSQL = new Date(parametro.getDataLancamento().getTime());
        
        prd.setDate(1, dataSQL);
        prd.setString(2, parametro.getGenero());
        prd.setBoolean(3, true);
        prd.setString(4, parametro.getDiretor());
        prd.setString(5, parametro.getAtor());
        prd.setString(6, parametro.getNome());
        prd.setInt(7, 0);
        prd.setInt(8, parametro.getId());

        prd.execute();
        cnn.close();

    }

    public void excluir(int id) throws SQLException {

        String sql = "DELETE FROM titulo WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, id);

        prd.execute();
        cnn.close();

    }

    public Titulo consultar(int id) throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, nome, genero, data_lancamento, diretor, ator, disponibilidade, atendimento_id FROM titulo WHERE id = ?";

        PreparedStatement stm = cnn.prepareStatement(sql);
        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();
        
        Titulo titulo = new Titulo();
        if (rs.next()) {
            titulo.setId(rs.getInt("id"));
            titulo.setNome(rs.getString("nome"));
            titulo.setGenero(rs.getString("genero"));
            titulo.setDataLancamento(rs.getDate("data_lancamento"));
            titulo.setDiretor(rs.getString("diretor"));
            titulo.setAtor(rs.getString("ator"));
            titulo.setDisponibilidade(rs.getBoolean("disponibilidade"));
            titulo.setAtendimento_id(rs.getInt("atendimento_id"));
        }
        rs.close();
        cnn.close();

        return titulo;
    }

    public List<Titulo> listar() throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, nome, genero, data_lancamento, diretor, ator, disponibilidade, atendimento_id FROM titulo";

        Statement stm = cnn.createStatement();
        
        ResultSet rs = stm.executeQuery(sql);

        List<Titulo> lista = new ArrayList<>();

        while (rs.next()) {
            Titulo titulo = new Titulo();
            titulo.setId(rs.getInt("id"));
            titulo.setNome(rs.getString("nome"));
            titulo.setGenero(rs.getString("genero"));
            titulo.setDataLancamento(rs.getDate("data_lancamento"));
            titulo.setDiretor(rs.getString("diretor"));
            titulo.setAtor(rs.getString("ator"));
            titulo.setDisponibilidade(rs.getBoolean("disponibilidade"));
            titulo.setAtendimento_id(rs.getInt("atendimento_id"));
            lista.add(titulo);
        }
        rs.close();
        cnn.close();

        return lista;
    }
    
    public List<Titulo> procurandoNomes(String nome) throws SQLException {
        
        Connection cnn = util.Conexao.getConexao();

        nome = nome.toUpperCase();
        
        String sql = "SELECT * FROM titulo WHERE UPPER(nome) LIKE '"+nome+"%'";

        Statement stm = cnn.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        List<Titulo> lista = new ArrayList<>();

        while (rs.next()) {
            
            Titulo titulo = new Titulo();
            titulo.setId(rs.getInt("id"));
            titulo.setNome(rs.getString("nome"));
            titulo.setGenero(rs.getString("genero"));
            titulo.setDataLancamento(rs.getDate("data_lancamento"));
            titulo.setDiretor(rs.getString("diretor"));
            titulo.setAtor(rs.getString("ator"));
            titulo.setDisponibilidade(rs.getBoolean("disponibilidade"));
            titulo.setAtendimento_id(rs.getInt("atendimento_id"));
            lista.add(titulo);
        }
        rs.close();
        cnn.close();

        return lista;
    }
    
}
