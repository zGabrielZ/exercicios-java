package br.com.gabrielferreira.trabalhador.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.trabalhador.model.ContratoHora;
import br.com.gabrielferreira.trabalhador.model.Departamento;
import br.com.gabrielferreira.trabalhador.model.Renda;
import br.com.gabrielferreira.trabalhador.model.Trabalhador;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.trabalhador.model.enumeration.TrabalhadorLevel.*;
import static br.com.gabrielferreira.commons.utils.StringUtils.*;
import static br.com.gabrielferreira.commons.utils.DataUtils.*;
import static br.com.gabrielferreira.commons.utils.MascarasUtils.*;
import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;

public class TrabalhadorService {

    public Trabalhador criarTrabalhador(String nomeDepartamento, String nomeTrabalhador, String trabalhadorLevel, BigDecimal salario){
        validarNome(nomeDepartamento, "o departamento");
        validarNome(nomeTrabalhador, "o nome do trabalhador");
        validarNome(trabalhadorLevel, "o level do trabalhador");
        validarSalario(salario);

        Departamento departamento = Departamento.builder()
                .id(UUID.randomUUID())
                .nome(nomeDepartamento)
                .build();

        return Trabalhador.builder()
                .id(UUID.randomUUID())
                .nome(nomeTrabalhador)
                .trabalhadorLevel(toTrabalhadorLevel(trabalhadorLevel))
                .salario(salario)
                .departamento(departamento)
                .contratoHoras(new ArrayList<>())
                .build();
    }

    public void calcularRenda(String mesAno, Trabalhador trabalhador){
        validarMesAno(mesAno);
        validarTrabalhador(trabalhador);
        validarContratoTrabalhador(trabalhador.getContratoHoras());

        String mes = mesAno.substring(0, 2);
        String ano = mesAno.substring(3);

        Integer mesInteiro = toMesInteiro(mes);
        Integer anoInteiro = toAnoInteiro(ano);

        LocalDate dataInicio = LocalDate.of(anoInteiro, mesInteiro, 1);
        LocalDate dataFim = dataInicio.withDayOfMonth(dataInicio.lengthOfMonth());

        BigDecimal soma = BigDecimal.ZERO;
        for (ContratoHora contratoHora : trabalhador.getContratoHoras()) {
            LocalDate dataContratoHora = contratoHora.getData();
            if((dataContratoHora.isAfter(dataInicio) || dataContratoHora == dataInicio) &&
                    (dataContratoHora.isBefore(dataFim) || dataContratoHora == dataFim)){
                BigDecimal valorPorHora = multiplicar(contratoHora.getValorPorHora(), toBigDecimal(contratoHora.getHoras()));
                soma = somar(soma, valorPorHora);
            }
        }

        Renda renda = Renda.builder()
                .id(UUID.randomUUID())
                .dataRenda(dataInicio)
                .valor(somar(soma, trabalhador.getSalario()))
                .build();

        trabalhador.setRenda(renda);
    }

    public String imprimirTrabalhador(Trabalhador trabalhador){
        validarTrabalhador(trabalhador);

        return  "Nome : " +
                trabalhador.getNome() +
                "\n" +
                "Departamento : " +
                trabalhador.getDepartamento().getNome() +
                "\n" +
                "Renda do Mês : " +
                toDataBrasilMesAno(trabalhador.getRenda().getDataRenda()) +
                " : " +
                valorMonetarioBrasil(trabalhador.getRenda().getValor());
    }

    private void validarNome(String valor, String msg){
        if(valor == null || valor.isBlank()){
            throw new RegraDeNegocioException("É necessário informar " + msg);
        }
    }

    private void validarSalario(BigDecimal salario){
        if(salario == null){
            throw new RegraDeNegocioException("É necessário informar o salário");
        }

        if(salario.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException("O salário não pode ser negativo");
        }
    }

    private void validarMesAno(String mesAno){
        validarNome(mesAno, "o mês e ano");

        if(mesAno.length() != 7){
            throw new RegraDeNegocioException("O formato está incorreto, teria que ser (MM/AAAA). Exemplo : 06/2022");
        }

        if(!mesAno.substring(2, 3).contains("/")){
            throw new RegraDeNegocioException("O formato está incorreto, teria que ter uma /, separando do mês e ano. Exemplo : 07/2022");
        }
    }

    private Integer toMesInteiro(String mes){
        if(!isNumerico(mes)){
            throw new RegraDeNegocioException("O mês tem que ser númerico");
        }

        int mesInteiro = Integer.parseInt(mes);

        if(!(mesInteiro >= 1 && mesInteiro <= 12)){
            throw new RegraDeNegocioException("O mês tem que ser de 1 até 12");
        }
        return mesInteiro;
    }

    private Integer toAnoInteiro(String ano){
        if(!isNumerico(ano)){
            throw new RegraDeNegocioException("O ano tem que ser númerico");
        }

        int anoInteiro = Integer.parseInt(ano);

        if(anoInteiro < 1910){
            throw new RegraDeNegocioException("O ano tem que ser maior que 1910");
        }
        return anoInteiro;
    }

    private void validarTrabalhador(Trabalhador trabalhador){
        if(trabalhador == null){
            throw new RegraDeNegocioException("É necessário informar o trabalhador");
        }
    }

    private void validarContratoTrabalhador(List<ContratoHora> contratoHoras){
        if(contratoHoras == null || contratoHoras.isEmpty()){
            throw new RegraDeNegocioException("É necessário ter pelo menos um contrato para o trabalhador");
        }
    }
}
