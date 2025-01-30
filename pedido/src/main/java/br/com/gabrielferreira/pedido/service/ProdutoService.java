package br.com.gabrielferreira.pedido.service;
import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.pedido.model.Produto;
import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoService {

    public Produto criarProduto(String nome, BigDecimal preco){
        validarNome(nome);
        validarPreco(preco);
        return Produto.builder()
                .id(UUID.randomUUID())
                .nome(nome)
                .preco(preco)
                .build();
    }

    private void validarNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o nome");
        }
    }

    private void validarPreco(BigDecimal preco){
        if(preco == null){
            throw new RegraDeNegocioException("É necessário informar o preço");
        }

        if(preco.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException("Preço não pode ser negativo");
        }
    }
}
