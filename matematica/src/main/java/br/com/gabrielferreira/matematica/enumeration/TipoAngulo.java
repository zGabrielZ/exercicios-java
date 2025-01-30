package br.com.gabrielferreira.matematica.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoAngulo {

    GRAUS,
    RADIANOS;

    public static boolean isGraus(TipoAngulo tipoAngulo){
        return tipoAngulo.name().equals(GRAUS.name());
    }

    public static boolean isRadianos(TipoAngulo tipoAngulo){
        return tipoAngulo.name().equals(RADIANOS.name());
    }
}
