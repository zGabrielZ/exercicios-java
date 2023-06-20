package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

import static br.com.gabrielferreira.model.Constantes.FORMATO_12H;
import static br.com.gabrielferreira.model.Constantes.FORMATO_24H;
import static br.com.gabrielferreira.validate.ValidarData.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Data implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    private static final Integer MEIA_NOITE = 0;
    private static final Integer DOZE_HORAS = 12;
    private static final Integer UMA_HORA = 1;
    private static final Integer VINTE_QUATRO_HORAS = 24;
    private static final String FORMATO_AM = "AM";
    private static final String FORMATO_PM = "PM";


    @EqualsAndHashCode.Include
    @Getter
    private final UUID id;

    @Getter
    private final Integer dia;

    @Getter
    private final Integer mes;

    @Getter
    private final Integer ano;

    @Getter
    private Integer hora;

    @Getter
    private Integer minuto;

    @Getter
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

    public String imprimir(Integer formato){

        validarValorInformado(formato, "É necessário informar o formato");

        if(!isContemHorario()){
            return getFormatoSemHorario();
        }

        if(formato.equals(FORMATO_12H)){
            if(this.hora.equals(MEIA_NOITE)){
                return getFormatoComHorario(FORMATO_AM, DOZE_HORAS);
            } else if(this.hora >= UMA_HORA && this.hora < DOZE_HORAS){
                return getFormatoComHorario(FORMATO_AM, this.hora);
            } else if(this.hora >= DOZE_HORAS && this.hora < VINTE_QUATRO_HORAS){
                return getFormatoComHorario(FORMATO_PM, this.hora + DOZE_HORAS - VINTE_QUATRO_HORAS);
            }
        } else if(formato.equals(FORMATO_24H)){
            return getFormatoComHorario("", this.hora).trim();
        } else if(!(formato >= FORMATO_12H && formato <= FORMATO_24H)){
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
