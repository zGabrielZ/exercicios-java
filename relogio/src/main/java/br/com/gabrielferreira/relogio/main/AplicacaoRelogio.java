package br.com.gabrielferreira.relogio.main;

import br.com.gabrielferreira.relogio.model.Relogio;
import br.com.gabrielferreira.relogio.service.RelogioService;
import lombok.Generated;

@Generated
public class AplicacaoRelogio {

    public static void main(String[] args) {
        System.out.println("Iniciando relógio");

        RelogioService relogioService = new RelogioService();
        Relogio relogio = relogioService.acertarRelogio(10, 30, 50);

        System.out.println("Hora : " + relogio.lerHora());
        System.out.println("Minuto : " + relogio.lerMinuto());
        System.out.println("Segundo : " + relogio.lerSegundo());
        System.out.println("Posição Hora : " + relogio.lerPosicaoHora());
        System.out.println("Posição Minuto : " + relogio.lerPosicaoMinuto());
        System.out.println("Posição Segundo : " + relogio.lerPosicaoSegundo());
    }
}
