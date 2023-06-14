package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Autor;
import br.com.gabrielferreira.model.Livro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static br.com.gabrielferreira.utils.DataUtils.toDataAtualBrasil;
import static br.com.gabrielferreira.utils.DataUtils.toDataBrasil;
import static org.junit.jupiter.api.Assertions.*;

class AutorServiceTest {

    private AutorService autorService;

    private static final String NOME_ARQUIVO = "autores-test.txt";
    private static final String CAMINHO_COMPLETO = System.getProperty("user.home") + "/Downloads/" + NOME_ARQUIVO;

    @BeforeEach
    public void criarInstancias(){
        autorService = new AutorService(new ArquivoService());
    }

    @Test
    @DisplayName("Deve validar lista de autores quando não informar nada")
    void deveValidarAutoresLista(){
        List<Autor> autores = new ArrayList<>();
        assertThrows(RegraDeNegocioException.class, () -> autorService.gerarArquivoAutores(autores, NOME_ARQUIVO));
    }

    @Test
    @DisplayName("Deve validar autor quando informar nulo")
    void deveValidarAutorNulo(){
        List<Autor> autores = new ArrayList<>();
        Autor autor = null;
        autores.add(autor);
        assertThrows(RegraDeNegocioException.class, () -> autorService.gerarArquivoAutores(autores, NOME_ARQUIVO));
    }

    @Test
    @DisplayName("Deve validar nome do autor quando não informar nada")
    void deveValidarNomeAutor(){
        List<Autor> autores = new ArrayList<>();
        autores.add(Autor.builder().nome("").build());
        assertThrows(RegraDeNegocioException.class, () -> autorService.gerarArquivoAutores(autores, NOME_ARQUIVO));
    }

    @Test
    @DisplayName("Deve validar data nascimento do autor quando não informar nada")
    void deveValidarDataNascimentoAutor(){
        List<Autor> autores = new ArrayList<>();
        autores.add(Autor.builder().nome("Gabriel").dataNascimento(null).build());
        assertThrows(RegraDeNegocioException.class, () -> autorService.gerarArquivoAutores(autores, NOME_ARQUIVO));
    }

    @Test
    @DisplayName("Deve validar data nascimento do autor quando for maior que a data atual")
    void deveValidarDataNascimentoDataAtual(){
        List<Autor> autores = new ArrayList<>();
        autores.add(Autor.builder().nome("Gabriel").dataNascimento(toDataAtualBrasil().plusDays(5)).build());
        assertThrows(RegraDeNegocioException.class, () -> autorService.gerarArquivoAutores(autores, NOME_ARQUIVO));
    }

    @Test
    @DisplayName("Deve validar livros do autor quando não informar nada")
    void deveValidarLivrosLista(){
        List<Autor> autores = new ArrayList<>();
        autores.add(Autor.builder().nome("Gabriel").dataNascimento(toDataBrasil("26/12/1997")).livros(new ArrayList<>()).build());
        assertThrows(RegraDeNegocioException.class, () -> autorService.gerarArquivoAutores(autores, NOME_ARQUIVO));
    }

    @Test
    @DisplayName("Deve validar livro do autor quando informar nulo")
    void deveValidarLivrosNulo(){
        List<Autor> autores = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();
        Livro livro = null;
        livros.add(livro);
        autores.add(Autor.builder().nome("Gabriel").dataNascimento(toDataBrasil("26/12/1997")).livros(livros).build());
        assertThrows(RegraDeNegocioException.class, () -> autorService.gerarArquivoAutores(autores, NOME_ARQUIVO));
    }

    @Test
    @DisplayName("Deve validar título livro do autor quando informar nada")
    void deveValidarTituloLivro(){
        List<Autor> autores = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();
        Livro livro = Livro.builder().titulo("").numeroPaginas(1).build();
        livros.add(livro);
        autores.add(Autor.builder().nome("Gabriel").dataNascimento(toDataBrasil("26/12/1997")).livros(livros).build());
        assertThrows(RegraDeNegocioException.class, () -> autorService.gerarArquivoAutores(autores, NOME_ARQUIVO));
    }

    @Test
    @DisplayName("Deve validar números paginas do livro do autor quando informar nada")
    void deveValidarNumeroPaginasLivro(){
        List<Autor> autores = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();
        Livro livro = Livro.builder().titulo("Livro do Gabriel").numeroPaginas(null).build();
        livros.add(livro);
        autores.add(Autor.builder().nome("Gabriel").dataNascimento(toDataBrasil("26/12/1997")).livros(livros).build());
        assertThrows(RegraDeNegocioException.class, () -> autorService.gerarArquivoAutores(autores, NOME_ARQUIVO));
    }

    @Test
    @DisplayName("Deve gerar arquivo do livro quando informar corretamente")
    void deveGerarArquivoLivro(){
        List<Autor> autores = new ArrayList<>();
        Autor autor1 = Autor.builder().nome("Gabriel").dataNascimento(toDataBrasil("26/12/1997")).build();
        List<Livro> livros1 = new ArrayList<>();
        livros1.add(Livro.builder().titulo("Livro do gabriel 1").numeroPaginas(123).build());
        livros1.add(Livro.builder().titulo("Livro do gabriel 2").numeroPaginas(144).build());
        livros1.add(Livro.builder().titulo("Livro do gabriel 3").numeroPaginas(200).build());
        autor1.setLivros(livros1);

        Autor autor2 = Autor.builder().nome("Mariana").dataNascimento(toDataBrasil("21/10/1995")).build();
        List<Livro> livros2 = new ArrayList<>();
        livros2.add(Livro.builder().titulo("Livro da mariana 1").numeroPaginas(123).build());
        livros2.add(Livro.builder().titulo("Livro do mariana 2").numeroPaginas(144).build());
        livros2.add(Livro.builder().titulo("Livro do mariana 3").numeroPaginas(200).build());
        autor2.setLivros(livros2);

        autores.add(autor1);
        autores.add(autor2);

        autorService.gerarArquivoAutores(autores, NOME_ARQUIVO);

        File file = new File(CAMINHO_COMPLETO);
        assertTrue(file.exists());

        file.delete();
    }

    @Test
    @DisplayName("Deve validar a leitura de arquivo quando não informar a entrada")
    void deveValidarEntradaNaLeituraArquivo(){
        String entrada = "";
        assertThrows(RegraDeNegocioException.class, () -> autorService.lerArquivoAutores(entrada));
    }

    @Test
    @DisplayName("Deve validar a leitura de arquivo quando informar a entrada incorreta")
    void deveValidarEntradaIncorretaNaLeituraArquivo(){
        String entrada = "autores22222-test.txt";
        assertThrows(RegraDeNegocioException.class, () -> autorService.lerArquivoAutores(entrada));
    }

    @Test
    @DisplayName("Deve realizar a leitura de arquivo quando informar a entrada correta")
    void deveLerArquivo(){
        List<Autor> autores = new ArrayList<>();
        Autor autor1 = Autor.builder().nome("Gabriel").dataNascimento(toDataBrasil("26/12/1997")).build();
        List<Livro> livros1 = new ArrayList<>();
        livros1.add(Livro.builder().titulo("Livro do gabriel 1").numeroPaginas(123).build());
        autor1.setLivros(livros1);
        autores.add(autor1);

        autorService.gerarArquivoAutores(autores, NOME_ARQUIVO);

        String entrada = autorService.lerArquivoAutores(CAMINHO_COMPLETO);

        assertNotNull(entrada);

        File file = new File(CAMINHO_COMPLETO);
        file.delete();
    }
}
