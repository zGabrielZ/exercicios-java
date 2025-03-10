package br.com.gabrielferreira.escola.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Prova implements Serializable {

    @Serial
    private static final long serialVersionUID = 9162731473093293178L;

    @EqualsAndHashCode.Include
    private UUID id;

    private String nome;

    private BigDecimal nota;

    private Peso peso;
}
