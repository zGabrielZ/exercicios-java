package br.com.gabrielferreira.main;

import br.com.gabrielferreira.service.PessoaService;
import lombok.Generated;

import static br.com.gabrielferreira.utils.LogUtils.gerarLogWarn;

@Generated
public class AplicacaoPessoasLogs {

    public static void main(String[] args) {

        PessoaService pessoaService = new PessoaService();

        try {
            System.out.println("Informe o caminho inteiro do arquivo : ");
            String caminho = "D:\\TXT\\nomes-pessoas.txt";

            Integer quantidadeUsuario = pessoaService.totalUsuarioLog(caminho);
            System.out.println("Quantidade de Usuários : " + quantidadeUsuario);

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }
    }
}
