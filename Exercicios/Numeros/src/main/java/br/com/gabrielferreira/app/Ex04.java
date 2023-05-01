package br.com.gabrielferreira.app;

public class Ex04 {

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++){
            String formula = String.format("%s X %s = %s", 9, i, 9 * i);
            System.out.println(formula);
        }
    }
}
