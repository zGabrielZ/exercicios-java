package br.com.gabrielferreira.service;
import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Ponteiro;
import br.com.gabrielferreira.model.Relogio;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class RelogioService implements Serializable {

    @Serial
    private static final long serialVersionUID = -2417851471879996877L;

    public Relogio acertarRelogio(Integer hora, Integer minuto, Integer segundo){

        Relogio relogio = new Relogio();
        relogio.setId(UUID.randomUUID());

        validarHoraMinutoSegundo(hora, minuto, segundo);
        relogio.setPonteiroHora(new Ponteiro(UUID.randomUUID(), hora % 12));
        relogio.setPonteiroMinuto(new Ponteiro(UUID.randomUUID(), minuto / 5));
        relogio.setPonteiroSegundo(new Ponteiro(UUID.randomUUID(), segundo / 5));

        return relogio;
    }

    private void validarHoraMinutoSegundo(Integer hora, Integer minuto, Integer segundo){
        if(hora == null){
            throw new RegraDeNegocioException("É necessário informar a hora");
        }

        if(minuto == null){
            throw new RegraDeNegocioException("É necessário informar o minuto");
        }

        if(segundo == null){
            throw new RegraDeNegocioException("É necessário informar o segundo");
        }
    }
}
