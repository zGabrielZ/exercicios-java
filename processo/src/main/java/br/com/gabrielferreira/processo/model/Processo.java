package br.com.gabrielferreira.processo.model;

import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
public class Processo implements Serializable {

    @Serial
    private static final long serialVersionUID = -8501676006915527338L;

    public String processar(String parametro){
        if(parametro == null || parametro.equals("")){
            return null;
        }

        if(parametro.length() <= 3){
            return parametro.toUpperCase();
        }

        StringBuilder stringBuilder = new StringBuilder();
        String maiusculo = parametro.toUpperCase();
        stringBuilder.append(maiusculo, 0, 3).reverse();
        return stringBuilder.append(maiusculo.substring(3)).toString();
    }
}
