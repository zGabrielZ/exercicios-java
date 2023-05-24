package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static br.com.gabrielferreira.utils.DataUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    @DisplayName("Deve criar produto")
    void deveCriarProduto(){
        Produto produto = new Produto(UUID.randomUUID(), 1, "Feijão", toBigDecimal(2.5), toDataBrasil("20/12/2010"));
        assertNotNull(produto);
    }

    @Test
    @DisplayName("Deve criar produto com getters e setters")
    void deveCriarProdutoGettersSetters(){
        Produto produto = new Produto();
        produto.setId(UUID.randomUUID());
        produto.setCodigo(1);
        produto.setDataValidade(toDataBrasil("20/12/2000"));
        produto.setPeso(toBigDecimal(2.0));
        produto.setNome("Feijão");

        assertNotNull(produto.getId());
        assertNotNull(produto.toString());
        assertEquals(1, produto.getCodigo());
        assertEquals("Feijão", produto.getNome());
        assertEquals(toBigDecimal(2.0), produto.getPeso());
        assertEquals(toDataBrasil("20/12/2000"), produto.getDataValidade());
    }

    @Test
    @DisplayName("Deve comparar produto quando não forem iguais")
    void deveCompararProdutoNaoIguais(){
        Produto produto1 = new Produto(UUID.randomUUID(), 1, "Feijão", toBigDecimal(2.5), toDataBrasil("20/12/2010"));
        Produto produto2 = new Produto(UUID.randomUUID(), 2, "Arroz", toBigDecimal(3.5), toDataBrasil("20/12/2010"));

        assertNotEquals(produto1, produto2);
        assertNotEquals(produto1.hashCode(), produto2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar aluno quando forem iguais")
    void deveCompararAlunoIguais(){
        UUID id = UUID.randomUUID();
        Integer codigo = 1;
        String nome = "Teste";
        BigDecimal peso = toBigDecimal(2.0);
        LocalDate data = toDataBrasil("20/12/2020");

        Produto produto1 = new Produto(id, codigo, nome, peso, data);
        Produto produto2 = new Produto(id, codigo, nome, peso, data);

        assertEquals(produto1, produto2);
        assertEquals(produto1.hashCode(), produto2.hashCode());
    }
}
