package br.com.gabrielferreira.model;

import br.com.gabrielferreira.exception.RegraDeNegocioException;

import java.util.ArrayList;
import java.util.List;

public class Pilha extends Colecao {

    private final List<Integer> pilhas;

    public Pilha(){
        pilhas = new ArrayList<>();
    }

    @Override
    public void inserirItem(Integer item) {
        if(item == null){
            throw new RegraDeNegocioException("É necessário informar valor para pilha");
        }

        if(!pilhas.isEmpty()){
            pilhas.add(0, item);
        } else {
            pilhas.add(item);
        }
    }

    @Override
    public Integer removerItem() {
        if(!pilhas.isEmpty()){
            Integer item = pilhas.get(0);
            pilhas.remove(pilhas.get(0));
            return item;
        }

        return null;
    }

    public List<Integer> getStatusAtual(){
        return pilhas;
    }
}
