package br.com.gabrielferreira.service;
import br.com.gabrielferreira.exception.ErroInesperadoException;
import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Comentarios;
import br.com.gabrielferreira.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.DataUtils.*;

class PostServiceTest {

    private PostService postService;

    private ComentariosService comentariosService;

    @BeforeEach
    public void criarInstancias(){
        postService = new PostService();
        comentariosService = new ComentariosService();
    }

    @Test
    @DisplayName("Deve validar momento quando não informar")
    void deveValidarMomentoQuandoTiverNulo(){
        String momemnto = null;
        String titulo = "Viagem para Nova Zelandia";
        String conteudo = "Adorei este lindo país";
        Integer likes = 12;
        assertThrows(RegraDeNegocioException.class, () -> postService.criarPost(momemnto, titulo, conteudo, likes));
    }

    @Test
    @DisplayName("Deve validar momento quando tiver no formato errado")
    void deveValidarMomentoQuandoTiverFormatoErrado(){
        String momemnto = "12";
        String titulo = "Viagem para Nova Zelandia";
        String conteudo = "Adorei este lindo país";
        Integer likes = 12;
        assertThrows(ErroInesperadoException.class, () -> postService.criarPost(momemnto, titulo, conteudo, likes));
    }

    @Test
    @DisplayName("Deve validar momento quando tiver maior que data atual")
    void deveValidarMomentoQuandoTiverMaiorQueDataAtual(){
        String momento = toDataHoraBrasil(LocalDateTime.now().plusDays(5L));
        String titulo = "Viagem para Nova Zelandia";
        String conteudo = "Adorei este lindo país";
        Integer likes = 12;
        assertThrows(RegraDeNegocioException.class, () -> postService.criarPost(momento, titulo, conteudo, likes));
    }

    @Test
    @DisplayName("Deve validar titulo quando não informar")
    void deveValidarTituloQuandoTiverNulo(){
        String momemnto = "20/10/2022 10:00:00";
        String titulo = null;
        String conteudo = "Adorei este lindo país";
        Integer likes = 12;
        assertThrows(RegraDeNegocioException.class, () -> postService.criarPost(momemnto, titulo, conteudo, likes));
    }

    @Test
    @DisplayName("Deve validar conteudo quando não informar")
    void deveValidarConteudoQuandoTiverNulo(){
        String momemnto = "20/10/2022 10:00:00";
        String titulo = "Viagem para o Brasil";
        String conteudo = null;
        Integer likes = 12;
        assertThrows(RegraDeNegocioException.class, () -> postService.criarPost(momemnto, titulo, conteudo, likes));
    }

    @Test
    @DisplayName("Deve validar likes quando não informar")
    void deveValidarLikesQuandoTiverNulo(){
        String momemnto = "20/10/2022 10:00:00";
        String titulo = "Viagem para o Brasil";
        String conteudo = "Estou adorando esta viagem";
        Integer likes = null;
        assertThrows(RegraDeNegocioException.class, () -> postService.criarPost(momemnto, titulo, conteudo, likes));
    }

    @Test
    @DisplayName("Deve validar likes quando for negativo")
    void deveValidarLikesQuandoTiverNegativo(){
        String momemnto = "20/10/2022 10:00:00";
        String titulo = "Viagem para o Brasil";
        String conteudo = "Estou adorando esta viagem";
        Integer likes = -19;
        assertThrows(RegraDeNegocioException.class, () -> postService.criarPost(momemnto, titulo, conteudo, likes));
    }

    @Test
    @DisplayName("Deve criar post")
    void deveCriarPost(){
        Post post = postService.criarPost("21/06/2023 10:10:00", "Viagem para Nova Zelandia", "Adorei este lindo país", 12);

        assertNotNull(post.getId());
        assertEquals(toDataHoraBrasil("21/06/2023 10:10:00"), post.getMomento());
        assertEquals("Viagem para Nova Zelandia", post.getTitulo());
        assertEquals("Adorei este lindo país", post.getConteudo());
        assertEquals(12, post.getLikes());
    }

    @Test
    @DisplayName("Deve imprimir post")
    void deveImprimirPost(){
        Post post = postService.criarPost("21/06/2023 10:10:00", "Viagem para Nova Zelandia", "Adorei este lindo país", 12);
        Comentarios comentarios = comentariosService.criarComentarios("Que legal");
        post.getComentarios().add(comentarios);

        String imprimir = postService.imprimirPost(post);

        assertNotNull(imprimir);
    }
}
