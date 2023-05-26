package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidarNumeroPrimo.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class NumeroPrimo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1163211115637737045L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private UUID id;

    @Getter
    @Setter
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
