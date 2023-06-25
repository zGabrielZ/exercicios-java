package br.com.gabrielferreira.utils;

import br.com.gabrielferreira.model.Triangulo;

import java.util.Comparator;

public class MaiorAreaTrianguloComparator implements Comparator<Triangulo> {

    @Override
    public int compare(Triangulo o1, Triangulo o2) {
        if(o1.getResultadoFinalCalculoArea().equals(o2.getResultadoFinalCalculoArea())){
            return 0;
        }

        if(o1.getResultadoFinalCalculoArea().compareTo(o2.getResultadoFinalCalculoArea()) < 0){
            return 1;
        }

        return -1;
    }
}
