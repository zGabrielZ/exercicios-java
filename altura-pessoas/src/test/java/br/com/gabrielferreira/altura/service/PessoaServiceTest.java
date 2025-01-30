package br.com.gabrielferreira.altura.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.altura.model.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PessoaServiceTest {

    private PessoaService pessoaService;

    @BeforeEach
    public void criarInstancias(){
        pessoaService = new PessoaService();
    }

    @Test
    @DisplayName("Deve validar criação da pessoa quando informar a altura nulo")
    void deveValidarCriarPessoaAlturaNula(){
        Double altura = null;
        assertThrows(RegraDeNegocioException.class, () -> pessoaService.criarPessoa(altura));
    }

    @Test
    @DisplayName("Deve validar criação da pessoa quando informar a altura negativa")
    void deveValidarCriarPessoaAlturaNegativa(){
        Double altura = -1.9;
        assertThrows(RegraDeNegocioException.class, () -> pessoaService.criarPessoa(altura));
    }

    @Test
    @DisplayName("Deve criar pessoa quando informar valores corretos")
    void deveCriarPessoa(){
        Pessoa pessoa = pessoaService.criarPessoa(1.70);

        assertNotNull(pessoa.getId());
        assertEquals(1.70, pessoa.getAltura());
    }

    @Test
    @DisplayName("Deve validar calculo média de alturas quando informar nulo")
    void deveValidarCalculoMediaAlturasPessoasQuandoInformarNulo(){
        Pessoa[] pessoas = new Pessoa[2];
        pessoas[0] = new Pessoa(UUID.randomUUID(), 1.6);
        pessoas[1] = null;
        assertThrows(RegraDeNegocioException.class, () -> pessoaService.calcularMediaAlturaPessoas(pessoas));
    }

    @Test
    @DisplayName("Deve realizar calculo média de alturas quando informar valores corretamentes")
    void deveRealizarCalculoMediaAlturasPessoas(){
        Pessoa[] pessoas = new Pessoa[2];
        pessoas[0] = new Pessoa(UUID.randomUUID(), 1.6);
        pessoas[1] = new Pessoa(UUID.randomUUID(), 1.7);

        Double media = pessoaService.calcularMediaAlturaPessoas(pessoas);

        assertEquals(1.65, media);
    }
}
