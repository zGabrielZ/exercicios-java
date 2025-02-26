package br.com.gabrielferreira.produto.main;

import br.com.gabrielferreira.commons.service.ArquivoService;
import br.com.gabrielferreira.produto.service.ProdutoService;
import lombok.Generated;

import java.io.File;

import static br.com.gabrielferreira.commons.utils.LogUtils.gerarLogWarn;

@Generated
public class AplicacaoProdutoArquivoCSV {

    private static final String CAMINHO_COMPLETO = System.getProperty("user.home") + "/Downloads/".concat("sumario-resultado.csv");

    public static void main(String[] args) {
        ProdutoService produtoService = new ProdutoService(new ArquivoService());

        try {
            String caminho = "sumario.csv";
            produtoService.gerarArquivoCsv(caminho, "sumario-resultado.csv");
        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        System.out.println("Deletando arquivo sumario-resultado.csv");
        File file = new File(CAMINHO_COMPLETO);
        boolean delete = file.delete();
        System.out.println("Arquivo deletado? " + delete);
    }
}
