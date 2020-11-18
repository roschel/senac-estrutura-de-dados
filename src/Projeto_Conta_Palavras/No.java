/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_Conta_Palavras;



public class No {
    private String elemento;
    private No esq;
    private No dir;
    private int contador;

    public No(String elemento, No esq, No dir, int contador) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.contador = contador;
    }

    No(String elemento, Object object, Object object0, int contador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
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

    public int getContador() {
        return contador;
    }

    public int setContador() {
        this.contador += 1;
        return this.contador;
    }

    @Override
    public String toString() {
        return "No{" +
                "elemento='" + elemento + '\'' +
                ", esq=" + esq +
                ", dir=" + dir +
                ", contador=" + contador +
                '}';
    }
}
