package Aula_01_Vetores;

import java.util.Scanner;

public class ex_04_inverter {

    public static void main(String[] args) {
        int n = leInteiroPositivo();
        int[] v = leVetorAleatorio(n);
        exibeVetor(v);
        inverter(v);
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
    
    public static int[] leVetor(int n) {
       int v[]=new int[n];
       Scanner sc = new Scanner(System.in);
       System.out.println("Digite os elementos do vetor:");
       for (int i=0; i<v.length;i++){
           System.out.printf("v[%d]=",i);
           v[i]=sc.nextInt();
       }
       return v;
    }

    public static int[] leVetorAleatorio(int n) {
       int v[]=new int[n];
       for (int i=0; i<v.length;i++){
           v[i]=(int)(Math.random()*100);
       }
       return v;
    }
    
    public static void exibeVetor(int[] v) {
       System.out.println();
       for (int i=0; i<v.length;i++){
           System.out.print(v[i] + " ");
       }
        System.out.println();
    }

    private static void inverter(int[] v) {
        int ini=0;
        int fim=v.length-1;
        while (ini <= fim) {
            //Troca
            int aux = v[ini];
            v[ini] = v[fim];
            v[fim] = aux;
            ini++;
            fim--;
        }
    }
}
