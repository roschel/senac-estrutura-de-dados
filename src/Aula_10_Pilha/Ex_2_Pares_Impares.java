/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_10_Pilha;

import java.util.Random;

/**
 *
 * @author anacris
 */
public class Ex_2_Pares_Impares {
    public static void main(String[] args) throws Exception {
        Random r = new Random();
        Pilha pares = new Pilha();
        Pilha impares = new Pilha();
        
        for(int i=0; i< 10; i++){
            int num = r.nextInt(100);
            if (num % 2 == 0)
                pares.push(num);
            else
                impares.push(num);
        }
        
        System.out.println("Pilha Pares");
        while (!pares.vazia())
            System.out.println(pares.pop());
        
        System.out.println("Pilha Ímpares");
        while (!impares.vazia())
            System.out.println(impares.pop());
    }
    
    /*
    Processo semelhante com o Stack do Collection do Java
    
    Stack <String> dados = new Stack <String>();
        
        dados.push("teste01"); //insere
        dados.push("teste02"); //insere
        dados.push("teste03"); //insere
        
        System.out.println(dados);
        
        dados.pop(); //remove elemento do topo
        
        System.out.println(dados);
        
        System.out.println(dados.peek());//retorna o elemento do topo da pilha.
    */
}
