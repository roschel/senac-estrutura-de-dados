package ADO1;

import java.util.Scanner;

public class Ex_08 {

    public static void main(String[] args) {

        int n1 = leInteiroPositivo();
        int v1[] = leVetorAleatorio(n1);
        exibeVetor(v1);

        int n2 = leInteiroPositivo();
        int v2[] = leVetorAleatorio(n2);
        exibeVetor(v2);

        int v3[] = intercala(v1, v2);
        exibeVetor(v3);
    }

    public static int[] intercala(int A[], int B[]) {
        int c[] = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (k < c.length) {
            //Sobras em B
            if (i == A.length) {
                c[k] = B[j];
                j++;
                k++;
            } else if (j == B.length) {
                //Sobras A
                c[k] = A[i];
                i++;
                k++;
            }else if (A[i]<=B[j]){
                c[k]=A[i];
                i++;
                k++;
            }else{
                c[k]=B[j];
                j++;
                k++;
            }
        }
        return c;
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

    public static void exibeVetor(int[] v) {
        System.out.println();
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }
}
