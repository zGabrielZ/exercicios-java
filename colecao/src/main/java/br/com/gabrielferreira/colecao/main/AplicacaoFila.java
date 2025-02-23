package br.com.gabrielferreira.colecao.main;

import br.com.gabrielferreira.colecao.model.Colecao;
import br.com.gabrielferreira.colecao.model.Fila;
import lombok.Generated;
import static br.com.gabrielferreira.commons.utils.LogUtils.*;

@Generated
public class AplicacaoFila {

    public static void main(String[] args) {
        Colecao colecao = new Fila();
        Fila fila = (Fila) colecao;

        statusFila(fila);

        System.out.println("Colocando alguns valores");
        try {
            colecao.inserirItem(1);
            colecao.inserirItem(4);
            colecao.inserirItem(5);
            colecao.inserirItem(10);
        } catch (Exception e){
            gerarLogWarn("Ocorreu um erro ao inserir item na fila. Causa {}", e);
        }
        System.out.println("1, 4, 5, 10");

        statusFila(fila);

        System.out.println("Removendo fila");
        Integer elemento = colecao.removerItem();
        System.out.println("Elemento removido : " + elemento);

        Integer elemento2 = colecao.removerItem();
        System.out.println("Elemento removido : " + elemento2);

        statusFila(fila);
    }

    private static void statusFila(Fila fila){
        System.out.println("Status da fila");
        for (Integer dado : fila.getStatusAtual()) {
            System.out.print(dado + ", ");
        }
        System.out.println("**********************************");
    }
}
