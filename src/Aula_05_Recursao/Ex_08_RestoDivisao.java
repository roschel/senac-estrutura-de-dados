/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_05_Recursao;

import static Aula_01_Vetores.ex_04_inverter.leInteiroPositivo;

/**
 *
 * @author joao
 */
public class Ex_08_RestoDivisao {
    public static void main(String[] args) {
        int n1 = leInteiroPositivo();
        int n2 = leInteiroPositivo();

        System.out.println(restoDiv(n1,n2));
    }
    
    public static int restoDiv(int n1, int n2){
        if(n1<n2){
            return n1;
        }
        return restoDiv(n1-n2, n2);
    }
}
