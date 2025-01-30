package br.com.gabrielferreira.jogos.model;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Jogo implements Serializable {

    @Serial
    private static final long serialVersionUID = -1083799102490754440L;

    @EqualsAndHashCode.Include
    private UUID id;

    private String nome;

    private BigDecimal preco;
}
