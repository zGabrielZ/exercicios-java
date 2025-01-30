package br.com.gabrielferreira.compras.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.commons.service.ArquivoService;
import br.com.gabrielferreira.compras.model.ItemCompra;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.DataUtils.toDataBrasil;
import static br.com.gabrielferreira.commons.utils.MascarasUtils.valorMonetarioBrasil;
import static br.com.gabrielferreira.commons.utils.LogUtils.*;

@AllArgsConstructor
public class ItemCompraService {

    private ArquivoService arquivoService;

    public ItemCompra criarItemCompra(String nomeProduto, BigDecimal preco){
        validarNomeProduto(nomeProduto);
        validarPreco(preco);

        return ItemCompra.builder()
                .id(UUID.randomUUID())
                .nomeProduto(nomeProduto)
                .preco(preco)
                .dataItemCompra(LocalDateTime.now())
                .build();
    }

    public void gerarArquivoItemCompra(List<ItemCompra> itens, String saida){
        validarItens(itens);
        String texto = gerarConcatenacao(itens);
        arquivoService.gerarArquivoEscrita(texto, System.getProperty("user.home") + "/Downloads/" + saida);
        gerarLogInfo("Arquivo gerado na pasta de downloads");
    }

    private void validarItens(List<ItemCompra> itens){
        if(itens == null || itens.isEmpty()){
            throw new RegraDeNegocioException("É necessário informar pelo menos um item de compra");
        }

        itens.forEach(itemCompra -> {
            if(itemCompra == null){
                throw new RegraDeNegocioException("É necessário informar item compra");
            }
        });
    }

    private String gerarConcatenacao(List<ItemCompra> itens){
        StringBuilder stringBuilder = new StringBuilder();
        itens.forEach(item -> stringBuilder
                .append("ID : ")
                .append(item.getId())
                .append(" - ")
                .append("Nome do produto : ")
                .append(item.getNomeProduto())
                .append(" - ")
                .append("Preço : ")
                .append(valorMonetarioBrasil(item.getPreco()))
                .append(" - ")
                .append("Data da compra : ")
                .append(toDataBrasil(item.getDataItemCompra()))
                .append("\n"));
        return stringBuilder.toString().trim();
    }

    private void validarNomeProduto(String nomeProduto){
        if(nomeProduto == null || nomeProduto.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o nome do produto");
        }
    }

    private void validarPreco(BigDecimal preco){
        if(preco == null){
            throw new RegraDeNegocioException("É necessário informar preço");
        }
    }
}
