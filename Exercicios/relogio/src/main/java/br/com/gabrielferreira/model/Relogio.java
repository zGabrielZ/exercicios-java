package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import lombok.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Relogio implements Serializable {

    @Serial
    private static final long serialVersionUID = -4495104636182544600L;

    @EqualsAndHashCode.Include
    private UUID id;

    private Ponteiro ponteiroHora;

    private Ponteiro ponteiroMinuto;

    private Ponteiro ponteiroSegundo;

    public Integer lerHora(){
        if(this.ponteiroHora != null && this.ponteiroHora.getPosicao() != null){
            return this.ponteiroHora.getPosicao();
        }
        throw new RegraDeNegocioException("Hora não encontrada");
    }

    public Integer lerMinuto(){
        if(this.ponteiroMinuto != null && this.ponteiroMinuto.getPosicao() != null){
            return this.ponteiroMinuto.getPosicao() * 5;
        }
        throw new RegraDeNegocioException("Minuto não encontrado");
    }

    public Integer lerSegundo(){
        if(this.ponteiroSegundo != null && this.ponteiroSegundo.getPosicao() != null){
            return this.ponteiroSegundo.getPosicao() * 5;
        }
        throw new RegraDeNegocioException("Segundo não encontrado");
    }

    public Integer lerPosicaoHora(){
        return this.ponteiroHora.getPosicao();
    }

    public Integer lerPosicaoMinuto(){
        return this.ponteiroMinuto.getPosicao();
    }

    public Integer lerPosicaoSegundo(){
        return this.ponteiroSegundo.getPosicao();
    }

}
