package br.com.gabrielferreira.aplicacao;

import br.com.gabrielferreira.exception.RegraDeNegocioException;

import java.util.Locale;
import java.util.Scanner;

public class Ex08 {

    public enum Mes{
        JANEIRO(1),
        FEVEREIRO(2),
        MARCO(3),
        ABRIL(4),
        MAIO(5),
        JUNHO(6),
        JULHO(7),
        AGOSTO(8),
        SETEMBRO(9),
        OUTUBRO(10),
        NOVEMBRO(11),
        DEZEMBRO(12);

        private Integer valor;

        Mes(Integer valor){
            this.valor = valor;
        }

        public Integer getValor() {
            return valor;
        }

        public static boolean isFevereiro(Integer valor){
            return FEVEREIRO.getValor().equals(valor);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual dia que vc deseja infomar ? ");
        int dia = scanner.nextInt();

        System.out.println("Qual mês que vc deseja infomar ? ");
        int mes = scanner.nextInt();

        System.out.println("Qual ano que vc deseja infomar ? ");
        int ano = scanner.nextInt();

        String anoFormat = String.valueOf(ano);
        if(anoFormat.length() > 4){
            throw new RegraDeNegocioException("Informe o ano corretamente");
        }

        if(!(mes >= 1 && mes <= 12)){
            throw new RegraDeNegocioException("Informe o mes corretamente");
        }

        if(!(dia >= 1 && dia <= 30)){
            throw new RegraDeNegocioException("Informe o dia corretamente");
        }

        if(Mes.isFevereiro(mes) && dia > 28){
            throw new RegraDeNegocioException("Informe o dia de fevereiro corretamente");
        }

        System.out.printf("Data validado : %s/%s/%s%n", dia, mes, ano);
        scanner.close();
        
    }
}
