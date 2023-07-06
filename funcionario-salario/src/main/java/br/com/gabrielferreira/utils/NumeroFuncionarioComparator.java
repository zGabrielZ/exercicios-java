package br.com.gabrielferreira.utils;

import br.com.gabrielferreira.model.Funcionario;

import java.util.Comparator;

public class NumeroFuncionarioComparator implements Comparator<Funcionario> {

    @Override
    public int compare(Funcionario o1, Funcionario o2) {
        if(o1.getNumeroFuncionarioIdentificador().equals(o2.getNumeroFuncionarioIdentificador())){
            return 0;
        }

        if(o1.getNumeroFuncionarioIdentificador().compareTo(o2.getNumeroFuncionarioIdentificador()) > 0){
            return 1;
        }

        return -1;
    }
}
