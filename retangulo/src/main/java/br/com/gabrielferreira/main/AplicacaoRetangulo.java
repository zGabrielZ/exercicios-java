package br.com.gabrielferreira.main;
import br.com.gabrielferreira.model.Retangulo;
import br.com.gabrielferreira.service.RetanguloService;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

import static br.com.gabrielferreira.utils.MascarasUtils.valorFormatadoBrasil;
import static br.com.gabrielferreira.validate.ValidarEntrada.validarEntradaBigDecimal;

@Slf4j
@Generated
public class AplicacaoRetangulo {

    public static void main(String[] args) {
        Locale locale = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(locale);

        RetanguloService retanguloService = new RetanguloService();

        try {
            System.out.println("Digite a largura e altura do retângulo abaixo : ");
            BigDecimal largura = validarEntradaBigDecimal(scanner);
            BigDecimal altura = validarEntradaBigDecimal(scanner);

            Retangulo retangulo = retanguloService.criarRetangulo(largura, altura);

            System.out.println("Área : " + valorFormatadoBrasil(retangulo.getArea()));
            System.out.println("Perímetro : " + valorFormatadoBrasil(retangulo.getPerimetro()));
            System.out.println("Diagonal : " + valorFormatadoBrasil(retangulo.getDiagonal()));
        } catch (Exception e){
            log.warn("Ocorreu erro na aplicação. Causa : {}", e.getMessage());
        }

        scanner.close();
    }
}
