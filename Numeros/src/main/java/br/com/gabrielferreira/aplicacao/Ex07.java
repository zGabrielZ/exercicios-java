package br.com.gabrielferreira.aplicacao;

public class Ex07 {

    public static void main(String[] args) {

        int x = 2;
        do {
            if(isPar(x)){
                x += 5;
            } else {
                x *= 2;
            }

            System.out.println(x);

        } while (x < 1000);

    }

    private static boolean isPar(Integer valor){
        return valor % 2 == 0;
    }
}
