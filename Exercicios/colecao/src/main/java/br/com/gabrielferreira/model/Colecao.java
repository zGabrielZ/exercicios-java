package br.com.gabrielferreira.model;

import java.io.Serial;
import java.io.Serializable;


public abstract class Colecao implements Serializable {

    @Serial
    private static final long serialVersionUID = -8501676006915527338L;

    public abstract void inserirItem(Integer item);

    public abstract Integer removerItem();
}
