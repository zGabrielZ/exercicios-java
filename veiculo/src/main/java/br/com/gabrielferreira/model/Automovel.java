package br.com.gabrielferreira.model;

import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
public class Automovel extends Veiculo {

    @Serial
    private static final long serialVersionUID = -8978342317475923432L;

    @Override
    public String ligado() {
        this.ligar();
        return "Automóvel ligado";
    }

    @Override
    public String desligado() {
        this.desligar();
        return "Autómovel desligado";
    }
}
