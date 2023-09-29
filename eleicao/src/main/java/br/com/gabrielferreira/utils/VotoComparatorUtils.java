package br.com.gabrielferreira.utils;

import br.com.gabrielferreira.model.Candidato;

import java.util.Comparator;

public class VotoComparatorUtils implements Comparator<Candidato> {

    @Override
    public int compare(Candidato o1, Candidato o2) {
        if(o1.getQuantidadeVotos().equals(o2.getQuantidadeVotos())){
            return 0;
        }

        if(o1.getQuantidadeVotos() < o2.getQuantidadeVotos()){
            return 1;
        }

        return -1;
    }
}
