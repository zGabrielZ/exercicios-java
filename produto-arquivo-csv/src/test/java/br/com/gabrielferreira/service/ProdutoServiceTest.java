package br.com.gabrielferreira.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {

    private static final String NOME_ARQUIVO = "sumario-resultado-teste.csv";
    private static final String CAMINHO_COMPLETO = System.getProperty("user.home") + "/Downloads/" + NOME_ARQUIVO;

    private ProdutoService produtoService;

    @BeforeEach
    public void criarInstancias(){
        produtoService = new ProdutoService(new ArquivoService());
    }

    @Test
    @DisplayName("Deve validar entrada quando não informar")
    void deveValidarEntrada(){
        try {
            produtoService.gerarArquivoCsv(null, "sumario-resultado-test.csv");
            fail("Deveria ter lançado a exceção da entrada nula");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar a entrada"));
        }
    }

    @Test
    @DisplayName("Deve validar entrada quando não informar o formato csv")
    void deveValidarEntradaCsv(){
        try {
            produtoService.gerarArquivoCsv("teste.txt", "sumario-resultado-test.csv");
            fail("Deveria ter lançado a exceção do formato difente de csv");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Somente arquivo csv"));
        }
    }

    @Test
    @DisplayName("Deve gerar arquivo quando informar valores corretamente")
    void deveGerarArquivo(){
        produtoService.gerarArquivoCsv("D:\\CSV\\sumario.csv", NOME_ARQUIVO);

        File file = new File(CAMINHO_COMPLETO);
        assertTrue(file.exists());

        file.delete();
    }
}
