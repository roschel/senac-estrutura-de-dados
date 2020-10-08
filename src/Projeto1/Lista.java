/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto1;

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


    public String buscaElemento(String x) {
        No temp = ini;
        int cont=0;

        while (temp != null) {
            cont++;
            if (cont == Integer.parseInt(x)) {
                return temp.getElemento();
            }
            temp = temp.getProx();
        }
        return "";
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


    public void troca(String elemento) {
        No no = buscaPosteriorLinear(elemento);

        if (no != null && no != ini) {
            No aux = no.getProx();
            no.setProx(no.getProx().getProx());

            aux.setProx(ini);
            ini = aux;
        } else if (no != ini) {
            insereInicio(elemento);
        }
    }

    public No buscaLinear(String elemento) {
        No no = ini;
        while (no.getElemento() != null && no.getElemento().equals(elemento)) {
            no = no.getProx();
        }

        return no != null ? no : null;
    }

    public No buscaPosteriorLinear(String elemento) {
        if (ini != null) {
            if (!ini.getElemento().equals(elemento)) {
                No no = ini;

                while (no.getProx() != null) {
                    if (no.getProx().getElemento().equals(elemento)) {
                        return no;
                    }
                    no = no.getProx();
                }
            } else {
                return ini;
            }
        }

        return null;
    }
}
