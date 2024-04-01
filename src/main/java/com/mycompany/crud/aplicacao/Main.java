/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.crud.aplicacao;

import com.mycompany.crud.produto.Produto;
import com.mycompany.crud.produto.dao.ProdutoDAO;

/**
 *
 * @author joaovitor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
           
        public static void main(String[] args) throws Exception {
      
        
        ProdutoDAO produtoDao = new ProdutoDAO();
           
        Produto produto = new Produto();
        produto.setNome_produto("Celular REDMI 13 C");
        produto.setNumero_produto(45);
        produto.setDescricao_produto("8GB RAM, 256gb Armazenamento");
        produto.setPreco_produto((float) 250.23);
        
       produtoDao.save(produto);
        
    }
    }
    

