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

//    public Lista compactar(String caminho, String saida) throws Exception {
//        Lista listaEncadeada = new Lista();
//        
//        ArrayList<String> linhasArquivo = lerArquivo(caminho);
//        
//        ArrayList<String> linhasFormatadas = listaEncadeada.inserePalavrasNaLista(linhasArquivo);
//
//        escreverArquivo(linhasFormatadas, saida);
//
//        return listaEncadeada;
//    }
    /**
     * Compacta o arquivo.
     *
     * @param caminho
     * @param saida
     * @return lista com todas as palavras encontradas no arquivo.
     * @throws Exception
     */
    public void compactar(String caminho, String saida) throws Exception {
        Lista lista = new Lista();

        //recuperando todas as linhas do arquivo
        ArrayList<String> linhasArquivo = lerArquivo(caminho);
        ArrayList<String> linhasFormatadas = new ArrayList<>();

        //percorre as linhas que foram retiradas do arquivo e passadas para o array
        for (int i = 0; i < linhasArquivo.size(); i++) {
            //linha do arquivo do indice atual
            String linhaArquivo = linhasArquivo.get(i);
            int inicio = 0;
            int fim;

            String linhaFormatada = "";
            linhasFormatadas.add(linhaFormatada);

            //percorrendo caractere a caractere da linha atual
            for (int j = 0; j < linhaArquivo.length(); j++) {
                char caractere = linhaArquivo.charAt(j);

                //se o caractere da posicao j nao for uma letra
                if (!Character.isLetter(caractere)) {
                    //se a posicao inicio for diferente de j entao eu tenho uma palavra formada
                    if (inicio != j) {
                        fim = j;

                        //recuperando a palavra
                        String palavra = linhaArquivo.substring(inicio, fim);
                        //trocando a posicao da palavra para a posicao inicial,
                        //se ela estiver na lista e recuperando a sua posicao
                        int posicao = lista.trocaParaInicio(palavra);

                        //se a palavra estiver na lista, a sua posicao sera copiada para o arquivo
                        if (posicao > 0) {
                            linhaFormatada += posicao + String.valueOf(caractere);
                        } else { //senao, a palavra sera copiada para o arquivo
                            lista.insereInicio(palavra);
                            linhaFormatada += palavra + String.valueOf(caractere);
                        }

                        linhasFormatadas.set(i, linhaFormatada);

                        //inicio passa a obter a posicao atual de j para a formacao da proxima palavra
                        inicio = j + 1;
                    } else {//se o caractere da posicao j nao for uma letra
                        linhaFormatada += String.valueOf(caractere);
                        inicio = j + 1;

                        //se a posicao j for a ultima do laco, sera adicionado os caracteres no arquivo
                        if (linhaArquivo.length() - 1 == j) {
                            linhasFormatadas.set(i, linhaFormatada);
                        }
                    }
                } else if (linhaArquivo.length() - 1 == j) { //se for caractere e se a posicao j for a ultima do laco
                    fim = j + 1;

                    String palavra = linhaArquivo.substring(inicio, fim);

                    int posicao = lista.trocaParaInicio(palavra);

                    if (posicao > 0) {
                        linhaFormatada += posicao;
                    } else {
                        lista.insereInicio(palavra);
                        linhaFormatada += palavra;
                    }

                    linhasFormatadas.set(i, linhaFormatada);
                }
            }
        }

        escreverArquivo(linhasFormatadas, saida);
    }

    public void descompactar(String caminho, String saida) throws IOException {
        Lista lista = new Lista();

        ArrayList<String> linhasArquivo = lerArquivo(caminho);
        ArrayList<String> linhasFormatadas = new ArrayList<>();

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

        for (int i = 0; i < linhasArquivo.size(); i++) {
            String linhaArquivo = linhasArquivo.get(i); //oi, 

            linhasFormatadas.add("");

            Matcher matcher = pattern.matcher(linhaArquivo);
            int inicio = 0;
            int fim;

            String linhaFormatada = "";
            while (matcher.find()) {
                String palavra = "";

                if (inicio != matcher.start()) {
                    boolean ehLetra = Character.isLetter(linhaArquivo.charAt(inicio));
                    fim = matcher.start();

                    if (ehLetra) {
                        palavra = linhaArquivo.substring(inicio, fim);
                        lista.insereInicio(palavra);
                    } else {
                        int posicao = Integer.parseInt(linhaArquivo.substring(inicio, fim));

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

                String palavra;
                if (ehLetra) {
                    palavra = linhaArquivo.substring(inicio, fim);
                    lista.insereInicio(palavra);
                } else {
                    int posicao = Integer.parseInt(linhaArquivo.substring(inicio, fim));

                    if (posicao > 0) {
                        palavra = lista.buscaElementoPelaPosicao(posicao);

                        lista.trocaParaInicio(palavra);
                    } else {
                        palavra = "0";
                    }
                }

                linhaFormatada += palavra;
            }

            linhasFormatadas.set(i, linhaFormatada);
        }

        escreverArquivo(linhasFormatadas, saida);
    }
}
