/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto01;

/**
 * @author joao
 */
public class Lista {

    No ini;

    // Criar uma lista encadeada vazia
    public Lista() {
        this.ini = null;
    }

    public boolean vazia() {
        return ini == null;
    }

    @Override
    public String toString() {
        String strLista = "";
        No temp = ini;

        while (temp != null) {
            strLista += temp.getElemento() + " ";
            temp = temp.getProx();
        }
        return strLista;
    }

    public void insereInicio(String elemento) {
        No novo = new No(elemento, ini);
        ini = novo;
    }

    public int buscaPosicaoDoElemento(String x) {
        No temp = ini;
        int cont = 0;

        while (temp != null) {
            cont++;
            if (temp.getElemento().equals(x)) {
                return cont;
            }
            temp = temp.getProx();
        }
        cont = 0;
        return cont;
    }
    
    public String buscaElementoPelaPosicao(int posicao) {
        No no = ini;
        int cont = 1;
        
        while (no != null) {            
            if (cont == posicao) {
                return no.getElemento();
            }
            
            no = no.getProx();
            cont++;
        }
        
        return null;
    }

    /**
     * Troca a posicao de um elemento da lista para a primeira posicao se ele
     * estiver na lista.
     *
     * @param elemento
     * @return posicao - se o elemento estiver na lista; 0 - se nao estiver.
     */
    public int trocaParaInicio(String elemento) {
        No no = buscaLinear(elemento);
        int posicao = buscaPosicaoDoElemento(elemento);

        if (no != null) {
            if (no != ini) {
                ordenar(no);

                no.setProx(ini);
                ini = no;
            }
        }

        return posicao;
    }

    public void ordenar(No no) {
        No aux = ini;

        while (aux != null) {
            if (aux.getProx() == no && no.getProx() != null) {
                aux.setProx(no.getProx());

                return;
            }

            aux = aux.getProx();
        }
    }

    public No buscaLinear(String elemento) {
        No no = ini;

        while (no != null) {
            if (no.getElemento().equals(elemento)) {
                return no;
            }

            no = no.getProx();
        }

        return null;
    }
}
