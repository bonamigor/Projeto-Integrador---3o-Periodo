/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Dependente;
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
public class DependenteDAO {

    public void incluir(Dependente parametro) throws SQLException {

        //Cria a instrução SQL para a inserção no banco
        String sql = "INSERT INTO dependente (nome, telefone, id_cliente , data_nascimento) "
                + " VALUES(?,?,?,?);";

        //Criando o objeto para a conexao
        Connection cnn = util.Conexao.getConexao();
        //Connection cnn = util.ConexaoSingleton.getConnection();

        //Cria o objeto para executar os comandos no banco
        PreparedStatement prd = cnn.prepareStatement(sql);

        java.sql.Date dataSQL = new Date(parametro.getDataNascimento().getTime());

        //Substitui as variveis do sql pelos valores passados
        //como parametro
        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getTelefone());
        prd.setInt(3, parametro.getCliente_id());
        prd.setDate(4, dataSQL);

        //Executa o comando
        prd.execute();

        //Recupera o id gerado
        String sql2 = "SELECT currval('dependente_id_seq') as id";

        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql2);

        if (rs.next()) {
            parametro.setId(rs.getInt("id"));
        }

        rs.close();
        cnn.close();

    }

    public void alterar(Dependente parametro) throws SQLException {

        String sql = "UPDATE dependente SET nome = ?, telefone = ?, id_cliente = ?, data_nascimento = ? WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);

        java.sql.Date dataSQL = new Date(parametro.getDataNascimento().getTime());

        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getTelefone());
        prd.setInt(3, parametro.getCliente_id());
        prd.setDate(4, dataSQL);
        prd.setInt(5, parametro.getId());

        prd.execute();
        cnn.close();

    }

    public void excluir(int id) throws SQLException {

        String sql = "DELETE FROM dependente WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, id);

        prd.execute();
        cnn.close();

    }

    public Dependente consultar(int id) throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, nome, telefone, id_cliente, data_nascimento FROM dependente WHERE id = ?";

        PreparedStatement stm = cnn.prepareStatement(sql);
        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();

        Dependente dependente = new Dependente();
        if (rs.next()) {
            dependente.setId(rs.getInt("id"));
            dependente.setNome(rs.getString("nome"));
            dependente.setTelefone(rs.getString("telefone"));
            dependente.setCliente_id(rs.getInt("id_cliente"));
            dependente.setDataNascimento(rs.getDate("data_nascimento"));
        }
        rs.close();
        cnn.close();

        return dependente;
    }

    public List<Dependente> listar() throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, nome, telefone, id_cliente, data_nascimento FROM dependente ";

        Statement stm = cnn.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        List<Dependente> lista = new ArrayList<>();

        while (rs.next()) {
            Dependente dependente = new Dependente();
            dependente.setId(rs.getInt("id"));
            dependente.setNome(rs.getString("nome"));
            dependente.setTelefone(rs.getString("telefone"));
            dependente.setCliente_id(rs.getInt("id_cliente"));
            dependente.setDataNascimento(rs.getDate("data_nascimento"));
            lista.add(dependente);
        }
        rs.close();
        cnn.close();

        return lista;
    }

    public List<String> comboBox() throws SQLException {

        List<String> strList = new ArrayList<String>();

        Connection cnn = util.ConexaoSingleton.getConnection();

        String sql = "SELECT nome FROM cliente";

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

        String sql = "SELECT id FROM cliente WHERE nome = ?";

        PreparedStatement stm = cnn.prepareStatement(sql);
        stm.setString(1, item);

        ResultSet rs = stm.executeQuery();

        if (rs.next()) {
            id = rs.getInt("id");
        }

        return id;

    }

}
