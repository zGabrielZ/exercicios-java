package br.com.gabrielferreira.funcionario.model;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;
import static br.com.gabrielferreira.commons.utils.MascarasUtils.valorMonetarioBrasil;
import static br.com.gabrielferreira.funcionario.validate.ValidarCampos.*;

@EqualsAndHashCode(callSuper = true)
public class FuncionarioTerceirizado extends Funcionario {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    private static final BigDecimal VALOR_BONUS = toBigDecimal(1.1);

    @Getter
    private final BigDecimal bonus;

    public FuncionarioTerceirizado(UUID id, String nome, Integer horas, BigDecimal valorPorHora, BigDecimal bonus){
        super(id, nome, horas, valorPorHora);
        this.bonus = bonus;

        validarId(this.getId());
        validarNome(this.getNome());
        validarHoras(this.getHoras());
        validarValorPorHora(this.getValorPorHora());
        validarBonus(this.bonus);
    }

    @Override
    public BigDecimal getPagamento() {
        BigDecimal valorHoras = multiplicar(this.getValorPorHora(), toBigDecimal(this.getHoras()));
        BigDecimal valorPorBonus = multiplicar(bonus, VALOR_BONUS);
        return somar(valorHoras, valorPorBonus);
    }

    @Override
    public String toString() {
        return this.getNome() + " - " + valorMonetarioBrasil(getPagamento());
    }
}
