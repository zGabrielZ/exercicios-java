package br.com.gabrielferreira.veiculo.main;

import br.com.gabrielferreira.veiculo.model.Automovel;
import br.com.gabrielferreira.veiculo.model.Motocicleta;
import br.com.gabrielferreira.veiculo.model.Onibus;
import br.com.gabrielferreira.veiculo.model.Veiculo;
import lombok.Generated;

@Generated
public class AplicacaoVeiculo {

    public static void main(String[] args) {
        System.out.println("Iniciando veículo");

        Veiculo automovel = new Automovel();
        System.out.println("Automóvel : " + automovel.ligado());
        System.out.println("Automóvel : " + automovel.desligado());

        Veiculo motocicleta = new Motocicleta();
        System.out.println("Motocicleta : " + motocicleta.ligado());
        System.out.println("Motocicleta : " + motocicleta.desligado());

        Veiculo onibus = new Onibus();
        System.out.println("Ônibus : " + onibus.ligado());
        System.out.println("Ônibus : " + onibus.desligado());
    }
}
