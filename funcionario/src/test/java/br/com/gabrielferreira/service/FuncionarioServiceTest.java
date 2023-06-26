package br.com.gabrielferreira.service;
import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class FuncionarioServiceTest {

    private FuncionarioService funcionarioService;

    @BeforeEach
    public void criarInstancias(){
        funcionarioService = new FuncionarioService();
    }

    @Test
    @DisplayName("Deve validar criação do funcionário quando informar o nome nulo")
    void deveValidarCriarFuncionarioNomeNulo(){
        String nome = null;
        BigDecimal salarioBruto = toBigDecimal(1000.00);
        BigDecimal taxa = toBigDecimal(100.00);
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService.criarFuncionario(nome, salarioBruto, taxa));
    }

    @Test
    @DisplayName("Deve validar criação do funcionário quando informar salário bruto nulo")
    void deveValidarCriarFuncionarioSalarioBrutoNulo(){
        String nome = "José da Silva";
        BigDecimal salarioBruto = null;
        BigDecimal taxa = toBigDecimal(100.00);
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService.criarFuncionario(nome, salarioBruto, taxa));
    }

    @Test
    @DisplayName("Deve validar criação do funcionário quando informar salário bruto negativo")
    void deveValidarCriarFuncionarioSalarioBrutoNegativo(){
        String nome = "José da Silva";
        BigDecimal salarioBruto = toBigDecimal(-1);
        BigDecimal taxa = toBigDecimal(100.00);
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService.criarFuncionario(nome, salarioBruto, taxa));
    }

    @Test
    @DisplayName("Deve validar criação do funcionário quando informar taxa nulo")
    void deveValidarCriarFuncionarioTaxaNulo(){
        String nome = "José da Silva";
        BigDecimal salarioBruto = toBigDecimal(5000.00);
        BigDecimal taxa = null;
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService.criarFuncionario(nome, salarioBruto, taxa));
    }

    @Test
    @DisplayName("Deve validar criação do funcionário quando informar taxa negativo")
    void deveValidarCriarFuncionarioTaxaNegativo(){
        String nome = "José da Silva";
        BigDecimal salarioBruto = toBigDecimal(5000.00);
        BigDecimal taxa = toBigDecimal(-100.00);
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService.criarFuncionario(nome, salarioBruto, taxa));
    }

    @Test
    @DisplayName("Deve validar criação do funcionário quando informar taxa maior que salário bruto")
    void deveValidarCriarFuncionarioTaxaMaiorQueSalarioBruto(){
        String nome = "José da Silva";
        BigDecimal salarioBruto = toBigDecimal(5000.00);
        BigDecimal taxa = toBigDecimal(5500.00);
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService.criarFuncionario(nome, salarioBruto, taxa));
    }

    @Test
    @DisplayName("Deve realizar a criação do funcionário quando informar os valores corretamentes")
    void deveCriarFuncionario(){
        Funcionario funcionario = funcionarioService.criarFuncionario("José da Silva", toBigDecimal(5000.00), toBigDecimal(1000.00));

        assertNotNull(funcionario.getId());
        assertEquals(toBigDecimal(4000.0), toRetorno(funcionario.getSalarioLiquido(), 1, RoundingMode.HALF_EVEN));
    }

    @Test
    @DisplayName("Deve validar adicionar porcentagem quando informar funcionário nulo")
    void deveValidarFuncionarioAdicionarPorcentagem(){
        Funcionario funcionario = null;
        BigDecimal porcentagem = toBigDecimal(100);
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService.adicionarPorcentagemSalario(funcionario, porcentagem));
    }

    @Test
    @DisplayName("Deve validar adicionar porcentagem quando informar porcentagem nulo")
    void deveValidarFuncionarioAdicionarPorcentagemNulo(){
        Funcionario funcionario = funcionarioService.criarFuncionario("José da Silva", toBigDecimal(5000.00), toBigDecimal(1000.00));
        BigDecimal porcentagem = null;
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService.adicionarPorcentagemSalario(funcionario, porcentagem));
    }

    @Test
    @DisplayName("Deve validar adicionar porcentagem quando informar porcentagem negativa")
    void deveValidarFuncionarioAdicionarPorcentagemNegativa(){
        Funcionario funcionario = funcionarioService.criarFuncionario("José da Silva", toBigDecimal(5000.00), toBigDecimal(1000.00));
        BigDecimal porcentagem = toBigDecimal(-100.00);
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService.adicionarPorcentagemSalario(funcionario, porcentagem));
    }

    @Test
    @DisplayName("Deve realizar a adição de porcentagem no salário do funcionário")
    void deveAdicionarPorcentagemFuncionario(){
        Funcionario funcionario = funcionarioService.criarFuncionario("José da Silva", toBigDecimal(5000.00), toBigDecimal(1000.00));
        BigDecimal porcentagem = toBigDecimal(100.00);

        funcionarioService.adicionarPorcentagemSalario(funcionario, porcentagem);

        assertEquals(toBigDecimal(9000.0), toRetorno(funcionario.getSalarioLiquido(), 1, RoundingMode.HALF_EVEN));
    }

    @Test
    @DisplayName("Deve imprimir status do funcionário quando informar valores correto")
    void deveImprmirStatusFuncionario(){
        Funcionario funcionario = funcionarioService.criarFuncionario("José da Silva", toBigDecimal(5000.00), toBigDecimal(1000.00));

        String status = funcionarioService.imprimirFuncionario(funcionario);

        assertNotNull(status);
    }
}
