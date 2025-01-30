package br.com.gabrielferreira.colecao.model;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilhaTest {

    @Test
    @DisplayName("Deve validar dado quando inserir item")
    void deveValidarDadoQuandoInserirItem(){
        Colecao colecao = new Pilha();
        assertThrows(RegraDeNegocioException.class, () -> colecao.inserirItem(null));
    }

    @Test
    @DisplayName("Deve inserir item quando informar corretamente")
    void deveInserirItem(){
        Colecao colecao = new Pilha();

        colecao.inserirItem(1);
        colecao.inserirItem(10);
        colecao.inserirItem(20);

        Pilha pilha = (Pilha) colecao;

        assertEquals(20, pilha.getStatusAtual().get(0));
        assertEquals(10, pilha.getStatusAtual().get(1));
        assertEquals(1, pilha.getStatusAtual().get(2));
    }

    @Test
    @DisplayName("Deve remover item quando")
    void deveRemoverItem(){
        Colecao colecao = new Pilha();

        colecao.inserirItem(1);
        colecao.inserirItem(10);
        colecao.inserirItem(20);

        Integer elemento = colecao.removerItem();

        Pilha pilha = (Pilha) colecao;

        assertFalse(pilha.getStatusAtual().contains(elemento));
        assertEquals(10, pilha.getStatusAtual().get(0));
        assertEquals(1, pilha.getStatusAtual().get(1));
    }
}
