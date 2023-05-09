package br.com.gabrielferreira.model;

import lombok.EqualsAndHashCode;
import lombok.Generated;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Generated
public class Onibus extends Veiculo {

    @Serial
    private static final long serialVersionUID = -7168094468446149936L;

    @Override
    public String ligado() {
        this.ligar();
        return "Ônibus ligado";
    }

    @Override
    public String desligado() {
        this.desligar();
        return "Ônibus desligado";
    }
}
