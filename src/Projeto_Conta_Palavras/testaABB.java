/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_Conta_Palavras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testaABB {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ABB tree = new ABB();

        BufferedReader reader = new BufferedReader(new FileReader("texto.txt"));
        String linha;
        List<String> palavras = new ArrayList<>();

        while ((linha = reader.readLine()) != null) {
            String[] x = linha.split(" ");
            for (int i = 0; i < x.length; i++) {
                palavras.add(x[i]);
            }
        }

        for (String palavra : palavras) {
            tree.insere(palavra);
        }
        
        tree.inOrdem();
    }
}
