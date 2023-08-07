package br.com.gabrielferreira.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static br.com.gabrielferreira.validate.ValidarCampos.*;

@EqualsAndHashCode(callSuper = true)
public class PessoaJuridica extends Pessoa {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    private static final Integer LIMITE_FUNCIONARIO = 10;
    private static final BigDecimal TAXA_IMPOSTO_14_PORCENTO = toBigDecimal(0.14);
    private static final BigDecimal TAXA_IMPOSTO_16_PORCENTO = toBigDecimal(0.16);

    @Getter
    private final Integer numeroFuncionarios;

    public PessoaJuridica(UUID id, String nome, BigDecimal rendaAnual, Integer numeroFuncionarios) {
        super(id, nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;

        validarFuncionarios(this.numeroFuncionarios);
    }

    @Override
    public BigDecimal getTaxaImposto() {
        if(this.numeroFuncionarios > LIMITE_FUNCIONARIO){
            return multiplicar(this.getRendaAnual(), TAXA_IMPOSTO_14_PORCENTO);
        }

        return multiplicar(this.getRendaAnual(), TAXA_IMPOSTO_16_PORCENTO);
    }
}
