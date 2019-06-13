
import entidade.Multa;
import java.sql.SQLException;
import persistencia.MultaDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafael
 */
public class TesteMulta {
    
    public static void main(String[] args) throws SQLException {
        
        MultaDAO persistenciaMulta = new MultaDAO();
        
        Multa multa = new Multa();   
        multa.setDescricao("Atraso");
        multa.setValor(7.0);
        
        persistenciaMulta.incluir(multa);
        
        Multa multa2 = new Multa();   
        multa2.setDescricao("Destruída");
        multa2.setValor(10.0);
        
        persistenciaMulta.incluir(multa2);
        
        Multa multa3 = new Multa();   
        multa3.setDescricao("Perda");
        multa3.setValor(12.0);
        
        persistenciaMulta.incluir(multa3);
        
    }
    
}
