package br.com.gabrielferreira.autor.main;

import br.com.gabrielferreira.autor.model.Autor;
import br.com.gabrielferreira.autor.model.Livro;
import br.com.gabrielferreira.commons.service.ArquivoService;
import br.com.gabrielferreira.autor.service.AutorService;
import lombok.Generated;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static br.com.gabrielferreira.commons.utils.DataUtils.toDataBrasil;
import static br.com.gabrielferreira.commons.utils.LogUtils.*;

@Generated
public class AplicacaoAutor {

    private static final String CAMINHO_COMPLETO = System.getProperty("user.home") + "/Downloads/".concat("autores.txt");

    public static void main(String[] args) {
        AutorService autorService = new AutorService(new ArquivoService());

        System.out.println("Criando autores");
        List<Livro> livros1 = new ArrayList<>();
        livros1.add(Livro.builder().titulo("Livro do josé 1").numeroPaginas(123).build());
        livros1.add(Livro.builder().titulo("Livro do josé 2").numeroPaginas(144).build());
        livros1.add(Livro.builder().titulo("Livro do josé 3").numeroPaginas(200).build());

        Autor autor1 = Autor.builder()
                .nome("José")
                .dataNascimento(toDataBrasil("20/12/2000"))
                .livros(livros1)
                .build();

        List<Livro> livros2 = new ArrayList<>();
        livros2.add(Livro.builder().titulo("Livro do marcos 1").numeroPaginas(440).build());
        livros2.add(Livro.builder().titulo("Livro do marcos 2").numeroPaginas(288).build());
        livros2.add(Livro.builder().titulo("Livro do marcos 3").numeroPaginas(300).build());

        Autor autor2 = Autor.builder()
                .nome("Marcos")
                .dataNascimento(toDataBrasil("01/12/1995"))
                .livros(livros2)
                .build();

        try {
            autorService.gerarArquivoAutores(Arrays.asList(autor1, autor2), "autores.txt");
        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação para gerar arquivo dos autores. Causa {}", e);
        }

        System.out.println();
        System.out.println("Lendo o nosso arquivo gerado pelo console");
        System.out.println();

        try {
            String caminhoGerado = System.getProperty("user.home") + "/Downloads/" + "autores.txt";
            System.out.println(autorService.lerArquivoAutores(caminhoGerado));
        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        System.out.println("Deletando arquivo agenda.txt");
        File file = new File(CAMINHO_COMPLETO);
        boolean delete = file.delete();
        System.out.println("Arquivo deletado? " + delete);
    }
}
