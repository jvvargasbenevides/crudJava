/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud.produto.dao;

import com.mycompany.crud.produto.Produto;
import com.mycompany.crud.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author joaovitor
 */
public class ProdutoDAO {
    
    public void save(Produto produto) throws Exception{
        String sql = "INSERT INTO produtos(nome_produto, preco_produto, descricao_produto, numero_produto) VALUES (?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement pstm =  null;
        
        try {
            //Criar uma conexão com banco de dados.
            conn = ConnectionFactory.createConnectionToMySQL();
        
            // Criamos uma PreparedStatement para executar uma query;
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1,produto.getNome_produto());
            pstm.setFloat(2, produto.getPreco_produto());
            pstm.setString(3,produto.getDescricao_produto());
            pstm.setInt(4, produto.getNumero_produto());
            
            // Executar a query
            pstm.execute();
        }catch(Exception e){
           e.printStackTrace();
        }finally{
         // Fechar as conexões.   
         try {
              if(pstm!=null) {
                  pstm.close();
              }
              if(conn!=null){
                conn.close();
              }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
      
