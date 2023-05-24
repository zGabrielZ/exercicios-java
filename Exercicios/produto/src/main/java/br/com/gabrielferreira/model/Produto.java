package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Produto implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private UUID id;

    @Getter
    @Setter
    private Integer codigo;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private BigDecimal peso = BigDecimal.ZERO;

    @Setter
    @Getter
    private LocalDate dataValidade;
}
