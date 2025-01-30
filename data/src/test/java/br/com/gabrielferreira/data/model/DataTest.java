package br.com.gabrielferreira.data.model;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @Test
    @DisplayName("Deve validar dia quando não for informado")
    void deveValidarDia(){
        try {
            new Data(UUID.randomUUID(), null, 1, 2000);
            fail("Deveria ter lançado a exceção do dia nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o dia"));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 31, -2, 32})
    @DisplayName("Deve validar dia quando o período estiver fora de 1 até 30")
    void deveValidarDiaPeriodoErrado(int dia){
        try {
            new Data(UUID.randomUUID(), dia, 1, 2000);
            fail("Deveria ter lançado a exceção do dia fora do período");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Informe o dia corretamente (1 até 30)"));
        }
    }

    @Test
    @DisplayName("Deve validar mês quando não for informado")
    void deveValidarMes(){
        try {
            new Data(UUID.randomUUID(), 1, null, 2000);
            fail("Deveria ter lanção a exceção do mês nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o mês"));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 13, -3, 15})
    @DisplayName("Deve validar mês quando o período estiver fora de 1 até 12")
    void deveValidarMesPeriodoErrado(int mes){
        try {
            new Data(UUID.randomUUID(), 1, mes, 2000);
            fail("Deveria ter lançado a exceção do mês fora do período");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Informe o mês corretamente (1 até 12)"));
        }
    }

    @Test
    @DisplayName("Deve validar ano quando não for informado")
    void deveValidarAno(){
        try {
            new Data(UUID.randomUUID(), 1, 1, null);
            fail("Deveria ter lanção a exceção do ano nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o ano"));
        }
    }

    @Test
    @DisplayName("Deve validar ano quando o tamanho for maior que 4")
    void deveValidarAnoPeriodoErrado(){
        try {
            new Data(UUID.randomUUID(), 1, 1, 20001);
            fail("Deveria ter lançado a exceção do ano tamanho incorreto");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Informe o ano corretamente"));
        }
    }

    @Test
    @DisplayName("Deve validar formato quando não for informado")
    void deveValidarFormato(){
        Data data = new Data(UUID.randomUUID(), 1, 1, 2000);
        assertThrows(RegraDeNegocioException.class, () -> data.imprimir(null));
    }

    @Test
    @DisplayName("Deve imprimir data quando informar somente o ano, mês e ano")
    void deveImprimirData(){
        Data data = new Data(UUID.randomUUID(), 1, 1, 2000);

        String resultado = data.imprimir(Constantes.FORMATO_12H);
        assertEquals("1/1/2000", resultado);

        String resultado2 = data.imprimir(Constantes.FORMATO_24H);
        assertEquals("1/1/2000", resultado2);
    }

    @Test
    @DisplayName("Deve validar hora quando não for informado")
    void deveValidarHora(){
        try {
            new Data(UUID.randomUUID(), 1, 1, 2000, null, 50, 50);
            fail("Deveria ter lançado a exceção do hora nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar a hora"));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 25, -2, 30, -10})
    @DisplayName("Deve validar hora quando o período estiver fora de 0 até 24")
    void deveValidarHoraPeriodoErrado(int hora){
        try {
            new Data(UUID.randomUUID(), 1, 1, 2000, hora, 1, 1);
            fail("Deveria ter lançado a exceção do hora fora do período");
        } catch (Exception e){
            assertTrue(e.getMessage().contains(String.format("A hora deve está entre 0 e 24, o valor fornecido %s", hora)));
        }
    }

    @Test
    @DisplayName("Deve validar minuto quando não for informado")
    void deveValidarMinuto(){
        try {
            new Data(UUID.randomUUID(), 1, 1, 2000, 1, null, 50);
            fail("Deveria ter lançado a exceção do minuto nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o minuto"));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 60, -2, 100, -10})
    @DisplayName("Deve validar minuto quando o período estiver fora de 0 até 59")
    void deveValidarMinutoPeriodoErrado(int minuto){
        try {
            new Data(UUID.randomUUID(), 1, 1, 2000, 1, minuto, 1);
            fail("Deveria ter lançado a exceção do minuto fora do período");
        } catch (Exception e){
            assertTrue(e.getMessage().contains(String.format("O minuto deve está entre 0 e 59, o valor fornecido %s", minuto)));
        }
    }

    @Test
    @DisplayName("Deve validar segundo quando não for informado")
    void deveValidarSegundo(){
        try {
            new Data(UUID.randomUUID(), 1, 1, 2000, 1, 1, null);
            fail("Deveria ter lançado a exceção do segundo nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o segundo"));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 60, -2, 100, -10})
    @DisplayName("Deve validar segundo quando o período estiver fora de 0 até 59")
    void deveValidarSegundoPeriodoErrado(int segundo){
        try {
            new Data(UUID.randomUUID(), 1, 1, 2000, 1, 1, segundo);
            fail("Deveria ter lançado a exceção do segundo fora do período");
        } catch (Exception e){
            assertTrue(e.getMessage().contains(String.format("O segundo deve está entre 0 e 59, o valor fornecido %s", segundo)));
        }
    }

    @Test
    @DisplayName("Deve validar o formato quando o período for diferente de 1 e 2")
    void deveValidarFormatoImpressao(){
        Data data = new Data(UUID.randomUUID(), 1, 1, 2000, 1, 1, 40);

        assertThrows(RegraDeNegocioException.class, () -> data.imprimir(3));
    }

    @Test
    @DisplayName("Deve imprimir data quando escolher o formato 24 horas")
    void deveImprimirDataFormatoVinteQuatroHoras(){
        Data data = new Data(UUID.randomUUID(), 1, 1, 2000, 10, 50, 40);

        String resultado = data.imprimir(Constantes.FORMATO_24H);

        assertEquals("1/1/2000 10:50:40", resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 11, 12, 15, 20, 24})
    @DisplayName("Deve imprimir data quando escolher formato 12 horas")
    void deveImprimirDataFormatoDozeHorasQuandoInformarZeroHoras(int hora){
        Data data = new Data(UUID.randomUUID(), 1, 1, 2000, hora, 50, 40);

        assertDoesNotThrow(() -> data.imprimir(Constantes.FORMATO_12H));
        assertNotNull(data.getId());
        assertEquals(1, data.getDia());
        assertEquals(1, data.getMes());
        assertEquals(2000, data.getAno());
        assertEquals(hora, data.getHora());
        assertEquals(50, data.getMinuto());
        assertEquals(40, data.getSegundo());
        assertNotNull(data.toString());
    }
}
