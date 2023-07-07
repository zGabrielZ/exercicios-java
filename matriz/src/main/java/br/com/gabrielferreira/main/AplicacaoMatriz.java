package br.com.gabrielferreira.main;

import lombok.Generated;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Generated
public class AplicacaoMatriz {

    public static void main(String[] args) {
        int [][] matriz = new int[3][3];
        matriz[0][0] = 5;
        matriz[0][1] = -3;
        matriz[0][2] = 10;
        matriz[1][0] = 15;
        matriz[1][1] = 8;
        matriz[1][2] = 2;
        matriz[2][0] = 7;
        matriz[2][1] = 9;
        matriz[2][2] = -4;

        List<Integer> matrizDiagonalPrincipal = new ArrayList<>();
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(i == j){
                    matrizDiagonalPrincipal.add(matriz[i][j]);
                }
                if(matriz[i][j] < 0){
                    soma += 1;
                }

                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Matriz negativo : " + matrizDiagonalPrincipal);
        System.out.println("Quantidade de números negativos : " + soma);
    }
}
