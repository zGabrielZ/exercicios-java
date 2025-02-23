package br.com.gabrielferreira.trabalhador.model.enumeration;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TrabalhadorLevel {

    JUNIOR, PLENO, SENIOR;

    public static TrabalhadorLevel toTrabalhadorLevel(String valor){
        for (TrabalhadorLevel trabalhador : TrabalhadorLevel.values()) {
            if(trabalhador.name().equals(valor)){
                return trabalhador;
            }
        }
        throw new RegraDeNegocioException("Senioridade não encontrada");
    }
}
