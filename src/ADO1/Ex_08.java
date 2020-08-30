package ADO1;

import java.util.Scanner;

public class Ex_08 {

    public static void main(String[] args) {

        int n1 = leInteiroPositivo();
        int v1[] = leVetorAleatorio(n1);

        int n2 = leInteiroPositivo();
        int v2[] = leVetorAleatorio(n2);

        intercala(v1, v2);
    }

    public static int[] intercala(int v1[], int v2[]) {
        int c[] = new int[v1.length + v2.length];
        int pos1 = 0;
        int pos2=0;

        for (int i = 0; i < c.length; i++) {
            if (i % 2 == 0) {
                c[i] = v1[pos1];
                pos1++;
            } else {
                c[i] = v2[pos2];
                pos2++;
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
}
