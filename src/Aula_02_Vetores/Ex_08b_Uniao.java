/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_02_Vetores;

import static Aula_01_Vetores.ex_01_Busca.busca;
import static Aula_01_Vetores.ex_04_inverter.exibeVetor;
import static Aula_01_Vetores.ex_04_inverter.leInteiroPositivo;
import static Aula_01_Vetores.ex_04_inverter.leVetor;
import static Aula_02_Vetores.Ex_05_Insercao.exibeVetorTam;

/**
 *
 * @author joao
 */
public class Ex_08b_Uniao {

    public static void main(String[] args) {
        int n1 = leInteiroPositivo();
        int[] v1 = leVetor(n1);
        exibeVetor(v1);

        int n2 = leInteiroPositivo();
        int[] v2 = leVetor(n2);
        exibeVetor(v2);

        int vUni[] = new int[n1 + n2];
        int nUni = uniao(v1, v2, vUni);

        System.out.println("\nO vetor da intersecção é:");
        exibeVetorTam(vUni, nUni);
    }

    public static int uniao(int[] v1, int[] v2, int[] vUni) {
        int k = 0;
        for (int i = 0; i < v1.length; i++) {
            vUni[k] = v1[i];
            k++;
        }

        for (int i = 0; i < v2.length; i++) {
            if (!busca(v1, v2[i])) {
                vUni[k] = v2[i];
                k++;
            }
        }
        return k;
    }
}
