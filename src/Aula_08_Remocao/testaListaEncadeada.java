/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_08_Remocao;

/**
 *
 * @author joao
 */
public class testaListaEncadeada {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.insereInicio(7);
        System.out.println(lista);
        lista.removeFinal2Recursivo();
        System.out.println(lista);
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
        
//        System.out.println(lista.buscaLinear(13));
//        System.out.println(lista.buscaLinear(6));
//        
//        System.out.println(lista.buscaLinear2(13).getElemento());
//        System.out.println(lista.buscaLinear2(6));
//        
//        System.out.println(lista.buscaLinearRecursiva(13));
//        System.out.println(lista.buscaLinearRecursiva(6));
//        
//        System.out.println(lista.buscaLinearRecursiva2(13).getElemento());
//        System.out.println(lista.buscaLinearRecursiva2(6));
//        System.out.println(lista);
//        
//        lista.removeInicio();
//        System.out.println(lista);
//        lista.removeFinal();
//        System.out.println(lista);
//        lista.removeFinal2();
//        System.out.println(lista);
//        
//        lista.removeFinal2Recursivo();
//        System.out.println(lista);
        
        lista.removeOrdenado(1);
        System.out.println(lista);
        lista.removeOrdenado(13);
        System.out.println(lista);
        lista.removeOrdenado(29);
        System.out.println(lista);
        lista.removeOrdenado(8);
        System.out.println(lista);
        
        System.out.println(lista.contaNos());
        
        lista.insereInicio(28);
        lista.insereInicio(11);
        System.out.println(lista);
        System.out.println(lista.menorNo().getElemento());
        
    }
}
