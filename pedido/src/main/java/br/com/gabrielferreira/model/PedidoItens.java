package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import static br.com.gabrielferreira.utils.CalculoUtils.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"produto"})
public class PedidoItens implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer quantidade;

    private BigDecimal preco;

    private Produto produto;

    public BigDecimal getSubTotal(){
        return multiplicar(preco, toBigDecimal(quantidade));
    }
}
