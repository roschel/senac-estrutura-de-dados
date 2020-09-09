/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_05_Recursao;

/**
 *
 * @author joao
 */
public class Ex_04_Produto {

    public static void main(String[] args) {
        System.out.println(produto(3, 5));
    }

    public static int produto(int a, int b) {
        if (b == 1) {
            return a;
        }
        return a + produto(a, b - 1);
    }
}
