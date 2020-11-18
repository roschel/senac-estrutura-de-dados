/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_Conta_Palavras;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
        elemento = verificaChar(elemento);
        
        No novo = new No(elemento, null, null, 1);
        No pai = null;
        No p = raiz;
        
        //Buscar onde inserir o novo nó
        while (p != null) {
            pai = p;
            if (elemento.compareTo(p.getElemento()) == 0) {
                p.setContador();
                return p.getContador();
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
            return raiz.getContador();
        }
        if (elemento.compareTo(pai.getElemento()) < 0) {
            pai.setEsq(novo);
        } else {
            pai.setDir(novo);
        }
        return pai.getContador();
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
    
    public String verificaChar(String palavra) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9áàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ]");
        int inicio = 0, fim;
        Matcher buscador = pattern.matcher(palavra);
        
        while(buscador.find()) {
            fim = buscador.start();
            
            if(inicio != fim) {
                palavra = palavra.substring(inicio, fim);
            } else {
                inicio = buscador.end();
            }
        }
        if(inicio != palavra.length()) {
            fim = palavra.length();
            palavra = palavra.substring(inicio, fim);
        }
        return palavra;
    }

    public void inOrdem() {
        inOrdem(this.raiz);
    }

    public void inOrdem(No p) {
        if (p != null) {
            inOrdem(p.getEsq());
            System.out.println(p.getElemento() + " - " + p.getContador());
            inOrdem(p.getDir());
        }
    }

    @Override
    public String toString() {
        return "ABB{" + "raiz=" + raiz + '}';
    }

}
