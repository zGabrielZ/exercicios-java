package br.com.gabrielferreira.autor.service;

import br.com.gabrielferreira.autor.model.Autor;
import br.com.gabrielferreira.autor.model.Livro;
import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.commons.service.ArquivoService;
import lombok.AllArgsConstructor;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.DataUtils.toDataAtualBrasil;
import static br.com.gabrielferreira.commons.utils.DataUtils.toDataBrasil;

@AllArgsConstructor
public class AutorService {

    private ArquivoService arquivoService;

    public void gerarArquivoAutores(List<Autor> autores, String saida){
        validarAutores(autores);

        autores.forEach(autor -> {
            validarNomeAutor(autor.getNome());
            validarDataNascimento(autor.getDataNascimento(), autor.getNome());
            validarLivros(autor.getLivros(), autor.getNome());

            autor.setId(UUID.randomUUID());
        });

        arquivoService.gerarArquivoEscrita(gerarConcatenacaoAutores(autores), System.getProperty("user.home") + "/Downloads/" + saida);
    }

    public String lerArquivoAutores(String entrada){
        if(entrada == null || entrada.isBlank()){
            throw new RegraDeNegocioException("É necessário informar a saída");
        }

        File file = new File(entrada);
        if(!file.exists()){
            throw new RegraDeNegocioException("Arquivo não encontrado");
        }

        return arquivoService.lerArquivo(entrada);
    }

    private String gerarConcatenacaoAutores(List<Autor> autores){
        StringBuilder stringBuilder = new StringBuilder();
        autores.forEach(autor -> {
            stringBuilder
                    .append("ID : ")
                    .append(autor.getId())
                    .append(" - ")
                    .append("Nome do autor : ")
                    .append(autor.getNome())
                    .append(" - ")
                    .append("Data de nascimento : ")
                    .append(toDataBrasil(autor.getDataNascimento()))
                    .append("\n");

            stringBuilder.append("Livros do autor ou autora ").append(autor.getNome()).append(" : ").append("\n");
            autor.getLivros().forEach(livro -> stringBuilder
                    .append("ID : ")
                    .append(livro.getId())
                    .append(" - ")
                    .append("Título : ")
                    .append(livro.getTitulo())
                    .append(" - ")
                    .append("Número de páginas : ")
                    .append(livro.getNumeroPaginas())
                    .append("\n"));

            stringBuilder.append("\n\n");
        });
        return stringBuilder.toString().trim();
    }

    private void validarAutores(List<Autor> autores){
        if(autores == null || autores.isEmpty()){
            throw new RegraDeNegocioException("É necessário informar pelo menos um autor");
        }

        autores.forEach(autor -> {
            if(autor == null){
                throw new RegraDeNegocioException("É necessário informar o autor");
            }
        });
    }

    private void validarNomeAutor(String nomeAutor){
        if(nomeAutor == null || nomeAutor.isBlank()){
            throw new RegraDeNegocioException("É necessário informar pelo menos o autor");
        }
    }

    private void validarDataNascimento(LocalDate dataNascimento, String nomeAutor){
        if(dataNascimento == null){
            throw new RegraDeNegocioException(String.format("É necessário informar pelo menos a data de nascimento do %s", nomeAutor));
        }

        if(dataNascimento.isAfter(toDataAtualBrasil())){
            throw new RegraDeNegocioException(String.format("A data de nascimento do autor %s tem que ser menor que a data atual", nomeAutor));
        }
    }

    private void validarLivros(List<Livro> livros, String nomeAutor){
        if(livros == null || livros.isEmpty()){
            throw new RegraDeNegocioException(String.format("É necessário informar pelo menos um livro do autor ou autora %s", nomeAutor));
        }

        livros.forEach(livro -> {
            if(livro == null){
                throw new RegraDeNegocioException(String.format("É necessário informar o livro do autor ou autora %s", nomeAutor));
            }

            validarTituloLivro(livro.getTitulo(), nomeAutor);
            validarNumeroPaginas(livro.getNumeroPaginas(), nomeAutor);

            livro.setId(UUID.randomUUID());
        });
    }

    private void validarTituloLivro(String tituloLivro, String nomeAutor){
        if(tituloLivro == null || tituloLivro.isBlank()){
            throw new RegraDeNegocioException(String.format("É necessário informar pelo menos o título do livro do autor ou autora %s", nomeAutor));
        }
    }

    private void validarNumeroPaginas(Integer numeroPaginas, String nomeAutor){
        if(numeroPaginas == null){
            throw new RegraDeNegocioException(String.format("É necessário informar pelo menos o número de páginas do autor ou autora %s", nomeAutor));
        }
    }
}
