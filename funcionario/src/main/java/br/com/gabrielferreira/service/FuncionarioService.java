package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Funcionario;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static br.com.gabrielferreira.utils.MascarasUtils.*;

public class FuncionarioService implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    public Funcionario criarFuncionario(String nome, BigDecimal salarioBruto, BigDecimal taxa){
        validarNome(nome);
        validarValorInformado(salarioBruto, "Salário Bruto");
        validarValorInformado(taxa, "Taxa");
        validarTaxaComSalarioBruto(salarioBruto, taxa);

        return Funcionario.builder()
                .id(UUID.randomUUID())
                .nome(nome)
                .salarioBruto(salarioBruto)
                .taxa(taxa)
                .salarioLiquido(subtrair(salarioBruto, taxa))
                .build();
    }

    public void adicionarPorcentagemSalario(Funcionario funcionario, BigDecimal porcentagem){
        verificarFuncionario(funcionario);
        validarPorcentagem(porcentagem);

        BigDecimal porcentagemCalculada = divide(porcentagem, toBigDecimal(100));
        funcionario.setSalarioLiquido(somar(funcionario.getSalarioLiquido(), multiplicar(funcionario.getSalarioBruto(), porcentagemCalculada)));
    }

    public String imprimirFuncionario(Funcionario funcionario){
        verificarFuncionario(funcionario);

        return "Nome do funcionário : " +
                funcionario.getNome() +
                ", " + valorMonetarioBrasil(funcionario.getSalarioLiquido());
    }

    private void validarNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o nome");
        }
    }

    private void validarValorInformado(BigDecimal valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(String.format("É necessário informar %s", msg));
        }

        if(valor.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException(String.format("%s não pode ser negativo", msg));
        }
    }

    private void validarTaxaComSalarioBruto(BigDecimal salarioBruto, BigDecimal taxa){
        if(salarioBruto.compareTo(taxa) < 0){
            throw new RegraDeNegocioException("Salário bruto não pode ser menor que a taxa");
        }
    }

    private void verificarFuncionario(Funcionario funcionario){
        if(funcionario == null){
            throw new RegraDeNegocioException("É necessário informar funcionário");
        }
    }

    private void validarPorcentagem(BigDecimal porcentagem){
        if(porcentagem == null){
            throw new RegraDeNegocioException("É necessário informar a porcentagem");
        }

        if(porcentagem.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException("A porcentagem não pode ser negativa");
        }
    }
}
