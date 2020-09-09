/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_05_Recursao;

/**
 *
 * @author joao
 */
public class Ex_06_SomaDigitos {

    public static void main(String[] args) {
        System.out.println(somaDigitos(235));
    }

    public static int somaDigitos(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + somaDigitos(n / 10);
    }
}
