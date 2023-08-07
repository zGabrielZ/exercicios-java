package br.com.gabrielferreira.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static br.com.gabrielferreira.validate.ValidarCampos.*;

@EqualsAndHashCode(callSuper = true)
public class PessoaFisica extends Pessoa {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    private static final BigDecimal LIMITE_IMPOSTO = toBigDecimal(20000.00);
    private static final BigDecimal TAXA_IMPOSTO_15_PORCENTO = toBigDecimal(0.15);
    private static final BigDecimal TAXA_IMPOSTO_25_PORCENTO = toBigDecimal(0.25);
    private static final BigDecimal TAXA_IMPOSTO_50_PORCENTO = toBigDecimal(0.50);

    @Getter
    private final BigDecimal gastoSaude;

    public PessoaFisica(UUID id, String nome, BigDecimal rendaAnual, BigDecimal gastoSaude) {
        super(id, nome, rendaAnual);
        this.gastoSaude = gastoSaude;

        validarGastoSaude(this.gastoSaude);
    }

    @Override
    public BigDecimal getTaxaImposto() {
        if((this.gastoSaude != null && this.gastoSaude.compareTo(BigDecimal.ZERO) > 0) && getCalculoRendaAnual() != null){
            return subtrair(getCalculoRendaAnual(), multiplicar(this.gastoSaude, TAXA_IMPOSTO_50_PORCENTO));
        }

        return getCalculoRendaAnual();
    }

    private BigDecimal getCalculoRendaAnual(){
        if(this.getRendaAnual().compareTo(LIMITE_IMPOSTO) < 0){
            return multiplicar(this.getRendaAnual(), TAXA_IMPOSTO_15_PORCENTO);
        } else if(this.getRendaAnual().compareTo(LIMITE_IMPOSTO) >= 0){
            return multiplicar(this.getRendaAnual(), TAXA_IMPOSTO_25_PORCENTO);
        }
        return null;
    }
}
