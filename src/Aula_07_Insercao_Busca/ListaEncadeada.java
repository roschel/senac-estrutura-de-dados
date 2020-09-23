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
public class ListaEncadeada {

    No ini;

    // Criar uma lista encadeada vazia
    public ListaEncadeada() {
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

    public void insereInicio(int elemento) {
        No novo = new No(elemento, ini);
        ini = novo;
    }

    public void insereFinal(int elemento) {
        No novo = new No(elemento, null);
        No temp = ini;

        if (temp == null) {
            ini = novo;
        } else {
            while (temp.getProx() != null) {
                temp = temp.getProx();
            }
            temp.setProx(novo);
        }
    }

    public void insereFinalRecursivo(int elemento) {
        insereFinalRecursivo(ini, elemento);
    }

    public void insereFinalRecursivo(No temp, int elemento) {
        // Lista vazia
        if (temp == null) {
            No novo = new No(elemento, null);
            ini = novo;
        }

        // Estar no ultimo nó
        if (temp.getProx() == null) {
            No novo = new No(elemento, null);
            temp.setProx(novo);
        } else {
            insereFinalRecursivo(temp.getProx(), elemento);
        }
    }

    public void insereOrdenado(int elemento) {
        No novo = new No(elemento, ini);
        No temp = ini;
        No anterior = null;

        while (temp != null && temp.getElemento() < elemento) {
            anterior = temp;
            temp = temp.getProx();
        }

        // Lista vazia ou tem mais nós e insere no início
        if (anterior == null) {
            ini = novo;
        } else {
            // Lista tem 1 ou mais nós
            novo.setProx(temp);
            anterior.setProx(novo);
        }
    }

    public boolean buscaLinear(int x) {
        No temp = ini;

        while (temp != null) {
            if (temp.getElemento() == x) {
                return true;
            }
            temp = temp.getProx();
        }
        return false;
    }

    public No buscaLinear2(int x) {
        No temp = ini;

        while (temp != null) {
            if (temp.getElemento() == x) {
                return temp;
            }
            temp = temp.getProx();
        }
        return null;
    }

    public boolean buscaLinearRecursiva(int x) {
        return buscaLinearRecursiva(ini, x);
    }

    public boolean buscaLinearRecursiva(No temp, int x) {
        if (temp == null) {
            return false;
        }
        
        if (temp.getElemento() == x) {
            return true;
        }

        return buscaLinearRecursiva(temp.getProx(), x);
    }

    public No buscaLinearRecursiva2(int x) {
        return buscaLinearRecursiva2(ini, x);
    }

    public No buscaLinearRecursiva2(No temp, int x) {
        if (temp == null || temp.getElemento() == x) {
            return temp;
        }
        return buscaLinearRecursiva2(temp.getProx(), x);
    }
}
