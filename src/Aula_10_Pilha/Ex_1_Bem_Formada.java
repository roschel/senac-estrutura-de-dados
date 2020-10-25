/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_10_Pilha;

import java.util.Scanner;

/**
 *
 * @author anacris
 */
public class Ex_1_Bem_Formada {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite uma sequencia de () ou []: ");
        String seq = entrada.nextLine();
        
        Pilha p = new Pilha();
        
        for (int i=0; i< seq.length(); i++){
            char caracter = seq.charAt(i);
            if(caracter == '(' || caracter == '['){
                p.push(caracter);
            }
            else {
                if(p.vazia()) {
                    System.out.println("Não está bem formada");
                    return;
                }
                char charTopo = (char) p.pop();
                //Analisar as compatibilidades
                if(charTopo == '(' && caracter == ']'){
                    System.out.println("Não está bem formada");
                    return;
                }
                if(charTopo == '[' && caracter == ')'){
                    System.out.println("Não está bem formada");
                    return;
                }
            }
        }
        //Terminou de percorrer a sequência e analisa a pilha
        if(p.vazia())
           System.out.println("Está bem formada a sequência");
        else
           System.out.println("Não está bem formada a sequência");
        
    }    
}
