/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_12_ADO_04_Fila;

/**
 *
 * @author anacris
 */
public class Batata_Quente {
    public static void main(String[] args) throws Exception {
        Fila q = new Fila();
        
        q.enqueue("Douglas");
        q.enqueue("Caio");
        q.enqueue("Miguel");
        q.enqueue("Savio");
        q.enqueue("Débora");
        q.enqueue("Eduardo");
        q.enqueue("João");
        System.out.println(q);
        Object vencedor = batataQuente(q,6);
        System.out.println("O vencedor é: " + vencedor);    
    }
    
    public static Object batataQuente(Fila q, int k) throws Exception{
        Fila temp = q;
        
        while(temp.size() > 1){
            for (int i=0; i < k; i++){
                temp.enqueue(temp.dequeue());
            }
            System.out.println("Saindo: " + temp.dequeue());
        }
        return temp.dequeue();
    }
}
