package br.com.gabrielferreira.pedido.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.pedido.model.Cliente;
import br.com.gabrielferreira.pedido.model.Pedido;
import br.com.gabrielferreira.pedido.model.PedidoItens;
import br.com.gabrielferreira.pedido.model.Produto;
import br.com.gabrielferreira.pedido.model.enumerations.PedidoStatus;

import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.DataUtils.*;
import static br.com.gabrielferreira.commons.utils.MascarasUtils.valorMonetarioBrasil;

public class PedidoService {

    public PedidoItens criarPedidoItens(Produto produto, Integer quantidade){
        validarProduto(produto);
        validarQuantidade(quantidade);
        return PedidoItens.builder()
                .id(UUID.randomUUID())
                .quantidade(quantidade)
                .preco(produto.getPreco())
                .produto(produto)
                .build();
    }

    public Pedido criarPedido(String status, Cliente cliente, List<PedidoItens> pedidoItens){
        PedidoStatus pedidoStatus = validarStatus(status);
        validarCliente(cliente);
        validarPedidoItens(pedidoItens);
        return Pedido.builder()
                .id(UUID.randomUUID())
                .momento(toDataHoraAtualBrasil())
                .cliente(cliente)
                .pedidoItens(pedidoItens)
                .pedidoStatus(pedidoStatus)
                .build();
    }

    public String imprimirPedido(Pedido pedido){
        if(pedido == null){
            throw new RegraDeNegocioException("É necessário informar pedido");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dados do pedido : ").append("\n");
        stringBuilder.append("Data do pedido : ").append(toDataHoraBrasil(pedido.getMomento())).append("\n");
        stringBuilder.append("Status do pedido : ").append(pedido.getPedidoStatus().name()).append("\n");
        stringBuilder.append("Cliente : ").append(pedido.getCliente().getNome())
                .append(" (").append(toDataBrasil(pedido.getCliente().getDataNascimento())).append(") - ")
                .append(pedido.getCliente().getEmail()).append("\n");

        if(!pedido.getPedidoItens().isEmpty()){
            stringBuilder.append("Lista dos pedidos : ").append("\n");
            for (PedidoItens pedidoItem : pedido.getPedidoItens()) {
                stringBuilder.append(pedidoItem.getProduto().getNome())
                        .append(", ").append(valorMonetarioBrasil(pedidoItem.getPreco()))
                        .append(", ").append("Quantidade : ").append(pedidoItem.getQuantidade())
                        .append(", ").append("Subtotal : ").append(valorMonetarioBrasil(pedidoItem.getSubTotal()))
                        .append("\n");
            }
        }

        stringBuilder.append("Preço total : ").append(valorMonetarioBrasil(pedido.getTotal()));
        return stringBuilder.toString();
    }

    private PedidoStatus validarStatus(String status){
        if(status == null || status.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o status do pedido");
        }

        return PedidoStatus.toPedidoStatus(status);
    }

    private void validarCliente(Cliente cliente){
        if(cliente == null){
            throw new RegraDeNegocioException("É necessário informar o cliente");
        }
    }

    private void validarPedidoItens(List<PedidoItens> pedidoItens){
        if(pedidoItens == null || pedidoItens.isEmpty()){
            throw new RegraDeNegocioException("É necessário informar os itens do pedido");
        }
    }

    private void validarProduto(Produto produto){
        if(produto == null){
            throw new RegraDeNegocioException("É necessário informar produto");
        }
    }

    private void validarQuantidade(Integer quantidade){
        if(quantidade == null){
            throw new RegraDeNegocioException("É necessário informar quantidade");
        }

        if(quantidade < 0){
            throw new RegraDeNegocioException("Quantidade não pode ser negativa");
        }
    }
}
