package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.ErroException;
import lombok.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Generated
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
        throw new ErroException("Hora não encontrada");
    }

    public Integer lerMinuto(){
        if(this.ponteiroMinuto != null && this.ponteiroMinuto.getPosicao() != null){
            return this.ponteiroMinuto.getPosicao() * 5;
        }
        throw new ErroException("Minuto não encontrado");
    }

    public Integer lerSegundo(){
        if(this.ponteiroSegundo != null && this.ponteiroSegundo.getPosicao() != null){
            return this.ponteiroSegundo.getPosicao() * 5;
        }
        throw new ErroException("Segundo não encontrado");
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
