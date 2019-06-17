/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Atendimento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class AtendimentoDAO {

    public void incluirReservaCliente(Atendimento parametro) throws SQLException {

        try {

            String sql = "INSERT INTO atendimento (quantidade_midia, data_entrada, status, funcionario_id, cliente_id, titulo_id) VALUES(?,?,?,?,?,?);";

            Connection cnn = util.Conexao.getConexao();
            PreparedStatement prd = cnn.prepareStatement(sql);

            java.sql.Date dataReserva = new Date(parametro.getDataEntrada().getTime());

            prd.setInt(1, parametro.getQuantidadeMidias());
            prd.setDate(2, dataReserva);
            prd.setBoolean(3, parametro.isStatus());
            prd.setInt(4, parametro.getFuncionario_id());
            prd.setInt(5, parametro.getCliente_id());
            prd.setInt(6, parametro.getTitulo_id());

            prd.execute();

            //Recupera o id gerado
            String sql2 = "SELECT currval('atendimento_id_seq') as id";

            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sql2);

            if (rs.next()) {
                parametro.setId(rs.getInt("id"));
            }

            rs.close();
            cnn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na Persistencia de Reserva" + e.getMessage());
        }
    }

    public void incluirReservaDependente(Atendimento parametro) throws SQLException {

        try {

            String sql = "INSERT INTO atendimento (quantidade_midia, data_entrada, status, funcionario_id, dependente_id, titulo_id) VALUES(?,?,?,?,?,?);";

            Connection cnn = util.Conexao.getConexao();
            PreparedStatement prd = cnn.prepareStatement(sql);

            java.sql.Date dataReserva = new Date(parametro.getDataEntrada().getTime());

            prd.setInt(1, parametro.getQuantidadeMidias());
            prd.setDate(2, dataReserva);
            prd.setBoolean(3, parametro.isStatus());
            prd.setInt(4, parametro.getFuncionario_id());
            prd.setInt(5, parametro.getCliente_id());
            prd.setInt(6, parametro.getTitulo_id());

            prd.execute();

            //Recupera o id gerado
            String sql2 = "SELECT currval('atendimento_id_seq') as id";

            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sql2);

            if (rs.next()) {
                parametro.setId(rs.getInt("id"));
            }

            rs.close();
            cnn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na Persistência de Reserva" + e.getMessage());
        }
    }
    
    public void incluirLocacaoCliente(Atendimento parametro) throws SQLException {

        try {

            String sql = "INSERT INTO atendimento (funcionario_id, cliente_id, titulo_id, midia_id, quantidade_midia, data_entrada, status, duracao, valor_total) VALUES(?,?,?,?,?,?,?,?,?);";

            Connection cnn = util.Conexao.getConexao();
            PreparedStatement prd = cnn.prepareStatement(sql);

            java.sql.Date dataLocacao = new Date(parametro.getDataEntrada().getTime());

            prd.setInt(1, parametro.getFuncionario_id());
            prd.setInt(2, parametro.getCliente_id());
            prd.setInt(3, parametro.getTitulo_id());
            prd.setInt(4, parametro.getMidia_id());
            prd.setInt(5, parametro.getQuantidadeMidias());
            prd.setDate(6, dataLocacao);
            prd.setBoolean(7, parametro.isStatus());
            prd.setInt(8, parametro.getDuracao());
            prd.setDouble(9, parametro.getValorTotal());

            prd.execute();

            //Recupera o id gerado
            String sql2 = "SELECT currval('atendimento_id_seq') as id";

            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sql2);

            if (rs.next()) {
                parametro.setId(rs.getInt("id"));
            }

            rs.close();
            cnn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na Persistência de Locação" + e.getMessage());
        }
    }
    
    public void incluirLocacaoDependente(Atendimento parametro) throws SQLException {

        try {

            String sql = "INSERT INTO atendimento (funcionario_id, dependente_id, titulo_id, midia_id, quantidade_midia, data, status, duracao, valor_total) VALUES(?,?,?,?,?,?,?,?);";

            Connection cnn = util.Conexao.getConexao();
            PreparedStatement prd = cnn.prepareStatement(sql);

            java.sql.Date dataLocacao = new Date(parametro.getDataEntrada().getTime());

            prd.setInt(1, parametro.getFuncionario_id());
            prd.setInt(2, parametro.getDependente_id());
            prd.setInt(3, parametro.getTitulo_id());
            prd.setInt(4, parametro.getMidia_id());
            prd.setInt(5, parametro.getQuantidadeMidias());
            prd.setDate(6, dataLocacao);
            prd.setBoolean(7, parametro.isStatus());
            prd.setInt(8, parametro.getDuracao());
            prd.setDouble(9, parametro.getValorTotal());

            prd.execute();

            //Recupera o id gerado
            String sql2 = "SELECT currval('atendimento_id_seq') as id";

            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sql2);

            if (rs.next()) {
                parametro.setId(rs.getInt("id"));
            }

            rs.close();
            cnn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na Persistência de Locação" + e.getMessage());
        }
    }
    
    public void alterarReservaCliente(Atendimento parametro) throws SQLException {

        try {

            String sql = "UPDATE atendimento SET quantidade_midia = ?, data_reserva, status = ?, funcionario_id = ?, cliente_id = ?, titulo_id = ? WHERE id = ?";

            Connection cnn = util.Conexao.getConexao();

            PreparedStatement prd = cnn.prepareStatement(sql);
            
            java.sql.Date dataReserva = new Date(parametro.getDataEntrada().getTime());

            //Substitui as variveis do sql pelos valores passados como parametro
            prd.setInt(1, parametro.getQuantidadeMidias());
            prd.setDate(2, dataReserva);
            prd.setBoolean(3, parametro.isStatus());
            prd.setInt(4, parametro.getFuncionario_id());
            prd.setInt(5, parametro.getCliente_id());
            prd.setInt(6, parametro.getTitulo_id());
            prd.setInt(7, parametro.getId());

            prd.execute();
            cnn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    public void alterarReservaDependente(Atendimento parametro) throws SQLException {

        try {

            String sql = "UPDATE atendimento SET quantidade_midia = ?, data_reserva, status = ?, funcionario_id = ?, dependente_id = ?, titulo_id = ? WHERE id = ?";

            Connection cnn = util.Conexao.getConexao();

            PreparedStatement prd = cnn.prepareStatement(sql);
            
            java.sql.Date dataReserva = new Date(parametro.getDataEntrada().getTime());

            //Substitui as variveis do sql pelos valores passados como parametro
            prd.setInt(1, parametro.getQuantidadeMidias());
            prd.setDate(2, dataReserva);
            prd.setBoolean(3, parametro.isStatus());
            prd.setInt(4, parametro.getFuncionario_id());
            prd.setInt(5, parametro.getDependente_id());
            prd.setInt(6, parametro.getTitulo_id());
            prd.setInt(7, parametro.getId());

            prd.execute();
            cnn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    public void alterarLocacaoCliente(Atendimento parametro) throws SQLException {

        try {

            String sql = "UPDATE atendimento SET funcionario_id = ?, cliente_id = ?, titulo_id = ?, midia_id = ?, multa_id = ?, quantidade_midia = ?, data_entrada = ?, data_saida = ?, status = ?, duracao = ?, valor_total= ? WHERE id = ?";

            Connection cnn = util.Conexao.getConexao();

            PreparedStatement prd = cnn.prepareStatement(sql);
            
            java.sql.Date dataEntrada = new Date(parametro.getDataEntrada().getTime());
            java.sql.Date dataSaida = new Date(parametro.getDataSaida().getTime());
            
            //Substitui as variveis do sql pelos valores passados como parametro
            prd.setInt(1, parametro.getFuncionario_id());
            prd.setInt(2, parametro.getCliente_id());
            prd.setInt(3, parametro.getTitulo_id());
            prd.setInt(4, parametro.getMidia_id());
            prd.setInt(5, parametro.getMulta_id());
            prd.setInt(6, parametro.getQuantidadeMidias());
            prd.setDate(7, dataEntrada);
            prd.setDate(8, dataSaida);
            prd.setBoolean(9, parametro.isStatus());
            prd.setInt(10, parametro.getDuracao());
            prd.setDouble(11, parametro.getValorTotal());
            prd.setInt(12, parametro.getId());

            prd.execute();
            cnn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO" + e.getMessage());
        }

    }
    
    public void alterarLocacaoDependente(Atendimento parametro) throws SQLException {

        try {

            String sql = "UPDATE atendimento SET funcionario_id = ?, dependente_id = ?, titulo_id = ?, midia_id = ?, quantidade_midia = ?, data = ?, status = ?, duracao = ?, valor_total= ? WHERE id = ?";

            Connection cnn = util.Conexao.getConexao();

            PreparedStatement prd = cnn.prepareStatement(sql);
            
            java.sql.Date dataLocacao = new Date(parametro.getDataEntrada().getTime());

            //Substitui as variveis do sql pelos valores passados como parametro
            prd.setInt(1, parametro.getFuncionario_id());
            prd.setInt(2, parametro.getCliente_id());
            prd.setInt(3, parametro.getTitulo_id());
            prd.setInt(4, parametro.getMidia_id());
            prd.setInt(5, parametro.getQuantidadeMidias());
            prd.setDate(6, dataLocacao);
            prd.setBoolean(7, parametro.isStatus());
            prd.setInt(8, parametro.getDuracao());
            prd.setDouble(9, parametro.getValorTotal());
            prd.setInt(10, parametro.getId());

            prd.execute();
            cnn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

//    public void incluir(Atendimento parametro) throws SQLException {
//        try {
//
//            //Cria a instrução SQL para a inserção no banco
//            String sql = "INSERT INTO atendimento (quantidade_midia, valor_total, desconto, data_venda, data_locacao, data_reserva, data_devolucao,"
//                    + " status, duracao, funcionario_id, multa_id, cliente_id, dependente_id)"
//                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
//
//            //Criando o objeto para a conexao
//            Connection cnn = util.Conexao.getConexao();
//
//            //Cria o objeto para executar os comandos no banco
//            PreparedStatement prd = cnn.prepareStatement(sql);
//
//            java.sql.Date dataVenda = new Date(parametro.getDataVenda().getTime());
//            java.sql.Date dataLocacao = new Date(parametro.getDataLocacao().getTime());
//            java.sql.Date dataReserva = new Date(parametro.getDataReserva().getTime());
//            java.sql.Date dataDevolucao = new Date(parametro.getDataDevolucao().getTime());
//
//            //Substitui as variveis do sql pelos valores passados
//            //como parametro
//            prd.setInt(1, parametro.getQuantidadeMidias());
//            prd.setDouble(2, parametro.getValorTotal());
//            prd.setDouble(3, parametro.getDesconto());
//            prd.setDate(4, dataVenda);
//            prd.setDate(5, dataLocacao);
//            prd.setDate(6, dataReserva);
//            prd.setDate(7, dataDevolucao);
//            prd.setBoolean(8, parametro.isStatus());
//            prd.setDate(9, (Date) parametro.getDuracao());
//            prd.setInt(10, parametro.getFuncionario_id());
//            prd.setInt(11, parametro.getMulta_id());
//            prd.setInt(12, parametro.getCliente_id());
//            prd.setInt(13, parametro.getDependente_id());
//
//            //Executa o comando
//            prd.execute();
//
//            //Recupera o id gerado
//            String sql2 = "SELECT currval('atendimento_id_seq') as id";
//
//            Statement stm = cnn.createStatement();
//            ResultSet rs = stm.executeQuery(sql2);
//
//            if (rs.next()) {
//                parametro.setId(rs.getInt("id"));
//            }
//
//            rs.close();
//            cnn.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro na Persistencia" + e.getMessage());
//        }
//
//    }
//
//    public void alterar(Atendimento parametro) throws SQLException {
//
//        try {
//
//            String sql = "UPDATE cliente SET"
//                    + " quantidade_midia = ?, valor_total = ?, desconto = ?, data_venda = ?, data_locacao = ?, data_reserva = ?, data_devolucao = ?,"
//                    + " status = ?, duracao = ?, funcionario_id = ?, multa_id = ?, cliente_id = ?, dependente_id = ?"
//                    + " WHERE id = ?";
//
//            Connection cnn = util.Conexao.getConexao();
//
//            PreparedStatement prd = cnn.prepareStatement(sql);
//
//            java.sql.Date dataVenda = new Date(parametro.getDataVenda().getTime());
//            java.sql.Date dataLocacao = new Date(parametro.getDataLocacao().getTime());
//            java.sql.Date dataReserva = new Date(parametro.getDataReserva().getTime());
//            java.sql.Date dataDevolucao = new Date(parametro.getDataDevolucao().getTime());
//
//            //Substitui as variveis do sql pelos valores passados
//            //como parametro
//            prd.setInt(1, parametro.getQuantidadeMidias());
//            prd.setDouble(2, parametro.getValorTotal());
//            prd.setDouble(3, parametro.getDesconto());
//            prd.setDate(4, dataVenda);
//            prd.setDate(5, dataLocacao);
//            prd.setDate(6, dataReserva);
//            prd.setDate(7, dataDevolucao);
//            prd.setBoolean(8, parametro.isStatus());
//            prd.setDate(9, (Date) parametro.getDuracao());
//            prd.setInt(10, parametro.getFuncionario_id());
//            prd.setInt(11, parametro.getMulta_id());
//            prd.setInt(12, parametro.getCliente_id());
//            prd.setInt(13, parametro.getDependente_id());
//            prd.setInt(14, parametro.getId());
//
//            prd.execute();
//            cnn.close();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//
//    }

    public void excluir(int id) throws SQLException {

        String sql = "DELETE FROM atendimento WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, id);

        prd.execute();
        cnn.close();

    }

    public Atendimento consultar(int id) throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, quantidade_midia, valor_total, desconto, data_entrada, data_saida,"
                + " status, duracao, funcionario_id, multa_id, cliente_id, dependente_id, titulo_id, midia_id, desconto"
                + " FROM atendimento WHERE id = ?";

        PreparedStatement stm = cnn.prepareStatement(sql);
        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();

        Atendimento atendimento = new Atendimento();

        if (rs.next()) {
            atendimento.setId(rs.getInt("id"));
            atendimento.setQuantidadeMidias(rs.getInt("quantidade_midia"));
            atendimento.setValorTotal(rs.getDouble("valor_total"));
            atendimento.setDesconto(rs.getDouble("desconto"));
            atendimento.setDataEntrada(rs.getDate("data_entrada"));
            atendimento.setDataSaida(rs.getDate("data_saida"));
            atendimento.setStatus(rs.getBoolean("status"));
            atendimento.setDuracao(rs.getInt("duracao"));
            atendimento.setFuncionario_id(rs.getInt("funcionario_id"));
            atendimento.setMulta_id(rs.getInt("multa_id"));
            atendimento.setCliente_id(rs.getInt("cliente_id"));
            atendimento.setDependente_id(rs.getInt("dependente_id"));
            atendimento.setTitulo_id(rs.getInt("titulo_id"));
            atendimento.setMidia_id(rs.getInt("midia_id"));
            atendimento.setDesconto(rs.getDouble("desconto"));
        }
        rs.close();
        cnn.close();

        return atendimento;
    }

    public List<Atendimento> listar() throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT id, quantidade_midia, valor_total, desconto, data_entrada, data_saida,"
                + " status, duracao, funcionario_id, multa_id, cliente_id, dependente_id, titulo_id, midia_id, desconto"
                + " FROM atendimento";

        Statement stm = cnn.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        List<Atendimento> lista = new ArrayList<>();

        while (rs.next()) {
            Atendimento atendimento = new Atendimento();
            atendimento.setId(rs.getInt("id"));
            atendimento.setQuantidadeMidias(rs.getInt("quantidade_midia"));
            atendimento.setValorTotal(rs.getDouble("valor_total"));
            atendimento.setDesconto(rs.getDouble("desconto"));
            atendimento.setDataEntrada(rs.getDate("data_entrada"));
            atendimento.setDataSaida(rs.getDate("data_saida"));
            atendimento.setStatus(rs.getBoolean("status"));
            atendimento.setDuracao(rs.getInt("duracao"));
            atendimento.setFuncionario_id(rs.getInt("funcionario_id"));
            atendimento.setMulta_id(rs.getInt("multa_id"));
            atendimento.setCliente_id(rs.getInt("cliente_id"));
            atendimento.setDependente_id(rs.getInt("dependente_id"));
            atendimento.setTitulo_id(rs.getInt("titulo_id"));
            atendimento.setMidia_id(rs.getInt("midia_id"));
            atendimento.setDesconto(rs.getDouble("desconto"));
            lista.add(atendimento);
        }
        rs.close();
        cnn.close();

        return lista;
    }

}
