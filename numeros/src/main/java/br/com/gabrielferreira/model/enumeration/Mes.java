package br.com.gabrielferreira.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Mes {

    JANEIRO(1),
    FEVEREIRO(2),
    MARCO(3),
    ABRIL(4),
    MAIO(5),
    JUNHO(6),
    JULHO(7),
    AGOSTO(8),
    SETEMBRO(9),
    OUTUBRO(10),
    NOVEMBRO(11),
    DEZEMBRO(12);

    private final Integer codigo;

    public static boolean isFevereiro(Integer valor){
        return FEVEREIRO.getCodigo().equals(valor);
    }
}
