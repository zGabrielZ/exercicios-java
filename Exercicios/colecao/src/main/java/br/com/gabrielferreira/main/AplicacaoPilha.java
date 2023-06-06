package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.Colecao;
import br.com.gabrielferreira.model.Pilha;
import lombok.Generated;

@Generated
public class AplicacaoPilha {

    public static void main(String[] args) {
        System.out.println("Iniciando aplicação pilha");

        Colecao colecao = new Pilha();
        Pilha pilha = (Pilha) colecao;

        statusPilha(pilha);

        System.out.println("Colocando alguns valores");
        colecao.inserirItem(1);
        colecao.inserirItem(4);
        colecao.inserirItem(5);
        colecao.inserirItem(10);
        System.out.println("1, 4, 5, 10");

        statusPilha(pilha);

        System.out.println("Removendo pilha");
        Integer elemento = colecao.removerItem();
        System.out.println("Elemento removido : " + elemento);

        Integer elemento2 = colecao.removerItem();
        System.out.println("Elemento removido : " + elemento2);

        statusPilha(pilha);

    }

    private static void statusPilha(Pilha pilha){
        System.out.println("Status da pilha");
        for (Integer dado : pilha.getStatusAtual()) {
            System.out.print(dado + ", ");
        }
        System.out.println();
        System.out.println("**********************************");
    }
}
