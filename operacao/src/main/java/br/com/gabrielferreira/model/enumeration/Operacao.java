package br.com.gabrielferreira.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

import static br.com.gabrielferreira.utils.CalculoUtils.*;

@Getter
@AllArgsConstructor
public enum Operacao {

    SOMA{
        @Override
        public BigDecimal calcular(BigDecimal valorParte1, BigDecimal valorParte2) {
            return somar(valorParte1, valorParte2);
        }
    },
    SUBTRACAO{
        @Override
        public BigDecimal calcular(BigDecimal valorParte1, BigDecimal valorParte2) {
            return subtrair(valorParte1, valorParte2);
        }
    },
    MULTIPLICACAO{
        @Override
        public BigDecimal calcular(BigDecimal valorParte1, BigDecimal valorParte2) {
            return multiplicar(valorParte1, valorParte2);
        }
    },
    DIVISAO{
        @Override
        public BigDecimal calcular(BigDecimal valorParte1, BigDecimal valorParte2) {
            return divide(valorParte1, valorParte2);
        }
    };

    public abstract BigDecimal calcular(BigDecimal valorParte1, BigDecimal valorParte2);
}
