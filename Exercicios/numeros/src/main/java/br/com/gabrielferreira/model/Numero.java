package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;
import br.com.gabrielferreira.model.enumeration.Mes;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@NoArgsConstructor
public class Numero implements Serializable {

    @Serial
    private static final long serialVersionUID = -8501676006915527338L;

    public List<Integer> imprimirDezAteVinteCinco(){
        List<Integer> valores = new ArrayList<>();
        for(int i = 10; i <= 25; i++){
            valores.add(i);
        }
        return valores;
    }

    public List<Integer> imprimirUmAteCemPulandoDeDois(){
        List<Integer> valores = new ArrayList<>();
        for(int i = 1; i <= 100; i+=2){
            valores.add(i);
        }
        return valores;
    }

    public List<Integer> imprimirSomandoAteBaterCem(){
        List<Integer> valores = new ArrayList<>();
        int soma = 0;
        int contador = 0;

        do {
            contador += 1;

            soma += contador;

            if(soma < 100){
                valores.add(contador);
            }

        } while (soma < 100);
        return valores;
    }

    public List<String> imprimirTabuadaDoNove(){
        List<String> valores = new ArrayList<>();
        for (int i = 0; i <= 10; i++){
            String formula = String.format("%s X %s = %s", 9, i, 9 * i);
            valores.add(formula);
        }
        return valores;
    }

    public BigDecimal calcularNumeroParaFatorar(Integer numero){
        if(numero == null){
            throw new RegraDeNegocioException("É necessário informar um número");
        }

        BigDecimal fatora = BigDecimal.ONE;
        for(int i = 1; i <= numero; i++){
            fatora = fatora.multiply(BigDecimal.valueOf(i));
        }
        return fatora;
    }

    public List<Integer> imprimirQuinzePrimeirosNumerosFibonacci(){
        List<Integer> list = new ArrayList<>();
        list.add(0); list.add(1);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i= 0; i < list.size(); i++){
            map.put(i, list.get(i));

            if(i > 0){
                Integer valorAnterior = map.get(i - 1);
                Integer valor = valorAnterior + list.get(i);
                list.add(valor);
            }

            if(list.size() == 15)
                break;
        }

        return list;
    }

    public List<Integer> imprimirAteUltrapassarMil(Integer valor){
        if(valor == null){
            throw new RegraDeNegocioException("É necessário inforar o valor");
        }

        List<Integer> valores = new ArrayList<>();
        do {
            if(isPar(valor)){
                valor += 5;
            } else {
                valor *= 2;
            }

            valores.add(valor);

        } while (valor < 1000);

        return valores;
    }

    public String imprimirDataInformada(Integer dia, Integer mes, Integer ano){
        if(dia == null){
            throw new RegraDeNegocioException("É necessário informar o dia");
        }

        if(mes == null){
            throw new RegraDeNegocioException("É necessário informar o mês");
        }

        if(ano == null){
            throw new RegraDeNegocioException("É necessário informar o ano");
        }

        String anoFormat = String.valueOf(ano);
        if(anoFormat.length() > 4){
            throw new RegraDeNegocioException("Informe o ano corretamente");
        }

        if(!(mes >= 1 && mes <= 12)){
            throw new RegraDeNegocioException("Informe o mês corretamente");
        }

        if(!(dia >= 1 && dia <= 30)){
            throw new RegraDeNegocioException("Informe o dia corretamente");
        }

        if(Mes.isFevereiro(mes) && dia > 28){
            throw new RegraDeNegocioException("Informe o dia de fevereiro corretamente");
        }

        return String.format("%s/%s/%s", dia, mes, ano);
    }

    private boolean isPar(Integer valor){
        return valor % 2 == 0;
    }
}
