package br.com.gabrielferreira.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Veiculo implements Serializable {

    @Serial
    private static final long serialVersionUID = 4221872999738486158L;

    @Setter
    @Getter
    @EqualsAndHashCode.Include
    private UUID id;

    @Getter
    @Setter
    private boolean ligado;

    protected void ligar(){
        this.setLigado(true);
    }

    protected void desligar(){
        this.setLigado(false);
    }

    public abstract String ligado();

    public abstract String desligado();
}
