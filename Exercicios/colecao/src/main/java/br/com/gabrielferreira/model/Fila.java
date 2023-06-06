package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;

import java.util.ArrayList;
import java.util.List;

public class Fila extends Colecao {

    private final List<Integer> filas;

    public Fila(){
        filas = new ArrayList<>();
    }

    @Override
    public void inserirItem(Integer item) {
        if(item == null){
            throw new RegraDeNegocioException("É necessário informar valor para fila");
        }
        filas.add(item);
    }

    @Override
    public Integer removerItem() {
        if(!filas.isEmpty()){
            Integer item = filas.get(0);
            filas.remove(filas.get(0));
            return item;
        }

        return null;
    }

    public List<Integer> getStatusAtual(){
        return filas;
    }
}
