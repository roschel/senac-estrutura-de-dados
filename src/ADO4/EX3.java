package ADO4;

import java.util.Scanner;

public class EX3 {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        System.out.print("Entre com um valor numérico: ");
        int numero = leitor.nextInt();

        conversor(numero);
    }

    private static void conversor(int numero) throws Exception {
        Pilha pilha = new Pilha();
        while (numero != 0) {

            // Guardando o resto da divisão na pilha
            pilha.push(numero % 2);

            // Decrementando número
            numero = numero / 2;
        }


        String saida = "";
        while (!pilha.vazia()) {
            saida += pilha.pop();
        }
        System.out.println("O número passado em binário é: " + saida);
    }
}
