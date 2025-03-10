package br.com.gabrielferreira.conta.model;

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
public class ContaPessoa implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer numero;

    private String nome;

    private BigDecimal saldo = BigDecimal.ZERO;
}
