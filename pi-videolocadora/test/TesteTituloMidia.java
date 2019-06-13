
import entidade.Midia;
import entidade.Titulo;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import negocio.NTitulo;
import persistencia.MidiaDAO;
import persistencia.TituloDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafael
 */
public class TesteTituloMidia {
    
    public static void main(String[] args) throws ParseException, SQLException {
        
        TituloDAO persistenciaTitulo = new TituloDAO();
        Scanner entrada = new Scanner(System.in);
        
//        titulo.setNome("O Chamado");
//        titulo.setGenero("Terror");
//        titulo.setDiretor("Gore Verbinski");
//        titulo.setAtor("Naomi Watts, Brian Cox, Martin Henderson");
//        Data
//        String data = "31/01/2003";
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        Date data_nascimento = formato.parse(data);
//        titulo.setDataLancamento(data_nascimento);
//        titulo.setDisponibilidade(true);
//        titulo.setAtendimento_id(1);
//        
//        persistenciaTitulo.incluir(titulo);
//        
//        Titulo titulo2 = new Titulo();
//        
//        titulo2.setNome("O Grito");
//        titulo2.setGenero("Suspense, Terror, Fantasia");
//        titulo2.setDiretor("Takashi Shimizu");
//        titulo2.setAtor("Sarah Michelle Gellar, Jason Behr, Clea DuVall");
//        //Data
//        String data2 = "07/01/2005";
//        formato = new SimpleDateFormat("dd/MM/yyyy");
//        data_nascimento = formato.parse(data2);
//        titulo2.setDataLancamento(data_nascimento);
//        titulo2.setDisponibilidade(true);
//        titulo2.setAtendimento_id(2);
//        
//        persistenciaTitulo.incluir(titulo2);
//        
//        Titulo titulo3 = new Titulo();
//        
//        titulo3.setNome("Frozen - Uma Aventura Congelante");
//        titulo3.setGenero("Musical, Fantasia, Aventura, Comédia dramática");
//        titulo3.setDiretor("Chris Buck, Jennifer Lee");
//        titulo3.setAtor("Kristen Bell, Jonathan Groff, Santino Fontana, Josh Gad, Idina Menzel, Alan Tudyk");
//        //Data
//        String data3 = "03/01/2014";
//        formato = new SimpleDateFormat("dd/MM/yyyy");
//        data_nascimento = formato.parse(data3);
//        titulo3.setDataLancamento(data_nascimento);
//        titulo3.setDisponibilidade(true);
//        titulo3.setAtendimento_id(3);
//        
//        persistenciaTitulo.incluir(titulo3);
//
//        MidiaDAO persistenciaMidia = new MidiaDAO();
//        Midia midia = new Midia();
//        
//        midia.setQuantidade(6);
//        midia.setDisponibilidade(true);
//        midia.setTitulo_id(8);
//        
//        persistenciaMidia.incluir(midia);
//        
//        Midia midia1 = new Midia();
//        
//        midia1.setQuantidade(6);
//        midia1.setDisponibilidade(true);
//        midia1.setTitulo_id(9);
//        
//        persistenciaMidia.incluir(midia1);
//        
//        Midia midia2 = new Midia();
//        
//        midia2.setQuantidade(6);
//        midia2.setDisponibilidade(true);
//        midia2.setTitulo_id(10);
//        
//        persistenciaMidia.incluir(midia2);

          System.out.println("Digite: ");
          String etc = entrada.next();
          
          persistenciaTitulo.procurandoNomes(etc);
          
        try {
            for (Titulo titulo : new TituloDAO().procurandoNomes(etc)) {
                System.out.println("alo");
                System.out.println(titulo.getNome());
            }
        } catch (Exception e) {
        }
        
        
        
        
        
        
    }
    
}
