/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud.produto.dao;

import com.mycompany.crud.produto.Produto;
import com.mycompany.crud.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
       public void update(Produto produto) throws Exception {
        String sql = "UPDATE produtos SET nome_produto = ?, descricao_produto = ?, numero_produto = ?, preco_produto = ? WHERE id_produto = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            // Define os valores para os parâmetros da consulta
            pstm.setString(1, produto.getNome_produto());
            pstm.setString(2, produto.getDescricao_produto());
            pstm.setInt(3, produto.getNumero_produto());
            pstm.setFloat(4, produto.getPreco_produto());
            pstm.setInt(5, produto.getId_produto());
            
            // Executa a consulta
            int rowsAffected = pstm.executeUpdate();
            
            // Verifica se algum registro foi atualizado
            if (rowsAffected > 0) {
                System.out.println("Registro atualizado com sucesso.");
            } else {
                System.out.println("Nenhum registro foi atualizado.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fecha os recursos
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
       
       public void deleteById( int id ) throws SQLException{
           String sql = "DELETE FROM produtos WHERE id_produto = ?";
           
           Connection conn = null;
           
           PreparedStatement pstm = null;
           
           try {
           conn = ConnectionFactory.createConnectionToMySQL();
           
           pstm = (PreparedStatement) conn.prepareStatement(sql);
           
           pstm.setInt(1, id);
           
           pstm.execute();
           
           } catch (Exception e) {
               e.printStackTrace();
           } finally {
               try {
                   if(pstm!=null){
                        pstm.close();
                      }
                   if(conn!=null){
                        conn.close();
                   }
               } catch (Exception e){ 
                   e.printStackTrace();
               }
           }
       }

    public List<Produto> getProdutos() {
        
        String sql = " SELECT * FROM produtos";
        
        List<Produto> produtos = new ArrayList<>();
        
    
        Connection conn = null;
        PreparedStatement pstm = null;
        // recupera dados do banco
        ResultSet rset = null; 
        
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            
            pstm = (PreparedStatement) conn.prepareStatement(sql);
        
            rset = pstm.executeQuery();
        
            while (rset.next()){
               
                
                Produto produto = new Produto();
               
                //Recuperar o id
                produto.setId_produto(rset.getInt("id_produto"));
                // Recuperar nome
                produto.setNome_produto(rset.getString("Nome_produto"));
                // Recuperar descricao
                produto.setDescricao_produto(rset.getString("Descricao_produto"));
                // Recuperar numero produto
                produto.setNumero_produto(rset.getInt("Numero_produto"));
                // Recuperar preco produto
                produto.setPreco_produto(rset.getFloat("Preco_produto"));
                
                produtos.add(produto);                
                } 
            } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try  {
                    if(rset!=null) {
                    rset.close();
                    }
                    if(pstm!=null){
                    pstm.close();
                    }
                    if(conn!=null){
                        conn.close();
                    }
                }catch (Exception e){
                   e.printStackTrace();
                }         
        }
          return produtos;
    }
    
}
      
