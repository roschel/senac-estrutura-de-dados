/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_07_Insercao_Busca;

import Aula_06_Lista_Encadeada.*;

/**
 *
 * @author joao
 */
public class testaListaEncadeada {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();       
        lista.insereInicio(7);
        lista.insereInicio(5);
        lista.insereInicio(3);
        System.out.println(lista);
        
        lista.insereFinal(10);
        lista.insereFinal(13);
        lista.insereFinalRecursivo(18);
        lista.insereFinalRecursivo(25);
        System.out.println(lista);
        
        lista.insereOrdenado(1);
        lista.insereOrdenado(9);
        lista.insereOrdenado(29);
        System.out.println(lista);
        
        System.out.println(lista.buscaLinear(13));
        System.out.println(lista.buscaLinear(6));
        
        System.out.println(lista.buscaLinear2(13).getElemento());
        System.out.println(lista.buscaLinear2(6));
        
        System.out.println(lista.buscaLinearRecursiva(13));
        System.out.println(lista.buscaLinearRecursiva(6));
        
        System.out.println(lista.buscaLinearRecursiva2(13).getElemento());
        System.out.println(lista.buscaLinearRecursiva2(6));
        
    }
}
