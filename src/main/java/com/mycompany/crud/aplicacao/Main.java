/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.crud.aplicacao;

import com.mycompany.crud.produto.Produto;
import com.mycompany.crud.produto.dao.ProdutoDAO;
import java.util.Scanner;

/**
 *
 * @author joaovitor
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
           
        public static void main(String[] args) throws Exception {
             ProdutoDAO produtoDao = new ProdutoDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o Metodo a ser chamado: (Inserir, Alterar, Visualizar, Deletar)");
        String escolha = scanner.nextLine();
        
        if (escolha.equalsIgnoreCase("Inserir")) {
            
            Produto produto = new Produto();
            System.out.println("Coloque o nome do produto.");
            String nomeProduto = scanner.nextLine();
            produto.setNome_produto(nomeProduto);
            System.out.println("Coloque o numero do produto.");
            String numero = scanner.nextLine();
            produto.setNumero_produto(Integer.parseInt(numero));
            System.out.println("Coloque a descricao do produto.");
            String descricao = scanner.nextLine();
            produto.setDescricao_produto(descricao);
            System.out.println("Coloque o preco do produto.");
            String preco = scanner.nextLine();
            produto.setPreco_produto(Float.parseFloat(preco));
        
        produtoDao.save(produto);
        
        // Imprimira os valores de cada coluna.
         System.out.println("ID:"+produto.getId_produto());
         System.out.println("Nome: "+nomeProduto);
         System.out.println("Numero: "+numero);
         System.out.println("Descricao: "+descricao);
         System.out.println("Preco: "+preco);
           
            
        } else if (escolha.equalsIgnoreCase("Alterar")) {
       Produto c1 = new Produto();
        System.out.println("Coloque o nome do produto.");
        String nome = scanner.nextLine();
       c1.setNome_produto(nome);
        System.out.println("Coloque a descricao do produto.");
        String descricao = scanner.nextLine();
       c1.setDescricao_produto(descricao);
       System.out.println("Coloque o preco do produto.");
        String preco = scanner.nextLine();
       c1.setPreco_produto(Float.parseFloat(preco));
        System.out.println("Coloque o numero do produto.");
        String numero = scanner.nextLine();
       c1.setNumero_produto(Integer.parseInt(numero));
        System.out.println("Coloque o id do produto a ser Alterado.");
        String id = scanner.nextLine();
       c1.setId_produto(Integer.parseInt(id));
       
       produtoDao.update(c1);
         System.out.println("ID:"+c1.getId_produto());
         System.out.println("Nome: "+nome);
         System.out.println("Numero: "+numero);
         System.out.println("Descricao: "+descricao);
         System.out.println("Preco: "+preco);

        } else if(escolha.equalsIgnoreCase("Visualizar")){
            for(Produto p : produtoDao.getProdutos()){
            System.out.println("Id: "+p.getId_produto());
            System.out.println("Produto: "+p.getNome_produto());
            System.out.println("Descricao: "+p.getDescricao_produto());
            System.out.println("Numero: "+p.getNumero_produto());
            System.out.println("Valor: "+p.getPreco_produto());
        }
           scanner.close();
    } else if(escolha.equalsIgnoreCase("Deletar")) {
        System.out.println("Coloque o ID do produto.");
        String id = scanner.nextLine();
        produtoDao.deleteById(Integer.parseInt(id));
    }

}
}
     
    
       
   

