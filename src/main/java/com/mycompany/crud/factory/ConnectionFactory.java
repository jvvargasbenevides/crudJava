/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joaovitor
 */
public class ConnectionFactory {
    // Nome do Usuário do MySQL
    private static final String USERNAME = "root";
    
    // Senha do Banco
    private static final String PASSWORD = "1234";
    
    // Caminho do banco de dados, porta, nome do banco de dados.
    private static final String DATABASE_URL = "jdbc:mysql://localhost:33306/crudjava_faculdade";
    
    /**
     *
     * @return
     * @throws Exception
     */
    public static Connection createConnectionToMySQL() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        
        return connection;
    }
    
    
    public static void main(String[] args) throws SQLException, Exception {
        
        // Recuperar uma conexão com o banco de dados
        Connection con = createConnectionToMySQL();
        
        // Testar se a conexão é nula
        if(con!=null){
            System.out.println("Conexão obtida com sucesso.");
            con.close();
        }
    }

}