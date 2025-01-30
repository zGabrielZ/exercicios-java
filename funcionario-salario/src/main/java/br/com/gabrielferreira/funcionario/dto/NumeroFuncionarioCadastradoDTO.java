package br.com.gabrielferreira.funcionario.dto;

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
public class NumeroFuncionarioCadastradoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    private Integer numeroFuncionario;

    private Integer numeroFuncionarioIdentificador;
}
