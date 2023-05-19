package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import lombok.*;

import static br.com.gabrielferreira.validate.ValidarData.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Data implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

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
