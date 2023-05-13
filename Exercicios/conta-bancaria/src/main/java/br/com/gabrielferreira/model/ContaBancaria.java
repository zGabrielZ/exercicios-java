package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.SaldoInsuficienteException;
import br.com.gabrielferreira.exception.ValorInvalidoException;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

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
        if(saldo == null){
            throw new ValorInvalidoException("É necessário informar o valor para depositar");
        }

        if(saldo.compareTo(BigDecimal.ZERO) <= 0){
            throw new ValorInvalidoException("Não é possível depositar com o valor zerado ou negativo");
        }

        this.saldo = this.saldo.add(saldo);
    }

    public void sacar(BigDecimal saldo){
        if(saldo == null){
            throw new ValorInvalidoException("É necessário informar o valor para sacar");
        }

        if(saldo.compareTo(BigDecimal.ZERO) <= 0){
            throw new ValorInvalidoException("Não é possível sacar com o valor zerado ou negativo");
        }

        if(saldo.compareTo(this.getSaldo()) > 0){
            throw new SaldoInsuficienteException("Não é possível sacar pois o valor final é menor que o valor informado");
        }

        this.saldo = this.saldo.subtract(saldo);
    }

    public void transferir(BigDecimal saldoParaTransferir, ContaBancaria contaBancariaDestino){
        if(saldoParaTransferir == null){
            throw new ValorInvalidoException("É necessário informar o valor do saldo para transferir");
        }

        sacar(saldoParaTransferir);
        contaBancariaDestino.depositar(saldoParaTransferir);
    }

    public abstract BigDecimal calcularSaldoFinal();
}
