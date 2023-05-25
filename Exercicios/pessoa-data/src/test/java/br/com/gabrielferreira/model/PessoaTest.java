package br.com.gabrielferreira.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.gabrielferreira.utils.DataUtils.*;

class PessoaTest {

    @Test
    @DisplayName("Deve validar data de nascimento quando não informar")
    void deveValidarDataNascimento(){
        try {
            new Pessoa(UUID.randomUUID(), null);
            fail("Deveria ter lançado a exceção da data de nascimento nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar a data de nascimento"));
        }
    }


    @Test
    @DisplayName("Deve calcular anos")
    void deveCalcularAnos(){
        Pessoa pessoa = new Pessoa(UUID.randomUUID(), toDataBrasil("20/01/2000"));
        String resultado = pessoa.calcularAnos().replace("anos", "").trim();
        assertTrue(Integer.parseInt(resultado) > 20);
    }

    @Test
    @DisplayName("Deve calcular meses")
    void deveCalcularMeses(){
        Pessoa pessoa = new Pessoa(UUID.randomUUID(), toDataBrasil("10/10/2010"));
        String resultado = pessoa.calcularMeses().replace("meses", "").trim();
        assertTrue(Integer.parseInt(resultado) > 100);
    }

    @Test
    @DisplayName("Deve calcular dias")
    void deveCalcularDias(){
        Pessoa pessoa = new Pessoa(UUID.randomUUID(), toDataBrasil("10/10/2015"));
        String resultado = pessoa.calcularDias().replace("dias", "").trim();
        assertTrue(Integer.parseInt(resultado) > 200);
    }

    @Test
    @DisplayName("Deve criar pessoa")
    void deveCriarPessoa(){
        Pessoa pessoa = new Pessoa(UUID.randomUUID(), toDataBrasil("20/10/2020"));

        assertNotNull(pessoa.getId());
        assertEquals("20/10/2020", toDataBrasil(pessoa.getDataNascimento()));
        assertNotNull(pessoa.toString());
    }

    @Test
    @DisplayName("Deve comparar pessoa quando não forem iguais")
    void deveCompararPessoaNaoIguais(){
        Pessoa pessoa1 = new Pessoa(UUID.randomUUID(), toDataBrasil("20/10/2021"));
        Pessoa pessoa2 = new Pessoa(UUID.randomUUID(), toDataBrasil("20/10/2022"));

        assertNotEquals(pessoa1, pessoa2);
        assertNotEquals(pessoa1.hashCode(), pessoa2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar pessoa quando forem iguais")
    void deveCompararPessoaIguais(){
        UUID id = UUID.randomUUID();
        LocalDate data = toDataBrasil("20/10/2000");
        Pessoa pessoa1 = new Pessoa(id, data);
        Pessoa pessoa2 = new Pessoa(id, data);

        assertEquals(pessoa1, pessoa2);
        assertEquals(pessoa1.hashCode(), pessoa2.hashCode());
    }
}
