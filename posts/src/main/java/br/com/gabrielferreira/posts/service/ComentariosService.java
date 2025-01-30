package br.com.gabrielferreira.posts.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.posts.model.Comentarios;
import java.util.UUID;

public class ComentariosService {

    public Comentarios criarComentarios(String comentarios){
        validarComentarios(comentarios);
        return Comentarios.builder()
                .id(UUID.randomUUID())
                .descricao(comentarios)
                .build();
    }

    private void validarComentarios(String comentarios){
        if(comentarios == null || comentarios.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o comentário");
        }
    }
}
