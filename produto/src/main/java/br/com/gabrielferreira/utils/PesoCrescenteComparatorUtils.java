package br.com.gabrielferreira.utils;

import br.com.gabrielferreira.model.Produto;

import java.util.Comparator;

public class PesoCrescenteComparatorUtils implements Comparator<Produto> {

    @Override
    public int compare(Produto o1, Produto o2) {
        if(o1.getPeso().equals(o2.getPeso())){
            return 0;
        }

        if(o1.getPeso().compareTo(o2.getPeso()) > 0){
            return 1;
        }

        return -1;
    }
}
