package br.com.gabrielferreira.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Veiculo implements Serializable {

    @Serial
    private static final long serialVersionUID = 4221872999738486158L;

    @EqualsAndHashCode.Include
    private UUID id;

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
