package br.com.gabrielferreira.autor.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(exclude = {"livros"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Autor implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @EqualsAndHashCode.Include
    private UUID id;

    private String nome;

    private LocalDate dataNascimento;

    private List<Livro> livros = new ArrayList<>();
}
