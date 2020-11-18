/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_Conta_Palavras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testaABB {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ABB tree = new ABB();

        BufferedReader reader = new BufferedReader(new FileReader("texto.txt"));
        String linha;
        String[] palavras = null;

        while ((linha = reader.readLine()) != null) {
            palavras = linha.split(" ");
        }

        for (String palavra : palavras) {
            tree.insere(palavra);
        }
        
        tree.inOrdem();

//        String a = "todos";
//        String b= "os";
//        System.out.println(b.compareTo(a));


//        tree.insere("teste");
//        tree.insere("uva");
//        tree.insere("abacaxi");
//        tree.insere("maca");
//        tree.insere("bana");
//        tree.insere("gilo");
//        if (tree.buscaIt("gilo") == 0) {
//            tree.insere("gilo");
//        }else{
//            System.out.println(tree.buscaIt("gilo"));
//        }
//        System.out.print("\nPré-Ordem: ");
//        tree.preOrdem();
//        System.out.print("\nIn-Ordem: ");
//        tree.inOrdem();
//        System.out.print("\nPós-Ordem: ");
//        tree.posOrdem();
//        int num = 8;
//        if(tree.buscaIt(num) != null)
//            System.out.println("Achou " + tree.buscaIt(num).getElemento());
//        else
//            System.out.println("NAO Achou " + num);
//        
//        num = 10;
//        if(tree.buscaR(num) != null)
//            System.out.println("Achou " + tree.buscaIt(num).getElemento());
//        else
//            System.out.println("NAO Achou " + num);
//        
//        System.out.println("O maior elemento = " + tree.maiorIt().getElemento());
//        System.out.println("O menor elemento = " + tree.menor().getElemento());
    }
}
