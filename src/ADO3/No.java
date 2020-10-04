/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO3;

/**
 *
 * @author joaoNo ini;

    // Criar uma lista encadeada vazia
    public ListaEncadeada() {
        this.ini = null;
    }
    
    public boolean vazia(){
        return ini == null;
    }

    @Override
    public String toString() {
        String strLista="";
        No temp = ini;
        
        while (temp != null) {            
            strLista += temp.getElemento() + " ";
            temp = temp.getProx();
        }
        return strLista;
    }
    
    public void insereInicio (int elemento){
        No novo = new No(elemento, ini);
        ini = novo;
    }
    
    public void insereFinal(int elemento){
        No novo = new No(elemento, null);
        No temp = ini;
        
        while(temp.getProx() != null){
            temp=temp.getProx();
        }
        temp.setProx(novo);
    }
 */
public class No {
    
     private int elemento;
    private No prox;

    public No(int elemento, No prox) {
        this.elemento = elemento;
        this.prox = prox;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "No{" + "elemento=" + elemento + ", prox=" + prox + '}';
    }
    
}
