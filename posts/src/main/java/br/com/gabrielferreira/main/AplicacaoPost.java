package br.com.gabrielferreira.main;
import br.com.gabrielferreira.model.Comentarios;
import br.com.gabrielferreira.model.Post;
import br.com.gabrielferreira.service.ComentariosService;
import br.com.gabrielferreira.service.PostService;
import lombok.Generated;

@Generated
public class AplicacaoPost {

    public static void main(String[] args) {
        PostService postService = new PostService();
        ComentariosService comentariosService = new ComentariosService();

        Post post1 = postService.criarPost("21/06/2023 10:10:00", "Viagem para Nova Zelandia", "Adorei este lindo país", 12);

        Comentarios comentarios1 = comentariosService.criarComentarios("Que legal, parabens");
        Comentarios comentarios2 = comentariosService.criarComentarios("Nossa que incrivel");

        post1.getComentarios().add(comentarios1);
        post1.getComentarios().add(comentarios2);

        System.out.println(postService.imprimirPost(post1));

        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        Post post2 = postService.criarPost("28/07/2023 08:00:00", "Boa noite pessoal", "Vejo voces amanha", 5);

        Comentarios comentarios3 = comentariosService.criarComentarios("Boa noite");
        Comentarios comentarios4 = comentariosService.criarComentarios("Boa noite e dorme bem");

        post2.getComentarios().add(comentarios3);
        post2.getComentarios().add(comentarios4);

        System.out.println(postService.imprimirPost(post2));
    }
}
