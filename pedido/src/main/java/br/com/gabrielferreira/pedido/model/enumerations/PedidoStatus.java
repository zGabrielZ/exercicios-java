package br.com.gabrielferreira.pedido.model.enumerations;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PedidoStatus {

    PAGAMENTO_PENDENTE,
    PROCESSANDO,
    PAGO,
    ENTREGUE;

    public static PedidoStatus toPedidoStatus(String status){
        for (PedidoStatus pedidoStatus : PedidoStatus.values()) {
            if(pedidoStatus.name().equals(status)){
                return pedidoStatus;
            }
        }
        throw new RegraDeNegocioException("Pedido status informado não encontrado");
    }
}
