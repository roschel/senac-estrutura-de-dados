/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_02_Vetores;

import static Aula_01_Vetores.ex_04_inverter.exibeVetor;
import static Aula_01_Vetores.ex_04_inverter.leInteiroPositivo;
import static Aula_01_Vetores.ex_04_inverter.leVetorAleatorio;

/**
 *
 * @author joao
 */
public class Ex_05_Insercao {

    public static void main(String[] args) {
        int[] v = new int[30];
        int n = leInteiroPositivo();
        leVetorAleatorioTamFixo(v, n);
        exibeVetor(v);
        exibeVetorTam(v, n);
        insercao(v, n, 77, 5);
        exibeVetorTam(v,n+1);
    }

    public static void leVetorAleatorioTamFixo(int[] v, int n) {
        for (int i = 0; i < n; i++) {
            v[i] = (int) (Math.random() * 100);
        }
    }

    public static void exibeVetorTam(int[] v, int n) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(v[i] + " ");
        }
    }

    private static void insercao(int[] v, int n, int x, int pos) {
        for (int i = n; i > pos; i--) {
            v[i] = v[i - 1];
        }
        v[pos] = x;
    }
}
