package br.com.gabrielferreira.jogos.utils;

import java.util.Comparator;

public class NomeComparatorUtils implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if(o1.equals(o2)){
            return 0;
        }

        if(o1.compareTo(o2) < 0){
            return 1;
        }

        return -1;
    }
}
