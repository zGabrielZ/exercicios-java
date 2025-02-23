package br.com.gabrielferreira.numeros.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.numeros.validate.ValidarNumeroPrimo.validarValorInformado;
import static br.com.gabrielferreira.numeros.validate.ValidarNumeroPrimo.validarValorLimite;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class NumeroPrimo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1163211115637737045L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer valor;

    public boolean isNumeroPrimo(){
        validarValorInformado(valor);
        validarValorLimite(valor);

        List<Integer> valoresDividos = new ArrayList<>();
        for(int i = 1; i <= valor; i++){
            if(valor % i == 0){
                valoresDividos.add(i);
            }
        }

        return (valoresDividos.size() == 2) && valoresDividos.contains(1) && valoresDividos.contains(valor);
    }
}
