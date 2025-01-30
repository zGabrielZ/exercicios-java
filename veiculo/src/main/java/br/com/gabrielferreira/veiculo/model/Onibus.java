package br.com.gabrielferreira.veiculo.model;

import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
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
