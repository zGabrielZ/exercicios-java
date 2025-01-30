package br.com.gabrielferreira.pessoas.main;

import br.com.gabrielferreira.commons.service.ArquivoService;
import br.com.gabrielferreira.pessoas.service.PessoaService;
import lombok.Generated;

import static br.com.gabrielferreira.commons.utils.LogUtils.*;

@Generated
public class AplicacaoPessoasLogs {

    public static void main(String[] args) {
        PessoaService pessoaService = new PessoaService(new ArquivoService());

        try {
            System.out.println("Informe o caminho inteiro do arquivo : ");
            String caminho = "nomes-pessoas.txt";

            Integer quantidadeUsuario = pessoaService.totalUsuarioLog(caminho);
            System.out.println("Quantidade de Usuários : " + quantidadeUsuario);

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }
    }
}
