/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto01;

/**
 *
 * @author joao
 */
public class Trabalho1 {

    public static void main(String[] args) throws Exception {
        
        String nomeDoArquivo1 = "original.txt";
        String arquivoDeSaida = "compactado.txt";
        String arquivoDescompactado = "descompactado.txt";

        Compactador compactador = new Compactador();
        
        compactador.compactar(nomeDoArquivo1, arquivoDeSaida);
        compactador.descompactar(arquivoDeSaida, arquivoDescompactado);
    }
}