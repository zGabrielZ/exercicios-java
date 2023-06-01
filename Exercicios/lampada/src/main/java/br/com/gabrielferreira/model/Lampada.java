package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Lampada implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @EqualsAndHashCode.Include
    private UUID id;

    private boolean ligada;

    public void ligar(){
        ligada = true;
    }

    public void desligar(){
        ligada = false;
    }

    public String imprimir(){
        return ligada ? "Lâmpada ligada" : "Lâmpada desligada";
    }
}
