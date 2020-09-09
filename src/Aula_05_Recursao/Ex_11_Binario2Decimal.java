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
public class Ex_11_Binario2Decimal {

    public static void main(String[] args) {
        int decimal = leInteiroPositivo();

        System.out.println(binario2DecimalR(10010));
    }

    public static int binario2Decimal(int binario) {
        int decimal = 0;
        int cont = 0;

        while (binario > 0) {
            int resto = binario % 2;
            decimal = binario + resto * (int) Math.pow(2, cont);
            binario = binario / 10;
            cont++;
        }
        return decimal;
    }

    public static int binario2DecimalR(int binario) {
        if (binario < 10) {
            return binario;
        }
        return (2 * binario2DecimalR(binario / 10)) + binario % 10;
    }

}
