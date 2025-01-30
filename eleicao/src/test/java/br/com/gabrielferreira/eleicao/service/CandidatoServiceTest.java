package br.com.gabrielferreira.eleicao.service;

import br.com.gabrielferreira.commons.service.ArquivoService;
import br.com.gabrielferreira.eleicao.model.Candidato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CandidatoServiceTest {

    private CandidatoService candidatoService;

    @BeforeEach
    public void criarInstancias(){
        candidatoService = new CandidatoService(new ArquivoService());
    }

    @Test
    @DisplayName("Deve validar entrada quando não informar")
    void deveValidarEntrada(){
        try {
            candidatoService.imprimirCandidatos(null);
            fail("Deveria ter lançado a exceção da entrada nula");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar a entrada"));
        }
    }

    @Test
    @DisplayName("Deve validar entrada quando não informar o formato csv")
    void deveValidarEntradaCsv(){
        try {
            candidatoService.imprimirCandidatos("teste.txt");
            fail("Deveria ter lançado a exceção do formato difente de csv");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Somente arquivo csv"));
        }
    }

    @Test
    @DisplayName("Deve ler dados do candidatos")
    void deveLerDadosCandidatos(){
        List<Candidato> candidatos = candidatoService.imprimirCandidatos("candidatos-test.csv");

        assertEquals(76, candidatos.get(0).getQuantidadeVotos());
        assertEquals(71, candidatos.get(1).getQuantidadeVotos());
        assertEquals(61, candidatos.get(2).getQuantidadeVotos());
    }
}
