package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Generated
@ToString
public abstract class ContaBancaria implements Serializable {

    @Serial
    private static final long serialVersionUID = -8501676006915527338L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Double saldo = 0.0;

    public void depositar(Double saldo){
        if(saldo == null){
            throw new RegraDeNegocioException("É necessário informar o valor para depositar");
        }

        if(saldo <= 0){
            throw new RegraDeNegocioException("Não é possível depositar com o valor zerado ou negativo");
        }

        this.saldo += saldo;
    }

    public void sacar(Double saldo){
        if(saldo == null){
            throw new RegraDeNegocioException("É necessário informar o valor para sacar");
        }

        if(saldo <= 0){
            throw new RegraDeNegocioException("Não é possível sacar com o valor zerado ou negativo");
        }

        if(saldo > this.getSaldo()){
            throw new RegraDeNegocioException("Não é possível sacar pois o valor final é menor que o valor informado");
        }

        this.saldo -= saldo;
    }

    public void transferir(Double saldoParaTransferir, ContaBancaria contaBancariaDestino){
        if(saldoParaTransferir == null){
            throw new RegraDeNegocioException("É necessário informar o valor do saldo para transferir");
        }

        sacar(saldoParaTransferir);
        contaBancariaDestino.depositar(saldoParaTransferir);
    }

    public abstract Double calcularSaldoFinal();
}
