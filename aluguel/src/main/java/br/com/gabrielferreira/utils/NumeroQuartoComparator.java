package br.com.gabrielferreira.utils;

import br.com.gabrielferreira.model.Pessoa;

import java.util.Comparator;

public class NumeroQuartoComparator implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        if(o1.getQuarto().getNumero().equals(o2.getQuarto().getNumero())){
            return 0;
        }

        if(o1.getQuarto().getNumero().compareTo(o2.getQuarto().getNumero()) > 0){
            return 1;
        }

        return -1;
    }
}
