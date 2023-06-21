package br.com.gabrielferreira.model;

import br.com.gabrielferreira.model.enumeration.Mes;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.gabrielferreira.validate.ValidarNumero.*;

@NoArgsConstructor
public class Numero implements Serializable {

    @Serial
    private static final long serialVersionUID = -8501676006915527338L;

    private static final Integer MES_INICIO = 1;
    private static final Integer MES_FINAL = 12;
    private static final Integer DIA_INICIO = 1;
    private static final Integer DIA_FINAL = 30;
    private static final Integer DIA_FINAL_FEVEREIRO = 28;


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
        validarNumeroInformado(numero, "É necessário informar um número");

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
        validarNumeroInformado(valor, "É necessário inforar o valor");

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
        validarNumeroInformado(dia, "É necessário informar o dia");
        validarNumeroInformado(mes, "É necessário informar o mês");
        validarNumeroInformado(ano, "É necessário informar o ano");

        validarTamanhoAno(ano);

        validarPeriodo(!(mes >= MES_INICIO && mes <= MES_FINAL), "Informe o mês corretamente");
        validarPeriodo(!(dia >= DIA_INICIO && dia <= DIA_FINAL), "Informe o dia corretamente");
        validarPeriodo(Mes.isFevereiro(mes) && dia > DIA_FINAL_FEVEREIRO, "Informe o dia de fevereiro corretamente");

        return String.format("%s/%s/%s", dia, mes, ano);
    }

    private boolean isPar(Integer valor){
        return valor % 2 == 0;
    }
}
