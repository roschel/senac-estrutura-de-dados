package Projeto01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Compactador {

    /**
     * Recupera as linhas do arquivo e adiciona a um ArrayList
     *
     * @param caminho
     * @return uma lista de String com todas as linhas do arquivo
     */
    private static ArrayList<String> lerArquivo(String caminho) {
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

    /**
     * Escreve no arquivo cada linha de acordo com cada elemento do array.
     *
     * @param linhasArquivo
     * @param saida
     */
    private static void escreverArquivo(ArrayList<String> linhasArquivo, String saida) {
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
     *
     * @param caminho
     * @param saida
     */
    public static void compactar(String caminho, String saida) {
        Lista lista = new Lista();
        ArrayList<String> linhasDoArquivo;
        ArrayList<String> linhasFormatadas;

        //recuperando todas as linhas do arquivo
        linhasDoArquivo = lerArquivo(caminho);
        linhasFormatadas = new ArrayList<>();

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

        //percorre as linhas que foram retiradas do arquivo e passadas para o array
        for (String linhaBuscada : linhasDoArquivo) {
            String palavra, linhaFormatada = "";
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
            linhasFormatadas.add(linhaFormatada);
        }
        validarDigitoCompactador(linhasFormatadas);
        escreverArquivo(linhasFormatadas, saida);
    }

    /**
     * Descompacta o arquivo
     *
     * @param caminho
     * @param saida
     */
    public static void descompactar(String caminho, String saida) {
        Lista lista = new Lista();
        ArrayList<String> linhasArquivo = lerArquivo(caminho);
        ArrayList<String> linhasFormatadas = new ArrayList<>();

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

        for (int i = 0; i < linhasArquivo.size() - 1; i++) {
            String linhaArquivo = linhasArquivo.get(i);
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

                        elemento = lista.buscaElementoPelaPosicao(posicao);
                        lista.trocaParaInicio(elemento);
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

                    elemento = lista.buscaElementoPelaPosicao(posicao);
                    lista.trocaParaInicio(elemento);
                }
                linhaFormatada += elemento;
            }
            linhasFormatadas.add(linhaFormatada);
        }
        validarDigitoCompactador(linhasFormatadas);
        escreverArquivo(linhasFormatadas, saida);
    }

    /**
     * Verifica se um caractere eh letra.
     *
     * @param character
     * @return true - se o caractere for uma letra; false - se não for
     */
    public static boolean isLetter(char character) {
        return Character.isLetter(character);
    }

    /**
     * Insere o digito que finaliza o arquivo
     *
     * @param linhasFormatadas
     */
    private static void validarDigitoCompactador(ArrayList<String> linhasFormatadas) {
        if (linhasFormatadas != null && !linhasFormatadas.isEmpty()) {
            if (!linhasFormatadas.get(linhasFormatadas.size() - 1).equals("0")) {
                linhasFormatadas.add("0");
            }
        }
    }
}
