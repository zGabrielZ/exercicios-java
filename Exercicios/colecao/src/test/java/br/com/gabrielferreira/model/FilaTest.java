package br.com.gabrielferreira.model;
import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaTest {

    @Test
    @DisplayName("Deve validar dado quando inserir item")
    void deveValidarDadoQuandoInserirItem(){
        Colecao colecao = new Fila();
        assertThrows(RegraDeNegocioException.class, () -> colecao.inserirItem(null));
    }

    @Test
    @DisplayName("Deve inserir item quando informar corretamente")
    void deveInserirItem(){
        Colecao colecao = new Fila();

        colecao.inserirItem(1);
        colecao.inserirItem(10);
        colecao.inserirItem(20);

        Fila fila = (Fila) colecao;

        assertEquals(1, fila.getStatusAtual().get(0));
        assertEquals(10, fila.getStatusAtual().get(1));
        assertEquals(20, fila.getStatusAtual().get(2));
    }

    @Test
    @DisplayName("Deve remover item quando")
    void deveRemoverItem(){
        Colecao colecao = new Fila();

        colecao.inserirItem(1);
        colecao.inserirItem(10);
        colecao.inserirItem(20);

        Integer elemento = colecao.removerItem();

        Fila fila = (Fila) colecao;

        assertFalse(fila.getStatusAtual().contains(elemento));
        assertEquals(10, fila.getStatusAtual().get(0));
        assertEquals(20, fila.getStatusAtual().get(1));
    }
}
