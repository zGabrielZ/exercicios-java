package br.com.gabrielferreira.produto.main;

import br.com.gabrielferreira.produto.model.Produto;
import br.com.gabrielferreira.produto.model.ProdutoImportado;
import br.com.gabrielferreira.produto.model.ProdutoUsado;
import lombok.Generated;

import java.util.UUID;
import static br.com.gabrielferreira.commons.utils.CalculoUtils.*;
import static br.com.gabrielferreira.commons.utils.DataUtils.*;

@Generated
public class AplicacaoProdutoImportado {

    public static void main(String[] args) {
        Produto produtoComum = new Produto(UUID.randomUUID(), "Notebook", toBigDecimal(1100.00));
        Produto produtoImportado = new ProdutoImportado(UUID.randomUUID(), "Tablet", toBigDecimal(260.00), toBigDecimal(20.00));
        Produto produtoUsado = new ProdutoUsado(UUID.randomUUID(), "Iphone", toBigDecimal(400.00), toDataBrasil("15/03/2017"));

        System.out.println("Preços : ");
        System.out.println(produtoComum.getPrecoTag());
        System.out.println(produtoImportado.getPrecoTag());
        System.out.println(produtoUsado.getPrecoTag());
    }
}
