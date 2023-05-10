package br.com.gabrielferreira.model;

public class ContaInvestimento extends ContaBancaria {

    @Override
    public Double calcularSaldoFinal() {
        return this.getSaldo() + (this.getSaldo() * 0.5);
    }
}
