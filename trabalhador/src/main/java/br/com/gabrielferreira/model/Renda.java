package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Renda implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @EqualsAndHashCode.Include
    private UUID id;

    private LocalDate dataRenda;

    private BigDecimal valor;
}
