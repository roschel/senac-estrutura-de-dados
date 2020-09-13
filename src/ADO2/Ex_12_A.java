/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO2;

import java.util.Scanner;

/**
 *
 * @author joao
 */
public class Ex_12_A {

    public static void main(String[] args) {
        int[] vetor = preencherVetor();
        
        int menorElemento = menorElemento(vetor, 0, vetor.length-1);
        
        int[] vetorOrdenado = ordenaVetor(vetor);

        Scanner leitor = new Scanner(System.in);
        System.out.print("Qual número deseja encontrar? ");
        int n = leitor.nextInt();
        System.out.printf("Valor encontrado na posição %d%n", buscaLinear(vetor, n, 0));
        
        System.out.printf("Menor elemento do vetor é %d%n",menorElemento);
        
        System.out.printf("A soma de todos os elementos é: %d%n", soma(vetor, 0));
        
        System.out.printf("A média de todos os elementos é: %d%n", media(vetor, 0));

    }

    public static int[] preencherVetor() {
        Scanner leitor = new Scanner(System.in);
        System.out.print("De um tamanho ao seu vetor: ");
        int t = leitor.nextInt();
        int[] vetor = new int[t];
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Digite o valor [%d] do vetor: ", i + 1);
            vetor[i] = leitor.nextInt();
        }

        return vetor;
    }

    public static int[] ordenaVetor(int[] v) {
        int aux = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (v[i] > v[j]) {
                    aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }

        return v;
    }

    public static int buscaLinear(int[] v, int n, int y) {
        int x = v[y];
        int ultimo = v[v.length - 1];
        int pos = 0;
        if (x < ultimo && x != n) {
            y++;
            return buscaLinear(v, n, y);
        }
        if (x < ultimo && v[y] == n) {
            pos = y;
            return pos;
        } else {
            return -1;
        }
    }

    public static int menorElemento(int[] v, int n, int m) {
        if (n == m) {
            return v[n];
        } else {
            int primeiraMetade, segundaMetade;
            int metade;

            metade = ((n + m) / 2);
            primeiraMetade = menorElemento(v, n, metade);
            segundaMetade = menorElemento(v, metade + 1, m);

            if (primeiraMetade < segundaMetade) {
                return primeiraMetade;
            } else {
                return segundaMetade;
            }
        }
    }
    
    public static int soma(int v[], int contador){
        if(contador < v.length){
            return v[contador] + soma(v, contador + 1);
        }
        return 0;
    }
    
    public static int media(int[] v, int i) {
        int cont;
        if (i < v.length) {
            return cont = 1 + media(v, i + 1);
        }
        return 0;
    }
}
