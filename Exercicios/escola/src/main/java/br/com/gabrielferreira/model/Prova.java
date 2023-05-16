package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Prova implements Serializable {

    @Serial
    private static final long serialVersionUID = 9162731473093293178L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private UUID id;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private BigDecimal nota;

    @Getter
    @Setter
    private Peso peso;
}
