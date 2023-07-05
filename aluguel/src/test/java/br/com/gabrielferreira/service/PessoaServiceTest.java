package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Pessoa;
import br.com.gabrielferreira.model.dto.QuartosReservadosDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PessoaServiceTest {

    private PessoaService pessoaService;

    @BeforeEach
    public void criarInstancias(){
        pessoaService = new PessoaService();
    }

    @Test
    @DisplayName("Deve validar criação da pessoa quando informar o nome nulo")
    void deveValidarCriarPessoaNomeNulo(){
        String nome = null;
        String email = "jose@gmail.com";
        Integer numeroQuarto = 5;
        List<QuartosReservadosDTO> quartosReservadosDTOS = new ArrayList<>();
        Integer numeroPessoa = 1;
        assertThrows(RegraDeNegocioException.class, () -> pessoaService.criarPessoa(nome, email, numeroQuarto, quartosReservadosDTOS, numeroPessoa));
    }

    @Test
    @DisplayName("Deve validar criação da pessoa quando informar o email nulo")
    void deveValidarCriarPessoaEmailNulo(){
        String nome = "José da Silva";
        String email = null;
        Integer numeroQuarto = 5;
        List<QuartosReservadosDTO> quartosReservadosDTOS = new ArrayList<>();
        Integer numeroPessoa = 1;
        assertThrows(RegraDeNegocioException.class, () -> pessoaService.criarPessoa(nome, email, numeroQuarto, quartosReservadosDTOS, numeroPessoa));
    }

    @ParameterizedTest
    @ValueSource(strings = {"jose", "@email", "@email.com", "jose-email.com"})
    @DisplayName("Deve validar criação da pessoa quando informar o email inválido")
    void deveValidarCriarPessoaEmailInvalido(String email){
        String nome = "José da Silva";
        Integer numeroQuarto = 5;
        List<QuartosReservadosDTO> quartosReservadosDTOS = new ArrayList<>();
        Integer numeroPessoa = 1;
        assertThrows(RegraDeNegocioException.class, () -> pessoaService.criarPessoa(nome, email, numeroQuarto, quartosReservadosDTOS, numeroPessoa));
    }

    @Test
    @DisplayName("Deve validar criação da pessoa quando informar o número quarto nulo")
    void deveValidarCriarPessoaNumeroQuartoNulo(){
        String nome = "José da Silva";
        String email = "jose@gmail.com";
        Integer numeroQuarto = null;
        List<QuartosReservadosDTO> quartosReservadosDTOS = new ArrayList<>();
        Integer numeroPessoa = 1;
        assertThrows(RegraDeNegocioException.class, () -> pessoaService.criarPessoa(nome, email, numeroQuarto, quartosReservadosDTOS, numeroPessoa));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, 10, -3, 11})
    @DisplayName("Deve validar criação da pessoa quando informar o número quarto fora do período")
    void deveValidarCriarPessoaNumeroQuartoForaPeriodo(int numeroQuarto){
        String nome = "José da Silva";
        String email = "jose@gmail.com";
        List<QuartosReservadosDTO> quartosReservadosDTOS = new ArrayList<>();
        Integer numeroPessoa = 1;
        assertThrows(RegraDeNegocioException.class, () -> pessoaService.criarPessoa(nome, email, numeroQuarto, quartosReservadosDTOS, numeroPessoa));
    }

    @Test
    @DisplayName("Deve validar criação da pessoa quando informar o número quarto já reservado")
    void deveValidarCriarPessoaNumeroQuartoJaReservado(){
        String nome = "José da Silva";
        String email = "jose@gmail.com";
        Integer numeroQuarto = 5;
        List<QuartosReservadosDTO> quartosReservadosDTOS = new ArrayList<>();
        quartosReservadosDTOS.add(QuartosReservadosDTO.builder().numeroPessoa(2).quartoReservado(5).build());
        Integer numeroPessoa = 1;
        assertThrows(RegraDeNegocioException.class, () -> pessoaService.criarPessoa(nome, email, numeroQuarto, quartosReservadosDTOS, numeroPessoa));
    }

    @Test
    @DisplayName("Deve criar pessoa quando informar valores corretos")
    void deveCriarPessoa(){
        Pessoa pessoa = pessoaService.criarPessoa("Gabriel", "gabriel@gmail.com", 1, new ArrayList<>(), 1);

        assertNotNull(pessoa.getId());
        assertEquals("Gabriel", pessoa.getNome());
        assertEquals(1, pessoa.getQuarto().getNumero());
    }

    @Test
    @DisplayName("Deve imprimir pessoas com quartos já reservados")
    void deveImprimirPessoas(){
        Pessoa pessoa1 = pessoaService.criarPessoa("Gabriel", "gabriel@gmail.com", 1, new ArrayList<>(), 1);
        Pessoa pessoa2 = pessoaService.criarPessoa("José", "jose@gmail.com", 2, new ArrayList<>(), 2);
        Pessoa pessoa3 = pessoaService.criarPessoa("Luan", "luan@gmail.com", 3, new ArrayList<>(), 3);

        String imprimir = pessoaService.imprimirPessoas(pessoa1, pessoa2, pessoa3);

        assertNotNull(imprimir);
    }
}
