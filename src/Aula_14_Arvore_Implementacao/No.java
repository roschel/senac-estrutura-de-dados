package Aula_14_Arvore_Implementacao;

public class No {
    private int elemento;
    private No esq;
    private No dir;

    public No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "No{" +
                "elemento=" + elemento +
                ", esq=" + esq +
                ", dir=" + dir +
                '}';
    }
}
