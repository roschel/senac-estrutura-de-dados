/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sillas.clpinto
 */
public class Compactador {

    private ArrayList<String> lerArquivo(String caminho) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(caminho);
        BufferedReader br = new BufferedReader(fr);

        ArrayList<String> linhasArquivo = new ArrayList<>();

        String linha;

        while ((linha = br.readLine()) != null) {
            linhasArquivo.add(linha);
        }

        fr.close();
        br.close();

        return linhasArquivo;
    }

    private void escreverArquivo(ArrayList<String> linhasArquivo, String saida) throws IOException {
        FileWriter fw = new FileWriter(saida);
        BufferedWriter bw = new BufferedWriter(fw);

        for (String linhaArquivo : linhasArquivo) {
            bw.write(linhaArquivo);
            bw.newLine();
        }

        bw.close();
    }

    /**
     * Compacta o arquivo.
     *
     * @param caminho
     * @param saida
     * @throws Exception
     */
    public void compactar(String caminho, String saida) throws Exception {
        Lista lista = new Lista();

        //recuperando todas as linhas do arquivo
        ArrayList<String> linhasArquivo = lerArquivo(caminho);
        ArrayList<String> linhasFormatadas = new ArrayList<>();

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

        //percorre as linhas que foram retiradas do arquivo e passadas para o array
        for (int i = 0; i < linhasArquivo.size(); i++) {
            String linhaArquivo = linhasArquivo.get(i);

            Matcher matcher = pattern.matcher(linhaArquivo);
            int inicio = 0;
            int fim;
            String linhaFormatada = "";
            String palavra;
            int posicao;
            while (matcher.find()) {
                fim = matcher.start();

                if (Character.isLetter(linhaArquivo.charAt(inicio))) {
                    palavra = linhaArquivo.substring(inicio, fim);
                    posicao = lista.trocaParaInicio(palavra);

                    if (posicao > 0) {
                        linhaFormatada += posicao + matcher.group();
                    } else {
                        linhaFormatada += palavra + matcher.group();
                        lista.insereInicio(palavra);
                    }
                } else {
                    linhaFormatada += matcher.group();
                }

                inicio = matcher.end();
            }

            if (inicio != linhaArquivo.length()) {
                fim = linhaArquivo.length();

                palavra = linhaArquivo.substring(inicio, fim);
                posicao = lista.trocaParaInicio(palavra);

                if (posicao > 0) {
                    linhaFormatada += posicao;
                } else {
                    linhaFormatada += palavra;
                    lista.insereInicio(palavra);
                }
            }

            linhasFormatadas.add(i, linhaFormatada);
        }

        escreverArquivo(linhasFormatadas, saida);
    }

    public void descompactar(String caminho, String saida) throws IOException {
        Lista lista = new Lista();

        ArrayList<String> linhasArquivo = lerArquivo(caminho);
        ArrayList<String> linhasFormatadas = new ArrayList<>();

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

        for (int i = 0; i < linhasArquivo.size(); i++) {
            String linhaArquivo = linhasArquivo.get(i);

            Matcher matcher = pattern.matcher(linhaArquivo);
            int inicio = 0;
            int fim;
            int posicao;
            String linhaFormatada = "";
            String palavra = "";
            while (matcher.find()) {

                if (inicio != matcher.start()) {
                    boolean ehLetra = Character.isLetter(linhaArquivo.charAt(inicio));
                    fim = matcher.start();

                    if (ehLetra) {
                        palavra = linhaArquivo.substring(inicio, fim);
                        lista.insereInicio(palavra);
                    } else {
                        posicao = Integer.parseInt(linhaArquivo.substring(inicio, fim));

                        if (posicao > 0) {
                            palavra = lista.buscaElementoPelaPosicao(posicao);

                            lista.trocaParaInicio(palavra);
                        } else {
                            palavra = "0";
                        }
                    }
                }

                linhaFormatada += palavra + matcher.group();

                inicio = matcher.end();
            }

            if (inicio != linhaArquivo.length()) {
                boolean ehLetra = Character.isLetter(linhaArquivo.charAt(inicio));
                fim = linhaArquivo.length();

                if (ehLetra) {
                    palavra = linhaArquivo.substring(inicio, fim);
                    lista.insereInicio(palavra);
                } else {
                    posicao = Integer.parseInt(linhaArquivo.substring(inicio, fim));

                    if (posicao > 0) {
                        palavra = lista.buscaElementoPelaPosicao(posicao);

                        lista.trocaParaInicio(palavra);
                    } else {
                        palavra = "0";
                    }
                }

                linhaFormatada += palavra;
            }

            linhasFormatadas.add(linhaFormatada);
        }

        escreverArquivo(linhasFormatadas, saida);
    }
}
