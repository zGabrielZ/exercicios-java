package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Jogo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class JogoServiceTest {

    private JogoService jogoService;

    @BeforeEach
    public void criarInstancias(){
        jogoService = new JogoService();
    }

    @Test
    @DisplayName("Deve validar criação do jogo quando informar o nome nulo")
    void deveValidarCriarJogoNomeNulo(){
        String nome = null;
        BigDecimal preco = toBigDecimal(20.0);
        assertThrows(RegraDeNegocioException.class, () -> jogoService.criarJogo(nome, preco));
    }

    @Test
    @DisplayName("Deve validar criação do jogo quando informar o preço nulo")
    void deveValidarCriarJogoPrecoNulo(){
        String nome = "Teste";
        BigDecimal preco = null;
        assertThrows(RegraDeNegocioException.class, () -> jogoService.criarJogo(nome, preco));
    }

    @Test
    @DisplayName("Deve validar criação do jogo quando informar o preço negativo")
    void deveValidarCriarJogoPrecoNegativo(){
        String nome = "Teste";
        BigDecimal preco = toBigDecimal(-20.0);
        assertThrows(RegraDeNegocioException.class, () -> jogoService.criarJogo(nome, preco));
    }

    @Test
    @DisplayName("Deve criar jogo")
    void deveCriarJogo(){
        Jogo jogo = jogoService.criarJogo("Teste", toBigDecimal(20.0));

        assertNotNull(jogo.getId());
        assertEquals("Teste", jogo.getNome());
        assertEquals(toBigDecimal(20.0), jogo.getPreco());
    }

    @Test
    @DisplayName("Deve calcular soma total")
    void deveCalcularSomaTotal(){
        Jogo jogo1 = jogoService.criarJogo("Teste 1", toBigDecimal(20.0));
        Jogo jogo2 = jogoService.criarJogo("Teste 2", toBigDecimal(40.0));
        Jogo jogo3 = jogoService.criarJogo("Teste 3", toBigDecimal(60.0));

        BigDecimal somaTotal = jogoService.calcularSomaTotal(Arrays.asList(jogo1, jogo2, jogo3));

        assertEquals(toBigDecimal(120.0), somaTotal);
    }

    @Test
    @DisplayName("Deve calcular preço médio")
    void deveCalcularPrecoMedio(){
        Jogo jogo1 = jogoService.criarJogo("Teste 1", toBigDecimal(20.0));
        Jogo jogo2 = jogoService.criarJogo("Teste 2", toBigDecimal(40.0));
        Jogo jogo3 = jogoService.criarJogo("Teste 3", toBigDecimal(60.0));

        BigDecimal precoMedio = jogoService.calcularPrecoMedio(Arrays.asList(jogo1, jogo2, jogo3));

        assertEquals(toRetorno(toBigDecimal(40.00), 2, RoundingMode.HALF_EVEN), precoMedio);
    }

    @Test
    @DisplayName("Deve mostrar jogos em ordem decrescente")
    void deveMostrarJogosOrdemDecrescente(){
        Jogo jogo1 = jogoService.criarJogo("God of War", toBigDecimal(20.0));
        Jogo jogo2 = jogoService.criarJogo("Fifa 23", toBigDecimal(40.0));
        Jogo jogo3 = jogoService.criarJogo("Call of Duty", toBigDecimal(60.0));

        List<String> nomes = jogoService.mostrarJogosOrdemDecrescente(Arrays.asList(jogo1, jogo2, jogo3));

        assertEquals("God of War", nomes.get(0));
        assertEquals("Fifa 23", nomes.get(1));
        assertEquals("Call of Duty", nomes.get(2));
    }

    @Test
    @DisplayName("Deve mostrar jogos em ordem decrescente inferior a preço médio")
    void deveMostrarJogosOrdemDecrescenteInferiorPrecoMedio(){
        Jogo jogo1 = jogoService.criarJogo("God of War", toBigDecimal(200.00));
        Jogo jogo2 = jogoService.criarJogo("Fifa 23", toBigDecimal(500.00));
        Jogo jogo3 = jogoService.criarJogo("Call of Duty", toBigDecimal(1000.00));

        List<String> nomes = jogoService.mostrarJogosOrdemDecrescenteInferiorPrecoMedio(Arrays.asList(jogo1, jogo2, jogo3));

        assertEquals("God of War", nomes.get(0));
        assertEquals("Fifa 23", nomes.get(1));
        assertEquals(2, nomes.size());
    }

    @Test
    @DisplayName("Deve mostrar jogos em ordem decrescente com o preço maior ou igual quando informar o preço")
    void deveMostrarJogosOrdemDecrescenteMaiorOuIgualPrecoInformado(){
        Jogo jogo1 = jogoService.criarJogo("God of War", toBigDecimal(200.00));
        Jogo jogo2 = jogoService.criarJogo("Fifa 23", toBigDecimal(500.00));
        Jogo jogo3 = jogoService.criarJogo("Call of Duty", toBigDecimal(1000.00));

        List<String> nomes = jogoService.mostrarJogosOrdemDecrescenteComPrecoMaiorOuIgualInformado(Arrays.asList(jogo1, jogo2, jogo3), toBigDecimal(450.00));

        assertEquals("Fifa 23", nomes.get(0));
        assertEquals("Call of Duty", nomes.get(1));
        assertEquals(2, nomes.size());
    }

    @Test
    @DisplayName("Deve calcular soma total com a letra informada")
    void deveCalcularSomaTotalComLetraInformada(){
        Jogo jogo1 = jogoService.criarJogo("God of War", toBigDecimal(200.00));
        Jogo jogo2 = jogoService.criarJogo("Fifa 23", toBigDecimal(500.00));
        Jogo jogo3 = jogoService.criarJogo("Call of Duty", toBigDecimal(1000.00));

        BigDecimal resultado = jogoService.calcularSomaTotalComLetraInformada(Arrays.asList(jogo1, jogo2, jogo3), 'F');

        assertEquals(toBigDecimal(500.00), resultado);
    }
}
