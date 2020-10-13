package Projeto01;

public class Trabalho1 {

    public static void main(String[] args) throws Exception {

        String arquivoOriginal = "original.txt";
        String arquivoCompactado = "compactado.txt";
        String arquivoDescompactado = "descompactado.txt";

        Compactador.compactar(arquivoOriginal, arquivoCompactado);
        Compactador.descompactar(arquivoCompactado, arquivoDescompactado);
    }
}
