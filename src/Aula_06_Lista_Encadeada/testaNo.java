/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_06_Lista_Encadeada;

/**
 *
 * @author joao
 */
public class testaNo {

    public static void main(String[] args) {
        No a = new No(5, null);
        No b = new No(7, a);
        No c = new No(3, b);
        System.out.println(c);
    }
    
}
