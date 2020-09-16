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
public class testaListaEncadeada {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();       
        lista.insereInicio(5);
        lista.insereInicio(7);
        lista.insereInicio(3);
        
        System.out.println(lista);
        
        lista.insereFinal(8);
        lista.insereFinal(2);
        System.out.println(lista);
        
    }
}
