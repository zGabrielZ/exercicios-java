package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.ErroInesperadoException;
import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.DataUtils.*;

class ClienteServiceTest {

    private ClienteService clienteService;

    @BeforeEach
    public void criarInstancias(){
        clienteService = new ClienteService();
    }

    @Test
    @DisplayName("Deve validar cliente quando não informar nome")
    void deveValidarNomeCliente(){
        String nome = getStringNula();
        String email = "jose@email.com";
        String dataNascimento = "10/02/1995";
        assertThrows(RegraDeNegocioException.class, () -> clienteService.criarCliente(nome, email, dataNascimento));
    }

    @Test
    @DisplayName("Deve validar cliente quando não informar email")
    void deveValidarEmailCliente(){
        String nome = getStringNaoNula();
        String email = getStringNula();
        String dataNascimento = "10/02/1995";
        assertThrows(RegraDeNegocioException.class, () -> clienteService.criarCliente(nome, email, dataNascimento));
    }

    @ParameterizedTest
    @ValueSource(strings = {"jose.com", "jose.br", "jose"})
    @DisplayName("Deve validar cliente quando email for inválido")
    void deveValidarEmailInvalidoCliente(String email){
        String nome = getStringNaoNula();
        String dataNascimento = "10/02/1995";
        assertThrows(RegraDeNegocioException.class, () -> clienteService.criarCliente(nome, email, dataNascimento));
    }

    @Test
    @DisplayName("Deve validar cliente quando não informar data nascimento")
    void deveValidarDataNascimentoCliente(){
        String nome = getStringNaoNula();
        String email = "jose@email.com";
        String dataNascimento = getStringNula();
        assertThrows(RegraDeNegocioException.class, () -> clienteService.criarCliente(nome, email, dataNascimento));
    }

    @Test
    @DisplayName("Deve validar cliente quando data nascimento estiver formato incorreto")
    void deveValidarDataNascimentoFormatoErradoCliente(){
        String nome = getStringNaoNula();
        String email = "jose@email.com";
        String dataNascimento = "10";
        assertThrows(ErroInesperadoException.class, () -> clienteService.criarCliente(nome, email, dataNascimento));
    }

    @Test
    @DisplayName("Deve validar cliente quando data nascimento for maior que data atual")
    void deveValidarDataNascimentoMaiorDataAtualCliente(){
        String nome = getStringNaoNula();
        String email = "jose@email.com";
        String dataNascimento = toDataBrasil(LocalDate.now().plusDays(5L));
        assertThrows(RegraDeNegocioException.class, () -> clienteService.criarCliente(nome, email, dataNascimento));
    }

    @Test
    @DisplayName("Deve criar cliente quando informar valores corretamente")
    void deveCriarCliente(){
        Cliente cliente = clienteService.criarCliente("José", "jose@email.com", "10/02/1994");

        assertNotNull(cliente.getId());
        assertEquals("José", cliente.getNome());
        assertEquals("jose@email.com", cliente.getEmail());
        assertEquals(toDataBrasil("10/02/1994"), cliente.getDataNascimento());
    }

    private String getStringNula(){
        return null;
    }

    private String getStringNaoNula(){
        return "teste teste";
    }

}
