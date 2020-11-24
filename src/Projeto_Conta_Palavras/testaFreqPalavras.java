package Projeto_Conta_Palavras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testaFreqPalavras {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FreqPalavras arvore = new FreqPalavras();

        BufferedReader leitor = new BufferedReader(new FileReader("texto.txt"));
        String linha;
        String regexNumerosCaracteres = "[^\\p{L}\\s]";

        while ((linha = leitor.readLine()) != null) {
            String[] arrayPalavras = linha.split(" ");

            for (String item : arrayPalavras) {
                String palavra = item.replaceAll(regexNumerosCaracteres, "");

                if (!palavra.isEmpty())
                    arvore.insere(palavra);
            }
        }
        leitor.close();

        arvore.inOrdem();
        arvore.mostrarFrequenciaPalavras();
    }
}
