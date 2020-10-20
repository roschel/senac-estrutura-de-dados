/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

/**
 *
 * @author sillas.clpinto
 */
public class Pilha {

    private Object itens[];
    private int topo;

    public boolean isVazia() {
        return topo == 0;
    }

    public void push(Object item) throws Exception {
        if (topo == itens.length) {
            throw new Exception("Erro: A pilha esta cheia");
        }
        itens[topo] = item;
        topo++;
    }

    public Object pop() throws Exception {
        if (isVazia()) {
            throw new Exception("Erro: A pilha esta cheia");
        }
        topo--;
        return itens[topo];
    }
    
    public int size() {
        return topo;
    }

    public Pilha(int tamanho) {
        itens = new Object[tamanho];
        topo = 0;
    }

    @Override
    public String toString() {
        String itensString = "itens [";

        for (int i = 0; i < topo; i++) {
            itensString += itens[i] + ";";
        }

        itensString = itensString.substring(0, itensString.length() - 1);
        itensString += "]";
        
        return itensString.replaceAll(";", ", ");
    }

}
