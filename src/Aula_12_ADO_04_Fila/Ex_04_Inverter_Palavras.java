/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_12_ADO_04_Fila;

import Aula_10_Pilha.Pilha;
import java.util.Scanner;

/**
 *
 * @author anacris
 */
public class Ex_04_Inverter_Palavras {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite um texto.txt (final com .): ");
        String texto = entrada.nextLine();
        System.out.println("O texto.txt com as palavras invertidas é: ");
        System.out.println(inv_Palavra(texto));
    }

    private static String inv_Palavra(String texto) throws Exception {
       Pilha p = new Pilha();
       String inv = "";
       
       for (int i=0; i < texto.length(); i++){
           char c = texto.charAt(i);
           if(c != ' ' && c != '.'){
               p.push(c);
           } else {
               while (!p.vazia()) {
                   inv = inv + p.pop();
               }
               inv = inv + c;
           }
       }
       return inv;
    }
}
