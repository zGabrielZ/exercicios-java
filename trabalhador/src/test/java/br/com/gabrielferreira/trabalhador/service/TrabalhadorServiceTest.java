package br.com.gabrielferreira.trabalhador.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.trabalhador.model.ContratoHora;
import br.com.gabrielferreira.trabalhador.model.Trabalhador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;
import static br.com.gabrielferreira.commons.utils.DataUtils.toDataBrasilMesAno;
import static org.junit.jupiter.api.Assertions.*;

class TrabalhadorServiceTest {

    private static final String VALOR_NULO = null;

    private TrabalhadorService trabalhadorService;

    private ContratoHoraService contratoHoraService;

    @BeforeEach
    public void criarInstancias(){
        trabalhadorService = new TrabalhadorService();
        contratoHoraService = new ContratoHoraService();
    }

    @Test
    @DisplayName("Deve validar criação do trabalhador quando informar o nome departamento nulo")
    void deveValidarCriarTrabalhadorNomeDepartamentoNulo(){
        String nomeTrabalhador = "José";
        String levelTrabalhador = "SENIOR";
        BigDecimal salario = toBigDecimal(10.0);
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.criarTrabalhador(VALOR_NULO, nomeTrabalhador, levelTrabalhador, salario));
    }

    @Test
    @DisplayName("Deve validar criação do trabalhador quando informar o nome trabalhador nulo")
    void deveValidarCriarTrabalhadorNomeTrabalhadorNulo(){
        String nomeDepartamento = "Design";
        String levelTrabalhador = "SENIOR";
        BigDecimal salario = toBigDecimal(10.0);
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.criarTrabalhador(nomeDepartamento, VALOR_NULO, levelTrabalhador, salario));
    }

    @Test
    @DisplayName("Deve validar criação do trabalhador quando informar o level trabalhador nulo")
    void deveValidarCriarTrabalhadorLevelTrabalhadorNulo(){
        String nomeDepartamento = "Design";
        String nomeTrabalhador = "José";
        BigDecimal salario = toBigDecimal(10.0);
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.criarTrabalhador(nomeDepartamento, nomeTrabalhador, VALOR_NULO, salario));
    }

    @Test
    @DisplayName("Deve validar criação do trabalhador quando informar o level trabalhador errado")
    void deveValidarCriarTrabalhadorLevelTrabalhadorInformadoIncorreto(){
        String nomeDepartamento = "Design";
        String nomeTrabalhador = "José";
        String levelTrabalhador = "INEXISTENTE";
        BigDecimal salario = toBigDecimal(10.0);
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.criarTrabalhador(nomeDepartamento, nomeTrabalhador, levelTrabalhador, salario));
    }

    @Test
    @DisplayName("Deve validar criação do trabalhador quando informar o salário nulo")
    void deveValidarCriarTrabalhadorSalarioNulo(){
        String nomeDepartamento = "Design";
        String nomeTrabalhador = "José";
        String levelTrabalhador = "PLENO";
        BigDecimal salario = null;
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.criarTrabalhador(nomeDepartamento, nomeTrabalhador, levelTrabalhador, salario));
    }

    @Test
    @DisplayName("Deve validar criação do trabalhador quando informar o salário negativo")
    void deveValidarCriarTrabalhadorSalarioNegativo(){
        String nomeDepartamento = "Design";
        String nomeTrabalhador = "José";
        String levelTrabalhador = "PLENO";
        BigDecimal salario = toBigDecimal(-19);
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.criarTrabalhador(nomeDepartamento, nomeTrabalhador, levelTrabalhador, salario));
    }

    @Test
    @DisplayName("Deve realizar a criação do trabalhador quando informar os valores corretos")
    void deveCriarTrabalhador(){
        Trabalhador trabalhador = trabalhadorService
                .criarTrabalhador("Design", "Alex", "PLENO", toBigDecimal(5000.00));

        assertNotNull(trabalhador.getId());
        assertEquals("Design", trabalhador.getDepartamento().getNome());
    }

    @Test
    @DisplayName("Deve validar cálculo de renda quando informar o trabalhador como nulo")
    void deveValidarCalculoRendaTrabalhadorNulo(){
        Trabalhador trabalhador = null;
        String mesAno = "12/2022";
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.calcularRenda(mesAno, trabalhador));
    }

    @Test
    @DisplayName("Deve validar cálculo de renda quando informar o mês e ano como nulo")
    void deveValidarCalculoRendaMesAnoNulo(){
        Trabalhador trabalhador = trabalhadorService
                .criarTrabalhador("Design", "Alex", "PLENO", toBigDecimal(5000.00));
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.calcularRenda(VALOR_NULO, trabalhador));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111/2022", "112022", "11/22", "1122022"})
    @DisplayName("Deve validar cálculo de renda quando informar o mês e ano com formato incorreto")
    void deveValidarCalculoRendaMesAnoFormatoIncorreto(String mesAno){
        Trabalhador trabalhador = trabalhadorService
                .criarTrabalhador("Design", "Alex", "PLENO", toBigDecimal(5000.00));
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.calcularRenda(mesAno, trabalhador));
    }

    @Test
    @DisplayName("Deve validar cálculo de renda quando informar o trabalhador sem contrato hora")
    void deveValidarCalculoRendaTrabalhadorSemContratoHora(){
        Trabalhador trabalhador = trabalhadorService
                .criarTrabalhador("Design", "Alex", "PLENO", toBigDecimal(5000.00));
        String mesAno = "11/2022";
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.calcularRenda(mesAno, trabalhador));
    }

    @Test
    @DisplayName("Deve validar cálculo de renda quando informar o mês não numérico")
    void deveValidarCalculoRendaTrabalhadorMesNaoNumerico(){
        Trabalhador trabalhador = trabalhadorService
                .criarTrabalhador("Design", "Alex", "PLENO", toBigDecimal(5000.00));

        ContratoHora contratoHora = contratoHoraService
                .criarContratoHora("20/08/2022", toBigDecimal(10.0), 10);

        trabalhador.adicionarContratoHoras(contratoHora);


        String mesAno = "AA/2022";
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.calcularRenda(mesAno, trabalhador));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "13", "14"})
    @DisplayName("Deve validar cálculo de renda quando informar o mês fora do período")
    void deveValidarCalculoRendaTrabalhadorMesForaPeriodo(String mes){
        Trabalhador trabalhador = trabalhadorService
                .criarTrabalhador("Design", "Alex", "PLENO", toBigDecimal(5000.00));

        ContratoHora contratoHora = contratoHoraService
                .criarContratoHora("20/08/2022", toBigDecimal(10.0), 10);

        trabalhador.adicionarContratoHoras(contratoHora);


        String mesAno = mes.concat("/").concat("2022");
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.calcularRenda(mesAno, trabalhador));
    }

    @Test
    @DisplayName("Deve validar cálculo de renda quando informar o ano não numérico")
    void deveValidarCalculoRendaTrabalhadorAnoNaoNumerico(){
        Trabalhador trabalhador = trabalhadorService
                .criarTrabalhador("Design", "Alex", "PLENO", toBigDecimal(5000.00));

        ContratoHora contratoHora = contratoHoraService
                .criarContratoHora("20/08/2022", toBigDecimal(10.0), 10);

        trabalhador.adicionarContratoHoras(contratoHora);


        String mesAno = "11/AAAA";
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.calcularRenda(mesAno, trabalhador));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1909", "1901", "1903", "1905"})
    @DisplayName("Deve validar cálculo de renda quando informar o ano fora do período")
    void deveValidarCalculoRendaTrabalhadorAnoForaPeriodo(String ano){
        Trabalhador trabalhador = trabalhadorService
                .criarTrabalhador("Design", "Alex", "PLENO", toBigDecimal(5000.00));

        ContratoHora contratoHora = contratoHoraService
                .criarContratoHora("20/08/2022", toBigDecimal(10.0), 10);

        trabalhador.adicionarContratoHoras(contratoHora);


        String mesAno = "11".concat("/").concat(ano);
        assertThrows(RegraDeNegocioException.class, () -> trabalhadorService.calcularRenda(mesAno, trabalhador));
    }

    @Test
    @DisplayName("Deve realizar cálculo de renda quando informar os valores corretamentes")
    void deveRealizarCalculoRenda(){
        Trabalhador trabalhador = trabalhadorService
                .criarTrabalhador("Design", "Alex", "PLENO", toBigDecimal(5000.00));

        ContratoHora contratoHora1 = contratoHoraService
                .criarContratoHora("20/08/2022", toBigDecimal(200.0), 10);
        ContratoHora contratoHora2 = contratoHoraService
                .criarContratoHora("10/09/2022", toBigDecimal(300.0), 2);
        ContratoHora contratoHora3 = contratoHoraService
                .criarContratoHora("15/09/2022", toBigDecimal(500.0), 6);
        ContratoHora contratoHora4 = contratoHoraService
                .criarContratoHora("05/05/2022", toBigDecimal(100.0), 25);

        trabalhador.adicionarContratoHoras(contratoHora1);
        trabalhador.adicionarContratoHoras(contratoHora2);
        trabalhador.adicionarContratoHoras(contratoHora3);
        trabalhador.adicionarContratoHoras(contratoHora4);

        trabalhadorService.calcularRenda("09/2022", trabalhador);

        String trabalhadorStatus = trabalhadorService.imprimirTrabalhador(trabalhador);

        assertEquals(toBigDecimal(8600.00), trabalhador.getRenda().getValor());
        assertEquals("09/2022", toDataBrasilMesAno(trabalhador.getRenda().getDataRenda()));
        assertNotNull(trabalhadorStatus);
    }

}
