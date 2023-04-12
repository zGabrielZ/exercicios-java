package br.com.gabrielferreira.aplicacao;

public class Ex05 {

    public static void main(String[] args) {
        int numeroFatorar = 10;

        double fatora = 1;
        for(int i = 1; i <= numeroFatorar; i++){
            fatora *= i;
        }

        System.out.println(fatora);
    }
}
