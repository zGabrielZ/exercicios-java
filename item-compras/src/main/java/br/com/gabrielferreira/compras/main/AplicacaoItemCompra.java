package br.com.gabrielferreira.compras.main;

import br.com.gabrielferreira.compras.model.ItemCompra;
import br.com.gabrielferreira.commons.service.ArquivoService;
import br.com.gabrielferreira.compras.service.ItemCompraService;
import lombok.Generated;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static br.com.gabrielferreira.commons.utils.CalculoUtils.toBigDecimal;

@Generated
public class AplicacaoItemCompra {

    private static final String CAMINHO_COMPLETO = System.getProperty("user.home") + "/Downloads/".concat("lista.txt");

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

        System.out.println("Deletando arquivo lista.txt");
        File file = new File(CAMINHO_COMPLETO);
        boolean delete = file.delete();
        System.out.println("Arquivo deletado? " + delete);
    }
}
