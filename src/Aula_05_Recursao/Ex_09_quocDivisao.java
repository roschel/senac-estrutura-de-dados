/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_05_Recursao;

import static Aula_01_Vetores.ex_04_inverter.leInteiroPositivo;
import static Aula_05_Recursao.Ex_07_Primo.ePrimoITERATIVO;

/**
 *
 * @author joao
 */
public class Ex_09_quocDivisao {

    public static void main(String[] args) {
        int n1 = leInteiroPositivo();
        int n2 = leInteiroPositivo();

        System.out.println(quocoDiv(n1, n2));
    }

    public static int quocoDiv(int n1, int n2) {
        if (n1 < n2) {
            return 0;
        }
        return 1 + quocoDiv(n1 - n2, n2);
    }
}
