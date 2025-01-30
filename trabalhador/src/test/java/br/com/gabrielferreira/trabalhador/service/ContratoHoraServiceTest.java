package br.com.gabrielferreira.trabalhador.service;

import br.com.gabrielferreira.commons.exception.ErroInesperadoException;
import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.trabalhador.model.ContratoHora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.commons.utils.DataUtils.toDataBrasil;
import static org.junit.jupiter.api.Assertions.*;

class ContratoHoraServiceTest {

    private ContratoHoraService contratoHoraService;

    @BeforeEach
    public void criarInstancias(){
        contratoHoraService = new ContratoHoraService();
    }

    @Test
    @DisplayName("Deve validar criação do contrato hora quando informar a data nula")
    void deveValidarCriarContratoHoraDataNula(){
        String data = null;
        BigDecimal valorPorHora = toBigDecimal(10.0);
        Integer horas = 5;
        assertThrows(RegraDeNegocioException.class, () -> contratoHoraService.criarContratoHora(data, valorPorHora, horas));
    }

    @Test
    @DisplayName("Deve validar criação do contrato hora quando informar a data formato incorreto")
    void deveValidarCriarContratoHoraDataFormatoIncorreto(){
        String data = "01/01/200";
        BigDecimal valorPorHora = toBigDecimal(10.0);
        Integer horas = 5;
        assertThrows(ErroInesperadoException.class, () -> contratoHoraService.criarContratoHora(data, valorPorHora, horas));
    }

    @Test
    @DisplayName("Deve validar criação do contrato hora quando informar o valor por hora nula")
    void deveValidarCriarContratoValorPorHoraNula(){
        String data = "01/01/2022";
        BigDecimal valorPorHora = null;
        Integer horas = 5;
        assertThrows(RegraDeNegocioException.class, () -> contratoHoraService.criarContratoHora(data, valorPorHora, horas));
    }

    @Test
    @DisplayName("Deve validar criação do contrato hora quando informar o valor por hora negativa")
    void deveValidarCriarContratoValorPorHoraNegativa(){
        String data = "01/01/2022";
        BigDecimal valorPorHora = toBigDecimal(-10);
        Integer horas = 5;
        assertThrows(RegraDeNegocioException.class, () -> contratoHoraService.criarContratoHora(data, valorPorHora, horas));
    }

    @Test
    @DisplayName("Deve validar criação do contrato hora quando informar a hora nula")
    void deveValidarCriarContratoHoraNula(){
        String data = "01/01/2022";
        BigDecimal valorPorHora = toBigDecimal(10.0);
        Integer horas = null;
        assertThrows(RegraDeNegocioException.class, () -> contratoHoraService.criarContratoHora(data, valorPorHora, horas));
    }

    @Test
    @DisplayName("Deve validar criação do contrato hora quando informar a hora negativa")
    void deveValidarCriarContratoHoraNegativa(){
        String data = "01/01/2022";
        BigDecimal valorPorHora = toBigDecimal(10);
        Integer horas = -5;
        assertThrows(RegraDeNegocioException.class, () -> contratoHoraService.criarContratoHora(data, valorPorHora, horas));
    }

    @Test
    @DisplayName("Deve realizar a criação do contrato hora quando informar os valores corretos")
    void deveCriarContratoHoras(){
        ContratoHora contratoHora = contratoHoraService
                .criarContratoHora("08/07/2022", toBigDecimal(10.0), 5);

        assertNotNull(contratoHora.getId());
        assertEquals("08/07/2022", toDataBrasil(contratoHora.getData()));
    }
}
