
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pilha.Lista;
import pilha.Pilha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sillas.clpinto
 */
public class Teste {

    public static void main(String[] args) throws Exception {
        System.out.println(teste());
    }

    public static String teste() {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite uma sequencia de () ou {}");
        String cadeia = "((){}())";//in.nextLine();
        Pattern abertura = Pattern.compile("[({]");
        Pattern fechamento = Pattern.compile("[)}]");        
        
        Lista lista = new Lista();
        
        Matcher buscador = abertura.matcher(cadeia);
        String novaCadeia = "";
        while (buscador.find()) {            
            lista.push(buscador.group());
            novaCadeia += buscador.group();
        }
        
        if (lista.size() == 0) {
            return "tudo errado";
        }
        
        buscador = fechamento.matcher(cadeia);
        while (buscador.find()) {            
            if (!valida(buscador.group()).equals(lista.pop())) {
                return "tudo errado";
            } else {
                novaCadeia += buscador.group();
            }
        }
        
        return novaCadeia;
    }
    
    public static String valida(String caractere) {
        if (caractere.equals(")")) {
            return "(";
        } else {
            return "}";
        }
    }
}
