package br.com.gabrielferreira.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidarCampos.*;
import static br.com.gabrielferreira.utils.CalculoUtils.*;
import static br.com.gabrielferreira.utils.MascarasUtils.*;

@EqualsAndHashCode(callSuper = true)
public class ProdutoImportado extends Produto {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @Getter
    private final BigDecimal taxaCustomizada;

    public ProdutoImportado(UUID id, String nome, BigDecimal preco, BigDecimal taxaCustomizada) {
        super(id, nome, preco);
        this.taxaCustomizada = taxaCustomizada;

        validarPreco(this.taxaCustomizada, "É necessário informar a taxa customizada", "A taxa customizada não pode ser negativo");
    }

    public BigDecimal getTotalPreco(){
        return somar(this.getPreco(), this.taxaCustomizada);
    }

    @Override
    public String getPrecoTag() {
        return this.getNome() + " " + valorMonetarioBrasil(getTotalPreco()) + " (Taxa customizada : " + valorMonetarioBrasil(this.taxaCustomizada) + ")";
    }
}
