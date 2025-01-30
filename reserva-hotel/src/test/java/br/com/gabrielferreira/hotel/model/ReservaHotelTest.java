package br.com.gabrielferreira.hotel.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.DataUtils.toDataAtualBrasil;
import static org.junit.jupiter.api.Assertions.*;

class ReservaHotelTest {

    @Test
    @DisplayName("Deve validar id reserva hotel quando não informar")
    void deveValidarIdReservaHotel(){
        try {
            new ReservaHotel(null, 1111, toDataAtualBrasil(), toDataAtualBrasil().plusDays(2L));
            fail("Deveria ter lançado a exceção do id nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o ID"));
        }
    }

    @Test
    @DisplayName("Deve validar número reserva hotel quando não informar")
    void deveValidarNumeroHotelReservaHotel(){
        try {
            new ReservaHotel(UUID.randomUUID(), null, toDataAtualBrasil(), toDataAtualBrasil().plusDays(2L));
            fail("Deveria ter lançado a exceção do número hotel nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar o número hotel"));
        }
    }

    @Test
    @DisplayName("Deve validar número reserva hotel quando informar valor negativo")
    void deveValidarNumeroHotelNegativoReservaHotel(){
        try {
            new ReservaHotel(UUID.randomUUID(), -1111, toDataAtualBrasil(), toDataAtualBrasil().plusDays(2L));
            fail("Deveria ter lançado a exceção do número hotel negativo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Número do hotel não pode ser negativo"));
        }
    }

    @Test
    @DisplayName("Deve validar check in reserva hotel quando não informar")
    void deveValidarCheckInReservaHotel(){
        try {
            new ReservaHotel(UUID.randomUUID(), 1111, null, toDataAtualBrasil().plusDays(2L));
            fail("Deveria ter lançado a exceção do check in nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar check in"));
        }
    }

    @Test
    @DisplayName("Deve validar check out reserva hotel quando não informar")
    void deveValidarCheckOutReservaHotel(){
        try {
            new ReservaHotel(UUID.randomUUID(), 1111, toDataAtualBrasil(), null);
            fail("Deveria ter lançado a exceção do check out nulo");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("É necessário informar check out"));
        }
    }

    @Test
    @DisplayName("Deve validar check in reserva hotel quando informar superior a check out")
    void deveValidarCheckInSuperiorCheckOutReservaHotel(){
        try {
            new ReservaHotel(UUID.randomUUID(), 1111, toDataAtualBrasil().plusDays(2L), toDataAtualBrasil());
            fail("Deveria ter lançado a exceção do check in maior que check out");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Check out tem que ser maior que o check in"));
        }
    }

    @Test
    @DisplayName("Deve criar reserva hotel")
    void deveCriarReservaHotel(){
        ReservaHotel reservaHotel = new ReservaHotel(UUID.randomUUID(), 1111, toDataAtualBrasil(), toDataAtualBrasil().plusDays(2L));

        assertNotNull(reservaHotel.getId());
        assertEquals(1111, reservaHotel.getNumeroHotel());
        assertEquals(toDataAtualBrasil(), reservaHotel.getCheckIn());
        assertEquals(toDataAtualBrasil().plusDays(2L), reservaHotel.getCheckOut());
        assertNotNull(reservaHotel.toString());
    }

    @Test
    @DisplayName("Deve validar check in e check out reserva hotel quando informar menor que a data atual")
    void deveValidarCheckInCheckOutSuperiorDataAtualReservaHotelUpdate(){
        try {
            ReservaHotel reservaHotel = new ReservaHotel(UUID.randomUUID(), 1111, toDataAtualBrasil(), toDataAtualBrasil().plusDays(2L));

            reservaHotel.updateDatas(toDataAtualBrasil().minusYears(2L), toDataAtualBrasil().minusYears(2L));

            fail("Deveria ter lançado a exceção do check in e check out menor que a data atual");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("As datas da reservas tem que ser futuras"));
        }
    }

    @Test
    @DisplayName("Deve atualizar reserva hotel")
    void deveAtualizarReservaHotel(){
        ReservaHotel reservaHotel = new ReservaHotel(UUID.randomUUID(), 1111, toDataAtualBrasil(), toDataAtualBrasil().plusDays(2L));

        reservaHotel.updateDatas(toDataAtualBrasil().plusYears(2L), toDataAtualBrasil().plusYears(2L));

        assertEquals(toDataAtualBrasil().plusYears(2L), reservaHotel.getCheckIn());
        assertEquals(toDataAtualBrasil().plusYears(2L), reservaHotel.getCheckOut());
    }
}
