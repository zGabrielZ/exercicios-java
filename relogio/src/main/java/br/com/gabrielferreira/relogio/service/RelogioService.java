package br.com.gabrielferreira.relogio.service;

import br.com.gabrielferreira.relogio.model.Ponteiro;
import br.com.gabrielferreira.relogio.model.Relogio;
import java.util.UUID;

import static br.com.gabrielferreira.relogio.validate.ValidarRelogio.validarValorInformado;

public class RelogioService {

    public Relogio acertarRelogio(Integer hora, Integer minuto, Integer segundo){

        validarHoraMinutoSegundo(hora, minuto, segundo);

        Ponteiro ponteiroHora = new Ponteiro(UUID.randomUUID(), hora % 12);
        Ponteiro ponteiroMinuto = new Ponteiro(UUID.randomUUID(), minuto / 5);
        Ponteiro ponteiroSegundo = new Ponteiro(UUID.randomUUID(), segundo / 5);
        return new Relogio(UUID.randomUUID(), ponteiroHora, ponteiroMinuto, ponteiroSegundo);
    }

    private void validarHoraMinutoSegundo(Integer hora, Integer minuto, Integer segundo){
        validarValorInformado(hora, "É necessário informar a hora");
        validarValorInformado(minuto, "É necessário informar o minuto");
        validarValorInformado(segundo, "É necessário informar o segundo");
    }
}
