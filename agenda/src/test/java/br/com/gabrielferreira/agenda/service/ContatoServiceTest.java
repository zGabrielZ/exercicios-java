package br.com.gabrielferreira.agenda.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.agenda.model.Contato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContatoServiceTest {

    private ContatoService contatoService;

    @BeforeEach
    public void criarInstancias(){
        contatoService = new ContatoService();
    }

    @Test
    @DisplayName("Deve validar nome quando não informar")
    void deveValidarNome(){
        String nome = getStringNula();
        String telefone = "12332111";
        assertThrows(RegraDeNegocioException.class, () -> contatoService.criarContato(nome, telefone));
    }

    @Test
    @DisplayName("Deve validar telefone quando não informar")
    void deveValidarTelefone(){
        String nome = getStringNaoNula();
        String telefone = getStringNula();
        assertThrows(RegraDeNegocioException.class, () -> contatoService.criarContato(nome, telefone));
    }

    @Test
    @DisplayName("Deve validar comprimento do telefone quando informar incorreto")
    void deveValidarTelefoneComprimentoIncorreto(){
        String nome = getStringNaoNula();
        String telefone = "111001010101010101";
        assertThrows(RegraDeNegocioException.class, () -> contatoService.criarContato(nome, telefone));
    }

    @Test
    @DisplayName("Deve validar telefone somente digitos")
    void deveValidarTelefoneSomenteDigitos(){
        String nome = getStringNaoNula();
        String telefone = "111aaa11";
        assertThrows(RegraDeNegocioException.class, () -> contatoService.criarContato(nome, telefone));
    }

    @Test
    @DisplayName("Deve validar nome já cadastrado")
    void deveValidarNomeCadastrado(){
        contatoService.criarContato(getStringNaoNula(), "11122233");

        String nome = getStringNaoNula();
        String telefone = "22233312";
        assertThrows(RegraDeNegocioException.class, () -> contatoService.criarContato(nome, telefone));
    }

    @Test
    @DisplayName("Deve criar contato quando informar valores corretos")
    void deveCriarContato(){
        contatoService.criarContato(getStringNaoNula(), "11122233");

        assertEquals("José da Silva", contatoService.getContatos().get(0).getNome());
    }

    @Test
    @DisplayName("Deve alterar contato quando informar nome")
    void deveAlterarContato(){
        contatoService.criarContato(getStringNaoNula(), "11122233");

        contatoService.alterarContato(getStringNaoNula(), "33333333");

        assertEquals("33333333", contatoService.getContatos().get(0).getTelefone());
    }

    @Test
    @DisplayName("Deve excluir contato quando informar nome")
    void deveExcluirContato(){
        contatoService.criarContato(getStringNaoNula(), "11122233");

        contatoService.excluirContato(getStringNaoNula());

        assertTrue(contatoService.getContatos().isEmpty());
    }

    @Test
    @DisplayName("Deve buscar contato quando informar a letra")
    void deveBuscarContatoPorLetra(){
        contatoService.criarContato(getStringNaoNula(), "11122233");

        List<Contato> contatos = contatoService.buscarContatosPorLetra('J');

        assertFalse(contatos.isEmpty());
        assertEquals("José da Silva", contatos.get(0).getNome());
        assertEquals("11122233", contatos.get(0).getTelefone());
    }

    private String getStringNula(){
        return null;
    }

    private String getStringNaoNula(){
        return "José da Silva";
    }
}
