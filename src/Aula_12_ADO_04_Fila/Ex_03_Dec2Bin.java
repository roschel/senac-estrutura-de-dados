/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_12_ADO_04_Fila;

import static Aula_01_Vetores.ex_04_inverter.leInteiroPositivo;
import Aula_10_Pilha.Pilha;


/**
 *
 * @author anacris
 */
public class Ex_03_Dec2Bin {
    public static void main(String[] args) throws Exception {
        
     int decimal = leInteiroPositivo();
  
     System.out.println(decimal2BinarioP(decimal));
     
    }
    
    public static String decimal2BinarioP(int decimal) throws Exception{
        Pilha p = new Pilha();
        String binario = " ";
        
        while (decimal > 0){
            int resto = decimal % 2;
            p.push(resto);
            decimal = decimal / 2; //atualização
        }
        
        while (!p.vazia()){
            binario = binario + p.pop();
        }      
        return binario;
    }
    
    public static int decimal2Binario(int decimal){
        int binario = 0;
        int cont = 0;
        
        while (decimal > 0){
            int resto = decimal % 2;
            binario = binario + resto* (int)Math.pow(10, cont);
            decimal = decimal / 2; //atualização
            cont++; 
        }
        return binario;
    
    }
    public static int decimal2BinarioR(int decimal){
       
        if (decimal < 2)
            return decimal;
        
        return (10 * decimal2BinarioR(decimal/2)) + decimal %2;
    
    }
}
