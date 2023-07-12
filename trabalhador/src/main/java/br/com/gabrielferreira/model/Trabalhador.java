package br.com.gabrielferreira.model;

import br.com.gabrielferreira.model.enumeration.TrabalhadorLevel;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Trabalhador implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @EqualsAndHashCode.Include
    private UUID id;

    private String nome;

    private TrabalhadorLevel trabalhadorLevel;

    private BigDecimal salario = BigDecimal.ZERO;

    private List<ContratoHora> contratoHoras = new ArrayList<>();

    private Departamento departamento;

    private Renda renda;

    public void adicionarContratoHoras(ContratoHora contratoHora){
        this.contratoHoras.add(contratoHora);
    }
}
