/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author joao
 */
public class Trabalho1 {

    public static void main(String[] args) throws Exception {
        String linha = null;
        String nomeDoArquivo1 = "original.txt";
        String arquivoDeSaida = "compactado.txt";

        FileReader fileReader = new FileReader(nomeDoArquivo1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter(arquivoDeSaida);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        Lista listaEncadeada = new Lista();

        // loop por cada linha do arquivo
        while ((linha = bufferedReader.readLine()) != null) {

            int cont = 0;
            String palavra = "";
            while (cont != linha.length()) {

                if (Character.isLetter(linha.charAt(cont))) {
                    palavra += linha.charAt(cont);
                } else {
                    int posicao = listaEncadeada.buscaPosicaoDoElemento(palavra);
                    if ( posicao > 0) {
                        bufferedWriter.write(Integer.toString(posicao) + linha.charAt(cont));
                        listaEncadeada.troca(palavra);
                    } else {
                        if (!palavra.trim().equals("")) {
                            listaEncadeada.insereInicio(palavra);
                        }
                        bufferedWriter.write(palavra + linha.charAt(cont));
                    }

                    palavra = "";
                }
                cont++;
            }
            if (cont == linha.length() && Character.isLetter(linha.charAt(cont-1))) {
                if (listaEncadeada.buscaPosicaoDoElemento(palavra) > 0) {
                    bufferedWriter.write(Integer.toString(listaEncadeada.buscaPosicaoDoElemento(palavra)));
                    listaEncadeada.troca(palavra);
                } else {
                    if (!palavra.trim().equals("")) {
                        listaEncadeada.insereInicio(palavra);
                    }
                    bufferedWriter.write(palavra);
                }

                palavra = "";
            }

            bufferedWriter.newLine();
        }

        // feche o arquivo
        bufferedReader.close();
        bufferedWriter.close();
    }
}
