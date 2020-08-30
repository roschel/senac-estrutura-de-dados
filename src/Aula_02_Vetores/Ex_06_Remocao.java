/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_02_Vetores;

import static Aula_01_Vetores.ex_04_inverter.exibeVetor;
import static Aula_01_Vetores.ex_04_inverter.leInteiroPositivo;
import static Aula_02_Vetores.Ex_05_Insercao.exibeVetorTam;
import static Aula_02_Vetores.Ex_05_Insercao.leVetorAleatorioTamFixo;
import java.util.Scanner;

/**
 *
 * @author joao
 */
public class Ex_06_Remocao {

    public static void main(String[] args) {
        int[] v = new int[30];
        int n = leInteiroPositivo();
        leVetorAleatorioTamFixo(v, n);
        exibeVetor(v);
        exibeVetorTam(v, n);

        Scanner sc = new Scanner(System.in);
        System.out.print("\nDigite o elemento que deseja remover: ");
        int x = sc.nextInt();
        int pos = buscaLinear(v, x);

        if (pos != -1) {
            remocao(v, n, pos);
        }
        
        exibeVetorTam(v, n -1);
    }
    
    private static void remocao(int[] v, int n, int pos) {
        for (int i = pos; i < n; i++) {
            v[i] = v[i + 1];
        }
        
    }

    public static int buscaLinear(int[] v, int x) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] == x) {
                return i; //achou
            }
        }
        return -1; //não achou
    }
}
