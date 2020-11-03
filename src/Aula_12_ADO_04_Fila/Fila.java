/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_12_ADO_04_Fila;

import Aula_10_Pilha.No;

/**
 *
 * @author anacris
 */
public class Fila {
    private No first;
    private No last;
    
    //Cria uma Fila vazia
    public Fila(){
        this.first = null;
        this.last = null;
    }
    
    //Verifica se a Fila está vazia
    public boolean isEmpty(){
        return this.first == null && this.last == null;
    }
    
    //Enfileirar um elemento
    public void enqueue (Object item){
        No  novo = new No(item, null);
        if(isEmpty()){
            this.first = novo;
            this.last = novo;
            return;
        }
        this.last.setProx(novo);
        this.last = novo;   
    }
    //Desenfileirar um elemento
    public Object dequeue () throws Exception{
        if(isEmpty()){
            throw new Exception ("Erro: Fila vazia. ");
        }
        Object item = this.first.getElemento();
        this.first = this.first.getProx();
        return item;
    }
    
    //Tamanho da fila
    public int size(){
        No temp = this.first;
        int cont = 0;
        
        while (temp != null){
            temp = temp.getProx();
            cont++;
        }
        return cont;
    }

    @Override
    public String toString() {
        return "Fila{" + "first=" + first + ", last=" + last + '}';
    }
   
    
}
