/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO4;

/**
 *
 * @author joao
 */
public class No {
    private Object elemento;
    private No prox;

    public No(Object elemento, No prox) {
        this.elemento = elemento;
        this.prox = prox;
    }

    public Object getElemento() {
        return elemento;
    }

    public No getProx() {
        return prox;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "No{" + "elemento=" + elemento + ", prox=" + prox + '}';
    }

    }
