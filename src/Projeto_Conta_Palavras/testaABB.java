package Projeto_Conta_Palavras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testaABB {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ABB arvore = new ABB();

        BufferedReader leitor = new BufferedReader(new FileReader("texto.txt"));
        String linha;
        String regexNumerosCaracteres = "[^\\p{L}\\s]";

        while ((linha = leitor.readLine()) != null) {
            String[] arrayPalavras = linha.split(" ");

            for (String item : arrayPalavras) {
                String palavra = item.replaceAll(regexNumerosCaracteres, "").toLowerCase();

                if (!palavra.isEmpty())
                    arvore.insere(palavra);
            }
        }
        leitor.close();

        arvore.inOrdem();
        arvore.mostrarFrequenciaPalavras();
    }
}
