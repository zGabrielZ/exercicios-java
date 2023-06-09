package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumeroTest {

    @Test
    @DisplayName("Deve imprimir números de 10 até 25")
    void deveImprimirDezAteVinteCinco(){
        Numero numero = new Numero();

        List<Integer> resultado = numero.imprimirDezAteVinteCinco();

        assertFalse(resultado.contains(9));
        assertTrue(resultado.contains(10));
        assertTrue(resultado.contains(25));
        assertFalse(resultado.contains(26));
    }

    @Test
    @DisplayName("Deve imprimir números de 1 até 100 pulando de 2 em 2")
    void deveImprimirUmAteCem(){
        Numero numero = new Numero();

        List<Integer> resultado = numero.imprimirUmAteCemPulandoDeDois();

        assertFalse(resultado.contains(0));
        assertTrue(resultado.contains(1));
        assertTrue(resultado.contains(97));
        assertFalse(resultado.contains(100));
    }

    @Test
    @DisplayName("Deve imprimir números somados até bater 100")
    void deveImprimirValoresSomadosAteBateCem(){
        Numero numero = new Numero();

        List<Integer> resultado = numero.imprimirSomandoAteBaterCem();

        assertTrue(resultado.contains(1));
        assertTrue(resultado.contains(13));
        assertFalse(resultado.contains(14));
    }

    @Test
    @DisplayName("Deve imprimir tabuada do nove")
    void deveImprimirTabuadaDoNove(){
        Numero numero = new Numero();

        List<String> resultado = numero.imprimirTabuadaDoNove();

        assertTrue(resultado.contains("9 X 0 = 0"));
        assertTrue(resultado.contains("9 X 1 = 9"));
        assertTrue(resultado.contains("9 X 9 = 81"));
        assertFalse(resultado.contains("9 X 11 = 99"));
    }

    @Test
    @DisplayName("Deve validar quando for calcular o número para fatorar")
    void deveValidarNoCalculoDeNumeroParaFatorar(){
        Numero numero = new Numero();
        assertThrows(RegraDeNegocioException.class, () -> numero.calcularNumeroParaFatorar(null));
    }

    @Test
    @DisplayName("Deve calcular o número para fatorar")
    void deveRealizarCalculoDeNumeroParaFatorar(){
        Numero numero = new Numero();

        BigDecimal resultado = numero.calcularNumeroParaFatorar(5);

        assertEquals(BigDecimal.valueOf(120), resultado);
    }

    @Test
    @DisplayName("Deve imprimir até quinze números quando for calcular o fibonacci")
    void deveImprimirNumerosFibonacciComLimiteQuinze(){
        Numero numero = new Numero();

        List<Integer> resultado = numero.imprimirQuinzePrimeirosNumerosFibonacci();

        assertTrue(resultado.contains(0));
        assertTrue(resultado.contains(1));
        assertTrue(resultado.contains(21));
        assertEquals(15, resultado.size());
    }

    @Test
    @DisplayName("Deve validar imprimir até ultrapssar até 1000 quando não informar valor nenhum")
    void deveValidarImprimirAteUltrapassarMil(){
        Numero numero = new Numero();
        assertThrows(RegraDeNegocioException.class, () -> numero.imprimirAteUltrapassarMil(null));
    }

    @Test
    @DisplayName("Deve imprimir até ultrapssar até 1000")
    void deveImprimirAteUltrapassarMil(){
        Numero numero = new Numero();

        List<Integer> resultado = numero.imprimirAteUltrapassarMil(4);

        assertTrue(resultado.contains(9));
        assertFalse(resultado.contains(10));
        assertTrue(resultado.contains(18));
    }

    @Test
    @DisplayName("Deve validar imprimir data informada quando não informar o dia")
    void deveValidarImprimirDataInformadaQuandoNaoInformarDia(){
        Numero numero = new Numero();
        assertThrows(RegraDeNegocioException.class, () -> numero.imprimirDataInformada(null, 10, 2000));
    }

    @Test
    @DisplayName("Deve validar imprimir data informada quando não informar o mês")
    void deveValidarImprimirDataInformadaQuandoNaoInformarMes(){
        Numero numero = new Numero();
        assertThrows(RegraDeNegocioException.class, () -> numero.imprimirDataInformada(10, null, 2000));
    }

    @Test
    @DisplayName("Deve validar imprimir data informada quando não informar o ano")
    void deveValidarImprimirDataInformadaQuandoNaoInformarAno(){
        Numero numero = new Numero();
        assertThrows(RegraDeNegocioException.class, () -> numero.imprimirDataInformada(10, 10, null));
    }

    @Test
    @DisplayName("Deve validar imprimir data informada quando formato do ano ultrapassar de quatro números")
    void deveValidarImprimirDataInformadaFormatoDoAno(){
        Numero numero = new Numero();
        assertThrows(RegraDeNegocioException.class, () -> numero.imprimirDataInformada(10, 10, 20000));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 13, -2, 14})
    @DisplayName("Deve validar imprimir data informada quando mês tiver fora do período")
    void deveValidarImprimirDataInformadaForaPeriodoMes(int valor){
        Numero numero = new Numero();
        assertThrows(RegraDeNegocioException.class, () -> numero.imprimirDataInformada(10, valor, 2000));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 31, 32, -2})
    @DisplayName("Deve validar imprimir data informada quando dia tiver fora do período")
    void deveValidarImprimirDataInformadaForaPeriodoDia(int valor){
        Numero numero = new Numero();
        assertThrows(RegraDeNegocioException.class, () -> numero.imprimirDataInformada(valor, 10, 2000));
    }

    @Test
    @DisplayName("Deve validar imprimir data informada quando o dia for maior que 28 e sendo fevereiro")
    void deveValidarImprimirDataInformadaFevereiroIncorreto(){
        Numero numero = new Numero();
        assertThrows(RegraDeNegocioException.class, () -> numero.imprimirDataInformada(29, 2, 2000));
    }

    @Test
    @DisplayName("Deve imprimir data informada")
    void deveImprimirDataInformada(){
        Numero numero = new Numero();

        String resultado = numero.imprimirDataInformada(29, 3, 2023);

        assertEquals("29/3/2023", resultado);
    }
}
