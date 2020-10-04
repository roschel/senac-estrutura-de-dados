/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO3;

import java.util.Scanner;

/**
 *
 * @author joao
 */
public class ADO3 {

    public static void main(String[] args) {
//        exercicioIntercalacao();
//        exercicioUniao();
        exercicioIntersecao();

    }

    private static Lista intercalacao(Lista x, Lista y) {
        Lista listaEncadeada = new Lista();
        No i = x.ini;
        No j = y.ini;
        int k = 0;

        while (k < (x.contaNos() + y.contaNos())) {
            //Sobras em B
            if (i == null) {
                listaEncadeada.insereOrdenado(j.getElemento());
                j = j.getProx();
                k++;
            } else if (j == null) {
                //Sobras A
                listaEncadeada.insereOrdenado(i.getElemento());
                i = i.getProx();
                k++;
            } else if (i.getElemento() <= j.getElemento()) {
                listaEncadeada.insereOrdenado(i.getElemento());
                i = i.getProx();
                k++;
            } else {
                listaEncadeada.insereOrdenado(j.getElemento());
                j = j.getProx();
                k++;
            }
        }
        return listaEncadeada;

    }

    public static void exercicioIntercalacao() {
        Lista lista1 = new Lista();
        Lista lista2 = new Lista();

        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o tamanho da lista 1: ");
        int tamanho1 = leitor.nextInt();
        lista1.criandoOrdenado(tamanho1);

        System.out.print("Digite o tamanho da lista 2: ");
        int tamanho2 = leitor.nextInt();
        lista2.criandoOrdenado(tamanho2);

        Lista listaIntercalada = intercalacao(lista1, lista2);

        System.out.println(lista1);
        System.out.println(lista2);
        System.out.println(listaIntercalada);
    }

    public static void exercicioUniao() {
        Lista lista1 = new Lista();
        Lista lista2 = new Lista();

        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o tamanho da lista 1: ");
        int tamanho1 = leitor.nextInt();
        lista1.criandoOrdenado(tamanho1);

        System.out.print("Digite o tamanho da lista 2: ");
        int tamanho2 = leitor.nextInt();
        lista2.criandoOrdenado(tamanho2);

        Lista listaIntercalada = new Lista();

        System.out.println(lista1);
        System.out.println(lista2);
        uniao(lista1, lista2, listaIntercalada);
        System.out.println(listaIntercalada);
    }

    public static void uniao(Lista v1, Lista v2, Lista vUni) {
        
        No temp1 = v1.ini;
        No temp2 = v2.ini;
        for (int i = 0; i < v1.contaNos(); i++) {
            vUni.insereOrdenado(temp1.getElemento());
            temp1 = temp1.getProx();
        }

        for (int i = 0; i < v2.contaNos(); i++) {
            if (!vUni.buscaLinear(temp2.getElemento())) {
                vUni.insereOrdenado(temp2.getElemento());
                temp2 = temp2.getProx();
            } else {
                temp2 = temp2.getProx();
            }
        }
    }

    private static void exercicioIntersecao() {
        Lista lista1 = new Lista();
        Lista lista2 = new Lista();

        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o tamanho da lista 1: ");
        int tamanho1 = leitor.nextInt();
        lista1.criandoOrdenado(tamanho1);

        System.out.print("Digite o tamanho da lista 2: ");
        int tamanho2 = leitor.nextInt();
        lista2.criandoOrdenado(tamanho2);

        Lista listaIntercalada = new Lista();

        System.out.println(lista1);
        System.out.println(lista2);
        inters(lista1, lista2, listaIntercalada);
        System.out.println(listaIntercalada);
    }

    public static void inters(Lista v1, Lista v2, Lista vInter) {
        
        No temp1 = v1.ini;
        
        for (int i = 0; i < v1.contaNos(); i++) {
            if (v2.buscaLinear(temp1.getElemento())) {
                vInter.insereOrdenado(temp1.getElemento());
                temp1=temp1.getProx();
            }else{
                temp1=temp1.getProx();
            }
        }
    }
}
