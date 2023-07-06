package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Funcionario;
import br.com.gabrielferreira.model.dto.NumeroFuncionarioCadastradoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class FuncionarioServiceTest {

    private FuncionarioService funcionarioService;

    @BeforeEach
    public void criarInstancias(){
        funcionarioService = new FuncionarioService();
    }

    @Test
    @DisplayName("Deve validar criação do funcionário quando informar o número do funcionário for nulo")
    void deveValidarCriarFuncionarioNumeroFuncionarioIdentificadorNulo(){
        Integer numeroFuncionarioIdentificador = null;
        String nome = "José";
        BigDecimal salario = toBigDecimal(100.00);
        List<NumeroFuncionarioCadastradoDTO> cadastros = new ArrayList<>();
        cadastros.add(NumeroFuncionarioCadastradoDTO.builder().numeroFuncionarioIdentificador(111).numeroFuncionario(1).build());
        Integer numeroFuncionario = 2;
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService
                .criarFuncionario(numeroFuncionarioIdentificador, nome, salario, cadastros, numeroFuncionario));
    }

    @Test
    @DisplayName("Deve validar criação do funcionário quando informar o número do funcionário for negativo")
    void deveValidarCriarFuncionarioNumeroFuncionarioIdentificadorNegativo(){
        Integer numeroFuncionarioIdentificador = -1;
        String nome = "José";
        BigDecimal salario = toBigDecimal(100.00);
        List<NumeroFuncionarioCadastradoDTO> cadastros = new ArrayList<>();
        cadastros.add(NumeroFuncionarioCadastradoDTO.builder().numeroFuncionarioIdentificador(111).numeroFuncionario(1).build());
        Integer numeroFuncionario = 2;
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService
                .criarFuncionario(numeroFuncionarioIdentificador, nome, salario, cadastros, numeroFuncionario));
    }

    @Test
    @DisplayName("Deve validar criação do funcionário quando informar o número do funcionário já cadastrado")
    void deveValidarCriarFuncionarioNumeroFuncionarioIdentificadorCadastrado(){
        Integer numeroFuncionarioIdentificador = 100;
        String nome = "José";
        BigDecimal salario = toBigDecimal(100.00);
        List<NumeroFuncionarioCadastradoDTO> cadastros = new ArrayList<>();
        cadastros.add(NumeroFuncionarioCadastradoDTO.builder().numeroFuncionarioIdentificador(100).numeroFuncionario(1).build());
        Integer numeroFuncionario = 2;
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService
                .criarFuncionario(numeroFuncionarioIdentificador, nome, salario, cadastros, numeroFuncionario));
    }

    @Test
    @DisplayName("Deve validar criação do funcionário quando informar o nome nulo")
    void deveValidarCriarFuncionarioNomeNulo(){
        Integer numeroFuncionarioIdentificador = 200;
        String nome = null;
        BigDecimal salario = toBigDecimal(100.00);
        List<NumeroFuncionarioCadastradoDTO> cadastros = new ArrayList<>();
        cadastros.add(NumeroFuncionarioCadastradoDTO.builder().numeroFuncionarioIdentificador(100).numeroFuncionario(1).build());
        Integer numeroFuncionario = 2;
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService
                .criarFuncionario(numeroFuncionarioIdentificador, nome, salario, cadastros, numeroFuncionario));
    }

    @Test
    @DisplayName("Deve validar criação do funcionário quando informar o salário nulo")
    void deveValidarCriarFuncionarioSalarioNulo(){
        Integer numeroFuncionarioIdentificador = 200;
        String nome = "José";
        BigDecimal salario = null;
        List<NumeroFuncionarioCadastradoDTO> cadastros = new ArrayList<>();
        cadastros.add(NumeroFuncionarioCadastradoDTO.builder().numeroFuncionarioIdentificador(100).numeroFuncionario(1).build());
        Integer numeroFuncionario = 2;
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService
                .criarFuncionario(numeroFuncionarioIdentificador, nome, salario, cadastros, numeroFuncionario));
    }

    @Test
    @DisplayName("Deve validar criação do funcionário quando informar o salário negativo")
    void deveValidarCriarFuncionarioSalarioNegativo(){
        Integer numeroFuncionarioIdentificador = 200;
        String nome = "José";
        BigDecimal salario = toBigDecimal(-200.00);
        List<NumeroFuncionarioCadastradoDTO> cadastros = new ArrayList<>();
        cadastros.add(NumeroFuncionarioCadastradoDTO.builder().numeroFuncionarioIdentificador(100).numeroFuncionario(1).build());
        Integer numeroFuncionario = 2;
        assertThrows(RegraDeNegocioException.class, () -> funcionarioService
                .criarFuncionario(numeroFuncionarioIdentificador, nome, salario, cadastros, numeroFuncionario));
    }

    @Test
    @DisplayName("Deve criar funcionário quando informar valores corretos")
    void deveCriarFuncionario(){
        Integer numeroFuncionarioIdentificador = 200;
        String nome = "José";
        BigDecimal salario = toBigDecimal(200.00);
        List<NumeroFuncionarioCadastradoDTO> cadastros = new ArrayList<>();
        cadastros.add(NumeroFuncionarioCadastradoDTO.builder().numeroFuncionarioIdentificador(100).numeroFuncionario(1).build());
        Integer numeroFuncionario = 2;

        Funcionario funcionario = funcionarioService.criarFuncionario(numeroFuncionarioIdentificador, nome, salario, cadastros, numeroFuncionario);

        assertNotNull(funcionario.getId());
        assertEquals(toBigDecimal(200.00), funcionario.getSalario());
    }

    @Test
    @DisplayName("Deve não encontrar funcionário quando informar o numero do funcionário não cadastrado")
    void deveNaoEncontrarFuncionarioQuandoInformarAdicionalSalario(){
        Funcionario funcionario1 = funcionarioService.criarFuncionario(111, "Gabriel", toBigDecimal(200.00), new ArrayList<>(), 1);
        Funcionario funcionario2 = funcionarioService.criarFuncionario(222, "José", toBigDecimal(300.00), new ArrayList<>(), 2);
        Funcionario funcionario3 = funcionarioService.criarFuncionario(333, "Marcos", toBigDecimal(400.00), new ArrayList<>(), 3);

        List<Funcionario> funcionarios = Arrays.asList(funcionario1, funcionario2, funcionario3);

        Integer numeroFuncionarioIdentificador = 444;
        BigDecimal porcentagemInformado = toBigDecimal(10.0);

        assertThrows(RegraDeNegocioException.class, () -> funcionarioService.adicionarPorcentagemSalario(funcionarios, numeroFuncionarioIdentificador, porcentagemInformado));
    }

    @Test
    @DisplayName("Deve adicionar porcentagem quando encontrar funcionário")
    void deveAdicionarPorcentagemFuncionario(){
        Funcionario funcionario1 = funcionarioService.criarFuncionario(111, "Gabriel", toBigDecimal(200.00), new ArrayList<>(), 1);
        List<Funcionario> funcionarios = List.of(funcionario1);

        funcionarioService.adicionarPorcentagemSalario(funcionarios, 111, toBigDecimal(10.0));

        assertEquals(toBigDecimal(220.0), toRetorno(funcionario1.getSalario(), 1, RoundingMode.HALF_EVEN));
    }

    @Test
    @DisplayName("Deve imprimir funcionários quando informar valores corretamente")
    void deveImprimirFuncionarios(){
        Funcionario funcionario1 = funcionarioService.criarFuncionario(111, "Gabriel", toBigDecimal(200.00), new ArrayList<>(), 1);
        Funcionario funcionario2 = funcionarioService.criarFuncionario(222, "José", toBigDecimal(300.00), new ArrayList<>(), 2);
        Funcionario funcionario3 = funcionarioService.criarFuncionario(333, "Marcos", toBigDecimal(400.00), new ArrayList<>(), 3);

        List<Funcionario> funcionarios = Arrays.asList(funcionario1, funcionario2, funcionario3);

        String imprimir = funcionarioService.imprimirFuncionarios(funcionarios);

        assertNotNull(imprimir);
    }
}
