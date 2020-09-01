package Aula_04_Exercicio_e_ADO1;

import static Aula_01_Vetores.ex_01_Busca.busca;
import static Aula_01_Vetores.ex_04_inverter.*;
import static Aula_01_Vetores.ex_04_inverter.exibeVetor;
import static Aula_03_Desempenho_Algoritmos.ex_03_TrocaMaiorMenor.troca;


/**
 *
 6) Escreva uma função que receba dois vetores (A[] e B[]) já ordenados em ordem crescente e
 ambos possuem o mesmo tamanho. A sua função imprime a intersecção entre os dois vetores, ou seja, os elementos em
 comum entre os vetores A[] e B[]. Considere que os vetores não contêm valores duplicados. A função deve ter deve ter
 complexidade O(n), ou seja, o tamanho do vetor A[] e do vetor B[].
 */

public class Ex_06_exibeInters {
    public static void main(String[] args) {
        int n = leInteiroPositivo();
        int[] A = leVetorAleatorio(n);
        bubbleSort(A);
        exibeVetor(A);

        int[] B = leVetorAleatorio(n);
        bubbleSort(B);
        exibeVetor(B);

        System.out.println("\nO vetor da intersecção é:");
        exibeInters(A,B);
    }

    // Método BubbleSort tem desempenho 0(n^2), quadrático.
    private static void bubbleSort(int[] v) {
        for (int i = 0; i < v.length-1; i++) {
            for (int j = 0; j < v.length-1; j++) {
                if (v[j]>v[j+1]){
                    troca(v,j,j+1);
                }
            }
        }
    }

    // Método exibeInters tem desempenho 0(n), linear.
    public static void exibeInters(int[] A, int[] B) {
        int i=0;
        int j=0;
        while (i < A.length && j < B.length){
            if(A[i]<B[j]){
                i++;
            }else if(A[i]>B[j]){
                j++;
            }else{
                System.out.print(A[i]+" ");
                i++;
                j++;
            }
        }
    }
}
