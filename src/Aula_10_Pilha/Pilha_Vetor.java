/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_10_Pilha;

/**
 *
 * @author anacris
 */
public class Pilha_Vetor {
    private Object item[];
    private int topo;
    
    //Criar uma pilha vazia
    public Pilha_Vetor(int maxTam) {
        this.item = new Object[maxTam];
        this.topo = 0;
    }
    
    public boolean vazia(){
        return this.topo == 0;
    }
    
    public void push(Object x) throws Exception{
        if(this.topo == this.item.length){
            throw new Exception("Erro: A pilha está cheia");
        }
        this.item[topo] = x;
        this.topo++;
            
    }
    
    public Object pop() throws Exception{
        if(this.vazia()){
            throw new Exception("Erro: A pilha está vazia");
        }
        this.topo--;
        return this.item[topo];
    }
    
   public int size(){
       return this.topo;
   }

    @Override
    public String toString() {
        return "Pilha_Vetor{" + "item=" + item + ", topo=" + topo + '}';
    }
    
    
}
