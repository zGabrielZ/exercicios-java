package br.com.gabrielferreira.app;

public class Ex03 {

    public static void main(String[] args) {
        int soma = 0;
        int contador = 0;

        do {
            contador += 1;

            soma += contador;

            System.out.println(contador);
        } while (soma < 100);
    }
}
