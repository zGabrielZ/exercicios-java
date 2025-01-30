package br.com.gabrielferreira.pedido.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.pedido.model.Cliente;

import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Pattern;

import static br.com.gabrielferreira.commons.utils.DataUtils.*;

public class ClienteService {

    public Cliente criarCliente(String nome, String email, String dataNascimento){
        validarNome(nome);
        validarEmail(email);
        LocalDate dataNascimentoConvetido = validarDataNascimento(dataNascimento);
        return Cliente.builder()
                .id(UUID.randomUUID())
                .nome(nome)
                .email(email)
                .dataNascimento(dataNascimentoConvetido)
                .build();
    }

    private void validarNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o nome");
        }
    }

    private void validarEmail(String email){
        if(email == null || email.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o e-mail");
        }

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if(!pattern.matcher(email).matches()){
            throw new RegraDeNegocioException("Digite um endereço do e-mail válido");
        }
    }

    private LocalDate validarDataNascimento(String dataNascimento){
        if(dataNascimento == null || dataNascimento.isBlank()){
            throw new RegraDeNegocioException("É necessário informar a data de nascimento");
        }

        LocalDate dataConvertido = toDataBrasil(dataNascimento);

        if(dataConvertido.isAfter(toDataAtualBrasil())){
            throw new RegraDeNegocioException("A data de nascimento não pode ser maior que a data atual");
        }

        return dataConvertido;
    }
}
