package ADO1;

import java.util.Scanner;

public class Ex_08 {
  public static void main(String[] args) {

    int n1 = leInteiroPositivo();
    int v1[] = leVetorAleatorio(n1);


    int n2 = leInteiroPositivo();
    int v2[]= leVetorAleatorio(n2);

    intercala(v1, v2);
  }

  public static int[] intercala(int v1[], int v2[]) {
    int c[] = new int[v1.length + v2.length];

    for (int i = 0; i < v1.length; i++) {
      for (int j = i + 1; j < v2.length; j++) {
        if (v2[j] > v1[i]) {

        }
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
    int v[]=new int[n];
    for (int i=0; i<v.length;i++){
      v[i]=(int)(Math.random()*100);
    }
    return v;
  }
}
