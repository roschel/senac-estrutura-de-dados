/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto01;

/**
 * @author joaoNo ini;
 * <p>
 * // Criar uma lista encadeada vazia
 * public ListaEncadeada() {
 * this.ini = null;
 * }
 * <p>
 * public boolean vazia(){
 * return ini == null;
 * }
 * @Override public String toString() {
 * String strLista="";
 * No temp = ini;
 * <p>
 * while (temp != null) {
 * strLista += temp.getElemento() + " ";
 * temp = temp.getProx();
 * }
 * return strLista;
 * }
 * <p>
 * public void insereInicio (int elemento){
 * No novo = new No(elemento, ini);
 * ini = novo;
 * }
 * <p>
 * public void insereFinal(int elemento){
 * No novo = new No(elemento, null);
 * No temp = ini;
 * <p>
 * while(temp.getProx() != null){
 * temp=temp.getProx();
 * }
 * temp.setProx(novo);
 * }
 */
public class No {

    private String elemento;
    private No prox;

    public No(String elemento, No prox) {
        this.elemento = elemento;
        this.prox = prox;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
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
        return "No { elemento = " + elemento + ", prox = " + prox + '}';
    }

}
