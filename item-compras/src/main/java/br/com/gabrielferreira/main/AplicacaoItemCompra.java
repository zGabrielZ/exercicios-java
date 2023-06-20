package br.com.gabrielferreira.main;

import br.com.gabrielferreira.model.ItemCompra;
import br.com.gabrielferreira.service.ArquivoService;
import br.com.gabrielferreira.service.ItemCompraService;
import lombok.Generated;

import java.util.Arrays;
import java.util.List;

import static br.com.gabrielferreira.utils.CalculoUtils.toBigDecimal;

@Generated
public class AplicacaoItemCompra {

    public static void main(String[] args) {
        System.out.println("Iniciando a aplicação item compra");
        ArquivoService arquivoService = new ArquivoService();
        ItemCompraService itemCompraService = new ItemCompraService(arquivoService);

        System.out.println("Criando itens");
        ItemCompra itemCompra1 = itemCompraService.criarItemCompra("Feijão", toBigDecimal(13.30));
        ItemCompra itemCompra2 = itemCompraService.criarItemCompra("Arroz", toBigDecimal(20.10));
        ItemCompra itemCompra3 = itemCompraService.criarItemCompra("Lasanha", toBigDecimal(50.00));
        ItemCompra itemCompra4 = itemCompraService.criarItemCompra("Macarrão", toBigDecimal(6.40));
        ItemCompra itemCompra5 = itemCompraService.criarItemCompra("Laranja", toBigDecimal(8.20));
        ItemCompra itemCompra6 = itemCompraService.criarItemCompra("Abacaxi", toBigDecimal(4.30));

        List<ItemCompra> itemCompras = Arrays.asList(itemCompra1, itemCompra2, itemCompra3, itemCompra4, itemCompra5, itemCompra6);

        System.out.println("Gerando o arquivo");

        itemCompraService.gerarArquivoItemCompra(itemCompras, "lista.txt");
    }
}
