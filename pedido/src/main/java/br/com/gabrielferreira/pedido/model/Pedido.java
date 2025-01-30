package br.com.gabrielferreira.pedido.model;

import br.com.gabrielferreira.pedido.model.enumerations.PedidoStatus;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"cliente", "pedidoItens"})
public class Pedido implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @EqualsAndHashCode.Include
    private UUID id;

    private LocalDateTime momento;

    private PedidoStatus pedidoStatus;

    private Cliente cliente;

    private List<PedidoItens> pedidoItens = new ArrayList<>();

    public BigDecimal getTotal(){
        BigDecimal somaTotal = BigDecimal.ZERO;
        for (PedidoItens item : pedidoItens) {
            somaTotal = somar(item.getSubTotal(), somaTotal);
        }
        return somaTotal;
    }
}
