package br.com.gabrielferreira.hotel.validate;

import br.com.gabrielferreira.commons.exception.RegraDeNegocioException;

import java.time.LocalDate;
import java.util.UUID;

import static br.com.gabrielferreira.commons.utils.DataUtils.*;

public class ValidarCampos {

    private ValidarCampos(){}

    public static void validarId(UUID id){
        if(id == null){
            throw new RegraDeNegocioException("É necessário informar o ID");
        }
    }

    public static void validarNumeroHotel(Integer numeroHotel){
        if(numeroHotel == null){
            throw new RegraDeNegocioException("É necessário informar o número hotel");
        }

        if(numeroHotel < 0){
            throw new RegraDeNegocioException("Número do hotel não pode ser negativo");
        }
    }

    public static void validarCheckIn(LocalDate checkIn){
        if(checkIn == null){
            throw new RegraDeNegocioException("É necessário informar check in");
        }
    }

    public static void validarCheckOut(LocalDate checkOut, LocalDate checkIn){
        if(checkOut == null){
            throw new RegraDeNegocioException("É necessário informar check out");
        }

        if(checkOut.isBefore(checkIn)){
            throw new RegraDeNegocioException("Check out tem que ser maior que o check in");
        }
    }

    public static void validarReservaUpdate(LocalDate checkInUpdate, LocalDate checkOutUpdate){
        if(checkInUpdate.isBefore(toDataAtualBrasil()) || checkOutUpdate.isBefore(toDataAtualBrasil())){
            throw new RegraDeNegocioException("As datas da reservas tem que ser futuras");
        }
    }
}
