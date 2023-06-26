package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Retangulo;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import static br.com.gabrielferreira.utils.CalculoUtils.*;


public class RetanguloService implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    public Retangulo criarRetangulo(BigDecimal largura, BigDecimal altura){
        validarValor(largura, "É necessário informar largura");
        validarValor(altura, "É necessário informar altura");

        BigDecimal area = calcularArea(largura, altura);
        BigDecimal perimetro = calcularPerimetro(largura, altura);
        BigDecimal diagonal = calcularDiagonal(largura, altura);

        return Retangulo.builder()
                .id(UUID.randomUUID())
                .largura(largura)
                .altura(altura)
                .area(area)
                .perimetro(perimetro)
                .diagonal(diagonal)
                .build();
    }

    private BigDecimal calcularArea(BigDecimal largura, BigDecimal altura){
        return multiplicar(largura, altura);
    }

    private BigDecimal calcularPerimetro(BigDecimal largura, BigDecimal altura){
        return multiplicar(toBigDecimal(2), somar(largura, altura));
    }

    private BigDecimal calcularDiagonal(BigDecimal largura, BigDecimal altura){
        largura = largura.pow(2);
        altura = altura.pow(2);
        BigDecimal soma = somar(largura, altura);
        return toBigDecimal(Math.sqrt(soma.doubleValue()));
    }

    private void validarValor(BigDecimal valor, String msg){
        if(valor == null){
            throw new RegraDeNegocioException(msg);
        }
    }
}
