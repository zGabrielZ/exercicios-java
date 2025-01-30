package br.com.gabrielferreira.posts.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.posts.model.Comentarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComentariosServiceTest {

    private ComentariosService comentariosService;

    @BeforeEach
    public void criarInstancias(){
        comentariosService = new ComentariosService();
    }

    @Test
    @DisplayName("Deve validar comentário quando não informar")
    void deveValidarComentario(){
        String comentario = null;
        assertThrows(RegraDeNegocioException.class, () -> comentariosService.criarComentarios(comentario));
    }

    @Test
    @DisplayName("Deve criar comentário")
    void deveCriarComentario(){
        Comentarios comentarios = comentariosService.criarComentarios("Que legal");

        assertNotNull(comentarios.getId());
        assertEquals("Que legal", comentarios.getDescricao());
    }


}
