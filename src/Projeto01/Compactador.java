/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sillas.clpinto
 */
public class Compactador {

    private ArrayList<String> lerArquivo(String caminho) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            ArrayList<String> linhasArquivo = new ArrayList<>();
            String linha;

            while ((linha = reader.readLine()) != null) {
                linhasArquivo.add(linha);
            }

            return linhasArquivo;

        } catch (IOException e) {
            throw new Error("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private void escreverArquivo(ArrayList<String> linhasArquivo, String saida) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(saida))) {
            for (String linhaArquivo : linhasArquivo) {
                bufferedWriter.write(linhaArquivo);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new Error("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    /**
     * Compacta o arquivo.
     * @param caminho
     * @param saida
     */
    public void compactar(String caminho, String saida) {
        Lista lista = new Lista();
        ArrayList<String> linhasDoArquivo;
        ArrayList<String> linhasFormatadas;

        //recuperando todas as linhas do arquivo
        linhasDoArquivo = lerArquivo(caminho);
        linhasFormatadas = new ArrayList<>();

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

        //percorre as linhas que foram retiradas do arquivo e passadas para o array
        for (int i = 0; i < linhasDoArquivo.size(); i++) {
            String linhaBuscada = linhasDoArquivo.get(i), palavra, linhaFormatada = "";
            Matcher buscador = pattern.matcher(linhaBuscada);

            int inicio = 0, fim, posicao, tamanhoLinha = linhaBuscada.length();
            char caracterBuscado;

            while (buscador.find()) {
                caracterBuscado = linhaBuscada.charAt(inicio);
                fim = buscador.start();

                if (isLetter(caracterBuscado)) {
                    palavra = linhaBuscada.substring(inicio, fim);
                    posicao = lista.trocaParaInicio(palavra);

                    if (posicao > 0) {
                        linhaFormatada += posicao + buscador.group();
                    } else {
                        linhaFormatada += palavra + buscador.group();
                        lista.insereInicio(palavra);
                    }
                } else {
                    linhaFormatada += buscador.group();
                }

                inicio = buscador.end();
            }

            if (inicio != tamanhoLinha) {

                fim = tamanhoLinha;
                palavra = linhaBuscada.substring(inicio, fim);
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
        validarDigitoCompactador(linhasFormatadas);
        escreverArquivo(linhasFormatadas, saida);
    }

    /**
     * Descompacta o arquivo
     * @param caminho
     * @param saida
     */
    public void descompactar(String caminho, String saida) {
        Lista lista = new Lista();
        ArrayList<String> linhasArquivo = lerArquivo(caminho);
        ArrayList<String> linhasFormatadas = new ArrayList<>();

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

        for (String linhaArquivo : linhasArquivo) {
            Matcher buscador = pattern.matcher(linhaArquivo);
            String linhaFormatada = "";
            String elemento;

            int inicio = 0, fim, posicao, tamanhoLinha = linhaArquivo.length();
            char caracterNaLinha;

            while (buscador.find()) {
                elemento = "";
                caracterNaLinha = linhaArquivo.charAt(inicio);

                if (inicio != buscador.start()) {
                    fim = buscador.start();
                    elemento = linhaArquivo.substring(inicio, fim);

                    if (isLetter(caracterNaLinha)) {
                        lista.insereInicio(elemento);
                    } else {
                        posicao = Integer.parseInt(elemento);

                        if (posicao > 0) {
                            elemento = lista.buscaElementoPelaPosicao(posicao);
                            lista.trocaParaInicio(elemento);
                        } else {
                            elemento = "0";
                        }
                    }
                }
                linhaFormatada += elemento + buscador.group();
                inicio = buscador.end();
            }

            if (inicio != tamanhoLinha) {
                caracterNaLinha = linhaArquivo.charAt(inicio);
                fim = tamanhoLinha;

                if (isLetter(caracterNaLinha)) {
                    elemento = linhaArquivo.substring(inicio, fim);
                    lista.insereInicio(elemento);
                } else {
                    posicao = Integer.parseInt(linhaArquivo.substring(inicio, fim));

                    if (posicao > 0) {
                        elemento = lista.buscaElementoPelaPosicao(posicao);
                        lista.trocaParaInicio(elemento);
                    } else {
                        elemento = "0";
                    }
                }
                linhaFormatada += elemento;
            }
            linhasFormatadas.add(linhaFormatada);
        }
        escreverArquivo(linhasFormatadas, saida);
    }

    public boolean isLetter(char character) {
        return Character.isLetter(character);
    }

    private void validarDigitoCompactador(ArrayList<String> linhasFormatadas) {
        if (linhasFormatadas != null && !linhasFormatadas.isEmpty()) {
            if (!linhasFormatadas.get(linhasFormatadas.size() - 1).equals("0")) {
                linhasFormatadas.add("0");
            }
        }
    }
}
