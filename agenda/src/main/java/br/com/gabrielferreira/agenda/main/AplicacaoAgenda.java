package br.com.gabrielferreira.agenda.main;
import br.com.gabrielferreira.agenda.service.ContatoService;
import lombok.Generated;
import java.util.Locale;
import java.util.Scanner;
import static br.com.gabrielferreira.commons.utils.LogUtils.gerarLogWarn;

@Generated
public class AplicacaoAgenda {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        ContatoService contatoService = new ContatoService();

        try {
            System.out.println("Inserindo contatos");
            contatoService.criarContato("José", "12345678");
            contatoService.criarContato("Mariano", "123456789");
            contatoService.criarContato("Marcos", "123456781");

            System.out.println("Alterando contatos");
            contatoService.alterarContato("José", "32112311");

            System.out.println("Buscando contato por letra");
            contatoService.buscarContatosPorLetra('J').forEach(contato -> {
                System.out.println("ID -> " + contato.getId());
                System.out.println("NOME -> " + contato.getNome());
                System.out.println("TELEFONE -> " + contato.getTelefone());
            });

            System.out.println("Excluindo contato");
            contatoService.excluirContato("José");

            System.out.println("Buscando contato por letra");
            contatoService.buscarContatosPorLetra('M').forEach(contato -> {
                System.out.println("ID -> " + contato.getId());
                System.out.println("NOME -> " + contato.getNome());
                System.out.println("TELEFONE -> " + contato.getTelefone());
            });

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro na aplicação. Causa : {}", e);
        }

        scanner.close();
    }
}
