package br.com.gabrielferreira.posts.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.posts.model.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.DataUtils.*;

public class PostService {

    public Post criarPost(String momento, String titulo, String conteudo, Integer likes){
        LocalDateTime momentoConvertido = validarMomento(momento);
        validarTitulo(titulo);
        validarConteudo(conteudo);
        validarLikes(likes);
        return Post.builder()
                .id(UUID.randomUUID())
                .momento(momentoConvertido)
                .titulo(titulo)
                .conteudo(conteudo)
                .likes(likes)
                .comentarios(new ArrayList<>())
                .build();
    }

    public String imprimirPost(Post post){
        if(post == null){
            throw new RegraDeNegocioException("É necessário informar post");
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(post.getTitulo()).append("\n")
                .append(post.getLikes()).append(" - ").append(toDataHoraBrasil(post.getMomento())).append("\n")
                .append(post.getConteudo()).append("\n");

        if(!post.getComentarios().isEmpty()){
            stringBuilder.append("Comentários : ").append("\n");
            post.getComentarios().forEach(comentarios -> stringBuilder.append(comentarios.getDescricao()).append("\n"));
        }

        return stringBuilder.toString();
    }

    private LocalDateTime validarMomento(String momento){
        if(momento == null || momento.isBlank()){
            throw new RegraDeNegocioException("É necessário informar momento");
        }

        LocalDateTime momentoConvertido = toDataHoraBrasil(momento);

        if(momentoConvertido.isAfter(toDataHoraAtualBrasil())){
            throw new RegraDeNegocioException("O momento não pode ser maior que a data atual");
        }

        return momentoConvertido;
    }

    private void validarTitulo(String titulo){
        if(titulo == null || titulo.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o título");
        }
    }

    private void validarConteudo(String conteudo){
        if(conteudo == null || conteudo.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o conteúdo");
        }
    }

    private void validarLikes(Integer likes){
        if(likes == null){
            throw new RegraDeNegocioException("É necessário informar quantidade de likes");
        }

        if(likes < 0){
            throw new RegraDeNegocioException("Likes não pode ser negativo");
        }
    }
}
