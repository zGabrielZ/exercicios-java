package br.com.gabrielferreira.model;

import lombok.EqualsAndHashCode;
import lombok.Generated;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Generated
public class Motocicleta extends Veiculo {

    @Serial
    private static final long serialVersionUID = 6502382296149292617L;

    @Override
    public String ligado() {
        this.ligar();
        return "Motocicleta ligada";
    }

    @Override
    public String desligado() {
        this.desligar();
        return "Motocicleta desligada";
    }
}
