package br.com.gabrielferreira.app;

import java.util.Locale;
import java.util.Scanner;

public class Ex05 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual número que vc deseja fatorar ? ");
        int numeroFatorar = scanner.nextInt();

        double fatora = 1;
        for(int i = 1; i <= numeroFatorar; i++){
            fatora *= i;
        }

        System.out.println(fatora);
        scanner.close();
    }
}
