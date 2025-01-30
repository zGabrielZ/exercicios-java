package br.com.gabrielferreira.pessoas.service;

import br.com.gabrielferreira.commons.service.ArquivoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaServiceTest {

    private PessoaService pessoaService;

    @BeforeEach
    public void criarInstancias(){
        pessoaService = new PessoaService(new ArquivoService());
    }

    @Test
    @DisplayName("Deve validar entrada quando não informar")
    void deveValidarEntrada(){
        try {
            pessoaService.totalUsuarioLog(null);
            fail("Deveria ter lançado a exceção da entrada nula");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar a entrada"));
        }
    }

    @Test
    @DisplayName("Deve validar entrada quando não informar o formato txt")
    void deveValidarEntradaTxt(){
        try {
            pessoaService.totalUsuarioLog("teste.csv");
            fail("Deveria ter lançado a exceção do formato difente de txt");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Somente arquivo txt"));
        }
    }

    @Test
    @DisplayName("Deve ler arquivo quando informar corretamente")
    void deveLerArquivo(){
        Integer quantidade = pessoaService.totalUsuarioLog("nomes-pessoas-test.txt");

        assertEquals(4, quantidade);
    }


}
