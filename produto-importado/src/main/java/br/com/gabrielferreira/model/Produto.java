package br.com.gabrielferreira.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import static br.com.gabrielferreira.utils.MascarasUtils.*;
import static br.com.gabrielferreira.validate.ValidarCampos.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @Getter
    @EqualsAndHashCode.Include
    private final UUID id;

    @Getter
    private final String nome;

    @Getter
    private final BigDecimal preco;

    public Produto(UUID id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;

        validarId(this.id);
        validarNome(this.nome);
        validarPreco(this.preco, "É necessário informar o preço", "Preço não pode ser negativo");
    }

    public String getPrecoTag(){
        return nome + " " + valorMonetarioBrasil(preco);
    }
}
