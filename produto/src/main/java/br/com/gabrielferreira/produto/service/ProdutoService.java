package br.com.gabrielferreira.produto.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.produto.model.Produto;
import br.com.gabrielferreira.produto.utils.PesoCrescenteComparatorUtils;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static br.com.gabrielferreira.commons.utils.DataUtils.toDataBrasil;

public class ProdutoService {

    private final List<Produto> produtos;

    public ProdutoService(){
        produtos = new ArrayList<>();
    }

    public String criarProdutos(List<Produto> produtos){
        validarProdutos(produtos);

        StringBuilder sb = new StringBuilder();

        int codigoGerado = 1;
        for (Produto produto : produtos) {
            validarProduto(produto);
            validarNomeProduto(produto.getNome());
            validarPesoProduto(produto.getPeso());
            validarDataProduto(produto.getDataValidade());

            produto.setCodigo(codigoGerado);
            gerarRetorno(sb, produto);

            codigoGerado++;
            this.produtos.add(produto);
        }

        return sb.toString();
    }

    public List<Produto> imprimirProdutosOrdemCrescentePeso(){
        if(produtos.isEmpty()){
            return new ArrayList<>();
        }

        produtos.sort(new PesoCrescenteComparatorUtils());
        return produtos;
    }

    public void limparProdutos(){
        this.produtos.clear();
    }

    private void validarProdutos(List<Produto> produtos){
        if(produtos == null || produtos.isEmpty()){
            throw new RegraDeNegocioException("É necessário informar pelo menos um produto");
        }
    }

    private void validarProduto(Produto produto){
        if(produto == null){
            throw new RegraDeNegocioException("É necessário informar o produto");
        }
    }

    private void validarNomeProduto(String nome){
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o nome do produto");
        } else if(!(nome.length() >= 1 && nome.length() <= 12)){
            throw new RegraDeNegocioException("Quantidade de caracteres do produto é de 1 até 12");
        }
    }

    private void validarPesoProduto(BigDecimal peso){
        if(peso == null){
            throw new RegraDeNegocioException("É necessário informar o peso");
        } else if(peso.compareTo(BigDecimal.ZERO) < 0){
            throw new RegraDeNegocioException("Não pode inserir peso com valor negativo");
        }
    }

    private void validarDataProduto(LocalDate data){
        if(data == null){
            throw new RegraDeNegocioException("É necessário informar a data do produto");
        }
    }

    private void gerarRetorno(StringBuilder sb, Produto produto){
        sb.append(produto.getCodigo())
                .append(") ")
                .append(formatarNome(produto.getNome()))
                .append(" ")
                .append(formatarPeso(produto.getPeso()))
                .append(" ")
                .append(toDataBrasil(produto.getDataValidade()))
                .append("\n");
    }

    private String formatarNome(String nome){
        return String.format("%12s", nome);
    }

    private String formatarPeso(BigDecimal peso){
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');

        DecimalFormat decimalFormat = new DecimalFormat("000000.00", decimalFormatSymbols);
        return decimalFormat.format(peso);
    }
}
