package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidarConta.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public abstract class ContaBancaria implements Serializable {

    @Serial
    private static final long serialVersionUID = -8501676006915527338L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private UUID id;

    @Getter
    private BigDecimal saldo = BigDecimal.ZERO;

    public void depositar(BigDecimal saldo){
        validarSaldoInformado(saldo, "É necessário informar o valor para depositar");
        validarSaldoNegativoOuZerado(saldo, "Não é possível depositar com o valor zerado ou negativo");
        this.saldo = somar(this.saldo, saldo);
    }

    public void sacar(BigDecimal saldo){
        validarSaldoInformado(saldo, "É necessário informar o valor para sacar");
        validarSaldoNegativoOuZerado(saldo, "Não é possível sacar com o valor zerado ou negativo");
        validarSaldoTotalMenorQueSaldoInformado(this.getSaldo(), saldo, "Não é possível sacar pois o valor final é menor que o valor informado");
        this.saldo = subtrair(this.saldo, saldo);
    }

    public void transferir(BigDecimal saldoParaTransferir, ContaBancaria contaBancariaDestino){
        validarSaldoInformado(saldoParaTransferir, "É necessário informar o valor do saldo para transferir");
        sacar(saldoParaTransferir);
        contaBancariaDestino.depositar(saldoParaTransferir);
    }

    public abstract BigDecimal calcularSaldoFinal();
}
