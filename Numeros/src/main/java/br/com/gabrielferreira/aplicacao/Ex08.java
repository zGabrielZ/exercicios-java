package br.com.gabrielferreira.aplicacao;

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
        int dia = 29;
        int mes = 3;
        int ano = 2023;

        String anoFormat = String.valueOf(ano);
        if(anoFormat.length() > 4){
            throw new RuntimeException("Informe o ano corretamente");
        }

        if(!(mes >= 1 && mes <= 12)){
            throw new RuntimeException("Informe o mes corretamente");
        }

        if(Mes.isFevereiro(mes) && dia > 28){
            throw new RuntimeException("Informe o dia de fevereiro corretamente");
        }

        System.out.println(String.format("Data validado : %s/%s/%s", dia, mes, ano));

        
    }
}
