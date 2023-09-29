package br.com.gabrielferreira.service;

import br.com.gabrielferreira.model.Triangulo;
import br.com.gabrielferreira.utils.MaiorAreaTrianguloComparatorUtils;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidarCalculo.*;

public class TrianguloService {

    public Triangulo criarTriangulo(Double ladoA, Double ladoB, Double ladoC, Character tipoTriangulo){
        validarValorInformado(ladoA, "É necessário informar o lado A");
        validarValorInformado(ladoB, "É necessário informar o lado B");
        validarValorInformado(ladoC, "É necessário informar o lado C");
        validarTipoTriangulo(tipoTriangulo);

        Triangulo triangulo = Triangulo.builder()
                .id(UUID.randomUUID())
                .ladoA(ladoA)
                .ladoB(ladoB)
                .ladoC(ladoC)
                .tipoTriangulo(tipoTriangulo)
                .build();

        Double calcularArea = calcularArea(triangulo);
        triangulo.setResultadoFinalCalculoArea(calcularArea);
        return triangulo;
    }

    public Character maiorAreaTipoTriangulo(List<Triangulo> triangulos){
        validarTipoTrianguloRepetido(triangulos.stream().map(Triangulo::getTipoTriangulo).toList());
        triangulos.sort(new MaiorAreaTrianguloComparatorUtils());
        return triangulos.get(0).getTipoTriangulo();
    }

    private Double calcularArea(Triangulo triangulo){
        Double valorP = (triangulo.getLadoA() + triangulo.getLadoB() + triangulo.getLadoC()) / 2.0;
        return Math.sqrt(valorP * (valorP - triangulo.getLadoA()) * (valorP - triangulo.getLadoB()) * (valorP - triangulo.getLadoC()));
    }
}
