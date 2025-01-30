package br.com.gabrielferreira.posts.service;

import br.com.gabrielferreira.commons.exception.ErroInesperadoException;
import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.posts.model.Comentarios;
import br.com.gabrielferreira.posts.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static br.com.gabrielferreira.commons.utils.DataUtils.toDataHoraBrasil;
import static org.junit.jupiter.api.Assertions.*;

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
        String momento = getStringNula();
        String titulo = getStringNaoNula();
        String conteudo = getStringNaoNula();
        Integer likes = 12;
        assertThrows(RegraDeNegocioException.class, () -> postService.criarPost(momento, titulo, conteudo, likes));
    }

    @Test
    @DisplayName("Deve validar momento quando tiver no formato errado")
    void deveValidarMomentoQuandoTiverFormatoErrado(){
        String momento = "12";
        String titulo = getStringNaoNula();
        String conteudo = getStringNaoNula();
        Integer likes = 12;
        assertThrows(ErroInesperadoException.class, () -> postService.criarPost(momento, titulo, conteudo, likes));
    }

    @Test
    @DisplayName("Deve validar momento quando tiver maior que data atual")
    void deveValidarMomentoQuandoTiverMaiorQueDataAtual(){
        String momento = toDataHoraBrasil(LocalDateTime.now().plusDays(5L));
        String titulo = getStringNaoNula();
        String conteudo = getStringNaoNula();
        Integer likes = 12;
        assertThrows(RegraDeNegocioException.class, () -> postService.criarPost(momento, titulo, conteudo, likes));
    }

    @Test
    @DisplayName("Deve validar titulo quando não informar")
    void deveValidarTituloQuandoTiverNulo(){
        String momento = "20/10/2022 10:00:00";
        String titulo = getStringNula();
        String conteudo = getStringNaoNula();
        Integer likes = 12;
        assertThrows(RegraDeNegocioException.class, () -> postService.criarPost(momento, titulo, conteudo, likes));
    }

    @Test
    @DisplayName("Deve validar conteudo quando não informar")
    void deveValidarConteudoQuandoTiverNulo(){
        String momento = "20/10/2022 10:00:00";
        String titulo = getStringNaoNula();
        String conteudo = getStringNula();
        Integer likes = 12;
        assertThrows(RegraDeNegocioException.class, () -> postService.criarPost(momento, titulo, conteudo, likes));
    }

    @Test
    @DisplayName("Deve validar likes quando não informar")
    void deveValidarLikesQuandoTiverNulo(){
        String momento = "20/10/2022 10:00:00";
        String titulo = getStringNaoNula();
        String conteudo = getStringNaoNula();
        Integer likes = null;
        assertThrows(RegraDeNegocioException.class, () -> postService.criarPost(momento, titulo, conteudo, likes));
    }

    @Test
    @DisplayName("Deve validar likes quando for negativo")
    void deveValidarLikesQuandoTiverNegativo(){
        String momento = "20/10/2022 10:00:00";
        String titulo = getStringNaoNula();
        String conteudo = getStringNaoNula();
        Integer likes = -19;
        assertThrows(RegraDeNegocioException.class, () -> postService.criarPost(momento, titulo, conteudo, likes));
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

    private String getStringNula(){
        return null;
    }

    private String getStringNaoNula(){
        return "Teste teste teste";
    }
}
