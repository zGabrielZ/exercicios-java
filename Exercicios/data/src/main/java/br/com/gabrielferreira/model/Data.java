package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Generated
@ToString
public class Data implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @EqualsAndHashCode.Include
    private final UUID id;

    private final Integer dia;

    private final Integer mes;

    private final Integer ano;

    private Integer hora;

    private Integer minuto;

    private Integer segundo;

    public Data(UUID id, Integer dia, Integer mes, Integer ano){
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        validarDia(this.dia);
        validarMes(this.mes);
        validarAno(this.ano);
    }

    public Data(UUID id ,Integer dia, Integer mes, Integer ano, Integer hora, Integer minuto, Integer segundo){
        this(id,dia, mes, ano);
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;

        validarHora(this.hora);
        validarMinuto(this.minuto);
        validarSegundo(this.segundo);
    }

    private void validarDia(Integer dia){
        if(dia == null){
            throw new RegraDeNegocioException("É necessário informar o dia");
        }

        if(!(dia >= 1 && dia <= 30)){
            throw new RegraDeNegocioException("Informe o dia corretamente (1 até 30)");
        }
    }

    private void validarMes(Integer mes){
        if(mes == null){
            throw new RegraDeNegocioException("É necessário informar o mês");
        }

        if(!(mes >= 1 && mes <= 12)){
            throw new RegraDeNegocioException("Informe o mês corretamente (1 até 12)");
        }
    }

    private void validarAno(Integer ano){
        if(ano == null){
            throw new RegraDeNegocioException("É necessário informar o ano");
        }

        String anoTamanho = String.valueOf(ano);
        if(anoTamanho.length() > 4){
            throw new RegraDeNegocioException("Informe o ano corretamente");
        }
    }

    private void validarHora(Integer hora){
        if(hora == null){
            throw new RegraDeNegocioException("É necessário informar a hora");
        }

        if(!(hora >= 0 && hora <= 24)){
            throw new RegraDeNegocioException(String.format("A hora deve está entre 0 e 24, o valor fornecido %s", hora));
        }
    }

    private void validarMinuto(Integer minuto){
        if(minuto == null){
            throw new RegraDeNegocioException("É necessário informar o minuto");
        }

        if(!(minuto >= 0 && minuto <= 59)){
            throw new RegraDeNegocioException(String.format("O minuto deve está entre 0 e 59, o valor fornecido %s", minuto));
        }
    }

    private void validarSegundo(Integer segundo){
        if(segundo == null){
            throw new RegraDeNegocioException("É necessário informar o segundo");
        }

        if(!(segundo >= 0 && segundo <= 59)){
            throw new RegraDeNegocioException(String.format("O segundo deve está entre 0 e 59, o valor fornecido %s", segundo));
        }
    }

    public String imprimir(Integer formato){

        if(formato == null){
            throw new RegraDeNegocioException("É necessário informar o formato");
        }

        if(!isContemHorario()){
            return getFormatoSemHorario();
        }

        if(formato.equals(1)){
            if(this.hora.equals(0)){
                return getFormatoComHorario("AM", 12);
            } else if(this.hora >= 1 && this.hora < 12){
                return getFormatoComHorario("AM", this.hora);
            } else if(this.hora >= 12 && this.hora < 24){
                return getFormatoComHorario("PM", this.hora + 12 - 24);
            }
        } else if(formato.equals(2)){
            return getFormatoComHorario("", this.hora).trim();
        } else if(!(formato >= 1 && formato <= 2)){
            throw new RegraDeNegocioException("Informe o formato correto");
        }

        return null;
    }

    private boolean isContemHorario(){
        return this.hora != null && this.minuto != null && this.segundo != null;
    }

    private String getFormatoSemHorario(){
        return String.format("%s/%s/%s", this.dia, this.mes, this.ano);
    }

    private String getFormatoComHorario(String tipo, Integer hora){
        return String.format("%s/%s/%s %s:%s:%s %s", this.dia, this.mes, this.ano, hora, this.minuto, this.segundo, tipo);
    }
}
