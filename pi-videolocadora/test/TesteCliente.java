
import entidade.Cliente;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import persistencia.ClienteDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rafael
 */
public class TesteCliente {

    public static void main(String[] args) throws ParseException, SQLException {

        Scanner entrada = new Scanner(System.in);
        Cliente cliente = new Cliente();
        ClienteDAO persistencia = new ClienteDAO();

        //inclusao
        System.out.println("Digite o nome: ");
        cliente.setNome(entrada.nextLine());
        System.out.println("Digite o CPF: ");
        cliente.setCpf(entrada.next());
        System.out.println("Digite o Telefone: ");
        cliente.setTelefone(entrada.next());
        System.out.println("Digite o Endereço: ");
        cliente.setEndereco(entrada.next());
        System.out.println("Digite o E-mail: ");
        cliente.setEmail(entrada.next());
        System.out.println("Digite o Data de Nascimento: ");
        String data = entrada.next();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data_nascimento = formato.parse(data);
        cliente.setData_nascimento(data_nascimento);
        persistencia.incluir(cliente);
        //alteracao
//        System.out.println("Digite o nome: ");
//        cliente.setNome(entrada.nextLine());
//        System.out.println("Digite o CPF: ");
//        cliente.setCpf(entrada.next());
//        System.out.println("Digite o Telefone: ");
//        cliente.setTelefone(entrada.next());
//        System.out.println("Digite o Endereço: ");
//        cliente.setEndereco(entrada.next());
//        System.out.println("Digite o E-mail: ");
//        cliente.setEmail(entrada.next());
//        System.out.println("Digite o Data de Nascimento: ");
//        String data = entrada.next();
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        Date data_nascimento = formato.parse(data);
//        cliente.setData_nascimento(data_nascimento);
//        System.out.println("Digite o ID: ");
//        cliente.setId(entrada.nextInt());
//        persistencia.alterar(cliente);
        //consulta
//          System.out.println("Digite o ID que deseja consultar: ");
//          Integer id = entrada.nextInt();
//          Cliente clienteConsulta = persistencia.consultar(id);
//          System.out.println("Nome: "+clienteConsulta.getNome());
//          System.out.println("CPF: "+clienteConsulta.getCpf());
//          System.out.println("Telefone: "+clienteConsulta.getTelefone());
//          System.out.println("Endereço: "+clienteConsulta.getEndereco());
//          System.out.println("E-mail: "+clienteConsulta.getEmail());
//          System.out.println("Data de Nascimento: "+clienteConsulta.getData_nascimento());
//          System.out.println("ID: "+id);
        //listagem
//        for (int i = 0; i < persistencia.listar().size(); i++) {
//            System.out.println(persistencia.listar().toString());
//        }
        
        //exclusao
//        System.out.println("Digite o ID do cliente que deseja excluir: ");
//        Integer id = entrada.nextInt();
//        persistencia.excluir(id);

    }

}
