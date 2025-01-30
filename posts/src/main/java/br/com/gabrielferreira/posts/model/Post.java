package br.com.gabrielferreira.posts.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"comentarios"})
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @EqualsAndHashCode.Include
    private UUID id;

    private LocalDateTime momento;

    private String titulo;

    private String conteudo;

    private Integer likes;

    private List<Comentarios> comentarios = new ArrayList<>();

}
