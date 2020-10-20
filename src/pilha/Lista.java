/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

import java.util.regex.Pattern;

/**
 *
 * @author sillas.clpinto
 */
public class Lista {

    private No topo;
    private int tamanho;

    public boolean isVazia() {
        return topo == null;
    }

    public Lista() {
        topo = null;
        tamanho = 0;
    }

    public void push(Object elemento) {
        topo = new No(elemento, topo);

        tamanho++;
    }

    public Object pop() {
        if (isVazia()) {
            return null;
        } else {
            tamanho--;
            Object elemento = topo.getElemento();
            topo = topo.getProx();

            return elemento;
        }
    }

    public int size() {
        return tamanho;
    }

    @Override
    public String toString() {
        String lista = "";
        
        No aux = topo;
        while (aux != null) {            
            lista += aux.getElemento() + " ";
            aux = aux.getProx();
        }
        
        return lista;
    }
    
//    public static String verificarCaracteres(String cadeia) {
//        Pattern abertura = Pattern.compile("[({]");
//    }
}
