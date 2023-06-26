package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Retangulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

class RetanguloServiceTest {

    private RetanguloService retanguloService;

    @BeforeEach
    public void criarInstancias(){
        retanguloService = new RetanguloService();
    }

    @Test
    @DisplayName("Deve validar criação do retângulo quando informar a largura nula")
    void deveValidarCriarRetanguloLarguraNulo(){
        BigDecimal largura = null;
        BigDecimal altura = toBigDecimal(2);
        assertThrows(RegraDeNegocioException.class, () -> retanguloService.criarRetangulo(largura, altura));
    }

    @Test
    @DisplayName("Deve validar criação do retângulo quando informar a altura nula")
    void deveValidarCriarRetanguloAlturaNulo(){
        BigDecimal largura = toBigDecimal(3);
        BigDecimal altura = null;
        assertThrows(RegraDeNegocioException.class, () -> retanguloService.criarRetangulo(largura, altura));
    }

    @Test
    @DisplayName("Deve realizar a criação do retângulo quando informar os valores corretamentes")
    void deveCriarRetangulo(){
        Retangulo retangulo = retanguloService.criarRetangulo(toBigDecimal(3), toBigDecimal(4));

        assertNotNull(retangulo.getId());
        assertEquals(toBigDecimal(12.0), toRetorno(retangulo.getArea(), 1, RoundingMode.HALF_EVEN));
        assertEquals(toBigDecimal(14.0), toRetorno(retangulo.getPerimetro(), 1, RoundingMode.HALF_EVEN));
        assertEquals(toBigDecimal(5.0), toRetorno(retangulo.getDiagonal(), 1, RoundingMode.HALF_EVEN));
    }
}
