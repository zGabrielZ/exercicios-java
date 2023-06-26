package br.com.gabrielferreira.model;

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
public class Retangulo implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @EqualsAndHashCode.Include
    private UUID id;

    private BigDecimal largura;

    private BigDecimal altura;

    private BigDecimal area = BigDecimal.ZERO;

    private BigDecimal perimetro = BigDecimal.ZERO;

    private BigDecimal diagonal = BigDecimal.ZERO;
}
