package br.com.gabrielferreira.service;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.Pessoa;
import br.com.gabrielferreira.model.Quarto;
import br.com.gabrielferreira.model.dto.QuartosReservadosDTO;
import br.com.gabrielferreira.utils.NumeroQuartoComparator;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class PessoaService implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;


    public Pessoa criarPessoa(String nome, String email, Integer numeroQuarto, List<QuartosReservadosDTO> quartosJaAlugados, Integer numeroPessoa){
        validarNome(nome);
        validarEmail(email);
        validarNumeroQuarto(numeroQuarto, quartosJaAlugados, numeroPessoa);

        Quarto quarto = Quarto.builder()
                .id(UUID.randomUUID())
                .numero(numeroQuarto)
                .build();

        return Pessoa.builder()
                .id(UUID.randomUUID())
                .nome(nome)
                .email(email)
                .quarto(quarto)
                .build();
    }

    public String imprimirPessoas(Pessoa...pessoas){
        if(pessoas != null){
            List<Pessoa> pessoaList = Arrays.asList(pessoas);
            pessoaList.sort(new NumeroQuartoComparator());

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Quartos Alugados : \n");

            pessoaList.forEach(pessoa -> stringBuilder.append(pessoa.getQuarto().getNumero())
                    .append(" : ")
                    .append(pessoa.getNome())
                    .append(", ")
                    .append(pessoa.getEmail())
                    .append("\n"));

            return stringBuilder.toString();
        }
        return null;
    }

    private void validarNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o nome");
        }
    }

    private void validarEmail(String email){
        if(email == null || email.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o email");
        }

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if(!pattern.matcher(email).matches()){
            throw new RegraDeNegocioException("Digite um endereço do e-mail válido");
        }
    }

    private void validarNumeroQuarto(Integer numeroQuarto, List<QuartosReservadosDTO> quartosJaAlugados, Integer numeroPessoa){
        if(numeroQuarto == null){
            throw new RegraDeNegocioException("É necessário informar o número do quarto");
        }

        if(!(numeroQuarto >= 0 && numeroQuarto <= 9)){
            throw new RegraDeNegocioException("O número do quarto tem que ser de 0 até 9");
        }

        for (QuartosReservadosDTO quartosJaAlugado : quartosJaAlugados) {
            if(!quartosJaAlugado.getNumeroPessoa().equals(numeroPessoa) && quartosJaAlugado.getQuartoReservado().equals(numeroQuarto)){
                throw new RegraDeNegocioException(String.format("Este quarto do número %s já foi alugado", numeroQuarto));
            }
        }
    }
}
