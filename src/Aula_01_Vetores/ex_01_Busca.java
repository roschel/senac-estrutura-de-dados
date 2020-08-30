package Aula_01_Vetores;

import static Aula_01_Vetores.ex_04_inverter.exibeVetor;
import static Aula_01_Vetores.ex_04_inverter.leInteiroPositivo;
import static Aula_01_Vetores.ex_04_inverter.leVetorAleatorio;
import java.util.Scanner;

public class ex_01_Busca {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = leInteiroPositivo();
        int v[] = leVetorAleatorio(n);
        exibeVetor(v);

        System.out.println("\nDigite o número que deseja buscar: ");
        int x = sc.nextInt();

        if (busca(v, x)) {
            System.out.printf("\n%d está no vetor", x);
        } else {
            System.out.printf("\n%d NÃO está no vetor", x);
        }
        System.out.println("");
    }

    public static boolean busca(int[] v, int x) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] == x) {
                return true; //achou
            }
        }
        return false; //não achou
    }
}
