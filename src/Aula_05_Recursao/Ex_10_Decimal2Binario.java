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
public class Ex_10_Decimal2Binario {

    public static void main(String[] args) {
        int decimal = leInteiroPositivo();

        System.out.println(decimal2BinarioR(decimal));
    }

    public static int decimal2Binario(int decimal) {
        int binario = 0;
        int cont = 0;
        while (decimal > 0) {
            int resto = decimal % 2;
            binario = binario + resto * (int) Math.pow(10, cont);
            decimal = decimal / 2;
            cont++;
        }
        return binario;
    }

    public static int decimal2BinarioR(int decimal) {
        if(decimal<2){
            return decimal;
        }
        return (10 * decimal2BinarioR(decimal/2)) + decimal % 2;
    }

}
