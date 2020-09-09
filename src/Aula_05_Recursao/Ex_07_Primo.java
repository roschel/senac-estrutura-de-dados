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
public class Ex_07_Primo {

    public static void main(String[] args) {
        int n = leInteiroPositivo();

        if (ePrimoITERATIVO(n)) {
            System.out.println(n + " é primo");
        } else {
            System.out.println(n + " não é primo");
        }
    }

    public static boolean ePrimoITERATIVO(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean ePrimoRECURSIVO(int n) {
        return ePrimoRECURSIVO(n, n - 1);
    }

    public static boolean ePrimoRECURSIVO(int n, int i) {
        if (i == 1) {
            return true;
        }
        if (n % i == 0) {
            return false;
        }

        return ePrimoRECURSIVO(n, i - 1);
    }
}
