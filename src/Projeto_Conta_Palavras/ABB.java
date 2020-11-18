/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_Conta_Palavras;


public class ABB {

    private No raiz;

    //Cria uma árvore vazia
    public ABB() {
        this.raiz = null;
    }

    //Verifica se a árvore está vazia
    public boolean vazia() {
        return this.raiz == null;
    }

    public int insere(String elemento) {
        No novo = new No(elemento, null, null, 0);
        No pai = null;
        No p = raiz;
        int cont = 0;

        //Buscar onde inserir o novo nó
        while (p != null) {
            pai = p;
            if (elemento.compareTo(p.getElemento()) == 0) {
                cont++;
                return cont;
            }
            if (elemento.compareTo(p.getElemento()) < 0) {
                p = p.getEsq();
            } else if (elemento.compareTo(p.getElemento()) > 0) {
                p = p.getDir();
            }
        }
        //Verifica se a árvore está vazia
        if (vazia()) {
            raiz = novo;
            return cont;
        }
        if (elemento.compareTo(pai.getElemento()) < 0) {
            pai.setEsq(novo);
        } else {
            pai.setDir(novo);
        }
        return cont;
    }

    public int buscaIt(String elemento) {
        No p = raiz;

        while (p != null) {

            int validador = elemento.compareTo(p.getElemento());
            if (validador < 0) {
                p = p.getEsq();

            }
            if (validador > 0) {
                p = p.getDir();

            }

            if (validador == 0) {
                return p.setContador();
            }
        }
        return 0; //não achou
    }

    @Override
    public String toString() {
        return "ABB{" + "raiz=" + raiz + '}';
    }

}
