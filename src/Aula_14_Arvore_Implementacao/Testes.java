package Aula_14_Arvore_Implementacao;

public class Testes {
    public static void main(String[] args) {
        ABB tree = new ABB();

        tree.insere(7);
        tree.insere(2);
        tree.insere(9);
        tree.insere(5);
        tree.insere(4);
        tree.insere(12);
        System.out.println(tree);

        tree.insereR(3);
        tree.insereR(8);
        System.out.println(tree);

        System.out.print("\nPré-ordem");
        tree.preOrdem();
        System.out.print("\nIn-ordem");
        tree.inOrdem();
        System.out.print("\nPós-ordem");
        tree.posOrdem();

        int num=8;
        if(tree.buscaIterativa(num) != null){
            System.out.println("Achou " + tree.buscaIterativa(num).getElemento());
        }else{
            System.out.println("Não achou " + num);
        }

        num=10;
        if(tree.buscaRecursiva(num) != null){
            System.out.println("Achou " + tree.buscaRecursiva(num).getElemento());
        }else{
            System.out.println("Não achou " + num);
        }

        System.out.println(tree.maiorIterativo());
        System.out.println(tree.maiorRecursivo());
    }

}
