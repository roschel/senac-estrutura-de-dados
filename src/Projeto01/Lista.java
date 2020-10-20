package Projeto01;

public class Lista {

    No ini;

    /**
     * Cria uma lista encadeada vazia.
     */
    public Lista() {
        this.ini = null;
    }

    /**
     * Insere um novo elemento no inicio da lista.
     *
     * @param elemento
     */
    public void insereInicio(String elemento) {
        ini = new No(elemento, ini);
    }

    /**
     * Busca a posicao do elemento na lista.
     *
     * @param elemento
     * @return a posicao do elemento na lista
     */
    public int buscaPosicaoDoElemento(String elemento) {
        No temp = ini;
        int cont = 0;

        while (temp != null) {
            cont++;
            if (temp.getElemento().equals(elemento)) {
                return cont;
            }
            temp = temp.getProx();
        }
        cont = 0;
        return cont;
    }

    /**
     * Verifica se o elemento existe na lista.
     *
     * @param posicao
     * @return proprio elemento se estiver na lista; senao, null
     */
    public String buscaElementoPelaPosicao(int posicao) {
        No temp = ini;
        int cont = 1;

        while (temp != null) {
            if (cont == posicao) {
                return temp.getElemento();
            }

            temp = temp.getProx();
            cont++;
        }
        return null;
    }

    /**
     * Troca a posicao de um elemento da lista para a primeira posicao se ele
     * estiver na lista.
     *
     * @param elemento
     * @return posicao - se o elemento estiver na lista; 0 - se nao estiver.
     */
    public int trocaParaInicio(String elemento) {
        No temp = buscaLinear(elemento);
        int posicao = buscaPosicaoDoElemento(elemento);

        if (temp != null) {
            if (temp != ini) {
                ordenar(temp);

                temp.setProx(ini);
                ini = temp;
            }
        }
        return posicao;
    }

    /**
     * Modifica o prox de um elemento da lista para o prox do seu prox.
     *
     * @param temp
     */
    public void ordenar(No temp) {
        No aux = ini;

        while (aux != null) {
            if (aux.getProx() == temp) {
                if (temp.getProx() != null) {

                    aux.setProx(temp.getProx());
                } else {
                    aux.setProx(null);
                }

                return;
            }
            aux = aux.getProx();
        }
    }

    /**
     * Verifica se o elemento existe na lista.
     *
     * @param elemento
     * @return temp - se o elemento estiver na lista; null - se nao estiver
     */
    public No buscaLinear(String elemento) {
        No temp = ini;

        while (temp != null) {
            if (temp.getElemento().equals(elemento)) {
                return temp;
            }
            temp = temp.getProx();
        }
        return null;
    }
}
