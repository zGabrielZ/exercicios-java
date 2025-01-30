package br.com.gabrielferreira.retangulo.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.retangulo.model.Retangulo;
import java.math.BigDecimal;
import java.util.UUID;
import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;


public class RetanguloService {

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
