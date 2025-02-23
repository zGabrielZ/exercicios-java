package br.com.gabrielferreira.aluguel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuartosReservadosDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    private Integer numeroPessoa;

    private Integer quartoReservado;
}
