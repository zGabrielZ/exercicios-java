package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.ContaPessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static br.com.gabrielferreira.utils.CalculoUtils.*;

import static org.junit.jupiter.api.Assertions.*;

class ContaPessoaServiceTest {

    private ContaPessoaService contaPessoaService;

    @BeforeEach
    public void criarInstancias(){
        contaPessoaService = new ContaPessoaService();
    }

    @Test
    @DisplayName("Deve validar conta pessoa quando informar número nulo")
    void deveValidarContaPessoaNumeroNulo(){
        Integer numero = null;
        String nome = "José";
        BigDecimal deposito = toBigDecimal(10.0);
        assertThrows(RegraDeNegocioException.class, () -> contaPessoaService.criarContaPessoa(numero, nome, deposito));
    }

    @Test
    @DisplayName("Deve validar conta pessoa quando informar número negativo")
    void deveValidarContaPessoaNumeroNegativo(){
        Integer numero = -10;
        String nome = "José";
        BigDecimal deposito = toBigDecimal(10.0);
        assertThrows(RegraDeNegocioException.class, () -> contaPessoaService.criarContaPessoa(numero, nome, deposito));
    }

    @Test
    @DisplayName("Deve validar conta pessoa quando informar nome nulo")
    void deveValidarContaPessoaNomeNulo(){
        Integer numero = 10;
        String nome = null;
        BigDecimal deposito = toBigDecimal(10.0);
        assertThrows(RegraDeNegocioException.class, () -> contaPessoaService.criarContaPessoa(numero, nome, deposito));
    }

    @Test
    @DisplayName("Deve validar conta pessoa quando informar depósito nulo")
    void deveValidarContaPessoaDepositoNulo(){
        Integer numero = 12;
        String nome = "José";
        BigDecimal deposito = null;
        assertThrows(RegraDeNegocioException.class, () -> contaPessoaService.criarContaPessoa(numero, nome, deposito));
    }

    @Test
    @DisplayName("Deve validar conta pessoa quando informar depósito negativo")
    void deveValidarContaPessoaDepositoNegativo(){
        Integer numero = 12;
        String nome = "José";
        BigDecimal deposito = toBigDecimal(-10);
        assertThrows(RegraDeNegocioException.class, () -> contaPessoaService.criarContaPessoa(numero, nome, deposito));
    }

    @Test
    @DisplayName("Deve criar conta pessoa quando informar valores corretamente")
    void deveCriarContaPessoa(){
        ContaPessoa contaPessoa = contaPessoaService.criarContaPessoa(10, "José da Silva", toBigDecimal(10.0));

        assertNotNull(contaPessoa.getId());
    }

    @Test
    @DisplayName("Deve validar imprimir conta pessoa quando não informar nada")
    void deveValidarImprimirContaPessoa(){
        ContaPessoa contaPessoa = null;
        assertThrows(RegraDeNegocioException.class, () -> contaPessoaService.imprimirContaPessoa(contaPessoa));
    }

    @Test
    @DisplayName("Deve imprimir conta pessoa quando informar valores corretamente")
    void deveImprimirContaPessoa(){
        ContaPessoa contaPessoa = contaPessoaService.criarContaPessoa(10, "José da Silva", toBigDecimal(10.0));

        String status = contaPessoaService.imprimirContaPessoa(contaPessoa);

        assertNotNull(status);
    }

    @Test
    @DisplayName("Deve depositar conta pessoa quando informar valores corretamente")
    void deveDepositarContaPessoa(){
        ContaPessoa contaPessoa = contaPessoaService.criarContaPessoa(10, "José da Silva", toBigDecimal(10.0));

        contaPessoaService.depositarContaPessoa(contaPessoa, toBigDecimal(20.0));

        assertEquals(toBigDecimal(30.0), toRetorno(contaPessoa.getSaldo(), 1, RoundingMode.HALF_EVEN));
    }

    @Test
    @DisplayName("Deve validar saque conta pessoa quando informar depósito maior que o saldo existente")
    void deveValidarSaqueContaPessoa(){
        ContaPessoa contaPessoa = contaPessoaService.criarContaPessoa(10, "José da Silva", toBigDecimal(10.0));
        BigDecimal novoDeposito = toBigDecimal(30.0);

        assertThrows(RegraDeNegocioException.class, () ->  contaPessoaService.sacarContaPessoa(contaPessoa, novoDeposito));
    }

    @Test
    @DisplayName("Deve sacar conta pessoa quando informar valores corretamente")
    void deveSacarContaPessoa(){
        ContaPessoa contaPessoa = contaPessoaService.criarContaPessoa(10, "José da Silva", toBigDecimal(10.0));

        contaPessoaService.sacarContaPessoa(contaPessoa, toBigDecimal(3.0));

        assertEquals(toBigDecimal(2.0), toRetorno(contaPessoa.getSaldo(), 1, RoundingMode.HALF_EVEN));
    }
}
