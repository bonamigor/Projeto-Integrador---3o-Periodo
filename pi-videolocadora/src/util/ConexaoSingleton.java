/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rafael
 */
public class ConexaoSingleton {

    private static Connection cnn;

    private static String url = "jdbc:postgresql://localhost/videolocadora";
    private static String user = "postgres";
    private static String senha = "123456";

    private ConexaoSingleton(){
        
    }
    
    public static synchronized Connection getConnection() {
        if (cnn == null) {
            try {
                cnn = DriverManager.getConnection(url, user, senha);
            } catch (SQLException ex) {
                System.out.println("Houve um erro ao conectar com o Banco de Dados.");
            }
        }

        return cnn;
    }

}
