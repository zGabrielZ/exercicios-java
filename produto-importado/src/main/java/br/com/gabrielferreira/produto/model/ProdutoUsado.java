package br.com.gabrielferreira.produto.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.MascarasUtils.*;
import static br.com.gabrielferreira.produto.validate.ValidarCampos.*;
import static br.com.gabrielferreira.commons.utils.DataUtils.*;

@EqualsAndHashCode(callSuper = true)
public class ProdutoUsado extends Produto {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @Getter
    private final LocalDate dataFabricada;

    public ProdutoUsado(UUID id, String nome, BigDecimal preco, LocalDate dataFabricada) {
        super(id, nome, preco);
        this.dataFabricada = dataFabricada;

        validarDataFabricada(this.dataFabricada);
    }

    @Override
    public String getPrecoTag() {
        return this.getNome() + " (Usado) " + valorMonetarioBrasil(this.getPreco()) + " (Data fabricada : " + toDataBrasil(this.dataFabricada) + ")";
    }
}
