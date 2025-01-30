package br.com.gabrielferreira.agenda.service;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;
import br.com.gabrielferreira.agenda.model.Contato;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContatoService {

    @Getter
    private final List<Contato> contatos;

    public ContatoService(){
        contatos = new ArrayList<>();
    }

    public void criarContato(String nome, String telefone){
        validarNome(nome);
        validarTelefone(telefone);
        validarNomeCadastrado(nome);

        Contato contato = Contato.builder()
                .id(UUID.randomUUID())
                .nome(nome)
                .telefone(telefone)
                .build();

        contatos.add(contato);
    }

    public void alterarContato(String nome, String telefone){
        validarNome(nome);

        Contato contatoEncontrado = buscarContato(nome);

        validarTelefone(telefone);
        contatoEncontrado.setTelefone(telefone);
    }

    public void excluirContato(String nome){
        validarNome(nome);
        Contato contato = buscarContato(nome);
        contatos.remove(contato);
    }

    public List<Contato> buscarContatosPorLetra(Character letra){
        if(letra == null){
            throw new RegraDeNegocioException("É necessário informar a letra");
        }

        return contatos.stream().filter(contato -> contato.getNome().charAt(0) == letra).toList();
    }

    private Contato buscarContato(String nome){
        return contatos.stream().filter(contato -> contato.getNome().equals(nome))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
    }

    private void validarNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o nome");
        }
    }

    private void validarTelefone(String telefone){
        if(telefone == null || telefone.isBlank()){
            throw new RegraDeNegocioException("É necessário informar o telefone");
        }

        if(!(telefone.length() >= 8 && telefone.length() <= 9)){
            throw new RegraDeNegocioException("É necessário informar o número do telefone do usuário até 9 caracteres");
        }

        validarTelefoneValido(telefone);
    }

    private void validarTelefoneValido(String telefone){
        if(isNaoPossuiDigito(telefone)){
            throw new RegraDeNegocioException("Digite um número com apenas dígitos do telefone para o usuário");
        }
    }

    private boolean isNaoPossuiDigito(String campo){
        char[] letras = campo.toCharArray();
        boolean isNaoPossuiNumero = false;
        for (char letra : letras) {
            if(!Character.isDigit(letra)){
                isNaoPossuiNumero = true;
                break;
            }
        }
        return isNaoPossuiNumero;
    }

    private void validarNomeCadastrado(String nome){
        boolean isPossuiNome = contatos.stream()
                .map(Contato::getNome).anyMatch(c -> c.equals(nome));

        if(isPossuiNome){
            throw new RegraDeNegocioException("Nome informado " + nome + " já foi cadastrado");
        }
    }
}
