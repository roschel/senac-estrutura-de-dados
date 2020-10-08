/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto1;

/**
 *
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

    public void insereFinal(String elemento) {
        No novo = new No(elemento, null);
        No temp = ini;

        while (temp.getProx() != null) {
            temp = temp.getProx();
        }
        temp.setProx(novo);
    }

    public void insereFinalRecursivo(String elemento) {
        insereFinalRecursivo(ini, elemento);
    }

    public void insereFinalRecursivo(No temp, String elemento) {
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

//    public void insereOrdenado(String elemento) {
//        No novo = new No(elemento, ini);
//        No temp = ini;
//        No anterior = null;
//
//        while (temp != null && temp.getElemento() < elemento) {
//            anterior = temp;
//            temp = temp.getProx();
//        }
//
//        // Lista vazia ou tem mais nós e insere no início
//        if (anterior == null) {
//            ini = novo;
//        } else {
//            // Lista tem 1 ou mais nós
//            novo.setProx(temp);
//            anterior.setProx(novo);
//        }
//    }
    public int buscaPosicaoDoElemento(String x) {
        No temp = ini;
        int cont = 0;

        while (temp != null) {
            if (temp.getElemento().equals(x)) {
                return cont;
            }
            cont++;
            temp = temp.getProx();
        }
        return cont;
    }

//    public void troca(No no) {
//        No aux = ini;
//
//        while (aux.getProx() != null && aux.getProx() != no) {
//            aux = aux.getProx();
//        }
//        if (aux.getProx() != null) {
//            aux.setProx(aux.getProx().getProx());
//
//            no.setProx(ini);
//            ini = no;
//        }
//
//    }
    public void troca(String elemento) {
        if (!(buscaPosicaoDoElemento(elemento) == 1)) {
            No aux = ini;
            No no;
            if ((no = buscaLinear(elemento)) != null) {
                while (aux.getProx() != null && aux.getProx() != no) {
                    aux = aux.getProx();
                }

                if (aux.getProx() != null) {
                    aux.setProx(aux.getProx().getProx());

                    no.setProx(ini);
                    ini = no;
                }

            } else {
                insereInicio(elemento);
            }
        }
    }

    public No buscaLinear(String elemento) {
        No no = ini;
        while (no.getElemento() != null && no.getElemento().equals(elemento)) {
            no = no.getProx();
        }

        return no != null ? no : null;
    }
//    public No buscaLinear2(int x) {
//        No temp = ini;
//
//        while (temp != null) {
//            if (temp.getElemento() == x) {
//                return temp;
//            }
//            temp = temp.getProx();
//        }
//        return null;
//    }

//    public boolean buscaLinearRecursiva(int x) {
//        return buscaLinearRecursiva(ini, x);
//    }
//
//    public boolean buscaLinearRecursiva(No temp, int x) {
//        if (temp == null) {
//            return false;
//        }
//
//        if (temp.getElemento() == x) {
//            return true;
//        }
//
//        return buscaLinearRecursiva(temp.getProx(), x);
//    }
//    public No buscaLinearRecursiva2(int x) {
//        return buscaLinearRecursiva2(ini, x);
//    }
//
//    public No buscaLinearRecursiva2(No temp, int x) {
//        if (temp == null || temp.getElemento() == x) {
//            return temp;
//        }
//        return buscaLinearRecursiva2(temp.getProx(), x);
//    }
    public void removeInicio() {
        if (vazia()) {
            System.out.println("Lista vazia");
        } else {
            // A lista possui um ou mais nos. Remover o primeiro
            ini = ini.getProx();
        }
    }

    public void removeFinal() {
        if (vazia()) {
            System.out.println("Lista vazia");
            return;
        }

        No temp = ini;
        No anterior = null;

        while (temp.getProx() != null) {
            anterior = temp;
            temp = temp.getProx();
        }
        // Lista com somente 1 no
        if (anterior == null) {
            ini = null;
            return;
        }
        // Lista com dois ou mais nos
        anterior.setProx(null);

    }

    public void removeFinalRecursivo() {
        removeFinalRecursivo(null, ini);
    }

    public void removeFinalRecursivo(No anterior, No temp) {
        if (vazia()) {
            System.out.println("Lista vazia");
            return;
        }
        // Lista com somente 1 no
        if (anterior == null && temp.getProx() == null) {
            ini = null;
            return;
        }
        // Estou no ultimo nó
        if (temp.getProx() == null) {
            anterior.setProx(null);
            return;
        }
        removeFinalRecursivo(temp, temp.getProx());
    }

    public void removeFinal2() {
        if (vazia()) {
            System.out.println("Lista vazia");
            return;
        }
        No temp = ini;

        // Lista com somente 1 no
        if (temp.getProx() == null) {
            ini = null;
            return;
        }

        while (temp.getProx().getProx() != null) {
            temp = temp.getProx();
        }

        // Lista com dois ou mais nos
        temp.setProx(null);

    }

    public void removeFinal2Recursivo() {
        removeFinal2Recursivo(ini);
    }

    public void removeFinal2Recursivo(No temp) {
        if (vazia()) {
            System.out.println("Lista vazia");
            return;
        }

        // Lista com somente 1 no
        if (temp.getProx() == null) {
            ini = null;
            return;
        }

        if (temp.getProx().getProx() == null) {
            // Lista com dois ou mais nos
            temp.setProx(null);
            return;
        }

        removeFinal2Recursivo(temp.getProx());
    }

//    public void removeOrdenado(int elemento) {
//        if (vazia()) {
//            System.out.println("Lista vazia");
//            return;
//        }
//
//        No temp = ini;
//        No anterior = null;
//
//        while (temp != null && temp.getElemento() != elemento) {
//            anterior = temp;
//            temp = temp.getProx();
//        }
//        // Remoção do início com apenas 1 ou mais nós
//        if (anterior == null) {
//            ini = ini.getProx();
//            return;
//        }
//
//        // Removendo elemento entre 2 nós ou remoção no final
//        if (temp != null && temp.getElemento() == elemento) {
//            anterior.setProx(temp.getProx());
//            return;
//        }
//        System.out.println(elemento + " Não está na lista");
//    }
    public int contaNos() {
        No temp = ini;
        int cont = 0;
        while (temp != null) {
            temp = temp.getProx();
            cont++;
        }

        return cont;
    }

    public int contaNosComFor() {
        int cont = 0;

        for (No temp = ini; temp != null; temp = temp.getProx()) {
            cont++;
        }

        return cont;
    }

//    public No menorNo() {
//        No menor = ini;
//        No temp = ini;
//
//        while (temp != null) {            
//            if (menor.getElemento() > temp.getElemento()) {
//                menor = temp;
//            }
//            temp = temp.getProx();
//        }
//        return menor;
//    }
//    public void criandoOrdenado(int tam){
//        for (int i = 0; i < tam; i++) {
//            double x = Math.random()*100+1;
//            insereOrdenado((int)x);
//        }
//    }
}
