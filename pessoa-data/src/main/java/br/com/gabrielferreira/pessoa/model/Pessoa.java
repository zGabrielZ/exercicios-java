package br.com.gabrielferreira.pessoa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.DataUtils.toDataAtualBrasil;
import static br.com.gabrielferreira.pessoa.validate.ValidarDataNascimento.validarData;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Pessoa implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @Getter
    @EqualsAndHashCode.Include
    private final UUID id;

    @Getter
    private final LocalDate dataNascimento;

    public Pessoa(UUID id, LocalDate dataNascimento){
        validarData(dataNascimento);
        this.id = id;
        this.dataNascimento = dataNascimento;
    }

    public String calcularAnos(){
        long anos = ChronoUnit.YEARS.between(dataNascimento, toDataAtualBrasil());
        return anos + " anos";
    }

    public String calcularMeses(){
        long meses = ChronoUnit.MONTHS.between(dataNascimento, toDataAtualBrasil());
        return meses + " meses";
    }

    public String calcularDias(){
        long dias = ChronoUnit.DAYS.between(dataNascimento, toDataAtualBrasil());
        return dias + " dias";
    }
}
