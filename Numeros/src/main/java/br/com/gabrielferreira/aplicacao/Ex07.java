package br.com.gabrielferreira.aplicacao;

import java.util.Locale;
import java.util.Scanner;

public class Ex07 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual número que vc deseja infomar ? ");
        int x = scanner.nextInt();

        do {
            if(isPar(x)){
                x += 5;
            } else {
                x *= 2;
            }

            System.out.println(x);

        } while (x < 1000);

        scanner.close();

    }

    private static boolean isPar(Integer valor){
        return valor % 2 == 0;
    }
}
