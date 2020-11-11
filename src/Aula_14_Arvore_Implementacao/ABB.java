package Aula_14_Arvore_Implementacao;

public class ABB {
    private No raiz;

    //Cria uma arvore vazia
    public ABB() {
        this.raiz = null;
    }

    //Verifica se árvore está vazia
    public boolean vazia() {
        return this.raiz == null;
    }

    //inserção
    public void insere(int elemento) {
        No novo = new No(elemento, null, null);
        No pai = null;
        No p = raiz;

        //buscar onde inserir o novo no
        while (p != null) {
            pai = p;
            if (elemento < p.getElemento()) {
                p = p.getEsq();
            } else {
                p = p.getDir();
            }
        }

        //Verificar se árvore está vazia
        if (vazia()) {
            raiz = novo;
            return;
        }

        if (elemento < pai.getElemento()) {
            pai.setEsq(novo);
        } else {
            pai.setDir(novo);
        }
    }

    //inserção recursiva
    public void insereR(int elemento) {
        if (vazia()) {
            raiz = new No(elemento, null, null);
            return;
        }
        No novo = new No(elemento, null, null);
        insereR(raiz, novo);
    }

    public void insereR(No p, No novo) {
        if (novo.getElemento() < p.getElemento()) {
            if (p.getEsq() == null) {
                p.setEsq(novo);
            } else {
                insereR(p.getEsq(), novo);
            }
        } else {
            if (p.getDir() == null) {
                p.setDir(novo);
            } else {
                insereR(p.getDir(), novo);
            }
        }
    }

    public void preOrdem() {
        preOrdem(raiz);
    }

    public void preOrdem(No p) {
        if (p != null) {
            System.out.print(p.getElemento() + " ");
            preOrdem(p.getEsq());
            preOrdem(p.getDir());
        }
    }

    public void inOrdem() {
        inOrdem(raiz);
    }

    public void inOrdem(No p) {
        if (p != null) {
            inOrdem(p.getEsq());
            System.out.print(p.getElemento() + " ");
            inOrdem(p.getDir());
        }
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    public void posOrdem(No p) {
        if (p != null) {
            posOrdem(p.getEsq());
            posOrdem(p.getDir());
            System.out.print(p.getElemento() + " ");
        }
    }

    public No buscaIterativa(int elemento) {
        No p = raiz;

        while (p != null) {
            if (elemento == p.getElemento()) {
                return p;
            }
            if (elemento < p.getElemento()) {
                p.getEsq();
            } else {
                p.getDir();
            }
        }
        //Não achamos
        return null;
    }

    public No buscaRecursiva(int elemento) {
        return buscaRecursiva(raiz, elemento);
    }

    private No buscaRecursiva(No p, int elemento) {
        if (p == null) {
            return null;
        }
        if (elemento == p.getElemento()) {
            return p;
        }
        if (elemento < p.getElemento()) {
            return buscaRecursiva(p.getEsq(), elemento);
        } else {
            return buscaRecursiva(p.getDir(), elemento);
        }
    }

    public No maiorIterativo() {
        No p = raiz;

        while (p.getDir() != null) {
            p = p.getDir();
        }

        return p;
    }

    public No maiorRecursivo(){
        return maiorRecursivo(raiz);
    }

    private No maiorRecursivo(No p) {
        if(p.getDir()==null){
            return p;
        }
        return maiorRecursivo(p.getDir());
    }

    public No menorRecursivo(){
        return menorRecursivo(raiz);
    }

    private No menorRecursivo(No p) {
        if(p.getEsq()==null){
            return p;
        }
        return menorRecursivo(p.getEsq());
    }



    @Override
    public String toString() {
        return "ABB{" +
                "raiz=" + raiz +
                '}';
    }
}
