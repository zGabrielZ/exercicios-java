package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Funcionario;
import br.com.gabrielferreira.model.dto.NumeroFuncionarioCadastradoDTO;
import br.com.gabrielferreira.utils.NumeroFuncionarioComparator;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static br.com.gabrielferreira.utils.MascarasUtils.*;

public class FuncionarioService implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    private static final BigDecimal PORCENTAGEM = toBigDecimal(100);

    public Funcionario criarFuncionario(Integer numeroFuncionarioIdentificador, String nome, BigDecimal salario, List<NumeroFuncionarioCadastradoDTO> numeroFuncionariosJaCadastrado
            , Integer numeroFuncionario){
        validarNumeroFuncionario(numeroFuncionarioIdentificador);
        validarNumeroFuncionarioCadastrados(numeroFuncionarioIdentificador, numeroFuncionariosJaCadastrado, numeroFuncionario);

        validarNome(nome);
        validarValor(salario, "É necessário informar o salário", "Salário não pode ser negativo");

        return Funcionario.builder()
                .id(UUID.randomUUID())
                .numeroFuncionarioIdentificador(numeroFuncionarioIdentificador)
                .nome(nome)
                .salario(salario)
                .build();
    }

    public void adicionarPorcentagemSalario(List<Funcionario> funcionarios, Integer numeroFuncionarioIdentificador, BigDecimal porcentagemInformado){
        if(funcionarios != null && !funcionarios.isEmpty()){
            validarNumeroFuncionario(numeroFuncionarioIdentificador);
            Funcionario funcionarioEncontrado = funcionarios.stream()
                    .filter(funcionario -> funcionario.getNumeroFuncionarioIdentificador().equals(numeroFuncionarioIdentificador))
                    .findFirst().orElseThrow(() -> new RegraDeNegocioException("Funcionário não encontrado com este número informado : " + numeroFuncionarioIdentificador));

            validarValor(porcentagemInformado, "É necessário informar a porcentagem", "Porcentagem não pode ser negativo");
            BigDecimal valorPorcentagem = divide(porcentagemInformado, PORCENTAGEM, RoundingMode.HALF_EVEN);
            BigDecimal aumentoSalario = multiplicar(funcionarioEncontrado.getSalario(), valorPorcentagem);
            funcionarioEncontrado.setSalario(somar(funcionarioEncontrado.getSalario(), aumentoSalario));
        }
    }

    public String imprimirFuncionarios(List<Funcionario> funcionarios){
        if(funcionarios != null && !funcionarios.isEmpty()){
            funcionarios.sort(new NumeroFuncionarioComparator());

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("Lista de funcionários : ").append("\n");
            funcionarios.forEach(funcionario -> stringBuilder.append(funcionario.getNumeroFuncionarioIdentificador())
                    .append(", ")
                    .append(funcionario.getNome())
                    .append(", ")
                    .append(valorMonetarioBrasil(funcionario.getSalario()))
                    .append("\n"));

            return stringBuilder.toString();
        }
        return null;
    }

    private void validarNumeroFuncionario(Integer numeroFuncionarioIdentificador){
        if(numeroFuncionarioIdentificador == null){
            throw new RegraDeNegocioException("É necessário informar o número do funcionário");
        }

        if(numeroFuncionarioIdentificador < 0){
            throw new RegraDeNegocioException("Número do funcionário não pode ser negativo");
        }
    }

    private void validarNumeroFuncionarioCadastrados(Integer numeroFuncionarioIdentificador ,List<NumeroFuncionarioCadastradoDTO> numeroFuncionarioCadastradoDTOS, Integer numeroFuncionario){
        for (NumeroFuncionarioCadastradoDTO numeroFuncionarioCadastrado : numeroFuncionarioCadastradoDTOS) {
            if(!numeroFuncionarioCadastrado.getNumeroFuncionario().equals(numeroFuncionario)
                    && numeroFuncionarioCadastrado.getNumeroFuncionarioIdentificador().equals(numeroFuncionarioIdentificador)){
                throw new RegraDeNegocioException(String.format("Este número do funcionário %s já foi cadastrado", numeroFuncionarioIdentificador));
            }
        }
    }

    private void validarNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o nome");
        }
    }

    private void validarValor(BigDecimal valor, String msg1, String msg2){
        if(valor == null){
            throw new RegraDeNegocioException(msg1);
        }

        if(valor.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException(msg2);
        }
    }
}
