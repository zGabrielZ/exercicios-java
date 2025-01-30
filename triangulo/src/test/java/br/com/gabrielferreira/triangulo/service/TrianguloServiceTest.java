package br.com.gabrielferreira.triangulo.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.triangulo.model.Triangulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrianguloServiceTest {

    private TrianguloService trianguloService;

    @BeforeEach
    public void criarInstancias(){
        trianguloService = new TrianguloService();
    }

    @Test
    @DisplayName("Deve validar criação do triângulo quando informar o lado a nulo")
    void deveValidarCriarTrianguloLadoANulo(){
        Double ladoA = null;
        Double ladoB = 10.0;
        Double ladoC = 20.0;
        Character tipoTriangulo = 'X';
        assertThrows(RegraDeNegocioException.class, () -> trianguloService.criarTriangulo(ladoA, ladoB, ladoC, tipoTriangulo));
    }

    @Test
    @DisplayName("Deve validar criação do triângulo quando informar o lado b nulo")
    void deveValidarCriarTrianguloLadoBNulo(){
        Double ladoA = 10.0;
        Double ladoB = null;
        Double ladoC = 20.0;
        Character tipoTriangulo = 'X';
        assertThrows(RegraDeNegocioException.class, () -> trianguloService.criarTriangulo(ladoA, ladoB, ladoC, tipoTriangulo));
    }

    @Test
    @DisplayName("Deve validar criação do triângulo quando informar o lado c nulo")
    void deveValidarCriarTrianguloLadoCNulo(){
        Double ladoA = 10.0;
        Double ladoB = 30.0;
        Double ladoC = null;
        Character tipoTriangulo = 'X';
        assertThrows(RegraDeNegocioException.class, () -> trianguloService.criarTriangulo(ladoA, ladoB, ladoC, tipoTriangulo));
    }

    @Test
    @DisplayName("Deve validar criação do triângulo quando informar o tipo triângulo nulo")
    void deveValidarCriarTrianguloTipoTrianguloNulo(){
        Double ladoA = 10.0;
        Double ladoB = 30.0;
        Double ladoC = 30.0;
        Character tipoTriangulo = null;
        assertThrows(RegraDeNegocioException.class, () -> trianguloService.criarTriangulo(ladoA, ladoB, ladoC, tipoTriangulo));
    }

    @Test
    @DisplayName("Deve realizar a criação do triângulo quando informar os valores corretamentes")
    void deveCriarTriangulo(){
        Triangulo triangulo = trianguloService.criarTriangulo(20.0, 20.0, 20.0, 'X');

        assertNotNull(triangulo.getId());
        assertEquals(173.20, triangulo.getResultadoFinalCalculoArea(), 0.1);
    }

    @Test
    @DisplayName("Deve verificar qual vai ser a maior área do triângulo")
    void deveVerificarMaiorAreaTriangulos(){
        List<Triangulo> triangulos = new ArrayList<>();

        Triangulo triangulo1 = trianguloService.criarTriangulo(10.0, 20.0, 20.0, 'X');
        Triangulo triangulo2 = trianguloService.criarTriangulo(20.0, 20.0, 20.0, 'Y');
        Triangulo triangulo3 = trianguloService.criarTriangulo(30.0, 20.0, 20.0, 'Z');

        triangulos.add(triangulo1);
        triangulos.add(triangulo2);
        triangulos.add(triangulo3);

        Character tipoTriangulo = trianguloService.maiorAreaTipoTriangulo(triangulos);

        assertEquals('Z', tipoTriangulo);
    }

    @Test
    @DisplayName("Deve validar tipo de triângulo quando for repetido")
    void deveValidarTipoTrianguloRepetido(){
        List<Triangulo> triangulos = new ArrayList<>();

        Triangulo triangulo1 = trianguloService.criarTriangulo(10.0, 20.0, 20.0, 'X');
        Triangulo triangulo2 = trianguloService.criarTriangulo(20.0, 20.0, 20.0, 'X');
        Triangulo triangulo3 = trianguloService.criarTriangulo(30.0, 20.0, 20.0, 'Z');

        triangulos.add(triangulo1);
        triangulos.add(triangulo2);
        triangulos.add(triangulo3);

        assertThrows(RegraDeNegocioException.class, () -> trianguloService.maiorAreaTipoTriangulo(triangulos));
    }
}
