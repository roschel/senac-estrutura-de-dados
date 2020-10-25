package ADO4;

import java.util.Scanner;

public class EX4 {
    public static void main(String[] args) throws Exception {

        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite uma frase: ");
        String frase = leitor.nextLine();

        invertendoFrase(frase);

    }

    public static void invertendoFrase(String frase) throws Exception {

        Pilha pilha = new Pilha();

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (c != ' ') {
                pilha.push(c);
            } else {
                while (!pilha.vazia()) {
                    System.out.print(pilha.pop());
                }
                System.out.print(" ");
            }
        }
        // Este while foi usado para percorrer a ultima palavra, já que a condição do for acabou.
        while (!pilha.vazia()) {
            System.out.print(pilha.pop());
        }
    }
}
