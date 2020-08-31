/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO1;

import java.util.Scanner;

/**
 *
 * @author joaom
 */
public class Ex_09 {
    
    public static void main(String[] args) {
        int n1 = leInteiroPositivo();
        int v1[] = leVetorAleatorio(n1);
        exibeVetor(v1);
        
        int v[] = ordenaVetor(v1);

        exibeVetor(v);
    }
    
    public static int leInteiroPositivo() {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Digite um número positivo: ");
            n = sc.nextInt();
        } while (n <= 0 || n >= 100);
        return n;
    }

    public static int[] leVetorAleatorio(int n) {
        int v[] = new int[n];
        for (int i = 0; i < v.length; i++) {
            v[i] = (int) (Math.random() * 100);
        }
        return v;
    }

    public static int[] ordenaVetor(int[] v) {
        int primeiro = v[0];
        int i = 1;
        int ultimo = v.length - 1;
        while (i <= ultimo) {
            if (v[i] <= primeiro) {
                i++;
            } else if (v[ultimo] > primeiro) {
                ultimo--;
            } else {
                int t = v[i];
                v[i] = v[ultimo];
                v[ultimo] = t;
                i++;
                ultimo--;
            }
        }
        v[0] = v[ultimo];
        v[ultimo] = primeiro;

        return v;
    }
    
    public static void exibeVetor(int[] v) {
       System.out.println();
       for (int i=0; i<v.length;i++){
           System.out.print(v[i] + " ");
       }
        System.out.println();
    }
    
}
