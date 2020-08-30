/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_03_Desempenho_Algoritmos;

import static Aula_01_Vetores.ex_04_inverter.exibeVetor;
import static Aula_01_Vetores.ex_04_inverter.leInteiroPositivo;
import static Aula_01_Vetores.ex_04_inverter.leVetorAleatorio;

/**
 *
 * @author joao
 */
public class ex_03_TrocaMaiorMenor {

    public static void main(String[] args) {
        int n = leInteiroPositivo();
        int[] v = leVetorAleatorio(n);
        exibeVetor(v);
        trocaMaiorMenor(v);
        exibeVetor(v);
    }

    public static void trocaMaiorMenor(int[] v) {
        int posMenor = 0;
        int posMaior = 0;
        for (int i = 1; i < v.length; i++) {
            if (v[i] > v[posMaior]) {
                posMaior = i;
            } else if (v[i]<v[posMenor]) {
                posMenor = i;
            }
        }
        troca(v, posMaior,posMenor);
    }

    public static void troca(int[] v, int posMaior, int posMenor) {
        int aux;
        
        aux=v[posMaior];
        v[posMaior]=v[posMenor];
        v[posMenor]=aux;
    }
}
