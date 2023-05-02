package br.com.gabrielferreira.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex06 {

    public static void main(String[] args) {
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

            if(i == 15)
                break;
        }

        System.out.println(list);

    }
}
